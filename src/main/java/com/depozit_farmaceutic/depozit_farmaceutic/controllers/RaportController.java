package com.depozit_farmaceutic.depozit_farmaceutic.controllers;

import com.depozit_farmaceutic.depozit_farmaceutic.entities.Farmacie;
import com.depozit_farmaceutic.depozit_farmaceutic.entities.Produs;
import com.depozit_farmaceutic.depozit_farmaceutic.entities.Raport;
import com.depozit_farmaceutic.depozit_farmaceutic.entities.ComandaProdus;
import com.depozit_farmaceutic.depozit_farmaceutic.repositories.ComandaProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RaportController {
    @Autowired
    private ComandaProdusRepository comandaProdusRepository;

    @GetMapping("/raport")
    public List<Raport> getRaport() {
        List<Raport> raport = new ArrayList<>();

        List<Produs> produse = comandaProdusRepository.findAll().stream()
                .map(ComandaProdus::getProdus)
                .distinct()
                .collect(Collectors.toList());

        List<Farmacie> farmacii = comandaProdusRepository.findAll().stream()
                .map(cp -> cp.getComanda().getFarmacie())
                .distinct()
                .collect(Collectors.toList());

        for (Produs produs : produse) {
            for (Farmacie farmacie : farmacii) {
                int cantitateTotala = comandaProdusRepository.findAll().stream()
                        .filter(cp -> cp.getProdus().getId().equals(produs.getId()) && cp.getComanda().getFarmacie().getId().equals(farmacie.getId()))
                        .mapToInt(ComandaProdus::getCantitate)
                        .sum();

                raport.add(new Raport(produs.getNume(), farmacie.getNume(), cantitateTotala));
            }
        }

        return raport;
    }
}