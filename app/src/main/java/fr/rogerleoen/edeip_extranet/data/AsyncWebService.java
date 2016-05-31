package fr.rogerleoen.edeip_extranet.data;

import android.text.Html;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import fr.rogerleoen.edeip_extranet.EdeipExtranet;
import fr.rogerleoen.edeip_extranet.objet.*;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 30/05/2016.
 */
public class AsyncWebService {
//    protected static String baseUrl = "http://192.168.10.3/edeip/";
    protected static String baseUrl = "http://roger-leoen.ddns.net/edeip/";
//    protected static String baseUrl = "http://edeip-lyon.fr/";

    protected static String HtmlDecodePost(String laChaine){
        return Html.fromHtml(laChaine).toString();
    }

    public static void getAllConnexion(){
        String url = "api/RealmData.php";
        AsyncHttpClient unClient = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllConnexion");
//        Log.e("StoreData", "getAllConnexion");
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadConnexion = false;
                EdeipExtranet.storedData.lesConnexions = new ArrayList<Connexion>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Connexion>>(){}.getType();
                    EdeipExtranet.storedData.lesConnexions = gRetour.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadConnexion = true;
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Connexions : " + t.toString());
                }
//                Log.i("StoredData", "Connexion Load");
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des Connexions - " + statusCode + " : " + error.toString());
            }
        });
    }

    public static void getAllNiveau(){
        String url = "api/RealmData.php";
        AsyncHttpClient unClient = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllNiveau");
//        Log.e("StoreData", "getAllNiveau");
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadNiveau = false;
                EdeipExtranet.storedData.lesNiveaux = new ArrayList<Niveau>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Niveau>>(){}.getType();
                    EdeipExtranet.storedData.lesNiveaux = gRetour.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadNiveau = true;
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Niveaux : " + t.toString());
                }
