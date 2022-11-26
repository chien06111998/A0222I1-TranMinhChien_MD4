package com.example.demo.service;

import com.example.demo.model.Infomation;

import java.util.List;
import java.util.Optional;

public interface IInformationService {
    List<Infomation> findAll();
    void create(Infomation infomation);
    void delete(Integer id);
    Optional<Infomation> findById(Integer id);
    List<Infomation> search(String title);

}
