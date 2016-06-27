package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		
		Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes"); // usando join fetch faz um comportamento que � pregui�oso se comportar ancioso
		
		List <Conta> contas = query.getResultList();
		
		for (Conta conta : contas) {
			System.out.println("N�mero de movimenta��es: " + conta.getMovimentacoes().size());
		}
		
		//mostra a quantidade total de movimenta��es do ID 1
		//Conta conta = manager.find(Conta.class, 1);	
		//System.out.println(conta.getMovimentacoes().size()); 
		
		//Para consulta o t�tular de uma conta
		//Movimentacao movimentacao = manager.find(Movimentacao.class, 2);
		//System.out.println("Titular da conta: " + movimentacao.getConta().getTitular());
	}

}
