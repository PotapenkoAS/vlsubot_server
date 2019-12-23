package com.example.vlsubot_1_0.controller.mobile;

import com.example.vlsubot_1_0.model.commonObject.requestObject.RegistrationRequest;
import com.example.vlsubot_1_0.model.commonObject.requestObject.UserRequest;
import com.example.vlsubot_1_0.model.commonObject.responseObject.StudentResponse;
import com.example.vlsubot_1_0.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.vlsubot_1_0.Constants.ROLE_STUDENT;

@RestController
@RequestMapping("/rest")
public class RegistrationRestController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationRestController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/registration")
    public StudentResponse postRegistration(@RequestBody RegistrationRequest registrationRequest) {
        return registrationService.registration(registrationRequest, ROLE_STUDENT);
    }

    @GetMapping("/check_login")
    public Boolean checkLogin(@RequestParam String login) {
        return registrationService.checkLogin(login);
    }
}

