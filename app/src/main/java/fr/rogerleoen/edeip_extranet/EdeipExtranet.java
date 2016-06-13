package fr.rogerleoen.edeip_extranet;

import android.app.Application;

import fr.rogerleoen.edeip_extranet.data.StoredData;
import fr.rogerleoen.edeip_extranet.objet.*;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 30/05/2016.
 */
public class EdeipExtranet extends Application {
    public static StoredData storedData = new StoredData();

    private static Utilisateur user = new Utilisateur();

    @Override
    public void onCreate(){
        super.onCreate();
        storedData.loadData();
    }

    public static Utilisateur getUser() {
        return user;
    }

    public static void setUserById(Integer idUtilisateur) {
        for (Utilisateur unUtilisateur : storedData.lesUtilisateurs){
            if (unUtilisateur.getIdUtilisateur().equals(idUtilisateur)){
                user = unUtilisateur;
                break;
            }
        }
    }

    public static Boolean estAdministrateur(){
        for (Administrateur unAdministrateur : EdeipExtranet.storedData.lesAdministrateurs){
            if (unAdministrateur.getIdUtilisateur().equals(EdeipExtranet.user.getIdUtilisateur())){
                return true;
            }
        }
        return false;
    }

    public static Boolean estEleve(){
        for (Eleve unEleve : EdeipExtranet.storedData.lesEleves){
            if (unEleve.getIdUtilisateur().equals(EdeipExtranet.user.getIdUtilisateur())){
                return true;
            }
        }
        return false;
    }

    public static Boolean estProfesseur(){
        for (Professeur unProfesseur : EdeipExtranet.storedData.lesProfesseurs){
            if (unProfesseur.getIdUtilisateur().equals(EdeipExtranet.user.getIdUtilisateur())){
                return true;
            }
        }
        return false;
    }

    public static Boolean estResponsable(){
        for (Responsable unResponsable : EdeipExtranet.storedData.lesResponsables){
            if (unResponsable.getIdResponsable().equals(EdeipExtranet.user.getIdUtilisateur())){
                return true;
            }
        }
        return false;
    }

    public static void Deconnexion() {
        user = new Utilisateur();
    }
}
