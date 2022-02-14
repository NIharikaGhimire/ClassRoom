package com.example.navigationdrawerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerlayout);
        toolbar= findViewById(R.id.toolbarId);
        navigationView=findViewById(R.id.nav);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("NavigationProject");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.menu_home){
                    ft=getSupportFragmentManager().beginTransaction();
                    //add replace
                    ft.replace(R.id.framelayout,new HomeFragment());
                    ft.commit();


                }
                if(id==R.id.menu_profile){
                    ft=getSupportFragmentManager().beginTransaction();
                    //add replace
                    ft.replace(R.id.framelayout,new ProfileFragment());
                    ft.commit();


                }
                if(id==R.id.menu_settings){
                    ft=getSupportFragmentManager().beginTransaction();
                    //add replace
                    ft.replace(R.id.framelayout,new SettingsFragment());
                    ft.commit();



                }
                return false;
            }
        });

    }
}