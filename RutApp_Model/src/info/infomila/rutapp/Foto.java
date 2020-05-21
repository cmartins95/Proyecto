package info.infomila.rutapp;

import java.io.Serializable;
import java.util.Objects;

public class Foto {
    
    private Integer fot_id;
    private String fot_titol;
    private String fot_url;
    
    protected Foto(){
        
    }

    public Integer getFot_id() {
        return fot_id;
    }

    public void setFot_id(Integer fot_id) {
        this.fot_id = fot_id;
    }

    public String getFot_titol() {
        return fot_titol;
    }

    public void setFot_titol(String fot_titol) {
        this.fot_titol = fot_titol;
    }

    public String getFot_url() {
        return fot_url;
    }

    public void setFot_url(String fot_url) {
        this.fot_url = fot_url;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.fot_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Foto other = (Foto) obj;
        if (!Objects.equals(this.fot_id, other.fot_id)) {
            return false;
        }
        return true;
    }
    
}
