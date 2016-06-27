package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TestaConsulta {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2);		
		
		// 1º forma:
//    	Query query = manager.createQuery("select m from Movimentacao m where m.conta.id=" + conta.getId());
		
		// 2ª forma: Positional Parameter Notation
//		Query query = manager.createQuery("select m from Movimentacao m where m.conta=?1");
//		query.setParameter(1, conta);
		
		//3ª forma: Named Parameter Notation - Mais indicada!
		Query query = manager.createQuery("select m from Movimentacao m where m.conta=:pConta"
											+ " and m.tipoMovimentacao = :pTipo"
											+ " order by m.valor desc");
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
			
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao m : movimentacoes) {
			System.out.println("\nDescrição ..: " + m.getDescricao());
			System.out.println("Valor ......:R$ " + m.getValor());			
		}
	}
}
