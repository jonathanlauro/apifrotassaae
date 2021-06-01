package br.com.controlefrota.controller.impl;

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

import com.lowagie.text.DocumentException;

import br.com.controlefrota.controller.RelatorioController;
import br.com.controlefrota.domain.model.ConsumoModel;
import br.com.controlefrota.model.Consumo;
import br.com.controlefrota.repository.ConsumoRepository;
import br.com.controlefrota.service.impl.ConsumoServiceEJB;
import br.com.controlefrota.service.relatorio.ConsumoPDFExport;
import br.com.controlefrota.service.relatorio.RelatorioService;

@Controller
public class RelatorioControllerImpl implements RelatorioController {

	@Autowired
	ConsumoRepository consumoRepository;
	@Autowired
	RelatorioService relatorioService;
	@Autowired
	ConsumoServiceEJB consumoService;

	@Override
	public ResponseEntity<?> gerarRelatorioMacro(HttpServletResponse response) {
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Relatório_Macro.pdf";
		response.setHeader(headerKey, headerValue);

		return ResponseEntity.status(HttpStatus.OK).body("Relatório Gerado com sucesso");
	}

	@Override
	public ResponseEntity<?> gerarRelatorioConsumosMacro(HttpServletResponse response)
			throws DocumentException, IOException {
		response.setContentType("application/pdf");

		DateFormat dateFormatted = new SimpleDateFormat("yyyy-mm-dd_HH:mm:ss");
		String currentDataTime = dateFormatted.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Relatório_Macro_" + currentDataTime + ".pdf";

		response.setHeader(headerKey, headerValue);

		List<Consumo> consumos = consumoService.findAll();
		List<ConsumoModel> gasolina = consumoService.findbyCombustivel("GASOLINA");
		List<ConsumoModel> alcool = consumoService.findbyCombustivel("ALCOOL");
		List<ConsumoModel> disel = consumoService.findbyCombustivel("DIESEL");

		ConsumoPDFExport consumoExport = new ConsumoPDFExport(consumos,gasolina,alcool,disel);
		consumoExport.export(response);

		return ResponseEntity.status(HttpStatus.OK).body("Relatório de Consumos Gerado com sucesso");
	}

	@Override
	public ResponseEntity<?> gerarRelatorioCondutores() {
		return ResponseEntity.status(HttpStatus.OK).body("Relatório de Condutores Gerado com sucesso");
	}

	@Override
	public ResponseEntity<?> gerarRelatorioTrabalhos() {
		return ResponseEntity.status(HttpStatus.OK).body("Relatório de Trabalhos Gerado com sucesso");
	}
}
