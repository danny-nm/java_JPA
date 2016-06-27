package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import br.com.alura.financas.dao.MovimentacaoDao;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaComDAO {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
	    Conta conta = manager.find(Conta.class, 2);//id 2 deve existir no banco
	    
	    MovimentacaoDao dao = new MovimentacaoDao(manager);
	    Double media = dao.mediaDaConta(conta);
	    
	    System.out.println(media);
	}

}
