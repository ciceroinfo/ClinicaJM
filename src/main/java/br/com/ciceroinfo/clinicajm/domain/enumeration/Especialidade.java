package br.com.ciceroinfo.clinicajm.domain.enumeration;

public enum Especialidade {

	CARDIOLOGISTA("Cardiologista"), PEDIATRA("Pediatra"), CLINICO_GERAL(
			"Clinico Geral"), DERMATOLOGISTA("Dermatologista"), OTORRINOLARINGOLOGISTA(
			"Otorinolaringologista"), PNEUMOLOGISTA("Peneumologista");

	private String descricao;

	private Especialidade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
