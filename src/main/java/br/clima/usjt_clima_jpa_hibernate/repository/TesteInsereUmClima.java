package br.clima.usjt_clima_jpa_hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.clima.usjt_clima_jpa_hibernate.model.Clima;

public class TesteInsereUmClima {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Clima c = new Clima();
		c.setTempMin("17°");
		c.setTempMax("23°");
		c.setUmidaRelativa("80%");
		c.setDescricao("céu aberto");
		c.setDataHora("19/04/2020");
		manager.persist(c);
		transaction.commit();
		manager.close();
		JPAUtil.close();

	}

}
