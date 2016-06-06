package fr.rogerleoen.edeip_extranet.objet;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 26/05/2016.
 */
public class Matiere {
    private Integer idMatiere;
    @SerializedName("libelleMatiere")
    private String libelleMatiere;

    private Collection<Niveau> lesNiveaux = new ArrayList<>();

    public Integer getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getLibelleMatiere() {
        return libelleMatiere;
    }

    public void setLibelleMatiere(String libelleMatiere) {
        this.libelleMatiere = libelleMatiere;
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

    public Niveau getNiveauById(Integer idNiveau){
        for (Niveau unNiveau : lesNiveaux){
            if (unNiveau.getIdNiveau().equals(idNiveau)){
                return unNiveau;
            }
        }
        return null;
    }
}
