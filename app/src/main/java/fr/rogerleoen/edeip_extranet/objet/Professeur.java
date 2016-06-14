package fr.rogerleoen.edeip_extranet.objet;

import java.util.ArrayList;

import fr.rogerleoen.edeip_extranet.EdeipExtranet;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 17/05/2016.
 */
public class Professeur extends Utilisateur {

    public ArrayList<MatiereNiveau> getMatiereNiveau() {
        ArrayList<MatiereNiveau> sesMatiereNiveau = new ArrayList<>();
        for (ProfesseurMatiereNiveau uneProfMatiereNiveau : EdeipExtranet.storedData.lesProfesseurMatiereNiveau){
            if (uneProfMatiereNiveau.getIdProfesseur().equals(this.getIdUtilisateur())){
                sesMatiereNiveau.add(EdeipExtranet.storedData.getMatiereNiveauById(uneProfMatiereNiveau.getIdMatiereNiveau()));
            }
        }
        return sesMatiereNiveau;
    }
}
