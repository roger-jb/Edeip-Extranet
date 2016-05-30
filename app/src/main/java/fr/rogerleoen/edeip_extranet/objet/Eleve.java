package fr.rogerleoen.edeip_extranet.objet;

import java.util.Collection;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 17/05/2016.
 */
public class Eleve extends Utilisateur {
    protected Integer idNiveau;
    protected Collection<Responsable> lesResponsables;

    public Integer getIdEleve() {
        return idUtilisateur;
    }

    public Integer getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public void addResponsable(Responsable unResponsable){
        Boolean found = false;
        for (Responsable leResponsable : lesResponsables){
            if (leResponsable.getIdResponsable().equals(unResponsable.getIdResponsable())){
                found = true;
                break;
            }
        }
        if (!found){
            lesResponsables.add(unResponsable);
        }
    }
}
