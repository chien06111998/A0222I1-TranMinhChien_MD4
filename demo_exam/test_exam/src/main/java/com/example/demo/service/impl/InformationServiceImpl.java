package com.example.demo.service.impl;

import com.example.demo.model.Infomation;
import com.example.demo.repository.IInformationRepo;
import com.example.demo.service.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformationServiceImpl implements IInformationService {
    @Autowired
    IInformationRepo informationRepo;

    @Override
    public List<Infomation> findAll() {
        return informationRepo.findAll();
    }

    @Override
    public void create(Infomation infomation) {
        informationRepo.save(infomation);
    }

    @Override
    public void delete(Integer id) {
        informationRepo.deleteById(id);
    }

    @Override
    public Optional<Infomation> findById(Integer id) {
        return informationRepo.findById(id);
    }

    @Override
    public List<Infomation> search(String title) {
        return informationRepo.findAllByTitleContaining(title);
    }
}
