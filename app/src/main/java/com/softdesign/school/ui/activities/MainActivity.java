package com.softdesign.school.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ActionBarContainer;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.softdesign.school.R;
import com.softdesign.school.utils.Lg;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VISIBLE_KEY = "visible";

    CheckBox mCheckBox;
    EditText mEditText;
    EditText mEditText2;
    Toolbar mToolbar;


    @Override
    public void onClick(View v)  {
        int id = v.getId();
        switch (id) {
            case R. id.checkBox:
                Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
                if (mCheckBox.isChecked() ) {
                    mEditText2.setVisibility(View.INVISIBLE);
                } else {
                    mEditText2.setVisibility(View.VISIBLE);
                }
                break;



        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Lg.e(this.getLocalClassName(), "===============================");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("School lesson 1");


        Lg.e(this.getLocalClassName(), "on create");
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);

        mEditText = (EditText) findViewById(R.id.text_field_1);
        mEditText2 = (EditText) findViewById(R.id.text_field_2);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setupToolbar();

    }


    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "Menu click", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Lg.e(this.getLocalClassName(), "on start");
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


     @Override
    protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Lg.e(this.getLocalClassName(), "on save instance state");
         outState.putBoolean(VISIBLE_KEY, mEditText2.getVisibility() == View.VISIBLE);
    }


     @Override
     protected void onRestoreInstanceState(Bundle SaveInstanceState) {
     super.onRestoreInstanceState(SaveInstanceState);
     Lg.e(this.getLocalClassName(), "on restore instance state");
         int visibleState = SaveInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE;

         mEditText2.setVisibility(visibleState);
     }



}