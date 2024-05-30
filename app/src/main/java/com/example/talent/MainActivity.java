package com.example.talent;

import static com.example.talent.R.id.itHome;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.talent.ui.adapter.AdapterViewPager;
import com.example.talent.ui.fragment.FragmentHistorio;
import com.example.talent.ui.fragment.FragmentHome;
import com.example.talent.ui.fragment.FragmentMensagem;
import com.example.talent.ui.fragment.FragmentSuporte;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager2 pagerMain;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pagerMain = findViewById(R.id.pagerMain);
        bottomNav = findViewById(R.id.BottomNav);

        fragmentArrayList.add(new FragmentHome());
        fragmentArrayList.add(new FragmentSuporte());
        fragmentArrayList.add(new FragmentMensagem());
        fragmentArrayList.add(new FragmentHistorio());

        AdapterViewPager adapterViewPager = new AdapterViewPager(this, fragmentArrayList);
        //setAdapter
        pagerMain.setAdapter(adapterViewPager);
        pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNav.setSelectedItemId(R.id.itHome);
                        break;
                    case 1:
                        bottomNav.setSelectedItemId(R.id.itSuporte);
                        break;
                    case 2:
                        bottomNav.setSelectedItemId(R.id.itMensagem);
                        break;
                    case 3:
                        bottomNav.setSelectedItemId(R.id.itHistorico);
                        break;
                }

                super.onPageSelected(position);
            }
        });

    }

}