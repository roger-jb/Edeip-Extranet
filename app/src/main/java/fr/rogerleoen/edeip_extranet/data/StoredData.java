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

    /**
     * chargement des données de la base de données
     */
    public void loadData() {
        AsyncWebService.getAllConnexion();
        AsyncWebService.getAllNiveau();
        AsyncWebService.getAllUtilisateur();
        AsyncWebService.getAllMatiere();
    }

    /**
     * mise à jour des données via la base de données
     */
    //TODO : gérer le refresh pour les différentes données
    public void refreshData(){}
}
