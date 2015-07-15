package br.com.ciceroinfo.clinicajm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ciceroinfo.clinicajm.domain.Paciente;
import br.com.ciceroinfo.clinicajm.repository.PacienteRepository;
import br.com.ciceroinfo.clinicajm.util.Mensagem;
import br.com.ciceroinfo.clinicajm.util.Mensagem.TipoMensagem;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;

	@RequestMapping(value = "/cadastrar.do", method = RequestMethod.POST)
	public String cadastrar(Paciente paciente, Model model) {

		pacienteRepository.salvaPaciente(paciente);

		model.addAttribute("paciente", new Paciente());
		model.addAttribute("mensagem", new Mensagem(
				"Sucesso ao cadastrar o médico", TipoMensagem.SUCESSO));

		return "cadastrarPaciente";
	}

	@RequestMapping(value = "/listar.do", method = RequestMethod.GET)
	public String listar(Model model) {

		List<Paciente> pacientes = pacienteRepository.listaPacientes();

		model.addAttribute("pacientes", pacientes);

		return "listarPacientes";
	}

	@RequestMapping(value = "/excluir.do", method = RequestMethod.GET)
	public String excluir(Integer id, Model model) {

		pacienteRepository.excluiPaciente(id);

		model.addAttribute("mensagem", new Mensagem(
				"Sucesso ao excluir o médico", TipoMensagem.SUCESSO));

		return "foward:/paciente/listar.do";
	}

}
