package br.com.controlefrota.controller.impl;

import br.com.controlefrota.controller.ConsumoController;
import br.com.controlefrota.domain.model.ConsumoModel;
import br.com.controlefrota.model.BuscaDeConsumo;
import br.com.controlefrota.model.Consumo;
import br.com.controlefrota.repository.CombustivelRepository;
import br.com.controlefrota.repository.ConsumoRepository;
import br.com.controlefrota.service.impl.ConsumoServiceEJB;
import br.com.controlefrota.service.impl.FiltroConsumoServiceEJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ConsumoControllerImpl implements ConsumoController{
	@Autowired
	ConsumoRepository consumoRepository;
	@Autowired
	ConsumoServiceEJB consumoService;
	@Autowired
	CombustivelRepository combustivelRepository;
	@Autowired
	FiltroConsumoServiceEJB filtroConsumoServiceEJB;


	@Override
	public List<ConsumoModel> listaConsumos() {
		return consumoService.listaDeConsumos();
	}

	@Override
	public Optional<Consumo> listaUnicoConsumoPorId(@PathVariable(value="id") Long id) {
		return consumoRepository.findById(id);
	}

	@Override
	public List<Consumo> listaFiltroDeConsumos(BuscaDeConsumo buscaDeConsumo) {

		return filtroConsumoServiceEJB.filtrar(buscaDeConsumo);
	}

	@Override
	public ResponseEntity<?> salvaconsumo(@RequestBody Consumo consumo) {
			try {
				
				consumoService.criar(consumo);
				return ResponseEntity.status(HttpStatus.OK).body("Cadastrado com sucesso");
			}catch( Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro! "+e);
			}
	
	}

	@Override
	public Consumo atualizarConsumo(@RequestBody Consumo consumo) {
		return consumoRepository.save(consumo);
	}

	@Override
	public ResponseEntity<?> deletarconsumo(@PathVariable Long id) {

		try{
			consumoService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("deletado com sucesso!");
		}catch( Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro! "+e);
		}
	}

	@Override
	public ResponseEntity<?> reembolsoDeConsumo(Long id) {
		try{
			consumoService.realizarReembolso(id);
			return ResponseEntity.status(HttpStatus.OK).body("Reembolso com sucesso!");
		}catch( Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro! "+e);
		}
	}

	@Override
	public List<ConsumoModel> listaUnicoConsumoPorCombustivel(String nome) {
		
		return consumoService.findbyCombustivel(nome);
		
	}

}
