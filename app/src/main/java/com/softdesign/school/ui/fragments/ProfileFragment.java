package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
<<<<<<< HEAD
=======
<<<<<<< HEAD

=======
>>>>>>> ДЗ_4
>>>>>>> master
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
<<<<<<< HEAD
=======
<<<<<<< HEAD

=======
>>>>>>> ДЗ_4
>>>>>>> master
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.utils.BlockToolbar;


public class ProfileFragment extends Fragment {

<<<<<<< HEAD
=======
<<<<<<< HEAD

=======
>>>>>>> ДЗ_4
>>>>>>> master
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_profile,null,false);
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

        navigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);

        collapseToolbar.setTitle(getResources().getString(R.string.header_family));

        /* кнопка с иконкой в Профиле
         */
<<<<<<< HEAD
=======
<<<<<<< HEAD

        params.setAnchorId(R.id.appbar_layout);
        params.anchorGravity= Gravity.RIGHT|Gravity.BOTTOM;
        actionButton.setImageResource(R.drawable.fab_edit);

        appBar.setExpanded(true);
        BlockToolbar.setDrag(true, appBar);

=======
>>>>>>> master

        params.setAnchorId(R.id.appbar_layout);
        params.anchorGravity= Gravity.RIGHT|Gravity.BOTTOM;
        actionButton.setImageResource(R.drawable.fab_edit);

        appBar.setExpanded(true);
        BlockToolbar.setDrag(true, appBar);
<<<<<<< HEAD
=======
>>>>>>> ДЗ_4
>>>>>>> master
    }
