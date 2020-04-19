package br.clima.usjt_clima_jpa_hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.clima.usjt_clima_jpa_hibernate.model.Clima;

public class TesteAtualizaClima {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Clima c = manager.find(Clima.class, 1L);
		c.setDescricao("Sol dia inteiro");
		c.setTempMin("23°");
		c.setTempMax("31°");
		c.setUmidaRelativa("4%");
		transaction.commit();
		manager.close();
		JPAUtil.close();

	}

}
