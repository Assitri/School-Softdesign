package com.softdesign.school.ui.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Window;
import android.view.WindowManager;
import com.softdesign.school.R;
import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String VISIBLE_KEY = "visible";
    CheckBox mCheckBox;
    EditText mEditText;
    EditText mEditText2;
    Toolbar mToolbar;
    int mIntColor;

    // сравниваем id с id кнопок и меняем цвет тулбара
    @Override
    public void onClick(View v)  {
        int id = v.getId();
        switch (id) {
            case R. id.checkBox:
                Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
                if (mCheckBox.isChecked() ) {mEditText2.setVisibility(View.INVISIBLE);} else { mEditText2.setVisibility(View.VISIBLE);}
                break;
            case R.id.button_blue:
                setToolBar(getResources().getColor(R.color.primary));
                break;
            case R.id.button_green:
                setToolBar(getResources().getColor(R.color.green));
                break;
            case R.id.button_red:
                setToolBar(getResources().getColor(R.color.red));
                break;
        }
    }

    // Задаем цвет тулбара, вызываем смену статусбара по цвету тулбара, сохраняем цвет. статусбар меняется только от лолипопа и выше
    public void setToolBar(int color) {
        int dark_color=color;
        mToolbar.setBackgroundColor(color);
        if (color == getResources().getColor(R.color.green))  dark_color=getResources().getColor(R.color.green_dark);
        if (color == getResources().getColor(R.color.red))  dark_color=getResources().getColor(R.color.red_dark);
        if (color == getResources().getColor(R.color.primary))  dark_color=getResources().getColor(R.color.primary_dark);
        mIntColor = color;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(dark_color);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Lg.e(this.getLocalClassName(), "===============================");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("School lesson 2");
        Lg.e(this.getLocalClassName(), "on create");
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);
        mEditText = (EditText) findViewById(R.id.text_field_1);
        mEditText2 = (EditText) findViewById(R.id.text_field_2);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mIntColor = R.color.primary;
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
        outState.putInt("mIntColor", mIntColor);
    }


     @Override
     protected void onRestoreInstanceState(Bundle SaveInstanceState) {
         super.onRestoreInstanceState(SaveInstanceState);
         Lg.e(this.getLocalClassName(), "on restore instance state");
         int visibleState = SaveInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE;
         mEditText2.setVisibility(visibleState);
         setToolBar(SaveInstanceState.getInt("mIntColor"));
     }
}