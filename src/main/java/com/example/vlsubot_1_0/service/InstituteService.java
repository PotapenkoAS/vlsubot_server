package com.example.vlsubot_1_0.service;

import com.example.vlsubot_1_0.model.entity.Institute;
import com.example.vlsubot_1_0.model.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteService {

    InstituteRepository instituteRepository;

    @Autowired
    public InstituteService(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }

    public List<Institute> getAll(){
        return instituteRepository.findAll();
    }

    public Institute getById(int id){
        return instituteRepository.getById(id);
    }
}
