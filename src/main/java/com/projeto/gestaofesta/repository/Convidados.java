package com.projeto.gestaofesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.gestaofesta.model.Convidado;

public interface Convidados extends JpaRepository<Convidado, Long> {

}
