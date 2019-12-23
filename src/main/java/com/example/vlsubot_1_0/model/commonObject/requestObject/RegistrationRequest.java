package com.example.vlsubot_1_0.model.commonObject.requestObject;

import com.example.vlsubot_1_0.model.entity.User;

public class RegistrationRequest {
    UserRequest user;
    String deviceId;

    public UserRequest getUser() {
        return user;
    }

    public void setUser(UserRequest user) {
        this.user = user;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
