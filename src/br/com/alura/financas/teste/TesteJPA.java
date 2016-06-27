package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		
		double inicio = System.currentTimeMillis(); //medindo o tempo do insert.

		Conta conta = new Conta();
		conta.setTitular("João Ferreira");
		conta.setBanco("HSBC");
		conta.setNumero("12345");
		conta.setAgencia("123");

		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
		
	    double fim = System.currentTimeMillis(); //medindo o tempo do insert.
	    System.out.println("Executado em: " + (fim - inicio)/1000 + "s"); //medindo o tempo do insert.
	}

}
