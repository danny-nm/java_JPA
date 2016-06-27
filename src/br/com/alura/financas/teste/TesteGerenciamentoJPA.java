package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteGerenciamentoJPA {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 1); // ID de uma conta que exista no banco de dados, no caso ID: 1
		manager.getTransaction().commit(); //Commit antes da alteração
	
		conta.setTitular("Caelum ensino e inovação"); //Alteração do titular da conta
		
		manager.getTransaction().begin();
        manager.merge(conta);
        manager.getTransaction().commit();
		
		manager.close(); 
		
		//apenas um select foi gerado pelo método find().
		//Nenhuma alteração (update) foi feita, porque o 
		//fechamento da transação tornou o objeto detached.
		
		//tornar o objeto conta gerenciado mais uma vez. 
		//criamos uma nova transação antes do fechamento do EntityManager
		//e dentro dela utilizar o método merge() para adicionar o objeto
		//no contexto de Persistence.
	}

}
