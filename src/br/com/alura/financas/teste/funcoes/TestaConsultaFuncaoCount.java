package br.com.alura.financas.teste.funcoes;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TestaConsultaFuncaoCount {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
	    Conta conta = manager.find(Conta.class, 2);//id 2 deve existir no banco
	    
	    TypedQuery<Long> query = manager.createQuery("select count(m) from Movimentacao m where m.conta = :pConta", Long.class);
	    
	    query.setParameter("pConta", conta);
	    Long quantidade = query.getSingleResult();
	    System.out.println("Total de movimentações: " + quantidade);
	}

}
