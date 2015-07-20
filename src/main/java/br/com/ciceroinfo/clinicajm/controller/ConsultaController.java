package br.com.ciceroinfo.clinicajm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ciceroinfo.clinicajm.domain.Consulta;
import br.com.ciceroinfo.clinicajm.repository.ConsultaRepository;
import br.com.ciceroinfo.clinicajm.util.Mensagem;
import br.com.ciceroinfo.clinicajm.util.Mensagem.TipoMensagem;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {

	@Autowired
	private ConsultaRepository consultaRepository;

	@RequestMapping(value = "/agendar.do", method = RequestMethod.POST)
	public String agendar(Consulta consulta, String data, String hora,
			Model model) {
		
		System.out.println("Agendar consulta: " + consulta + ", data=" + data
				+ ", hora=" + hora);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Date dataConsulta;

		consultaRepository.salvaConsulta(consulta);

		try {

			dataConsulta = sdf.parse(data + " " + hora);

			consulta.setDataConsulta(dataConsulta);
			consultaRepository.salvaConsulta(consulta);
			model.addAttribute("mensagem", new Mensagem(
					"Sucesso ao cadastrar consulta", TipoMensagem.SUCESSO));

		} catch (ParseException e) {
			model.addAttribute("mensagem",
					new Mensagem("Erro ao fazer conversão de data e hora",
							TipoMensagem.ERRO));
		}

		return "forward:/preparaCadastroConsulta.do";
	}

	@RequestMapping(value = "/detalharConsulta.do", method = RequestMethod.GET)
	public String detalhar(Integer idConsulta, Model model) {
		
		System.out.println("detalhar idConsulta:" + idConsulta);

		Consulta consulta = consultaRepository.recuperaConsulta(idConsulta);
		
		System.out.println("detalhar retorno consulta:" + consulta);

		model.addAttribute("consulta", consulta);

		return "realizarAtendimento";
	}

	@RequestMapping(value = "/atender.do", method = RequestMethod.POST)
	public String gravarAtendimento(Consulta consulta, Model model) {

		System.out.println("gravarAtendimento consulta:" + consulta);
		
		consulta.setDataAtendimento(new Date());
		consultaRepository.atualizaConsulta(consulta);

		model.addAttribute("mensagem", new Mensagem(
				"Sucesso ao cadastrar o atendimento", TipoMensagem.SUCESSO));

		return "forward:/preparaCadastroAtendimento.do";
	}

	@RequestMapping(value = "/listarPorPaciente.do", method = RequestMethod.GET)
	public @ResponseBody List<Consulta> listarPorPaciente(Integer idPaciente) {
		
		System.out.println("listarPorPaciente idPaciente:" + idPaciente);
		
		return consultaRepository.listaPorPaciente(idPaciente);
	}

}
