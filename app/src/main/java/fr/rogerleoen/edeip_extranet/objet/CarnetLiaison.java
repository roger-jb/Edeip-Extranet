package fr.rogerleoen.edeip_extranet.objet;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.rogerleoen.edeip_extranet.EdeipExtranet;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 30/05/2016.
 */
public class CarnetLiaison {
    private Integer idCarnetLiaison;
    @SerializedName("contenuCarnetLiaison")
    private String contenuCarnetLiaison;
    private Integer idReponse = null;
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

    public String getContenuCarnetLiaison() {
        return contenuCarnetLiaison;
    }

    public void setContenuCarnetLiaison(String contenuCarnetLiaison) {
        this.contenuCarnetLiaison = contenuCarnetLiaison;
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

    public String afficheDateRedaction() {
//        String dtStart = "2010-10-15T09:27:37Z";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//        "2016-03-02 16:13:42"
        String dtStart = dateRedaction;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        try {
            Date date = format.parse(dtStart);
            System.out.println(date);
            format = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss");
            dtStart = format.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dtStart;
    }

    public String afficheContenuComplet(Boolean originel) {

        String retour = "";
        if (originel) {
            retour += "Concernant : \n" + EdeipExtranet.storedData.getUtilisateurById(this.getIdEleve()).getNomPrenom() + "\n\n";
        }
        else {
            retour += "\tréponse à : \n";
            retour += EdeipExtranet.storedData.getUtilisateurById(this.getIdRedacteur()).getNomPrenom()+"\n\n";
        }
        retour += this.getContenuCarnetLiaison() + "\n\n";

        if (this.getIdReponse() != null){
            retour += EdeipExtranet.storedData.getCarnetLiaisonById(this.getIdReponse()).afficheContenuComplet(false);
        }
        return retour;
    }
}
