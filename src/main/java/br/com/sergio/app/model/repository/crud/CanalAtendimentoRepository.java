package br.com.sergio.app.model.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sergio.app.model.vo.entity.CanalAtendimento;

public interface CanalAtendimentoRepository extends JpaRepository<CanalAtendimento, Integer> {

}