//                Log.i("StoredData", "Niveau Load");
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des Niveaux - " + statusCode + " : " + error.toString());
            }
        });
    }

    public static void getAllUtilisateur() {
        String url = "api/RealmData.php";
        AsyncHttpClient unClient = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get","AllUtilisateur");
//        Log.e("StoreData", "getAllUtilisateur");
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadUtilisateur = false;
                EdeipExtranet.storedData.lesUtilisateurs = new ArrayList<Utilisateur>();
                try{
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Utilisateur>>(){}.getType();
                    EdeipExtranet.storedData.lesUtilisateurs = gRetour.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadUtilisateur = true;

                    AsyncWebService.getAllAdministrateur();
                    AsyncWebService.getAllProfesseur();
                    AsyncWebService.getAllResponsable();
                    AsyncWebService.getAllEleve();
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Utilisateurs : " + t.toString());
                }
//                Log.i("StoredData", "Utilisateur Load");
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des Utilisateur - " + statusCode + " : " + error.toString());
            }
        });
    }

    public static void getAllMatiere() {
        String url = "api/RealmData.php";
        AsyncHttpClient unClient = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllMatiere");
        unClient.get(baseUrl+url , params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadMatiere = false;
                EdeipExtranet.storedData.lesMatieres = new ArrayList<Matiere>();
                try{
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Matiere>>(){}.getType();
                    EdeipExtranet.storedData.lesMatieres = gRetour.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadMatiere = true;
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Matiere : " + t.toString());
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des Matiere - " + statusCode + " : " + error.toString());
            }
        });
    }

    public static void getAllAdministrateur() {
        if (!EdeipExtranet.storedData.loadUtilisateur){
            getAllUtilisateur();
        }
        else{
            String url = "api/RealmData.php";
            AsyncHttpClient unClient = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            params.add("get", "AllAdministrateur");
            unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
                @Override
                public void onSuccess(String reponse){
                    String retour = HtmlDecodePost(reponse);
                    EdeipExtranet.storedData.loadAdministrateur = false;
                    EdeipExtranet.storedData.lesAdministrateurs = new ArrayList<>();
                    try {
                        Gson gRetour = new Gson();
                        Type collectionType = new TypeToken<Collection<Administrateur>>(){}.getType();
                        Collection<Administrateur> desAdministrateurs = gRetour.fromJson(retour, collectionType);
                        for (Administrateur unAdministrateur : desAdministrateurs){
                            Utilisateur unUtilisateur = EdeipExtranet.storedData.getUtilisateurById(unAdministrateur.getIdUtilisateur());
                            unAdministrateur.update(unUtilisateur);
                            EdeipExtranet.storedData.lesAdministrateurs.add(unAdministrateur);
                        }
                    } catch (Throwable t){
                        Log.e("RealmData", "Erreur dans la recuperation des Administrateur : " + t.toString());
                    }
                }
                @Override
                public void onFailure(int statusCode, Throwable error, String content){
                    Log.e("RealmData", "Erreur dans l'appel WS des Administrateur - " + statusCode + " : " + error.toString());
                }
            });

        }
    }

    public static void getAllProfesseur() {
        if (!EdeipExtranet.storedData.loadUtilisateur){
            getAllUtilisateur();
        }
        else{
            String url = "api/RealmData.php";
            AsyncHttpClient unClient = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            params.add("get", "AllProfesseur");
            unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
                @Override
                public void onSuccess(String reponse){
                    String retour = HtmlDecodePost(reponse);
                    EdeipExtranet.storedData.loadProfesseur = false;
                    EdeipExtranet.storedData.lesProfesseurs = new ArrayList<Professeur>();
                    try {
                        Gson gRetour = new Gson();
                        Type collectionType = new TypeToken<Collection<Professeur>>(){}.getType();
                        Collection<Professeur> desProfesseurs = gRetour.fromJson(retour, collectionType);
                        for (Professeur unProfesseur : desProfesseurs){
                            Utilisateur unUtilisateur = EdeipExtranet.storedData.getUtilisateurById(unProfesseur.getIdUtilisateur());
                            unProfesseur.update(unUtilisateur);
                            EdeipExtranet.storedData.lesProfesseurs.add(unProfesseur);
                        }
                    } catch (Throwable t){
                        Log.e("RealmData", "Erreur dans la recuperation des Professeur : " + t.toString());
                    }
                }
                @Override
                public void onFailure(int statusCode, Throwable error, String content){
                    Log.e("RealmData", "Erreur dans l'appel WS des Professeur - " + statusCode + " : " + error.toString());
                }
            });
        }
    }

    public static void getAllResponsable() {
        if (!EdeipExtranet.storedData.loadUtilisateur){
            getAllUtilisateur();
        }
        else{
            String url = "api/RealmData.php";
            AsyncHttpClient unClient = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            params.add("get", "AllResponsable");
            unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
                @Override
                public void onSuccess(String reponse){
                    String retour = HtmlDecodePost(reponse);
                    EdeipExtranet.storedData.loadResponsable = false;
                    EdeipExtranet.storedData.lesResponsables = new ArrayList<Responsable>();
                    try {
                        Gson gRetour = new Gson();
                        Type collectionType = new TypeToken<Collection<Responsable>>(){}.getType();
                        Collection<Responsable> desResponsables = gRetour.fromJson(retour, collectionType);
                        for (Responsable unResponsable : desResponsables){
                            Utilisateur unUtilisateur = EdeipExtranet.storedData.getUtilisateurById(unResponsable.getIdUtilisateur());
                            unResponsable.update(unUtilisateur);
                            EdeipExtranet.storedData.lesResponsables.add(unResponsable);
                        }
                    } catch (Throwable t){
                        Log.e("RealmData", "Erreur dans la recuperation des Responsable : " + t.toString());
                    }
                }
                @Override
                public void onFailure(int statusCode, Throwable error, String content){
                    Log.e("RealmData", "Erreur dans l'appel WS des Responsable - " + statusCode + " : " + error.toString());
                }
            });
        }
    }

    public static void getAllEleve() {
        if (!EdeipExtranet.storedData.loadUtilisateur){
            getAllUtilisateur();
        }
        else{
            String url = "api/RealmData.php";
            AsyncHttpClient unClient = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            params.add("get", "AllEleve");
            unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
                @Override
                public void onSuccess(String reponse){
                    String retour = HtmlDecodePost(reponse);
                    EdeipExtranet.storedData.loadEleve = false;
                    EdeipExtranet.storedData.lesEleves = new ArrayList<Eleve>();
                    try {
                        Gson gRetour = new Gson();
                        Type collectionType = new TypeToken<Collection<Responsable>>(){}.getType();
                        Collection<Responsable> desResponsables = gRetour.fromJson(retour, collectionType);
                        for (Responsable unResponsable : desResponsables){
                            Utilisateur unUtilisateur = EdeipExtranet.storedData.getUtilisateurById(unResponsable.getIdUtilisateur());
                            unResponsable.update(unUtilisateur);
                            EdeipExtranet.storedData.lesResponsables.add(unResponsable);
                        }
                    } catch (Throwable t){
                        Log.e("RealmData", "Erreur dans la recuperation des Responsable : " + t.toString());
                    }
                }
                @Override
                public void onFailure(int statusCode, Throwable error, String content){
                    Log.e("RealmData", "Erreur dans l'appel WS des Responsable - " + statusCode + " : " + error.toString());
                }
            });
        }
    }

    public static void getAllCahierText(){
        String url = "api/RealmData.php";
        AsyncHttpClient unClient = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllCahierTexte");
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadCahierText = false;
                EdeipExtranet.storedData.lesCahierTexts = new ArrayList<CahierText>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<CahierText>>(){}.getType();
                    EdeipExtranet.storedData.lesCahierTexts = gRetour.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadCahierText = true;
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des CahierText : " + t.toString());
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des CahierText - " + statusCode + " : " + error.toString());
            }
        });
    }

    public static void getAllCarnetLiaison(){
        String url = "api/RealmData.php";
        AsyncHttpClient unClient = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllCarnetLiaison");
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadCarnetLiaison = false;
                EdeipExtranet.storedData.lesCarnetLiaisons = new ArrayList<CarnetLiaison>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<CarnetLiaison>>(){}.getType();
                    EdeipExtranet.storedData.lesCarnetLiaisons = gRetour.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadCarnetLiaison = true;
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des CarnetLiaison : " + t.toString());
                }
            }
        });
    }
}
