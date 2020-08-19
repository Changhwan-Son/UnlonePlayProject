package dto;

public class LoginRequest {
    public String name;
    public String password;
    public boolean rememberName;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberName() {
        return rememberName;
    }

    public void setRememberName(boolean rememberName) {
        this.rememberName = rememberName;
    }
}
