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
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadConnexion = false;
                EdeipExtranet.storedData.lesConnexions = new ArrayList<>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Connexion>>(){}.getType();
                    EdeipExtranet.storedData.lesConnexions = gRetour.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadConnexion = true;
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Connexions : " + t.toString());
                }
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
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadNiveau = false;
                EdeipExtranet.storedData.lesNiveaux = new ArrayList<>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Niveau>>(){}.getType();
                    EdeipExtranet.storedData.lesNiveaux = gRetour.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadNiveau = true;
                    if (!EdeipExtranet.storedData.loadModule){
                        AsyncWebService.getAllModules();
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Niveaux : " + t.getMessage());
                }
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
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadUtilisateur = false;
                EdeipExtranet.storedData.lesUtilisateurs = new ArrayList<>();
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
                EdeipExtranet.storedData.lesMatieres = new ArrayList<>();
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
                    EdeipExtranet.storedData.lesProfesseurs = new ArrayList<>();
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
                    EdeipExtranet.storedData.lesResponsables = new ArrayList<>();
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
                    EdeipExtranet.storedData.lesEleves = new ArrayList<>();
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
                EdeipExtranet.storedData.lesCahierTexts = new ArrayList<>();
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
                EdeipExtranet.storedData.lesCarnetLiaisons = new ArrayList<>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<CarnetLiaison>>(){}.getType();
                    EdeipExtranet.storedData.lesCarnetLiaisons = gRetour.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadCarnetLiaison = true;
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des CarnetLiaison : " + t.toString());
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des CarnetLiaison - " + statusCode + " : " + error.toString());
            }
        });
    }

    public static void getAllModules(){
        String url = "api/RealmData.php";
        AsyncHttpClient unClient = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllModule");
        Log.i("StoredData", "recup des modules");
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadModule = false;
                EdeipExtranet.storedData.lesModules = new ArrayList<>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Module>>(){}.getType();
                    EdeipExtranet.storedData.lesModules = gRetour.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadModule = true;
                    Log.i("StoredData", "loadModule OK");
                    if (!EdeipExtranet.storedData.loadNiveau){
                        AsyncWebService.getAllNiveau();
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Modules : " + t.getMessage());
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des Modules - " + statusCode + " : " + error.toString());
            }
        });
    }

    public static void getAllMatiereNiveau(){
        String url = "api/RealmData.php";
        AsyncHttpClient unClient = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllMatiereNiveau");
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadMatiereNiveau = false;
                EdeipExtranet.storedData.lesMatiereNiveau = new ArrayList<>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<MatiereNiveau>>(){}.getType();
                    EdeipExtranet.storedData.lesMatiereNiveau = gRetour.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadMatiereNiveau = true;
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des MatiereNiveau : " + t.toString());
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des MatiereNiveau - " + statusCode + " : " + error.toString());
            }
        });
    }

    public static void getAllEleveMatiereNiveau(){
        String url = "api/RealmData.php";
        AsyncHttpClient unClient = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllEleveMatiereNiveau");
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadEleveMatiereNiveau = false;
                EdeipExtranet.storedData.lesEleveMatiereNiveau = new ArrayList<>();
                try {
                    Gson gson = new Gson();
                    Type collectionType = new TypeToken<Collection<EleveMatiereNiveau>>(){}.getType();
                    EdeipExtranet.storedData.lesEleveMatiereNiveau = gson.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadEleveMatiereNiveau = false;
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des EleveMatiereNiveau : " + t.toString());
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des EleveMatiereNiveau - " + statusCode + " : " + error.toString());
            }
        });
    }

    public static void getAllProfesseurMatiereNiveau(){
        String url = "api/RealmData.php";
        AsyncHttpClient unClient = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllProfesseurMatiereNiveau");
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadProfesseurMatiereNiveau = false;
                EdeipExtranet.storedData.lesProfesseurMatiereNiveau = new ArrayList<>();
                try {
                    Gson gson = new Gson();
                    Type collectionType = new TypeToken<Collection<ProfesseurMatiereNiveau>>(){}.getType();
                    EdeipExtranet.storedData.lesProfesseurMatiereNiveau = gson.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadProfesseurMatiereNiveau = false;
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des ProfesseurMatiereNiveau : " + t.toString());
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des ProfesseurMatiereNiveau - " + statusCode + " : " + error.toString());
            }
        });
    }

    public static void getAllEleveResponsabe(){
        String url = "api/RealmData.php";
        AsyncHttpClient unClient = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllEleveResponsable");
        unClient.get(baseUrl+url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String reponse){
                String retour = HtmlDecodePost(reponse);
                EdeipExtranet.storedData.loadEleveResponsable = false;
                EdeipExtranet.storedData.lesEleveResponsable = new ArrayList<>();
                try {
                    Gson gson = new Gson();
                    Type collectionType = new TypeToken<Collection<EleveResponsable>>(){}.getType();
                    EdeipExtranet.storedData.lesEleveResponsable = gson.fromJson(retour, collectionType);
                    EdeipExtranet.storedData.loadEleveResponsable = false;
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des EleveResponsable : " + t.toString());
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des EleveResponsable - " + statusCode + " : " + error.toString());
            }
        });
    }

    private static void linkModuleNiveau(){
        Log.e("storedData", "linkModuleNiveau");
        Log.e("storedData", "lesNiveaux.size() : " + Integer.toString(EdeipExtranet.storedData.lesNiveaux.size()));
        Log.e("storedData", "lesModules.size() : " + Integer.toString(EdeipExtranet.storedData.lesModules.size()));
        if (EdeipExtranet.storedData.lesNiveaux.size()>0 && EdeipExtranet.storedData.lesModules.size() > 0) {
            for (Niveau unNiveau : EdeipExtranet.storedData.lesNiveaux) {
                unNiveau.setModule(EdeipExtranet.storedData.getModuleById(unNiveau.getIdModule()));
                EdeipExtranet.storedData.getModuleById(unNiveau.getIdModule()).addNiveau(unNiveau);
            }
        }
    }

    private static void linkMatiereNiveau(){
        if (EdeipExtranet.storedData.lesMatiereNiveau.size()>0)
            for (MatiereNiveau unMatiereNiveau : EdeipExtranet.storedData.lesMatiereNiveau){
                EdeipExtranet.storedData.getMatiereById(unMatiereNiveau.getIdMatiere()).addNiveau(EdeipExtranet.storedData.getNiveauById(unMatiereNiveau.getIdNiveau()));
                EdeipExtranet.storedData.getNiveauById(unMatiereNiveau.getIdNiveau()).addMatiere(EdeipExtranet.storedData.getMatiereById(unMatiereNiveau.getIdMatiere()));
            }
    }
}
