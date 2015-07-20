CREATE TABLE medico (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(120) NOT NULL,
	especialidade VARCHAR(120) NOT NULL
);

CREATE TABLE paciente (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(120) NOT NULL,
	data_nascimento DATE NOT NULL
);

DROP TABLE consulta;
CREATE TABLE consulta (
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_medico INT NOT NULL,
	id_paciente INT NOT NULL,
	sintomas VARCHAR(255) NULL,
	receita VARCHAR(255) NULL,
	data_consulta TIMESTAMP NOT NULL,
	data_atendimento TIMESTAMP NULL
);

select * from medico;
select * from paciente;
select * from consulta;