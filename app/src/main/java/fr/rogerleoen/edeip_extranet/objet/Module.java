package fr.rogerleoen.edeip_extranet.objet;

import com.google.gson.annotations.SerializedName;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 05/06/2016.
 */
public class Module {
    private Integer idModule;
    @SerializedName("libelleModule")
    private String libelleModule;

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    public String getLibelleModule() {
        return libelleModule;
    }

    public void setLibelleModule(String libelleModule) {
        this.libelleModule = libelleModule;
    }
}
