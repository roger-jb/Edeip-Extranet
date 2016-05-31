package fr.rogerleoen.edeip_extranet.data;


import java.util.ArrayList;
import java.util.Collection;

import fr.rogerleoen.edeip_extranet.objet.*;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 30/05/2016.
 */
public class StoredData {

    public Collection<Connexion>        lesConnexions       = new ArrayList<>();

    public Collection<Utilisateur>      lesUtilisateurs     = new ArrayList<>();
    public Collection<Administrateur>   lesAdministrateurs  = new ArrayList<>();
    public Collection<Professeur>       lesProfesseurs      = new ArrayList<>();
    public Collection<Responsable>      lesResponsables     = new ArrayList<>();
    public Collection<Eleve>            lesEleves           = new ArrayList<>();

    public Collection<Matiere>          lesMatieres         = new ArrayList<>();
    public Collection<Niveau>           lesNiveaux          = new ArrayList<>();

    public Collection<CarnetLiaison>    lesCarnetLiaisons   = new ArrayList<>();
    public Collection<CahierText>       lesCahierTexts      = new ArrayList<>();

    //Boolean technique pour les chargement
    public volatile Boolean loadConnexion       = false;
    public volatile Boolean loadUtilisateur     = false;
    public volatile Boolean loadAdministrateur  = false;
    public volatile Boolean loadProfesseur      = false;
    public volatile Boolean loadResponsable     = false;
    public volatile Boolean loadEleve           = false;
    public volatile Boolean loadMatiere         = false;
    public volatile Boolean loadNiveau          = false;
    public volatile Boolean loadCarnetLiaison   = false;
    public volatile Boolean loadCahierText   = false;

    /**
     * chargement des données de la base de données
     */
    public void loadData() {
        AsyncWebService.getAllConnexion();
        AsyncWebService.getAllNiveau();
        AsyncWebService.getAllUtilisateur();
        AsyncWebService.getAllMatiere();
        AsyncWebService.getAllCarnetLiaison();
        AsyncWebService.getAllCahierText();
    }

    /**
     * mise à jour des données via la base de données
     */
    //TODO : gérer le refresh pour les différentes données
    public void refreshData(){}

    public Utilisateur getUtilisateurById(Integer idUtilisateur) {
        for (Utilisateur unUtilisateur : lesUtilisateurs){
            if (unUtilisateur.getIdUtilisateur().equals(idUtilisateur)){
                return unUtilisateur;
            }
        }
        return null;
    }

    public CahierText getCahierTextById(int idCahierText) {
        for (CahierText unCahierText : lesCahierTexts){
            if (unCahierText.getIdCahierTexte().equals(idCahierText)){
                return unCahierText;
            }
        }
        return null;
    }
}
