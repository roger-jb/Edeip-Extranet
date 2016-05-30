package fr.rogerleoen.edeip_extranet;

import android.app.Application;

import fr.rogerleoen.edeip_extranet.data.StoredData;
import fr.rogerleoen.edeip_extranet.objet.Utilisateur;

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
}
