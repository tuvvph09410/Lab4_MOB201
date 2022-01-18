package com.example.lab4_mob201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.lab4_mob201.Fragment.Fragment_Bai1;
import com.example.lab4_mob201.Fragment.Fragment_Bai2;
import com.example.lab4_mob201.Fragment.Fragment_Bai3;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initViewByID();
        this.initBottomNav();
    }

    private void initBottomNav() {
        this.bottomNavigationView.setOnNavigationItemSelectedListener(this);
        checkedItemNavBottom(R.id.bai1);
        this.actionBar.setTitle("Bài 1");
        this.loadFragment(new Fragment_Bai1());
    }

    private void checkedItemNavBottom(int item) {
        this.bottomNavigationView.getMenu().findItem(item).setChecked(true);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void initViewByID() {
        this.bottomNavigationView = findViewById(R.id.bottomNavView);
        this.actionBar = getSupportActionBar();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bai1:
                loadFragment(new Fragment_Bai1());
                this.actionBar.setTitle("Bài 1");
                checkedItemNavBottom(R.id.bai1);
                break;
            case R.id.bai2:
                loadFragment(new Fragment_Bai2());
                this.actionBar.setTitle("Bài 2");
                checkedItemNavBottom(R.id.bai2);
                break;
            case R.id.bai3:
                loadFragment(new Fragment_Bai3());
                this.actionBar.setTitle("Bài 3");
                checkedItemNavBottom(R.id.bai3);
                break;
        }
        return true;
    }
}