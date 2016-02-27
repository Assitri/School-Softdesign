package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.R;
import com.softdesign.school.ui.adapters.UserAdapter;
import com.softdesign.school.utils.BlockToolbar;

import java.util.ArrayList;


public class ContactsFragment extends Fragment {

    /* Array - массив с данными о пользователях (объекты User).
      mRecyclerView - View элемент-список
      mLayoutManager - LayoutManager отвечает за положение item элементов в списке
      mAdapter - адаптер, вставляющий элементы из объектов User в item элементы
     */

    private ArrayList<User> mUsers = new ArrayList<User>();
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_contacts, null, false);
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

        generateData();


        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.contacts_recyclerview);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new UserAdapter(mUsers,getContext());
        mRecyclerView.setAdapter(mAdapter);


        collapseToolbar.setTitle(getResources().getString(R.string.drawer_contacts));

        navigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);

        /* кнопка с иконкой в Контактах справа внизу экрана */

        params.setAnchorId(R.id.fragmentContainer);
        params.anchorGravity= Gravity.RIGHT|Gravity.BOTTOM;
        actionButton.setImageResource(R.drawable.fab_message);

        appBar.setExpanded(false,false);
        mRecyclerView.setNestedScrollingEnabled(false);
        BlockToolbar.setDrag(false,appBar);
    }

    /* Данные пользователей. Вставляет в массив объекты User. */
    private void generateData() {
        mUsers.add(new User("unit", "1", getResources().getDrawable(R.drawable.contact_1)));
        mUsers.add(new User("unit", "2", getResources().getDrawable(R.drawable.contact_2)));
        mUsers.add(new User("unit","3",getResources().getDrawable(R.drawable.contact_3)));
        mUsers.add(new User("unit", "4", getResources().getDrawable(R.drawable.contact_4)));
        mUsers.add(new User("unit", "5", getResources().getDrawable(R.drawable.contact_5)));
        mUsers.add(new User("unit", "6", getResources().getDrawable(R.drawable.contact_1)));
        mUsers.add(new User("unit", "7", getResources().getDrawable(R.drawable.contact_2)));
        mUsers.add(new User("unit", "8", getResources().getDrawable(R.drawable.contact_3)));
        mUsers.add(new User("unit", "9", getResources().getDrawable(R.drawable.contact_4)));
        mUsers.add(new User("unit", "10", getResources().getDrawable(R.drawable.contact_5)));
    }
}
