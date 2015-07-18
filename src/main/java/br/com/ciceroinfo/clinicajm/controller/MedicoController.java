package br.com.ciceroinfo.clinicajm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ciceroinfo.clinicajm.domain.Medico;
import br.com.ciceroinfo.clinicajm.domain.enumeration.Especialidade;
import br.com.ciceroinfo.clinicajm.repository.MedicoRepository;
import br.com.ciceroinfo.clinicajm.util.Mensagem;
import br.com.ciceroinfo.clinicajm.util.Mensagem.TipoMensagem;

@Controller
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoRepository medicoRepository;

	@RequestMapping(value = "/cadastrar.do", method = RequestMethod.POST)
	public String cadastrar(Medico medico, Model model) {

		medicoRepository.salvaMedico(medico);

		model.addAttribute("medico", new Medico());
		model.addAttribute("especialidades", Especialidade.values());
		model.addAttribute("mensagem", new Mensagem(
				"Sucesso ao cadastrar o médico", TipoMensagem.SUCESSO));

		return "cadastrarMedico";
	}

	@RequestMapping(value = "/listar.do", method = RequestMethod.GET)
	public String listar(Model model) {

		List<Medico> medicos = medicoRepository.listaMedicos();

		model.addAttribute("medicos", medicos);

		return "listarMedicos";
	}

	@RequestMapping(value = "/excluir.do", method = RequestMethod.GET)
	public String excluir(Integer idMedico, Model model) {

		medicoRepository.excluiMedico(idMedico);

		model.addAttribute("mensagem", new Mensagem(
				"Sucesso ao excluir o médico", TipoMensagem.SUCESSO));

		return "forward:/medico/listar.do";
	}

	@RequestMapping(value = "/listarPorEspecialidade.do", method = RequestMethod.GET)
	public @ResponseBody List<Medico> listarPorEspecialidade(
			Especialidade especialidade) {

		return medicoRepository.listaMedicosPorEspecialidade(especialidade);
	}
}
