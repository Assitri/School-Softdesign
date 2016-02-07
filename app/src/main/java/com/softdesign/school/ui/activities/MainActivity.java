package com.softdesign.school.ui.activities;

import android.os.Build;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;
import android.support.v7.app.ActionBar;
import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingFragment;
import com.softdesign.school.ui.fragments.TasksFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.utils.Lg;
import android.widget.Toast;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //тут переменные. и чтобы OnClickListener работал внизу делаем пустой метод onClick, иначе выдает ошибку.
        Toolbar mToolbar;
        int mIntColor;
        NavigationView mNavigationView;
        public DrawerLayout mNavigationDrawer;
        Fragment mFragment;
        FrameLayout mFrameLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Lg.e(this.getLocalClassName(), "===");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mNavigationDrawer =(DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

        setupDrawer();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, new ProfileFragment()).commit();

    }
    @Override
    protected void onStart() {
        super.onStart();
        Lg.e(this.getLocalClassName(), "on start");
    }

   // public void setupToolbar() {
       //setSupportActionBar(mToolbar);
       // android.support.v7.app.ActionBar actionBar = getSupportActionBar();
       // setSupportActionBar(mToolbar);
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
              // actionBar.setDisplayHomeAsUpEnabled(true);
    //}
    private void setupToolbar() {
                //setSupportActionBar(mToolbar);
                ActionBar actionBar = getSupportActionBar();
                if (actionBar != null) {
                        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
                        actionBar.setDisplayHomeAsUpEnabled(true);
                   }
            }





    @Override
    protected void onResume() {
        super.onResume();
        Lg.e(this.getLocalClassName(), "on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lg.e(this.getLocalClassName(), "on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Lg.e(this.getLocalClassName(), "on stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e(this.getLocalClassName(), "on restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e(this.getLocalClassName(), "on destroy");
    }


//метод для драйвера. сравнивает getItemId с id из файла драйвер меню, если все ок выдает файлы фрагментов
    public void setupDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        ;
                        break;
                    case R.id.drawer_setting:
                        mFragment = new SettingFragment();
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TasksFragment();
                        break;
                    case R.id.drawer_team:
                        mFragment = new TeamFragment();
                        break;
                }
                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, mFragment).addToBackStack(null).commit();
                }
                mNavigationDrawer.closeDrawers();
                return false;
            }
        });
    }

//кнопочка Home  -вылазиет боковое меню.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
                        Toast.makeText(this,"Menu",Toast.LENGTH_SHORT).show();
                        mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
    //кнопочка Назад
    public void onBackPressed() {
        super.onBackPressed();
        mFragment = getSupportFragmentManager().findFragmentById(R.id.main_frame_container);
    }

    @Override
    public void onClick(View v) {

    }
}