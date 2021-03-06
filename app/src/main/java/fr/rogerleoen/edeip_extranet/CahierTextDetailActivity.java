package fr.rogerleoen.edeip_extranet;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

/**
 * An activity representing a single CahierText detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link CahierTextListActivity}.
 */
public class CahierTextDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cahiertext_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        toolbar.setTitle(EdeipExtranet.storedData.getMatiereByIdMatiereNiveau(CahierTextDetailFragment.ARG_ITEM_ID.getIdMatiereNiveau()).getLibelleMatiere()+" ("+CahierTextDetailFragment.ARG_ITEM_ID.getDateRealisation()+")");
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
//            arguments.putString(CahierTextDetailFragment.ARG_ITEM_ID,
//                    getIntent().getStringExtra(CahierTextDetailFragment.ARG_ITEM_ID.getIdCahierTexte().toString()));
            CahierTextDetailFragment fragment = new CahierTextDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.cahiertext_detail_container, fragment)
                    .commit();
        }
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig){
//        super.onConfigurationChanged(newConfig);
//        Toolbar laToolBar = (Toolbar) findViewById(R.id.toolbar_layout);
//        laToolBar.setTitle(CahierTextDetailFragment.ARG_ITEM_ID.getDateRealisation());
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_cahier_text, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.home :
                navigateUpTo(new Intent(this, CahierTextListActivity.class));
                return true;
            case R.id.action_CarnetLiaison :
                startActivity(new Intent(this, CarnetLiaisonListActivity.class));
                return true;
            case R.id.action_CahierText :
                startActivity(new Intent(this, CahierTextSelectActivity.class));
                return true;
            case R.id.action_deconnexion :
                EdeipExtranet.Deconnexion();
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
