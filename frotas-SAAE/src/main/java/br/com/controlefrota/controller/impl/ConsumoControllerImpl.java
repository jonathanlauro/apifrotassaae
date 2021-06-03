package br.com.controlefrota.controller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefrota.controller.ConsumoController;
import br.com.controlefrota.domain.model.ConsumoModel;
import br.com.controlefrota.model.Consumo;
import br.com.controlefrota.repository.CombustivelRepository;
import br.com.controlefrota.repository.ConsumoRepository;
import br.com.controlefrota.service.impl.ConsumoServiceEJB;

@RestController
public class ConsumoControllerImpl implements ConsumoController{
	@Autowired
	ConsumoRepository consumoRepository;
	@Autowired
	ConsumoServiceEJB consumoService;
	@Autowired
	CombustivelRepository combustivelRepository;


	@Override
	public List<ConsumoModel> listaConsumos() {
		return consumoService.findAll().stream().map(this::toDto).collect(Collectors.toList());
	}

	@Override
	public Optional<Consumo> listaUnicoConsumoPorId(@PathVariable(value="id") Long id) {
		return consumoRepository.findById(id);
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
	public List<ConsumoModel> listaUnicoConsumoPorCombustivel(String nome) {
		
		return consumoService.findbyCombustivel(nome);
		
	}
	
	public ConsumoModel toDto(Consumo entity) {
        ConsumoModel dto = new ConsumoModel();
        dto.setIdConsumo(entity.getIdConsumo());
        dto.setCondutor(entity.getCondutor().getNome());
        dto.setVeiculo(entity.getVeiculo().getModelo());
        dto.setPlaca(entity.getVeiculo().getPlaca());
        dto.setCombustivel(entity.getCombustivel().getNome());
        dto.setLitros(entity.getLitros());
        dto.setValor(entity.getValor());
        dto.setNumeroDaNotaFiscal(entity.getNumNotaFiscal());
        dto.setDataRegistroDaNota(entity.getDataRegistro());
        dto.setDataDeRegistro(entity.getDataDeCriacao());
        return dto;
    }

}
