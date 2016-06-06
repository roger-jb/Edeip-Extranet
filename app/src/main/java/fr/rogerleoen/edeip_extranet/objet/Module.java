package fr.rogerleoen.edeip_extranet.objet;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 05/06/2016.
 */
public class Module {
    private Integer idModule;
    @SerializedName("libelleModule")
    private String libelleModule;

    private Collection<Niveau> lesNiveaux;

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    public String getLibelleModule() {
        return libelleModule;
    }

    public void setLibelleModule(String libelleModule) {
        this.libelleModule = libelleModule;
    }

    public void addNiveau(Niveau leNiveau) {
        Boolean found = false;
        for (Niveau unNiveau : lesNiveaux){
            if (unNiveau.getIdNiveau().equals(leNiveau.getIdNiveau())){
                found = true;
                break;
            }
        }
        if (!found){
            lesNiveaux.add(leNiveau);
        }
    }
}
