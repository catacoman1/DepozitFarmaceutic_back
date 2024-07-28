package com.depozit_farmaceutic.depozit_farmaceutic.services;

import com.depozit_farmaceutic.depozit_farmaceutic.entities.Produs;
import com.depozit_farmaceutic.depozit_farmaceutic.repositories.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdusService {

    @Autowired
    private ProdusRepository produsRepository;

    public List<Produs> getAllProduse() {
        return produsRepository.findAll();
    }
}