package br.com.sergio.app.model.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sergio.app.model.vo.entity.OperacaoBancariaPorCanal;

public interface OperacaoBancariaPorCanalRepository extends JpaRepository<OperacaoBancariaPorCanal, Integer> {

}
