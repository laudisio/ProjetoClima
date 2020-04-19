package br.clima.usjt_clima_jpa_hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.clima.usjt_clima_jpa_hibernate.model.Semana;

public class TesteRemoveDiaSemana {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Semana s = manager.find(Semana.class, 1L);
		manager.remove(s);
		transaction.commit();
		manager.close();
		JPAUtil.close();

	}

}
