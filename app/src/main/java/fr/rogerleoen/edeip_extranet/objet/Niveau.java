package fr.rogerleoen.edeip_extranet.objet;

import com.google.gson.annotations.SerializedName;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 26/05/2016.
 */
public class Niveau {
    private Integer idNiveau;
    @SerializedName("libelleNiveau")
    private String libelleNiveau;
    private Integer idModule;

}
