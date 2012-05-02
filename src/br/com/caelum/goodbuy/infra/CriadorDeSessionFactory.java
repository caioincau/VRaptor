package br.com.caelum.goodbuy.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
@Component
@ApplicationScoped
public class CriadorDeSessionFactory implements ComponentFactory<SessionFactory> {
	
	private SessionFactory factory;

	@Override
	public SessionFactory getInstance() {

		return this.factory;
	}
	@PostConstruct
	public void abre() {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		this.factory = configuration.buildSessionFactory();
		
	}
	@PreDestroy
	void fecha(){
		this.factory.close();
	}

}
