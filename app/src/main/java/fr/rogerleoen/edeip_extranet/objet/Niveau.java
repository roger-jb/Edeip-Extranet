package fr.rogerleoen.edeip_extranet.objet;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;

import fr.rogerleoen.edeip_extranet.EdeipExtranet;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 26/05/2016.
 */
public class Niveau {
    private Integer idNiveau;
    @SerializedName("libelleNiveau")
    private String libelleNiveau;
    private Integer idModule;

    private Collection<Matiere> lesMatieres = new ArrayList<>();

    private Module module = null;

    public Integer getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public String getLibelleNiveau() {
        return libelleNiveau;
    }

    public void setLibelleNiveau(String libelleNiveau) {
        this.libelleNiveau = libelleNiveau;
    }

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Module getModule(){
        if (module.equals(null)){
            module = EdeipExtranet.storedData.getModuleById(idModule);
        }
        return module;
    }

    public void addMatiere(Matiere laMatiere) {
        Boolean found = false;
        for (Matiere uneMatiere : lesMatieres){
            if (uneMatiere.getIdMatiere().equals(laMatiere.getIdMatiere())){
                found = true;
                break;
            }
        }
        if (!found){
            lesMatieres.add(laMatiere);
        }
    }

    public Matiere getMatiereById(Integer idMatiere){
        for (Matiere uneMatiere : lesMatieres){
            if (uneMatiere.getIdMatiere().equals(idMatiere)){
                return uneMatiere;
            }
        }
        return null;
    }
}
