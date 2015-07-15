package br.com.ciceroinfo.clinicajm.domain.enumeration;

public enum Especialidade {

	CARDIOLOGISTA("Cardiologista"), PEDIATRIA("Pediatria");

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
