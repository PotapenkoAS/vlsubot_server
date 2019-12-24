package com.example.vlsubot_1_0.controller.mobile;

import com.example.vlsubot_1_0.model.commonObject.requestObject.DeviceIdRequest;
import com.example.vlsubot_1_0.model.commonObject.requestObject.LoginCredentialsRequest;
import com.example.vlsubot_1_0.model.commonObject.responseObject.StudentResponse;
import com.example.vlsubot_1_0.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.vlsubot_1_0.Constants.ROLE_STUDENT;

@RestController
@RequestMapping("/rest")
public class LoginRestController {

    private LoginService loginService;

    @Autowired
    public LoginRestController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public StudentResponse postLogin(@RequestBody LoginCredentialsRequest loginCredentialsRequest) {
        return loginService.loginStudent(loginCredentialsRequest, ROLE_STUDENT);
    }

    @PostMapping("/auto_login")
    public StudentResponse postAutoLogin(@RequestBody DeviceIdRequest deviceId) {
        return loginService.autoLoginStudent(deviceId.getDeviceId());
    }

    @PostMapping("/sign_out")
    public Boolean signOut(@RequestBody DeviceIdRequest deviceId) {
        return loginService.signOut(deviceId);
    }
}
