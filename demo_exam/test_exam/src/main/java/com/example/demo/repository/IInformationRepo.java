package com.example.demo.repository;

import com.example.demo.model.Infomation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInformationRepo extends JpaRepository<Infomation, Integer> {
    List<Infomation> findAllByTitleContaining(String title);
}
