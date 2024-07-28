package com.depozit_farmaceutic.depozit_farmaceutic.entities;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Raport {
    private String produs;
    private String farmacie;
    private int cantitate;

    public Raport(String produs, String farmacie, int cantitate) {
        this.produs = produs;
        this.farmacie = farmacie;
        this.cantitate = cantitate;
    }
}

