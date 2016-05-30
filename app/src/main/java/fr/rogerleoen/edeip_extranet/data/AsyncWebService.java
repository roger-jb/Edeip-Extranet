package fr.rogerleoen.edeip_extranet.data;

import android.text.Html;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import fr.rogerleoen.edeip_extranet.EdeipExtranet;
import fr.rogerleoen.edeip_extranet.objet.Connexion;
import fr.rogerleoen.edeip_extranet.objet.Matiere;
import fr.rogerleoen.edeip_extranet.objet.Niveau;
import fr.rogerleoen.edeip_extranet.objet.Utilisateur;

/**
 * Application Edeip-Extranet
 * Created by Jean-Baptiste on 30/05/2016.
 */
public class AsyncWebService {
    protected static String baseUrl = "http://192.168.10.3/edeip/";
//    protected static String baseUrl = "http://roger-leoen.ddns.net/edeip/";
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
                EdeipExtranet.storedData.lesConnexions = new ArrayList<Connexion>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Connexion>>(){}.getType();
                    EdeipExtranet.storedData.lesConnexions = gRetour.fromJson(retour, collectionType);
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
                EdeipExtranet.storedData.lesNiveaux = new ArrayList<Niveau>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Niveau>>(){}.getType();
                    EdeipExtranet.storedData.lesNiveaux = gRetour.fromJson(retour, collectionType);
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
                EdeipExtranet.storedData.lesUtilisateurs = new ArrayList<Utilisateur>();
                try{
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Utilisateur>>(){}.getType();
                    EdeipExtranet.storedData.lesUtilisateurs = gRetour.fromJson(retour, collectionType);
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
        unClient.get(url , params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.lesMatieres = new ArrayList<Matiere>();
                try{
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Matiere>>(){}.getType();
                    EdeipExtranet.storedData.lesMatieres = gRetour.fromJson(retour, collectionType);
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
    }

    public static void getAllProfesseur() {
    }

    public static void getAllResponsable() {
    }

    public static void getAllEleve() {
    }
}
