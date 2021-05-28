package br.com.controlefrota.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/gerarRelatorio")
public interface RelatorioController {

	@GetMapping
	public ResponseEntity<?> gerarRelatorioMacro(HttpServletResponse response);
	
	@GetMapping("/consumos")
	public ResponseEntity<?> gerarRelatorioConsumosMacro(HttpServletResponse response) throws DocumentException, IOException;
	
	@GetMapping("/condutores")
	public ResponseEntity<?> gerarRelatorioCondutores();
	
	@GetMapping("/trabalhos")
	public ResponseEntity<?> gerarRelatorioTrabalhos();
}
