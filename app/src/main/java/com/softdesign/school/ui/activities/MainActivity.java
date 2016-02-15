package com.softdesign.school.ui.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingsFragment;
import com.softdesign.school.ui.fragments.TaskFragment;
import com.softdesign.school.ui.fragments.TeamFragment;


public class MainActivity extends AppCompatActivity {

    /*
      переменные
     */

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private Fragment mFragment;

    /*
    В onCreate метод setContentView подгружает в это Активити
    ресурс activity_main, для размещения нашего созданного интерфейса.
    Так же тут идет нахождение тулбара по его id в др файлах, помещение сего в переменную
    mToolbar и потом уже вызов метода setupToolbar(). Все то же самое с id drawer_layout и
    navigation_view. Подгружаем файлы фрагментов.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawer();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ProfileFragment()).commit();

    }

    /*
      Mетод setupToolBar -  yстанавливает Toolbar и иконку для кнопки Home.
     */
    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.toolbar_menu_icon);
    }

    /*
     метод setupDrawer - чтобы меню было кликабельным и по клику на item переходило на нужный фрагмент. сравнивает id
     пункта меню с id фрагментов, если все ок создает новый объект по ссылке mFragment и показывает нужный нам файл фрагмента.
     */

    private void setupDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        break;
                    case R.id.drawer_team:
                        mFragment = new TeamFragment();
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TaskFragment();
                        break;
                    case R.id.drawer_settings:
                        mFragment = new SettingsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, mFragment).addToBackStack(null).commit();
                mDrawerLayout.closeDrawers();
                return false;
            }
        });
    }

    /*
      метод onOptionsItemSelected - для обработки нажатий пунктов меню и  запуска layout.

     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }



}
