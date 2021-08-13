package rs.raf.projekat1.dusan_milutinovic_10518.view.actvities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import rs.raf.projekat1.dusan_milutinovic_10518.R;
import rs.raf.projekat1.dusan_milutinovic_10518.preferences.PreferencesUtils;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        initView();
    }

    private void initView() {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, PreferencesUtils.isLoggedIn(this) ? MainActivity.class : LoginActivity.class);
            startActivity(intent);
            finish();
        }, 2000);
    }
}