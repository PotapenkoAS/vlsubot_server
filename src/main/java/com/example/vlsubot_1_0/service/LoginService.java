package com.example.vlsubot_1_0.service;

import com.example.vlsubot_1_0.model.commonObject.CustomUserDetails;
import com.example.vlsubot_1_0.model.commonObject.requestObject.DeviceIdRequest;
import com.example.vlsubot_1_0.model.commonObject.requestObject.LoginCredentialsRequest;
import com.example.vlsubot_1_0.model.commonObject.responseObject.StudentResponse;
import com.example.vlsubot_1_0.model.entity.Student;
import com.example.vlsubot_1_0.model.entity.User;
import com.example.vlsubot_1_0.model.repository.StudentRepository;
import com.example.vlsubot_1_0.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

@Service
public class LoginService {

    private UserRepository userRepository;
    private StudentRepository studentRepository;
    private Mapper mapper;
    @PersistenceContext
    private EntityManager em;

    @Autowired
    public LoginService(UserRepository userRepository, StudentRepository studentRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    public StudentResponse loginStudent(LoginCredentialsRequest loginCredentialsRequest, String role) {
        User user = userRepository.findByLoginAndPasswordAndRole(loginCredentialsRequest.getLogin(), loginCredentialsRequest.getPassword(), role);
        if (user != null) {
            loginUserToSecurityHolder(user);
            Student student = studentRepository.getByUserId(user.getId());
            return mapper.studentToStudentResponse(user.getId(), user.getLogin(), user.getPassword(), student, null);
        }
        return null;
    }

    public StudentResponse autoLoginStudent(String deviceId) {
        Student student;
        if ((student = studentRepository.getByDeviceId(deviceId)) != null) {
            User user = userRepository.getById(student.getUserId());
            return mapper.studentToStudentResponse(user.getId(), user.getLogin(), user.getPassword(), student, null);
        }
        return null;
    }

    private boolean loginUserToSecurityHolder(User user) {

        try {
            ArrayList<GrantedAuthority> auths = new ArrayList<>();
            auths.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
            CustomUserDetails cud = new CustomUserDetails(
                    user.getLogin(),
                    "{noop}" + user.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    auths,
                    user.getId());
            Authentication auth = new UsernamePasswordAuthenticationToken(cud, null, auths);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Transactional
    public Boolean signOut(DeviceIdRequest deviceId) {
        try {
            Query query = em.createQuery("update Student set deviceId=null where deviceId =:deviceId");
            query.setParameter("deviceId", deviceId.getDeviceId());
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
