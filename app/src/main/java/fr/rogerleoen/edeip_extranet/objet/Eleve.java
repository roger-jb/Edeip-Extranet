package fr.rogerleoen.edeip_extranet.objet;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 17/05/2016.
 */
public class Eleve extends Utilisateur {
    protected Integer idNiveau;
    protected Collection<Responsable> lesResponsables = new ArrayList<>();

    public Integer getIdEleve() {
        return idUtilisateur;
    }

    public Integer getIdNiveau() {
        return idNiveau;
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

    public Collection<Responsable> getLesResponsables(){
        return lesResponsables;
    }

    public Responsable getResponsable(Integer idResponsble){
        Responsable leResponsable = new Responsable();
        for (Responsable unResponsable : lesResponsables){
            if (unResponsable.getIdResponsable().equals(idResponsble)){
                leResponsable = unResponsable;
                break;
            }
        }
        return leResponsable;
    }
}
