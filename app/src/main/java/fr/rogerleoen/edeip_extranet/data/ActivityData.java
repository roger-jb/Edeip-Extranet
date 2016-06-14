package fr.rogerleoen.edeip_extranet.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;

import fr.rogerleoen.edeip_extranet.EdeipExtranet;
import fr.rogerleoen.edeip_extranet.objet.CahierText;
import fr.rogerleoen.edeip_extranet.objet.CarnetLiaison;
import fr.rogerleoen.edeip_extranet.objet.Eleve;
import fr.rogerleoen.edeip_extranet.objet.MatiereNiveau;
import fr.rogerleoen.edeip_extranet.objet.Professeur;
import fr.rogerleoen.edeip_extranet.objet.Responsable;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 06/06/2016.
 */
public class ActivityData {
    public static Collection<CahierText> lesCahierText          = new ArrayList<>();
    public static Collection<CarnetLiaison> lesCarnetLiaison    = new ArrayList<>();

    public static void loadLesCahierText(){
        if (EdeipExtranet.storedData.lesCahierTexts.size() == 0){
            AsyncWebService.getAllCahierText();
        }
        lesCahierText = EdeipExtranet.storedData.lesCahierTexts;
    }

    public static void loadLesCarnetLiaison(){
        if (EdeipExtranet.storedData.lesCarnetLiaisons.size() == 0){
            AsyncWebService.getAllCarnetLiaison();
        }
//        if (EdeipExtranet.getUser().estEleve()){
//            for (CarnetLiaison unCarnetLiaison : EdeipExtranet.storedData.lesCarnetLiaisons){
//                if (unCarnetLiaison.getIdEleve().equals(EdeipExtranet.getUser().getIdUtilisateur())){
//                    lesCarnetLiaison.add(unCarnetLiaison);
//                }
//            }
//        }
//        if (EdeipExtranet.getUser().estResponsable()){
//            Responsable userResponsable = EdeipExtranet.getUser().getResponsable();
//            ArrayList<Eleve> sesEleves = userResponsable.getEleves();
//            for (CarnetLiaison unCarnetLiaison : EdeipExtranet.storedData.lesCarnetLiaisons){
//                for (Eleve unEleve : sesEleves){
//                    if (unCarnetLiaison.getIdEleve().equals(unEleve.getIdEleve())){
//                        lesCarnetLiaison.add(unCarnetLiaison);
//                    }
//                }
//            }
//        }
//        if (EdeipExtranet.getUser().estProfesseur()){
//            Professeur userProfesseur = EdeipExtranet.getUser().getProfesseur();
//            ArrayList<Eleve> sesElevesGlobal = new ArrayList<>();
//            ArrayList<MatiereNiveau> sesMatiereNiveau = userProfesseur.getMatiereNiveau();
//            for (MatiereNiveau saMatiereNiveau : sesMatiereNiveau){
//                ArrayList<Eleve> sesEleves = saMatiereNiveau.getEleves();
//                for (Eleve unEleve : sesEleves){
//                    boolean found = false;
//                    for (Eleve unEleveGloabal : sesElevesGlobal){
//                        if (unEleve.getIdEleve().equals(unEleveGloabal.getIdEleve())){
//                            found = true;
//                            break;
//                        }
//                    }
//                    if (found){
//                        sesElevesGlobal.add(unEleve);
//                    }
//                }
//            }
//            for (CarnetLiaison unCarnetLiaison : EdeipExtranet.storedData.lesCarnetLiaisons){
//                for (Eleve unEleve : sesElevesGlobal){
//                    if (unCarnetLiaison.getIdEleve().equals(unEleve.getIdEleve())){
//                        lesCarnetLiaison.add(unCarnetLiaison);
//                    }
//                }
//            }
//        }
//        if (EdeipExtranet.getUser().estAdministrateur()){
            lesCarnetLiaison = EdeipExtranet.storedData.lesCarnetLiaisons;
//        }
        Log.e("ActivityDatas", "count(lesCarnetsLiaison)= " + lesCarnetLiaison.size());
    }
}
