package br.com.controlefrota.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.Consumo;
import br.com.controlefrota.model.RelatorioConsumos;
import br.com.controlefrota.repository.ConsumoRepository;

@Service
public class RelatorioService {

	@Autowired
	ConsumoRepository consumoRepository;
	private int totalNotas;
	private Float totalConsumosEmReais;
	private Float totalLitrosAbastecidos = (float) 0.0;
	
	
	public RelatorioConsumos gerarRelarotioConsumo() {
		
		RelatorioConsumos consumoRel = new RelatorioConsumos();
		
		List<Consumo> listConsumos = consumoRepository.findAll();
		
		for(Consumo con:listConsumos) {
			this.totalNotas+=1;
			this.totalLitrosAbastecidos+=con.getLitros();
			this.totalConsumosEmReais += con.getValor();
		}
		
		consumoRel.setTotalDeNotasFiscais(this.totalNotas);
		consumoRel.setTotalConsumosEmReais(this.totalConsumosEmReais);
		consumoRel.setTotalLitrosAbastecidos(this.totalLitrosAbastecidos);
		
		
		
		return consumoRel;
	}
}
