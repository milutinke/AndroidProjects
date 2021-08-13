package rs.raf.vezbe.domaci1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        new Handler().postDelayed(() -> {
            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
            boolean isLoggedIn = sharedPreferences.contains("username") && (!sharedPreferences.getString("username", "").trim().isEmpty());

            Intent intent = new Intent(MainActivity.this, !isLoggedIn ? LoginActivity.class : ArticleActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }
}