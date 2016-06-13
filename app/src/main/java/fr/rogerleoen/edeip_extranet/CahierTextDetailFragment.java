package fr.rogerleoen.edeip_extranet;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.rogerleoen.edeip_extranet.objet.CahierText;

/**
 * A fragment representing a single CahierText detail screen.
 * This fragment is either contained in a {@link CahierTextListActivity}
 * in two-pane mode (on tablets) or a {@link CahierTextDetailActivity}
 * on handsets.
 */
public class CahierTextDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public volatile static CahierText ARG_ITEM_ID;

    /**
     * The dummy content this fragment is presenting.
     */
    private CahierText mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CahierTextDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItem = EdeipExtranet.storedData.getCahierTextById(ARG_ITEM_ID.getIdCahierTexte());

        Activity activity = this.getActivity();
        CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setTitle(
                    EdeipExtranet.storedData.getMatiereByIdMatiereNiveau(CahierTextDetailFragment.ARG_ITEM_ID.getIdMatiereNiveau()).getLibelleMatiere()
                            +" ("
                            +CahierTextDetailFragment.ARG_ITEM_ID.getDateRealisation()
                            +")"
            );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cahiertext_detail, container, false);
        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.cahiertext_detail)).setText(mItem.getContenuCahierTexte());
        }
        return rootView;
    }
}
