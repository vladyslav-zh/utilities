
package com.globalutiles.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Custom map fragment with fixed bug and with redrawing some layouts on map
 * 
 * @author Vladyslav Z. Jul 11, 2013 10:42:54 AM
 */
public class CustomMapFragment extends SupportMapFragment {
    private OnActivityCreatedListener onActivityCreatedListener;

    public CustomMapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle savedInstance) {
        View layout = super.onCreateView(inflater, view, savedInstance);

        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        ((ViewGroup) layout).addView(frameLayout,
                new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getOnActivityCreatedListener() != null)
            getOnActivityCreatedListener().onCreated();
    }

    public OnActivityCreatedListener getOnActivityCreatedListener() {
        return onActivityCreatedListener;
    }

    public void setOnActivityCreatedListener(
            OnActivityCreatedListener onActivityCreatedListener) {
        this.onActivityCreatedListener = onActivityCreatedListener;
    }

    public interface OnActivityCreatedListener {
        void onCreated();
    }
}
