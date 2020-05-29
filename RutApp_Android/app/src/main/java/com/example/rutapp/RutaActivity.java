package com.example.rutapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rutapp.asynctask.AsyncTaskGetPunts;
import com.example.rutapp.asynctask.AsyncTaskGetRutes;
import com.example.rutapp.model.Punt;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.media.MediaExtractor.MetricsConstants.MIME_TYPE;
import static com.example.rutapp.MainActivity.rutes;

public class RutaActivity extends AppCompatActivity {

    public static final String POSITION_RUTA = "id_ruta";
    private static final String MIME_TYPE = "text/html";

    private ImageLoader imgLoader;
    private int pos;
    private ImageView ivwImatgeRuta2;
    private WebView wbvDescripcio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta);

        pos = getIntent().getIntExtra(POSITION_RUTA,-1);

        ivwImatgeRuta2 = findViewById(R.id.ivwImatgeRuta2);
        wbvDescripcio = findViewById(R.id.wbvDescripcio);

        imgLoader = ImageLoader.getInstance();
        imgLoader.displayImage(rutes.get(pos).getFotUrl(),ivwImatgeRuta2);
        DescripcrionRuta();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.punts){
            Intent i = new Intent(this,PuntsActivity.class);
            i.putExtra(RutaActivity.POSITION_RUTA,pos);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private void DescripcrionRuta() {
        List<Extension> ext = new ArrayList<>();
        ext.add(TablesExtension.create());
        org.commonmark.parser.Parser parser = Parser.builder().extensions(ext).build();
        Node root = parser.parse(rutes.get(pos).getDescMarkdown());
        HtmlRenderer htmlRenderer = HtmlRenderer.builder().extensions(ext).build();
        String htmlText = htmlRenderer.render(root);
        Log.d("HTML","html ---->  " + htmlText);
        wbvDescripcio.loadData(htmlText,MIME_TYPE,null);
    }

}
