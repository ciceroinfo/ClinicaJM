package br.com.ciceroinfo.clinicajm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ciceroinfo.clinicajm.domain.Paciente;

@Repository
public class PacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void salvaPaciente(Paciente paciente) {
		System.out.println("Gravando paciente: " + paciente);
		entityManager.merge(paciente);
	}

	@Transactional
	public void excluiPaciente(Integer id) {
		Paciente paciente = entityManager.find(Paciente.class, id);
		entityManager.remove(paciente);
	}

	@Transactional
	public Paciente recuperaPaciente(Integer id) {
		return entityManager.find(Paciente.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Paciente> listaPacientes() {

		Query query = entityManager
				.createQuery("SELECT p FROM Paciente p ORDER BY p.id");

		return query.getResultList();
	}

}
