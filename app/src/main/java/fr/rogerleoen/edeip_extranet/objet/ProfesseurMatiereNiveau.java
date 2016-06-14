package fr.rogerleoen.edeip_extranet.objet;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 05/06/2016.
 */
public class ProfesseurMatiereNiveau {
    private Integer idProfesseurMatiereNiveau;
    private Integer idProfesseur;
    private Integer idMatiereNiveau;

    public Integer getIdProfesseurMatiereNiveau() {
        return idProfesseurMatiereNiveau;
    }

    public void setIdProfesseurMatiereNiveau(Integer idProfesseurMatiereNiveau) {
        this.idProfesseurMatiereNiveau = idProfesseurMatiereNiveau;
    }

    public Integer getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Integer idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public Integer getIdMatiereNiveau() {
        return idMatiereNiveau;
    }

    public void setIdMatiereNiveau(Integer idMatiereNiveau) {
        this.idMatiereNiveau = idMatiereNiveau;
    }
}
