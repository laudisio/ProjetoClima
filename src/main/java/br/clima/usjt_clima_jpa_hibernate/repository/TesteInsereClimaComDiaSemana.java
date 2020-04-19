package br.clima.usjt_clima_jpa_hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.clima.usjt_clima_jpa_hibernate.model.Clima;
import br.clima.usjt_clima_jpa_hibernate.model.Semana;

public class TesteInsereClimaComDiaSemana {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Semana s = new Semana();
		s.setDiaSemana("Segunda-Feira");
		manager.persist(s);
		Clima c = new Clima();
		c.setTempMin("22°");
		c.setTempMax("26°");
		c.setUmidaRelativa("36%");
		c.setDescricao("Ensolarado com algumas nuvens.");
		c.setDataHora("19-04-2020 13:33");
		c.setDiaDaSemana(s);
		manager.persist(c);
		transaction.commit();
		manager.close();
		JPAUtil.close();

	}

}
