package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteEstadosJPA {
	
	public static void main(String[] args) {
		
		//Buscar uma Conta no banco de dados através de seu ID (chave primária):
		
		EntityManager manager = new JPAUtil().getEntityManager();		
		manager.getTransaction().begin();		

		Conta conta = manager.find(Conta.class, 1);// ID de uma conta que exista no banco de dados, no caso ID: 1
		
		System.out.println(conta.getTitular());
		
		// Alterando o titular da conta (uma conta já existente)
        conta.setTitular("Luiz Ferreira");
        System.out.println(conta.getTitular());
		
		manager.getTransaction().commit();
		manager.close();
		
	}

}
