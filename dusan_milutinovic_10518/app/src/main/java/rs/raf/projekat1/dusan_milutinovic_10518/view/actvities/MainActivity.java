package rs.raf.projekat1.dusan_milutinovic_10518.view.actvities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import rs.raf.projekat1.dusan_milutinovic_10518.R;
import rs.raf.projekat1.dusan_milutinovic_10518.view.viewpager.PagerAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        init();
    }

    private void init() {
        initViewPager();
        initNavigation();
    }

    private void initViewPager() {
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    }

    private void initNavigation() {
        ((BottomNavigationView) findViewById(R.id.bottomNavigation)).setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_1:
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_1, false);
                    break;
            }

            return true;
        });
    }
}