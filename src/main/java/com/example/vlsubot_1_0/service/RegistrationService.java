package com.example.vlsubot_1_0.service;

import com.example.vlsubot_1_0.model.commonObject.requestObject.LoginCredentialsRequest;
import com.example.vlsubot_1_0.model.commonObject.requestObject.RegistrationRequest;
import com.example.vlsubot_1_0.model.commonObject.responseObject.StudentResponse;
import com.example.vlsubot_1_0.model.entity.StudentGroup;
import com.example.vlsubot_1_0.model.entity.Student;
import com.example.vlsubot_1_0.model.entity.User;
import com.example.vlsubot_1_0.model.repository.DepartmentRepository;
import com.example.vlsubot_1_0.model.repository.GroupRepository;
import com.example.vlsubot_1_0.model.repository.StudentRepository;
import com.example.vlsubot_1_0.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private UserRepository userRepository;
    private StudentRepository studentRepository;
    private GroupRepository groupRepository;
    private DepartmentRepository departmentRepository;
    private LoginService loginService;
    private Mapper mapper;

    @Autowired
    public RegistrationService(UserRepository userRepository, StudentRepository studentRepository, GroupRepository groupRepository, DepartmentRepository departmentRepository, LoginService loginService, Mapper mapper) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.departmentRepository = departmentRepository;
        this.loginService = loginService;
        this.mapper = mapper;
    }

    @Transactional
    public StudentResponse registration(RegistrationRequest registrationRequest, String role) {
        StudentResponse studentResponse;
        try {
            User user = new User(registrationRequest.getUser().getLogin(), registrationRequest.getUser().getPassword(), role);
            user = userRepository.save(user);
            StudentGroup studentGroup = groupRepository.getByShortName(registrationRequest.getUser().getGroupShortName());
            Student student = createNewStudent(registrationRequest, user.getId(), studentGroup.getId());
            studentRepository.save(student);
            studentResponse = mapper.studentToStudentResponse(user.getId(), user.getLogin(), user.getPassword(), student, studentGroup.getDepartmentId());
            loginService.loginStudent(new LoginCredentialsRequest(registrationRequest.getUser().getLogin(), registrationRequest.getUser().getPassword(), student.getDeviceId()), role);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return studentResponse;
    }

    public Boolean checkLogin(String login) {
        return !userRepository.existsByLogin(login);
    }

    private Student createNewStudent(RegistrationRequest userRequest, Integer userId, Integer groupId) {

        return new Student(
                userRequest.getUser().getFirstName(),
                userRequest.getUser().getLastName(),
                userRequest.getUser().getPatronymic(),
                groupId,
                userId,
                userRequest.getDeviceId());
    }

}
