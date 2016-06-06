package fr.rogerleoen.edeip_extranet.objet;

import fr.rogerleoen.edeip_extranet.EdeipExtranet;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 05/06/2016.
 */
public class EleveResponsable {
    private Integer idEleve;
    private Integer idResponsable;

    public Integer getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }

    public Integer getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Eleve getEleve(){
        return EdeipExtranet.storedData.getEleveById(this.idEleve);
    }
}
