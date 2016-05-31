package fr.rogerleoen.edeip_extranet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import fr.rogerleoen.edeip_extranet.data.AsyncWebService;


public class CahierTextSelectActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btViewCahierText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cahier_text_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (EdeipExtranet.storedData.lesCahierTexts.size() < 1){
            AsyncWebService.getAllCahierText();
        }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btViewCahierText = (Button) findViewById(R.id.btViewCahierText);
        btViewCahierText.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_cahier_text, menu);
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


    //pour le bouton
    // lié à l'implémentation View.onClickListener
    @Override
    public void onClick(View v) {
        if (v == btViewCahierText){
            startActivity(new Intent(this, CahierTextListActivity.class));
        }
    }
}
