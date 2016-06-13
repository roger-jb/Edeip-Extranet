package fr.rogerleoen.edeip_extranet.objet;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import fr.rogerleoen.edeip_extranet.EdeipExtranet;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 16/05/2016.
 */
public class Utilisateur{
    @SerializedName("idUtilisateur")
    protected Integer idUtilisateur;
    @SerializedName("nomUtilisateur")
    protected String nomUtilisateur;
    @SerializedName("prenomUtilisateur")
    protected String prenomUtilisateur;
    @SerializedName("adr1Utilisateur")
    protected String adr1Utilisateur;
    @SerializedName("adr2Utilisateur")
    protected String adr2Utilisateur;
    @SerializedName("cpUtilisateur")
    protected String cpUtilisateur;
    @SerializedName("villeUtilisateur")
    protected String villeUtilisateur;
    @SerializedName("actifUtilisateur")
    protected Boolean actifUtilisateur;
    @SerializedName("mailUtilisateur")
    protected String mailUtilisateur;
    @SerializedName("dateNaissanceUtilisateur")
    protected String dateNaissanceUtilisateur;
    @SerializedName("dateInscriptionUtilisateur")
    protected String dateInscriptionUtilisateur;

    public Utilisateur(){}
    public Utilisateur(Utilisateur unUtilisateur){
        idUtilisateur = unUtilisateur.getIdUtilisateur();
        nomUtilisateur = unUtilisateur.getNomUtilisateur();
        prenomUtilisateur = unUtilisateur.getPrenomUtilisateur();
        adr1Utilisateur = unUtilisateur.getAdr1Utilisateur();
        adr2Utilisateur = unUtilisateur.getAdr2Utilisateur();
        cpUtilisateur = unUtilisateur.getCpUtilisateur();
        villeUtilisateur = unUtilisateur.getVilleUtilisateur();
        actifUtilisateur = unUtilisateur.getActifUtilisateur();
        mailUtilisateur = unUtilisateur.getMailUtilisateur();
        dateNaissanceUtilisateur = unUtilisateur.getDateNaissanceUtilisateur();
        dateInscriptionUtilisateur = unUtilisateur.getDateInscriptionUtilisateur();
    }

    public void update(Utilisateur unUtilisateur) {
        if (unUtilisateur.getIdUtilisateur()>0){
            idUtilisateur = unUtilisateur.getIdUtilisateur();
            nomUtilisateur = unUtilisateur.getNomUtilisateur();
            prenomUtilisateur = unUtilisateur.getPrenomUtilisateur();
            adr1Utilisateur = unUtilisateur.getAdr1Utilisateur();
            adr2Utilisateur = unUtilisateur.getAdr2Utilisateur();
            cpUtilisateur = unUtilisateur.getCpUtilisateur();
            villeUtilisateur = unUtilisateur.getVilleUtilisateur();
            actifUtilisateur = unUtilisateur.getActifUtilisateur();
            mailUtilisateur = unUtilisateur.getMailUtilisateur();
            dateNaissanceUtilisateur = unUtilisateur.getDateNaissanceUtilisateur();
            dateInscriptionUtilisateur = unUtilisateur.getDateInscriptionUtilisateur();
        }
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public String getAdr1Utilisateur() {
        return adr1Utilisateur;
    }

    public String getAdr2Utilisateur() {
        return adr2Utilisateur;
    }

    public String getCpUtilisateur() {
        return cpUtilisateur;
    }

    public String getVilleUtilisateur() {
        return villeUtilisateur;
    }

    public Boolean getActifUtilisateur() {
        return actifUtilisateur;
    }

    public String getMailUtilisateur() {
        return mailUtilisateur;
    }

    public String getDateNaissanceUtilisateur() {
        return dateNaissanceUtilisateur;
    }

    public String getDateInscriptionUtilisateur() {
        return dateInscriptionUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public void setAdr1Utilisateur(String adr1Utilisateur) {
        this.adr1Utilisateur = adr1Utilisateur;
    }

    public void setAdr2Utilisateur(String adr2Utilisateur) {
        this.adr2Utilisateur = adr2Utilisateur;
    }

    public void setCpUtilisateur(String cpUtilisateur) {
        this.cpUtilisateur = cpUtilisateur;
    }

    public void setVilleUtilisateur(String villeUtilisateur) {
        this.villeUtilisateur = villeUtilisateur;
    }

    public void setActifUtilisateur(Boolean actifUtilisateur) {
        this.actifUtilisateur = actifUtilisateur;
    }

    public void setMailUtilisateur(String mailUtilisateur) {
        this.mailUtilisateur = mailUtilisateur;
    }

    public void setDateNaissanceUtilisateur(String dateNaissanceUtilisateur) {
        this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
    }

    public void setDateInscriptionUtilisateur(String dateInscriptionUtilisateur) {
        this.dateInscriptionUtilisateur = dateInscriptionUtilisateur;
    }

    public boolean estResponsable(){
        for (Responsable unResponsable : EdeipExtranet.storedData.lesResponsables){
            if (unResponsable.getIdResponsable().equals(this.getIdUtilisateur())){
                return true;
            }
        }
        return false;
    }

    public boolean estProfesseur(){
        for (Professeur unProf : EdeipExtranet.storedData.lesProfesseurs){
            if (unProf.getIdUtilisateur().equals(this.getIdUtilisateur())){
                return true;
            }
        }
        return false;
    }

    public boolean estEleve(){
        for (Eleve unEleve : EdeipExtranet.storedData.lesEleves){
            if (unEleve.getIdEleve().equals(this.getIdUtilisateur())){
                return true;
            }
        }
        return false;
    }

    public boolean estAdministrateur(){
        for (Administrateur unAdmin : EdeipExtranet.storedData.lesAdministrateurs){
            if (unAdmin.getIdUtilisateur().equals(this.getIdUtilisateur())){
                return true;
            }
        }
        return false;
    }

    public Responsable getResponsable(){
        for (Responsable unResponsable : EdeipExtranet.storedData.lesResponsables){
            if (unResponsable.getIdResponsable().equals(this.getIdUtilisateur())){
                return unResponsable;
            }
        }
        return null;
    }

    public Professeur getProfesseur(){
        for (Professeur unProf : EdeipExtranet.storedData.lesProfesseurs){
            if (unProf.getIdUtilisateur().equals(this.getIdUtilisateur())){
                return unProf;
            }
        }
        return null;
    }

    public Eleve getEleve(){
        for (Eleve unEleve : EdeipExtranet.storedData.lesEleves){
            if (unEleve.getIdEleve().equals(this.getIdUtilisateur())){
                return unEleve;
            }
        }
        return null;
    }

    public Administrateur getAdministrateur(){
        for (Administrateur unAdmin : EdeipExtranet.storedData.lesAdministrateurs){
            if (unAdmin.getIdUtilisateur().equals(this.getIdUtilisateur())){
                return unAdmin;
            }
        }
        return null;
    }

}
