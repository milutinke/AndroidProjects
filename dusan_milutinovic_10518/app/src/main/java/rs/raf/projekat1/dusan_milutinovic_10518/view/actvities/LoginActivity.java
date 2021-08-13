package rs.raf.projekat1.dusan_milutinovic_10518.view.actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rs.raf.projekat1.dusan_milutinovic_10518.R;
import rs.raf.projekat1.dusan_milutinovic_10518.preferences.LoggedUser;
import rs.raf.projekat1.dusan_milutinovic_10518.preferences.PreferencesUtils;

public class LoginActivity extends AppCompatActivity {
    // View components
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText bankNameEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button doLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponents();
    }

    private void initComponents() {
        initViewComponents();
        initListeners();
    }

    private void initViewComponents() {
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        bankNameEditText = findViewById(R.id.bankNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        doLoginButton = findViewById(R.id.doLoginButton);
    }

    private void initListeners() {
        doLoginButton.setOnClickListener(v -> {
            doLogin();
        });
    }

    private void doLogin() {
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String bankName = bankNameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

        if (firstName.length() == 0) {
            Toast.makeText(this, "You must enter a valid first name!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (lastName.length() == 0) {
            Toast.makeText(this, "You must enter a valid last name!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (bankName.length() == 0) {
            Toast.makeText(this, "You must enter a valid bank name!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 5) {
            Toast.makeText(this, "Password must be minimum 5 characters long!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (confirmPassword.length() == 0) {
            Toast.makeText(this, "You must confirm a password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!confirmPassword.equals(password)) {
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            return;
        }

        LoggedUser user = new LoggedUser(firstName, lastName, bankName, password);
        PreferencesUtils.login(this, user);
        Toast.makeText(this, "Successfully logged in!", Toast.LENGTH_SHORT).show();
        doLoginButton.setEnabled(false);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}