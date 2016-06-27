package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteGerenciamentoJPA {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 1); // ID de uma conta que exista no banco de dados, no caso ID: 1
		manager.getTransaction().commit(); //Commit antes da altera��o
	
		conta.setTitular("Caelum ensino e inova��o"); //Altera��o do titular da conta
		
		manager.getTransaction().begin();
        manager.merge(conta);
        manager.getTransaction().commit();
		
		manager.close(); 
		
		//apenas um select foi gerado pelo m�todo find().
		//Nenhuma altera��o (update) foi feita, porque o 
		//fechamento da transa��o tornou o objeto detached.
		
		//tornar o objeto conta gerenciado mais uma vez. 
		//criamos uma nova transa��o antes do fechamento do EntityManager
		//e dentro dela utilizar o m�todo merge() para adicionar o objeto
		//no contexto de Persistence.
	}

}
