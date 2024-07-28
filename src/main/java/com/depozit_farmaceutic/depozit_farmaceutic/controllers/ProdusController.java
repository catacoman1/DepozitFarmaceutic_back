package com.depozit_farmaceutic.depozit_farmaceutic.controllers;

import com.depozit_farmaceutic.depozit_farmaceutic.entities.Produs;
import com.depozit_farmaceutic.depozit_farmaceutic.services.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdusController {

    @Autowired
    private ProdusService produsService;

    @GetMapping("/produse")
    public List<Produs> getAllProduse() {
        List<Produs> produse = produsService.getAllProduse();
        produse.forEach(produs -> System.out.println(produs.getNume() + " - " + produs.getPret()));
        return produse;

    }
}
