package com.depozit_farmaceutic.depozit_farmaceutic.repositories;

import com.depozit_farmaceutic.depozit_farmaceutic.entities.Produs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdusRepository  extends JpaRepository<Produs, Long> {
}
