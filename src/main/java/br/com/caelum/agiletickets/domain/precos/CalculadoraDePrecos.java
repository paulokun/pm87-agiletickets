package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco = sessao.getPreco(); 
		BigDecimal multiplicador = new BigDecimal(0);
		TipoDeEspetaculo tipo = sessao.getEspetaculo().getTipo();
		
		if(tipo.equals(TipoDeEspetaculo.CINEMA) || tipo.equals(TipoDeEspetaculo.SHOW)) {
			//quando estiver acabando os ingressos... 
			if(sessao.percentualIngressos() <= 0.05) {
				multiplicador = BigDecimal.valueOf(0.10);
			}
		} else if(tipo.equals(TipoDeEspetaculo.BALLET)
				|| tipo.equals(TipoDeEspetaculo.ORQUESTRA)) {
			if(sessao.percentualIngressos() <= 0.50) { 
				multiplicador = BigDecimal.valueOf(0.20);
			}
		}
		
		preco = sessao.getPreco().add(sessao.getPreco().multiply(multiplicador));
		
		if(sessao.getDuracaoEmMinutos() != null && sessao.getDuracaoEmMinutos() > 60
				&& (tipo.equals(TipoDeEspetaculo.ORQUESTRA)
				|| tipo.equals(TipoDeEspetaculo.BALLET)) ){
			preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		}

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}
	
}