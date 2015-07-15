package br.com.ciceroinfo.clinicajm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ciceroinfo.clinicajm.domain.Medico;
import br.com.ciceroinfo.clinicajm.domain.enumeration.Especialidade;

@Repository
public class MedicoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void salvaMedico(Medico medico) {
		entityManager.merge(medico);
	}

	@Transactional
	public void excluiMedico(Integer id) {
		Medico medico = entityManager.find(Medico.class, id);
		entityManager.remove(medico);
	}

	@Transactional
	public Medico recuperaMedico(Integer id) {
		return entityManager.find(Medico.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Medico> listaMedicos() {

		Query query = entityManager
				.createQuery("SELECT m FROM Medico m ORDER BY m.id");

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Medico> listaMedicosPorEspecialidade(Especialidade especialidade) {
		Query query = entityManager
				.createQuery("SELECT m FROM Medico m WHERE m.especialidade = :especialidade order by m.nome");

		query.setParameter("especialidade", especialidade);

		return query.getResultList();
	}

}
