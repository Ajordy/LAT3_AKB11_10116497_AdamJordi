package Ajordy.com.view;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import Ajordy.com.R;
import Ajordy.com.view.daily.DailyFragment;
import Ajordy.com.view.gallery.GalleryFragment;
import Ajordy.com.view.home.HomeFragment;
import Ajordy.com.view.music.MusicFragment;
import Ajordy.com.view.profile.ProfileFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
    }

    void loadFragment(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,fragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.navigation_home:
                loadFragment(new HomeFragment());
                return  true;
            case R.id.navigation_daily:
                loadFragment(new DailyFragment());
                return  true;
            case R.id.navigation_galery:
                loadFragment(new GalleryFragment());
                return  true;
            case R.id.navigation_music:
                loadFragment(new MusicFragment());
                return  true;
            case R.id.navigation_profile:
                loadFragment(new ProfileFragment());
                return  true;

        }
        return false;
    }
}
