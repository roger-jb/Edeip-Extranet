package fr.rogerleoen.edeip_extranet.data;


import java.util.ArrayList;
import java.util.Collection;

import fr.rogerleoen.edeip_extranet.EdeipExtranet;
import fr.rogerleoen.edeip_extranet.objet.*;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 30/05/2016.
 */
public class StoredData {

    public Collection<Connexion>                lesConnexions               = new ArrayList<>();

    public Collection<Utilisateur>              lesUtilisateurs             = new ArrayList<>();
    public Collection<Administrateur>           lesAdministrateurs          = new ArrayList<>();
    public Collection<Professeur>               lesProfesseurs              = new ArrayList<>();
    public Collection<Responsable>              lesResponsables             = new ArrayList<>();
    public Collection<Eleve>                    lesEleves                   = new ArrayList<>();

    public Collection<Matiere>                  lesMatieres                 = new ArrayList<>();
    public Collection<Niveau>                   lesNiveaux                  = new ArrayList<>();
    public Collection<Module>                   lesModules                  = new ArrayList<>();

    public Collection<CarnetLiaison>            lesCarnetLiaisons           = new ArrayList<>();
    public Collection<CahierText>               lesCahierTexts              = new ArrayList<>();

    public Collection<MatiereNiveau>            lesMatiereNiveau            = new ArrayList<>();
    public Collection<EleveMatiereNiveau>       lesEleveMatiereNiveau       = new ArrayList<>();
    public Collection<ProfesseurMatiereNiveau>  lesProfesseurMatiereNiveau  = new ArrayList<>();
    public Collection<EleveResponsable>         lesEleveResponsable         = new ArrayList<>();

    //Boolean technique pour les chargement
    public volatile Boolean loadConnexion               = false;
    public volatile Boolean loadUtilisateur             = false;
    public volatile Boolean loadAdministrateur          = false;
    public volatile Boolean loadProfesseur              = false;
    public volatile Boolean loadResponsable             = false;
    public volatile Boolean loadEleve                   = false;
    public volatile Boolean loadMatiere                 = false;
    public volatile Boolean loadNiveau                  = false;
    public volatile Boolean loadModule                  = false;
    public volatile Boolean loadCarnetLiaison           = false;
    public volatile Boolean loadCahierText              = false;
    public volatile Boolean loadMatiereNiveau           = false;
    public volatile Boolean loadEleveMatiereNiveau      = false;
    public volatile Boolean loadProfesseurMatiereNiveau = false;
    public volatile Boolean loadEleveResponsable        = false;

    /**
     * chargement des données de la base de données
     */
    public void loadData() {
        AsyncWebService.getAllConnexion();
        AsyncWebService.getAllModules();
        AsyncWebService.getAllNiveau();
        AsyncWebService.getAllUtilisateur();
        AsyncWebService.getAllMatiere();
        AsyncWebService.getAllCarnetLiaison();
        AsyncWebService.getAllCahierText();

        AsyncWebService.getAllMatiereNiveau();
    }

    /**
     * mise à jour des données via la base de données
     */
    //TODO : gérer le refresh pour les différentes données
    public void refreshData(){}

    public Administrateur getAdministrateurById(Integer idAdministateur){
        for (Administrateur unAdministrateur : lesAdministrateurs){
            if (unAdministrateur.getIdUtilisateur().equals(idAdministateur)){
                return unAdministrateur;
            }
        }
        return null;
    }

    public CahierText getCahierTextById(Integer idCahierText) {
        for (CahierText unCahierText : lesCahierTexts){
            if (unCahierText.getIdCahierTexte().equals(idCahierText)){
                return unCahierText;
            }
        }
        return null;
    }

    public CarnetLiaison getCarnetLiaisonById(Integer idCarnetLiaison) {
        for (CarnetLiaison unCarnetLiaison : lesCarnetLiaisons){
            if (unCarnetLiaison.getIdCarnetLiaison().equals(idCarnetLiaison)){
                return unCarnetLiaison;
            }
        }
        return null;
    }

    public Eleve getEleveById(Integer idEleve) {
        for (Eleve unEleve : lesEleves){
            if (unEleve.getIdUtilisateur().equals(idEleve)){
                return unEleve;
            }
        }
        return null;
    }

    public Matiere getMatiereById(Integer idMatiere){
        for (Matiere uneMatiere : lesMatieres){
            if (uneMatiere.getIdMatiere().equals(idMatiere)){
                return uneMatiere;
            }
        }
        return null;
    }


    public Matiere getMatiereByIdMatiereNiveau(Integer idMatiereNiveau) {
        if (EdeipExtranet.storedData.lesMatiereNiveau.size()>0){
            for (MatiereNiveau uneMatiereNiveau : EdeipExtranet.storedData.lesMatiereNiveau) {
                if (uneMatiereNiveau.getIdMatiereNiveau().equals(idMatiereNiveau)) {
                    return EdeipExtranet.storedData.getMatiereById(uneMatiereNiveau.getIdMatiere());
                }
            }
        }
        return new Matiere();
    }


    public Module getModuleById(Integer idModule){
        for (Module unModule : lesModules){
            if (unModule.getIdModule().equals(idModule)){
                return unModule;
            }
        }
        return null;
    }

    public Niveau getNiveauById(Integer idNiveau){
        for (Niveau unNiveau : lesNiveaux){
            if (unNiveau.getIdNiveau().equals(idNiveau)){
                return unNiveau;
            }
        }
        return null;
    }

    public Professeur getProfesseurById(Integer idProfesseur){
        for (Professeur unProfesseur : lesProfesseurs){
            if (unProfesseur.getIdUtilisateur().equals(idProfesseur)){
                return unProfesseur;
            }
        }
        return null;
    }

    public Responsable getResponsableById(Integer idResponsable){
        for (Responsable unResponsble : lesResponsables){
            if (unResponsble.getIdResponsable().equals(idResponsable)){
                return unResponsble;
            }
        }
        return null;
    }

    public Utilisateur getUtilisateurById(Integer idUtilisateur) {
        for (Utilisateur unUtilisateur : lesUtilisateurs){
            if (unUtilisateur.getIdUtilisateur().equals(idUtilisateur)){
                return unUtilisateur;
            }
        }
        return null;
    }
}
