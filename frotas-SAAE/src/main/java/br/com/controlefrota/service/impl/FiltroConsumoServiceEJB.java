package br.com.controlefrota.service.impl;

import br.com.controlefrota.domain.model.ConsumoModel;
import br.com.controlefrota.model.BuscaDeConsumo;
import br.com.controlefrota.model.Combustivel;
import br.com.controlefrota.model.Consumo;
import br.com.controlefrota.service.FiltroConsumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiltroConsumoServiceEJB implements FiltroConsumo {
    
    @Autowired
    ConsumoServiceEJB consumoService;

    
    @Override
    public List<Consumo> filtrar(BuscaDeConsumo busca) {

        List<Consumo> listaFiltrada = new ArrayList<>();

        int i = 0;

        if(busca.getNome() == null){

            listaFiltrada = consumoService.findAll();
        }

        if(busca.getNome() != null && !busca.getNome().isEmpty() ){

            while(i < busca.getNome().size()){
                List<Consumo> result= consumoService.findByNomeCondutor(busca.getNome().get(i));

                for (int j = 0; j < result.size(); j++) {
                    listaFiltrada.add(result.get(j));
                }
                i++;
            }
        }

        if(busca.getDataDeInicio() != null && busca.getDataFim() != null){
            List<Consumo> buscaComNomeEData = new ArrayList<>();

            for (Consumo con : listaFiltrada) {
                if(busca.getDataDeInicio().isBefore(con.getDataRegistro()) && busca.getDataFim().isAfter(con.getDataRegistro())){
                    buscaComNomeEData.add(con);
                }
            }
            return buscaComNomeEData;
        }

        if(busca.getCombustivelNome() != null && !busca.getCombustivelNome().isEmpty()){
            int a = 0, l;
            List<Consumo> buscaPorCombustivel = new ArrayList<>();

            while(a < busca.getCombustivelNome().size()){
                List<Consumo> resultadoBusca = consumoService.findbyCombustivelCompleta(busca.getCombustivelNome().get(a));
                for (l = 0; l < resultadoBusca.size(); l++) {
                    buscaPorCombustivel.add(resultadoBusca.get(l));
                }
                a++;
            }

            return buscaPorCombustivel;
        }
        if(busca.getPlacaVeiculo() != null && !busca.getPlacaVeiculo().isEmpty()){
            List<Consumo> consumosVeiculo = new ArrayList<>();
            int x = 0,d;

            while(x < busca.getPlacaVeiculo().size()){

                List<Consumo> resultadoBuscaVeiculos = consumoService.findByVeiculo(busca.getPlacaVeiculo().get(x));
                for(d = 0; d < resultadoBuscaVeiculos.size(); d++){
                    consumosVeiculo.add(resultadoBuscaVeiculos.get(d));
                }
                x++;
            }
            return consumosVeiculo;
        }
        
        return listaFiltrada;
    }
}
