package br.com.caelum.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.com.caelum.goodbuy.modelo.Produto;

public class AdicaoDeProduto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Produto p = new Produto();
		p.setNome("Furadeira");
		p.setDescricao("Furadeira B&D 220w");
		p.setPreco(299.99);
		
		Transaction tx = session.getTransaction();
		tx.begin();
		session.save(p);
		
		
		tx.commit();
		
		
	}

}
