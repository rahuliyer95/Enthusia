package org.enthusia.app.enthusia.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etsy.android.grid.StaggeredGridView;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;

import org.enthusia.app.R;
import org.enthusia.app.enthusia.adapters.EnthusiaSponsorsAdapter;

import java.util.ArrayList;

public class EnthusiaSponsorsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.enthusia_fragment_sponsors, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TypedArray array = getResources().obtainTypedArray(R.array.enthusia_spons);
        ArrayList<Integer> objects = new ArrayList<>(array.length());
        for (int i=0; i < array.length(); i++)
            objects.add(array.getResourceId(i, -1));

        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(new EnthusiaSponsorsAdapter(getActivity(), objects));
        animationAdapter.setAbsListView(((StaggeredGridView) getActivity().findViewById(R.id.enthusia_grid_sponsors)));
        ((StaggeredGridView) getActivity().findViewById(R.id.enthusia_grid_sponsors)).setAdapter(animationAdapter);
    }
}
