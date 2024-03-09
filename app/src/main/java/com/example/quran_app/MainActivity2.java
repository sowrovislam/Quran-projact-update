package com.example.quran_app;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
public class MainActivity2 extends AppCompatActivity {



    DrawerLayout drawerLayout;
    NavigationView navigationView;
    MaterialToolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigationview);
        materialToolbar=findViewById(R.id.toolbar);




//<<<<<<<<<<<<<<<<<<<<<<<<<<<< DrawerLayout >>>>>>>>>>>>>>>>>>>>>>>>> Start >>>>>

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(
                MainActivity2.this,drawerLayout,materialToolbar,R.string.CloseDrawer,R.string.OpenDeawer);
        drawerLayout.addDrawerListener(toggle);

//<<<<<<<<<<<<<<<<<<<<<<<<<<<< DrawerLayout >>>>>>>>>>>>>>>>>>>>>>>>> End >>>>>


        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fremlayout,new BlankFragment());
        fragmentTransaction.commit();












    }



}