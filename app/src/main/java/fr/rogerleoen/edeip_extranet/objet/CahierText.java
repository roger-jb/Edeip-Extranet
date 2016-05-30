package fr.rogerleoen.edeip_extranet.objet;

import com.google.gson.annotations.SerializedName;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 30/05/2016.
 */
public class CahierText {
    private Integer idCahierTexte;
    private Integer idMatiereNiveau;
    @SerializedName("dateRealisation")
    private String dateRealisation;
    @SerializedName("contenuCahierTexte")
    private String contenuCahierTexte;
    private Integer idRedacteur;
    @SerializedName("dateRedaction")
    private String dateRedaction;

    public Integer getIdCahierTexte() {
        return idCahierTexte;
    }

    public void setIdCahierTexte(Integer idCahierTexte) {
        this.idCahierTexte = idCahierTexte;
    }

    public Integer getIdMatiereNiveau() {
        return idMatiereNiveau;
    }

    public void setIdMatiereNiveau(Integer idMatiereNiveau) {
        this.idMatiereNiveau = idMatiereNiveau;
    }

    public String getDateRealisation() {
        return dateRealisation;
    }

    public void setDateRealisation(String dateRealisation) {
        this.dateRealisation = dateRealisation;
    }

    public String getContenuCahierTexte() {
        return contenuCahierTexte;
    }

    public void setContenuCahierTexte(String contenuCahierTexte) {
        this.contenuCahierTexte = contenuCahierTexte;
    }

    public Integer getIdRedacteur() {
        return idRedacteur;
    }

    public void setIdRedacteur(Integer idRedacteur) {
        this.idRedacteur = idRedacteur;
    }

    public String getDateRedaction() {
        return dateRedaction;
    }

    public void setDateRedaction(String dateRedaction) {
        this.dateRedaction = dateRedaction;
    }
}
