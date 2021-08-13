package rs.raf.vezbe.domaci2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rs.raf.vezbe.domaci2.models.User;
import rs.raf.vezbe.domaci2.recycler.adapter.UserAdapter;
import rs.raf.vezbe.domaci2.recycler.differ.UserDifferCallback;
import rs.raf.vezbe.domaci2.viewmodels.RecyclerViewModel;

public class MainActivity extends AppCompatActivity {

    // View components
    private RecyclerView recyclerView;
    private EditText filterInputView;
    private Button addUserButtonView;

    private RecyclerViewModel recyclerViewModel;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        recyclerViewModel = new ViewModelProvider(this).get(RecyclerViewModel.class);

        initViews();
        initListeners();
        initObservers();
        initRecycler();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        filterInputView = findViewById(R.id.filterInputView);
        addUserButtonView = findViewById(R.id.addUserButtonView);
    }

    private void initListeners() {
        filterInputView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                recyclerViewModel.filterUsers(s.toString());
            }
        });

        addUserButtonView.setOnClickListener(v -> {
            recyclerViewModel.addUser();
        });
    }

    private void initObservers() {
        recyclerViewModel.getUsers().observe(this, cars -> {
            userAdapter.submitList(cars);
        });
    }

    private void initRecycler() {
        userAdapter = new UserAdapter(new UserDifferCallback(), user -> {

            new AlertDialog.Builder(this)
                    .setTitle("Confirm Action")
                    .setMessage("Do you really want to delete user " + user.getFirstName() + " " + user.getLastName() + " ?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            Toast.makeText(MainActivity.this, "The user has been succesfully deleted!", Toast.LENGTH_SHORT).show();
                            recyclerViewModel.deleteUser(user);
                        }
                    })
                    .setNegativeButton(android.R.string.no, null).show();

            return null;
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);
    }
}