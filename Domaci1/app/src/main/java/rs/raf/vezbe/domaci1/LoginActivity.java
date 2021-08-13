package rs.raf.vezbe.domaci1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    // View components
    private EditText username;
    private EditText password;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        initViews();
        initListeners();
    }

    private void initViews() {
        this.username = findViewById(R.id.username);
        this.password = findViewById(R.id.password);
        this.loginButton = findViewById(R.id.loginButton);
    }

    private void initListeners() {
        loginButton.setOnClickListener(v -> {
            String username = this.username.getText().toString().trim();
            String password = this.password.getText().toString();

            if (username.isEmpty()) {
                this.username.setFocusable(true);
                Toast.makeText(this, "Please enter the username!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.isEmpty()) {
                this.password.setFocusable(true);
                Toast.makeText(this, "Please enter the password!", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
            sharedPreferences.edit().putString("username", username).apply();

            Intent intent = new Intent(this, ArticleActivity.class);
            startActivity(intent);
            finish();
        });
    }
}