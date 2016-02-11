package br.com.sergio.app.model.mapping;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

import br.com.sergio.app.model.vo.OperacaoBancariaPorCanalVO;

@SqlResultSetMapping(
	name="OperacaoBancariaPorCanalVOMapping",
	classes=@ConstructorResult(
		targetClass=OperacaoBancariaPorCanalVO.class,
		columns={
			@ColumnResult(name="id"),
			@ColumnResult(name="operacaoBancariaId"),
			@ColumnResult(name="operacaoBancariaNome"),
			@ColumnResult(name="canalOperacaoBancariaId"),
			@ColumnResult(name="canalOperacaoBancariaNome")
		}
	)
)
public class OperacaoBancariaPorCanalVOMapping {

}
