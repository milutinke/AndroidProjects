package rs.raf.vezbe.domaci1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ArticleActivity extends AppCompatActivity {

    // View components
    private TextView welcomeText;
    private Button favouriteButton;
    private ImageView star;

    // State
    private boolean favored;
    private SharedPreferences sharedPreferences;

    // Constants
    public static final String SP_FAVORITE_KEY = "favored";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        init();
    }

    private void init() {
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        initViews();
        restoreState();
        initListeners();
    }

    private void initViews() {
        welcomeText = findViewById(R.id.welcomeText);
        favouriteButton = findViewById(R.id.favouriteButton);
        star = findViewById(R.id.star);
    }

    private void restoreState() {
        sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        favored = sharedPreferences.getBoolean(SP_FAVORITE_KEY, false);
        welcomeText.setText(welcomeText.getText().toString().replaceAll("%username%", sharedPreferences.getString("username", "none")));
        Glide.with(this).load(R.drawable.ic_baseline_star_border_24).into(star);

        if (favored) {
            favouriteButton.setText(getResources().getString(R.string.unfavourite));
            Glide.with(this).load(R.drawable.ic_baseline_star_24).into(star);
        }
    }

    private void initListeners() {
        favouriteButton.setOnClickListener(v -> {
            favored = !favored;
            sharedPreferences.edit().putBoolean(SP_FAVORITE_KEY, favored).apply();
            favouriteButton.setText(getResources().getString(favored ? R.string.unfavourite : R.string.favourite));
            Glide.with(this).load(favored ? R.drawable.ic_baseline_star_24 : R.drawable.ic_baseline_star_border_24).into(star);
        });
    }
}