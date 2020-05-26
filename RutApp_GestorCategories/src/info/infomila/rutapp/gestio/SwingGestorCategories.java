package info.infomila.rutapp.gestio;

import info.infomila.rutapp.Categoria;
import info.infomila.rutapp.Ruta;
import info.infomila.utils.RutAppUtils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class SwingGestorCategories {
    
    private RutAppUtils obj;
    
    private JFrame frame;
    private JPanel north, center, right;
    private JButton btnAdd, btnModify, btnDelete;
    private JScrollPane scrollCategories, scrollRutes;
    private JDialog windowAdd, windowModify, windowDelete;
    
    private Categoria categoriaRoot;
    private Categoria categoriaSelected;
    private DefaultMutableTreeNode rootCategoria;
    private DefaultTreeModel modelCategories;
    private JTree treeCategories;
    
    private DefaultListModel modelRutes;
    private JList listRutes;
    
    private JDialog dlgAddCategoria;
    private JButton btnSave, btnCancel;
    private JTextField valueCategoriaName, valueCategoriaId, valueCategoriaPare;
    
    public SwingGestorCategories(RutAppUtils object){
        obj = object;
        CreaFinestra();
    }

    private void CreaFinestra() {
        frame = new JFrame("RutApp Gestor de Categories");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        JPanelNorth();
        JPanelCenter();
        JPanelRight();
        frame.add(north, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);
        frame.add(right, BorderLayout.EAST);
        frame.setSize(600, 500);
    }
    
    private void JPanelNorth() {
        north = new JPanel();
        Border marc = BorderFactory.createLineBorder(north.getBackground(),10);
        north.setBorder(marc);
        north.add(Box.createRigidArea(new Dimension(0,20)));
        btnAdd = new JButton("Afegir");
        btnAdd.setEnabled(true);
        btnAdd.addActionListener(new AddActionListener());
        north.add(btnAdd);
        north.add(Box.createRigidArea(new Dimension(0,20)));
        btnModify = new JButton("Modificar");
        btnModify.setEnabled(false);
        btnModify.addActionListener(new ModifyActionListener());
        north.add(btnModify);
        north.add(Box.createRigidArea(new Dimension(0,20)));
        btnDelete = new JButton("Esborrar");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new DeleteActionListener());
        north.add(btnDelete);
    }
    
    private void JPanelCenter() {
        center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        categoriaRoot = new Categoria(0,"Categories");
        for(int i=0;i<obj.getCategories().size();i++){
            categoriaRoot.addFilla(obj.getCategories().get(i));
        }
        rootCategoria = new DefaultMutableTreeNode(categoriaRoot);
        AddCategoriesToTree(rootCategoria, categoriaRoot.getListFilles());
        modelCategories = new DefaultTreeModel(rootCategoria);
        treeCategories = new JTree(modelCategories);
        treeCategories.getSelectionModel().setSelectionMode(javax.swing.tree.TreeSelectionModel.SINGLE_TREE_SELECTION);
        treeCategories.getSelectionModel().addTreeSelectionListener(new SelectionChangedListenerJTree());
        scrollCategories = new JScrollPane(treeCategories);
        scrollCategories.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollCategories.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        center.add(new JLabel("Categories"),JLabel.CENTER);
        center.add(scrollCategories);
    }
    
    private void JPanelRight() {
        right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        modelRutes = new DefaultListModel();
        listRutes = new JList();
        listRutes.setModel(modelRutes);
        scrollRutes = new JScrollPane(listRutes);
        scrollRutes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollRutes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        right.add(new JLabel("Rutes"),JLabel.CENTER);
        right.add(scrollRutes);
    }

    private void DialogAddCategoria(){
        
        dlgAddCategoria = new JDialog(frame,true);
        
        JLabel lbl_id = new JLabel("ID: ");
        JLabel lbl_pare = new JLabel("Categoria pare: ");
        JLabel lbl_nom = new JLabel("Nom: ");
        valueCategoriaId = new JTextField();
        valueCategoriaId.setText(obj.getNewCategoriaId()+"");
        valueCategoriaId.setEditable(false);
        valueCategoriaPare = new JTextField();
        if(categoriaSelected!=null && !categoriaSelected.equals(categoriaRoot)){
            valueCategoriaPare.setText(categoriaSelected.getNom());
        }else{
            valueCategoriaPare.setText("Sense categoria pare");
        }
        valueCategoriaPare.setEditable(false);
        valueCategoriaName = new JTextField();
        
        btnSave = new JButton("Desar");
        btnSave.addActionListener(new ManageNewCategoria());
        btnCancel = new JButton("Cancel·lar");
        btnCancel.addActionListener(new ManageNewCategoria());
        
        Box bId = Box.createHorizontalBox();
        bId.setPreferredSize(new Dimension(300,20));
        bId.add(lbl_id);
        bId.add(Box.createHorizontalStrut(15));
        bId.add(valueCategoriaId);
        
        Box bCatPare = Box.createHorizontalBox();
        bCatPare.setPreferredSize(new Dimension(300,20));
        bCatPare.add(lbl_pare);
        bCatPare.add(Box.createHorizontalStrut(15));
        bCatPare.add(valueCategoriaPare);
        
        Box bNom = Box.createHorizontalBox();
        bNom.setPreferredSize(new Dimension(300,20));
        bNom.add(lbl_nom);
        bNom.add(Box.createHorizontalStrut(15));
        bNom.add(valueCategoriaName);
        
        Box bButtons = Box.createHorizontalBox();
        bButtons.add(btnSave);
        bId.add(Box.createHorizontalStrut(100));
        bButtons.add(btnCancel);
        
        Box b = Box.createVerticalBox();
        b.add(Box.createVerticalStrut(10));
        b.add(bId);
        b.add(Box.createVerticalStrut(10));
        b.add(bCatPare);
        b.add(Box.createVerticalStrut(10));
        b.add(bNom);
        b.add(Box.createVerticalStrut(25));
        b.add(bButtons);
        b.add(Box.createVerticalStrut(10));
        
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(400,150));
        p.add(b);
        dlgAddCategoria.add(p);
        dlgAddCategoria.setTitle("Nova Categoria");
        dlgAddCategoria.pack();
        dlgAddCategoria.setResizable(false);
        dlgAddCategoria.setLocationRelativeTo(frame);
        dlgAddCategoria.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dlgAddCategoria.setVisible(true);
    }
    
    private void AddCategoriesToTree(DefaultMutableTreeNode pare, List<Categoria> categories) {
        for(int i=0;i<categories.size();i++){
            DefaultMutableTreeNode filla;
            filla = new DefaultMutableTreeNode(categories.get(i));
            pare.add(filla);
            if(categories.get(i).getFillesCount()>0){
                AddCategoriesToTree(filla, categories.get(i).getListFilles());
            }
        }
    }

    private class ManageNewCategoria implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnSave){
                Categoria newCategoria = new Categoria(obj.getNewCategoriaId(),valueCategoriaName.getText()); 
                obj.crearCategoria(newCategoria);
                obj.commit();
            }
            valueCategoriaName.setText("");
            dlgAddCategoria.dispose();
        }
    }

    private class AddActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            DialogAddCategoria();
        }
    }

    private class ModifyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(categoriaSelected!=null){
                windowModify = new JDialog(frame, true);
            }
        }
    }

    private class DeleteActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            
        }
    }

    private class SelectionChangedListenerJTree implements TreeSelectionListener {

        @Override
        public void valueChanged(TreeSelectionEvent arg0) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeCategories.getLastSelectedPathComponent();
            categoriaSelected = (Categoria) node.getUserObject();
            if(categoriaSelected!=null){
                ActualitzarRutes();
                btnModify.setEnabled(true);
                btnDelete.setEnabled(true);
            }
        }

        private void ActualitzarRutes() {
            modelRutes.removeAllElements();
            List<Ruta> rutes = obj.getRutes(categoriaSelected);
            for(int i=0;i<rutes.size();i++){
                modelRutes.add(i,rutes.get(i).getTitol());
            }
        }
    }

}
