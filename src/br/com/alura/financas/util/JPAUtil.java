package br.com.alura.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//Melhor performance da execução da aplicação.
	//Forma de garantir que a EntityManagerFactory seja criada
	//uma única vez no projeto. E cada vez que precisarmos de
	//um EntityManager, solicitaremos a ela.
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");
	
	public EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}

}
