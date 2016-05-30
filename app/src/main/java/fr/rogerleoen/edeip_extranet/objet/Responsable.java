package fr.rogerleoen.edeip_extranet.objet;

import java.util.ArrayList;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 17/05/2016.
 */
public class Responsable extends Utilisateur {
    // TODO: 30/05/2016 : linquer les élèves et les Responsable
    private ArrayList<Eleve> lesEleves = null;

    public Responsable(){
        super();
    }

    public Responsable(Utilisateur unUtilisateur){
        super(unUtilisateur);
    }

    public Integer getIdResponsable () {
        return idUtilisateur;
    }

    public ArrayList<Eleve> getEleve(){
        return lesEleves;
    }

    public Eleve getEleveById(Integer idEleve){
        for (Eleve unEleves: lesEleves
             ) {
            if(unEleves.getIdEleve().equals(idEleve)){
                return unEleves;
            }
        }
        return new Eleve();
    }

    public void addEleve(Eleve unEleve) {
        Boolean found = false;
        for (Eleve lEleve :
                lesEleves) {
            if (lEleve.getIdEleve().equals(unEleve.getIdEleve())){
                found = true;
                break;
            }
        }
        if (!found)
            lesEleves.add(unEleve);
    }
}
