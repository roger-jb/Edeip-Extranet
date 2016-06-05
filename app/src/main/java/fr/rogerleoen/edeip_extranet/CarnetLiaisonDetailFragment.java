package fr.rogerleoen.edeip_extranet;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.rogerleoen.edeip_extranet.objet.CarnetLiaison;

/**
 * A fragment representing a single CarnetLiaison detail screen.
 * This fragment is either contained in a {@link CarnetLiaisonListActivity}
 * in two-pane mode (on tablets) or a {@link CarnetLiaisonDetailActivity}
 * on handsets.
 */
public class CarnetLiaisonDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static volatile CarnetLiaison ARG_ITEM_ID;

    /**
     * The dummy content this fragment is presenting.
     */
    private CarnetLiaison mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CarnetLiaisonDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItem = EdeipExtranet.storedData.getCarnetLiaisonById(ARG_ITEM_ID.getIdCarnetLiaison());

        Activity activity = this.getActivity();
        CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setTitle(mItem.getDateRedaction());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.carnetliaison_detail, container, false);
        // Show the dummy content as text in a TextView.
        Log.e("DebugmItem", mItem.getDateRedaction() + " " + mItem.getContenuCarnetLiaison());
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.carnetliaison_detail)).setText(mItem.getDateRedaction() + "\n" + mItem.getContenuCarnetLiaison());
        }

        return rootView;
    }
}
