package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.utils.BlockToolbar;


public class TaskFragment extends Fragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_task,null,false);
        return convertView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        AppBarLayout appBar = (AppBarLayout) getActivity().findViewById(R.id.appbar_layout);
        NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.navigation_view);
        FloatingActionButton actionButton = (FloatingActionButton) getActivity().findViewById(R.id.float_action_button);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) actionButton.getLayoutParams();
        CollapsingToolbarLayout collapseToolbar = (CollapsingToolbarLayout) getActivity().findViewById(R.id.collapse_toolbar);


        navigationView.getMenu().findItem(R.id.drawer_tasks).setChecked(true);


        collapseToolbar.setTitle(getResources().getString(R.string.drawer_tasks));

        params.setAnchorId(R.id.fragmentContainer);
        params.anchorGravity= Gravity.RIGHT|Gravity.BOTTOM;
        actionButton.setImageResource(R.drawable.fab_add);


        appBar.setExpanded(false,false);
        BlockToolbar.setDrag(false, appBar);
    }
}
