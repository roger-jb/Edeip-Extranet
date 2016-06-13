package fr.rogerleoen.edeip_extranet.objet;

import java.util.ArrayList;

import fr.rogerleoen.edeip_extranet.EdeipExtranet;

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

    public ArrayList<Eleve> getEleves(){
        if (lesEleves.size() == 0){
            for (EleveResponsable unEleveResp: EdeipExtranet.storedData.lesEleveResponsable){
                if (unEleveResp.getIdResponsable().equals(this.getIdResponsable())){
                    lesEleves.add(Eleve.getById(unEleveResp.getIdEleve()));
                }
            }
        }
        return lesEleves;
    }

    public Eleve getEleveById(Integer idEleve){
        if (lesEleves.size() == 0){
            for (EleveResponsable unEleveResp: EdeipExtranet.storedData.lesEleveResponsable){
                if (unEleveResp.getIdResponsable().equals(this.getIdResponsable())){
                    lesEleves.add(Eleve.getById(unEleveResp.getIdEleve()));
                }
            }
        }
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
        if (lesEleves.size() == 0){
            for (EleveResponsable unEleveResp: EdeipExtranet.storedData.lesEleveResponsable){
                if (unEleveResp.getIdResponsable().equals(this.getIdResponsable())){
                    lesEleves.add(Eleve.getById(unEleveResp.getIdEleve()));
                }
            }
        }
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
