package fr.rogerleoen.edeip_extranet.objet;

import java.util.ArrayList;

import fr.rogerleoen.edeip_extranet.EdeipExtranet;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 05/06/2016.
 */
public class MatiereNiveau {
    private Integer idMatiereNiveau;
    private Integer idMatiere;
    private Integer idNiveau;

    public Integer getIdMatiereNiveau() {
        return idMatiereNiveau;
    }

    public void setIdMatiereNiveau(Integer idMatiereNiveau) {
        this.idMatiereNiveau = idMatiereNiveau;
    }

    public Integer getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Integer getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public ArrayList<Eleve> getEleves() {
        ArrayList<Eleve> lesEleves = new ArrayList<>();
        for (EleveMatiereNiveau unEleveMatiereNiveau: EdeipExtranet.storedData.lesEleveMatiereNiveau){
            if (unEleveMatiereNiveau.getIdMatiereNiveau().equals(this.getIdMatiereNiveau())){
                lesEleves.add(Eleve.getById(unEleveMatiereNiveau.getIdEleve()));
            }
        }
        return lesEleves;

    }
}
