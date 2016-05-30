package fr.rogerleoen.edeip_extranet.objet;

import com.google.gson.annotations.SerializedName;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 30/05/2016.
 */
public class CarnetLiaison {
    private Integer idCarnetLiaison;
    @SerializedName("contenuCarneLiaison")
    private String contennuCarnetLiaison;
    private Integer idReponse;
    private Integer idRedacteur;
    @SerializedName("dateRedaction")
    private String dateRedaction;
    private Integer idEleve;

    public Integer getIdCarnetLiaison() {
        return idCarnetLiaison;
    }

    public void setIdCarnetLiaison(Integer idCarnetLiaison) {
        this.idCarnetLiaison = idCarnetLiaison;
    }

    public String getContennuCarnetLiaison() {
        return contennuCarnetLiaison;
    }

    public void setContennuCarnetLiaison(String contennuCarnetLiaison) {
        this.contennuCarnetLiaison = contennuCarnetLiaison;
    }

    public Integer getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(Integer idReponse) {
        this.idReponse = idReponse;
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

    public Integer getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }
}
