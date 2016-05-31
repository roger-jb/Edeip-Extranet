package fr.rogerleoen.edeip_extranet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AccueilActivity extends AppCompatActivity {

    private TextView txtNomPrenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtNomPrenom = (TextView) findViewById(R.id.txtNomPrenom);
        txtNomPrenom.setText(EdeipExtranet.getUser().getNomUtilisateur() + " " + EdeipExtranet.getUser().getPrenomUtilisateur());
    }

    @Override
    public void onResume(){
        super.onResume();
        txtNomPrenom.setText(EdeipExtranet.getUser().getNomUtilisateur() + " " + EdeipExtranet.getUser().getPrenomUtilisateur());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_accueil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.action_CarnetLiaison :
                startActivity(new Intent(this, CarnetLiaisonSelectActivity.class));
                return true;
            case R.id.action_CahierText :
                startActivity(new Intent(this, CahierTextSelectActivity.class));
                return true;
            case R.id.action_deconnexion :
                EdeipExtranet.Deconnexion();
                startActivity(new Intent(this, LoginActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
