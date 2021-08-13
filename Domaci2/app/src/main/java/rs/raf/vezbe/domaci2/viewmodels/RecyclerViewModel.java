package rs.raf.vezbe.domaci2.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import rs.raf.vezbe.domaci2.models.User;

public class RecyclerViewModel extends ViewModel {
    public static int counter = 101;

    private final MutableLiveData<List<User>> users = new MutableLiveData<>();
    private final List<User> usersList = new ArrayList<>();

    public RecyclerViewModel() {
        for (int i = 0; i <= 100; i++)
            usersList.add(new User(i, "Test " + i, "User " + i, "+38634234523", "user@example.com", "https://i.pravatar.cc/70"));

        users.setValue(new ArrayList<>(usersList));
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public void filterUsers(String text) {
        List<User> filteredCars = usersList.stream().filter(user -> user.getFirstName().toLowerCase().startsWith(text.toLowerCase())).collect(Collectors.toList());
        users.setValue(filteredCars);
    }

    public void addUser() {
        usersList.add(new User(counter++, "Test " + counter, "User" + counter, "+38634234523", "user@example.com", "https://i.pravatar.cc/70"));
        users.setValue(new ArrayList<>(usersList));
    }

    public void deleteUser(User user) {
        usersList.remove(user);
        users.setValue(new ArrayList<>(usersList));
    }
}
