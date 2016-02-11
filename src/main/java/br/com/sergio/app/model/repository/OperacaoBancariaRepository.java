package br.com.sergio.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sergio.app.model.vo.entity.OperacaoBancaria;

public interface OperacaoBancariaRepository extends JpaRepository<OperacaoBancaria, Integer> {

}
