package br.clima.usjt_clima_jpa_hibernate.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.clima.usjt_clima_jpa_hibernate.model.Cidade;
import br.clima.usjt_clima_jpa_hibernate.model.Clima;
import br.clima.usjt_clima_jpa_hibernate.model.Semana;

public class TesteInsereDoisClimasEmUmaCidade {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Cidade c= new Cidade();
		c.setNome("São Paulo");
		c.setLatitude(29.63);
		c.setLongitude(-68.90);
		Semana s1 = new Semana();
		Semana s2 = new Semana();
		s1.setDiaSemana("Segunda");
		s2.setDiaSemana("Terça");
		manager.persist(s1);
		manager.persist(s2);
		List<Clima>climas = new ArrayList<>();
		Clima c1 = new Clima();
		c1.setTempMin("18°");
		c1.setTempMax("29°");
		c1.setUmidaRelativa("20%");
		c1.setDescricao("Dia ensolarado.");
		c1.setDataHora("20-04-2020, 11:33");
		c1.setDiaDaSemana(s1);
		c1.setCidade(c);
		Clima c2 = new Clima();
		c2.setTempMin("19°");
		c2.setTempMax("31°");
		c2.setUmidaRelativa("8%");
		c2.setDescricao("Dia ensolarado");
		c2.setDataHora("21-04-2020, 15:33");
		c2.setDiaDaSemana(s2);
		c2.setCidade(c);
		climas.add(c1);
		climas.add(c2);
		c.setClimas(climas);
		manager.persist(c);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}

}