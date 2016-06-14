package fr.rogerleoen.edeip_extranet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import fr.rogerleoen.edeip_extranet.data.ActivityData;
import fr.rogerleoen.edeip_extranet.objet.CahierText;

import java.util.ArrayList;

/**
 * An activity representing a list of CahierTexts. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CahierTextDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class CahierTextListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityData.loadLesCahierText();
        setContentView(R.layout.activity_cahiertext_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        View recyclerView = findViewById(R.id.cahiertext_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.cahiertext_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
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
            case android.R.id.home :
                startActivity(new Intent(this, CahierTextSelectActivity.class));
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
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter((ArrayList<CahierText>) ActivityData.lesCahierText /*EdeipExtranet.storedData.lesCahierTexts*/));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ArrayList<CahierText> mValues;

        public SimpleItemRecyclerViewAdapter(ArrayList<CahierText> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cahiertext_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
//            holder.mIdView.setText(mValues.get(position).getIdCahierTexte().toString());
            holder.mIdView.setText(
                    EdeipExtranet.storedData.getMatiereByIdMatiereNiveau(mValues.get(position).getIdMatiereNiveau()).getLibelleMatiere()
//                    + "\n" +
//                    mValues.get(position).getDateRealisation()
            );
//            holder.mContentView.setText(mValues.get(position).getContenuCahierTexte());
            holder.mContentView.setText("Pour le : " + mValues.get(position).getDateRealisation());


            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        Log.e("holder", holder.mItem.getIdCahierTexte().toString());
//                        arguments.putString(CahierTextDetailFragment.ARG_ITEM_ID, holder.mItem.getIdCahierTexte().toString());
                        CahierTextDetailFragment fragment = new CahierTextDetailFragment();
                        fragment.setArguments(arguments);
                    fragment.ARG_ITEM_ID = holder.mItem;
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.cahiertext_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, CahierTextDetailActivity.class);
                        CahierTextDetailFragment.ARG_ITEM_ID = holder.mItem;
//                        intent.putExtra(CahierTextDetailFragment.ARG_ITEM_ID, holder.mItem.getIdCahierTexte().toString());

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public CahierText mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
