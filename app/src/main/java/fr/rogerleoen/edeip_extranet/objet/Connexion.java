package fr.rogerleoen.edeip_extranet.objet;

import com.google.gson.annotations.SerializedName;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 17/05/2016.
 */
public class Connexion{
    @SerializedName("idUtilisateur")
    protected Integer idUtilisateur;
    @SerializedName("loginUtilisateur")
    protected String loginUtilisateur;
    @SerializedName("mdpUtilisateur")
    protected String mdpUtilisateur;

    public Connexion() {
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getLoginUtilisateur() {
        return loginUtilisateur;
    }

    public String getMdpUtilisateur() {
        return mdpUtilisateur;
    }
}
