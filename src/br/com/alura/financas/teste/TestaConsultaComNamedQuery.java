package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import br.com.alura.financas.dao.MovimentacaoDao;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TestaConsultaComNamedQuery {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(3);

		MovimentacaoDao dao = new MovimentacaoDao(manager);
		Long total = dao.totalDeMovimentacoes(conta);

		System.out.println(total);
	}

}
