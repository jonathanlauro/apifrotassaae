package br.com.controlefrota.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.DocumentException;

import br.com.controlefrota.model.Consumo;
import br.com.controlefrota.model.RelatorioConsumos;
import br.com.controlefrota.repository.ConsumoRepository;
import br.com.controlefrota.service.ConsumoPDFExport;
import br.com.controlefrota.service.RelatorioService;

@Controller
@RequestMapping("/gerarRelatorio")
public class RelatorioController {

	@Autowired
	ConsumoRepository consumoRepository;
	@Autowired
	RelatorioService relatorioService;

	@GetMapping
	public ResponseEntity<?> gerarRelatorioMacro(HttpServletResponse response) {
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Relatório_Macro.pdf";
		response.setHeader(headerKey, headerValue);

		return ResponseEntity.status(HttpStatus.OK).body("Relatório Gerado com sucesso");
	}

	@GetMapping("/consumos")
	public ResponseEntity<?> gerarRelatorioConsumosMacro(HttpServletResponse response)
			throws DocumentException, IOException {
		response.setContentType("application/pdf");

		DateFormat dateFormatted = new SimpleDateFormat("yyyy-mm-dd_HH:mm:ss");
		String currentDataTime = dateFormatted.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Relatório_Macro_" + currentDataTime + ".pdf";

		response.setHeader(headerKey, headerValue);

		List<Consumo> consumos = consumoRepository.findAll();

		ConsumoPDFExport consumoExport = new ConsumoPDFExport(consumos);
		consumoExport.export(response);

		return ResponseEntity.status(HttpStatus.OK).body("Relatório de Consumos Gerado com sucesso");
	}

	@GetMapping("/condutores")
	public ResponseEntity<?> gerarRelatorioCondutores() {
		return ResponseEntity.status(HttpStatus.OK).body("Relatório de Condutores Gerado com sucesso");
	}

	@GetMapping("/trabalhos")
	public ResponseEntity<?> gerarRelatorioTrabalhos() {
		return ResponseEntity.status(HttpStatus.OK).body("Relatório de Trabalhos Gerado com sucesso");
	}
}
