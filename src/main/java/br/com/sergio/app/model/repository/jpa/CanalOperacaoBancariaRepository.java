package br.com.sergio.app.model.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sergio.app.model.jpa.CanalOperacaoBancaria;

@Repository
public interface CanalOperacaoBancariaRepository extends JpaRepository<CanalOperacaoBancaria, Integer> {

}
