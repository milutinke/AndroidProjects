package rs.raf.projekat1.dusan_milutinovic_10518.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class PreferencesUtils {
    public static final String SHARED_PREFERENCES = "SHARED_PREFERENCES";
    public static final String IS_LOGGED_IN = "IS_LOGGED_IN";

    public static final String USER_FIRST_NAME = "USER_FIRST_NAME";
    public static final String USER_LAST_NAME = "USER_LAST_NAME";
    public static final String USER_BANK_NAME = "USER_BANK_NAME";
    public static final String USER_PASSWORD = "USER_PASSWORD";

    public static boolean isLoggedIn(AppCompatActivity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

    public static LoggedUser getLoggedUser(AppCompatActivity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);

        if (!PreferencesUtils.isLoggedIn(activity))
            return null;

        LoggedUser user = new LoggedUser();
        user.setFistName(sharedPreferences.getString(USER_FIRST_NAME, "None"));
        user.setLastName(sharedPreferences.getString(USER_LAST_NAME, "None"));
        user.setBankName(sharedPreferences.getString(USER_BANK_NAME, "None"));
        user.setPassword(sharedPreferences.getString(USER_PASSWORD, "None"));

        return user;
    }

    public static void login(AppCompatActivity activity, LoggedUser loggedUser) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(USER_FIRST_NAME, loggedUser.getFistName());
        editor.putString(USER_LAST_NAME, loggedUser.getLastName());
        editor.putString(USER_BANK_NAME, loggedUser.getBankName());
        editor.putString(USER_PASSWORD, loggedUser.getPassword());

        editor.putBoolean(IS_LOGGED_IN, true);
        editor.commit();
    }
}
