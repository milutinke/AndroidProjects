package rs.raf.projekat1.dusan_milutinovic_10518.preferences;

import java.sql.Struct;

public class LoggedUser {
    private String fistName;
    private String lastName;
    private String bankName;
    private String password;

    public LoggedUser() {
    }

    public LoggedUser(String fistName, String lastName, String bankName, String password) {
        this();

        this.fistName = fistName;
        this.lastName = lastName;
        this.bankName = bankName;
        this.password = password;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
