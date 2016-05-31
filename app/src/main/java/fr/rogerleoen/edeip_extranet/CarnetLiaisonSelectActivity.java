package fr.rogerleoen.edeip_extranet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import fr.rogerleoen.edeip_extranet.data.AsyncWebService;

public class CarnetLiaisonSelectActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btViewCarnetLiaison;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnet_liaison_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (EdeipExtranet.storedData.lesCarnetLiaisons.size() < 1){
            AsyncWebService.getAllCarnetLiaison();
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

        btViewCarnetLiaison = (Button) findViewById(R.id.btViewCarnetLiaison);
        btViewCarnetLiaison.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_carnet_liaison, menu);
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

    @Override
    public void onClick(View v) {
        if (v == btViewCarnetLiaison){
            startActivity(new Intent(this, CarnetLiaisonListActivity.class));
        }
    }
}
