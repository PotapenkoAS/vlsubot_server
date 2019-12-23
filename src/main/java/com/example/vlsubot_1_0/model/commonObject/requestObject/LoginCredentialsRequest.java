package com.example.vlsubot_1_0.model.commonObject.requestObject;

public class LoginCredentialsRequest {
    private String login;
    private String password;
    private String deviceId;

    public LoginCredentialsRequest(String login, String password, String deviceId) {
        this.login = login;
        this.password = password;
        this.deviceId = deviceId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
