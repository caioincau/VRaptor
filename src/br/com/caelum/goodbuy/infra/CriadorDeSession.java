package br.com.caelum.goodbuy.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class CriadorDeSession implements ComponentFactory<Session> {

	private final SessionFactory factory;

	private Session session;

	public CriadorDeSession(SessionFactory factory) {
		this.factory = factory;

	}

	@PostConstruct
	public void abre() {
		this.session = factory.openSession();

	}

	@Override
	public Session getInstance() {

		return this.session;
	}
	
	@PreDestroy
	public void fecha(){
		this.session.close();
		
	}

}


