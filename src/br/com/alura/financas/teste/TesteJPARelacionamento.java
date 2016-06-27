package br.com.alura.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.EntityManager;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Maria dos Santos");
		conta.setBanco("BANCO DO BRASIL");
		conta.setNumero("16987-8");
		conta.setAgencia("001");

		Conta conta2 = new Conta();
		conta2.setTitular("Paulo Roberto Souza");
		conta2.setBanco("BANCO BRADESCO ");
		conta2.setNumero("86759-1");
		conta2.setAgencia("237");
		
		Conta conta3 = new Conta();
		conta3.setTitular("Antonio Duraes");
		conta3.setBanco("BANCO ITAU UNIBANCO");
		conta3.setNumero("46346-3");
		conta3.setAgencia("341");
		
		Conta conta4 = new Conta();
		conta4.setTitular("Leandra Marques");
		conta4.setBanco("BANCO SANTANDER ");
		conta4.setNumero("12345-6");
		conta4.setAgencia("033");
		
		Conta conta5 = new Conta();
		conta5.setTitular("Alexandre Duarte");
		conta5.setBanco("CAIXA ECONOMICA FEDERAL");
		conta5.setNumero("98654-3");
		conta5.setAgencia("104");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Almoco no Restaurante - AGOSTO/2012");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("175.8"));
		movimentacao.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Conta de luz - ABRIL/2012");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("135.0"));
		movimentacao2.setConta(conta2);
		
		Movimentacao movimentacao3 = new Movimentacao();
		movimentacao3.setData(Calendar.getInstance());
		movimentacao3.setDescricao("Aluguel - MAIO/2012");
		movimentacao3.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao3.setValor(new BigDecimal("680.0"));
		movimentacao3.setConta(conta3);
		
		Movimentacao movimentacao4 = new Movimentacao();
		movimentacao4.setData(Calendar.getInstance());
		movimentacao4.setDescricao("Salario - FEVEREIRO/2012 ");
		movimentacao4.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao4.setValor(new BigDecimal("3830.68"));
		movimentacao4.setConta(conta4);
		
		Movimentacao movimentacao5 = new Movimentacao();
		movimentacao5.setData(Calendar.getInstance());
		movimentacao5.setDescricao("Conta de telefone - SETEMBRO/2011");
		movimentacao5.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao5.setValor(new BigDecimal("168.27"));
		movimentacao5.setConta(conta5);	
				

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();
		manager.persist(conta);
		manager.persist(movimentacao);
		manager.persist(conta2);
		manager.persist(movimentacao2);
		manager.persist(conta3);
		manager.persist(movimentacao3);
		manager.persist(conta4);
		manager.persist(movimentacao4);
		manager.persist(conta5);
		manager.persist(movimentacao5);
		manager.getTransaction().commit();
		manager.close();

	}
}
