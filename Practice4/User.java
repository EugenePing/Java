package Shapenko.Practice4;

public class User {
    private String role;
    private Account account;

    public User(String role, Account account) {
        this.role = role;
        this.account = account;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
