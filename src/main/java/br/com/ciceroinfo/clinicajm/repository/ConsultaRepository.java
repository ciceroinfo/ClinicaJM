package br.com.ciceroinfo.clinicajm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ciceroinfo.clinicajm.domain.Consulta;

@Repository
public class ConsultaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void salvaConsulta(Consulta consulta) {
		System.out.println("Gravando consulta: " + consulta);
		entityManager.merge(consulta);
	}

	@Transactional
	public void atualizaConsulta(Consulta consulta) {
		System.out.println("Atualizando consulta: " + consulta);
		entityManager.merge(consulta);
	}

	@Transactional
	public Consulta recuperaConsulta(Integer id) {
		return entityManager.find(Consulta.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Consulta> listaPorPaciente(Integer idPaciente) {
		Query query = entityManager
				.createQuery("SELECT c FROM Consulta c WHERE c.paciente.id = :idPaciente order by c.dataConsulta");
		
		query.setParameter("idPaciente", idPaciente);

		List<Consulta> consultas = query.getResultList();
		 
		for (Consulta consulta : consultas) {
			System.out.println("Consuta: " + consulta);
		}
		 
		return consultas;
	}

}
