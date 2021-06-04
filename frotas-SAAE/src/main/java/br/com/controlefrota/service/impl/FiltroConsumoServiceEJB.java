package br.com.controlefrota.service.impl;

import br.com.controlefrota.model.BuscaDeConsumo;
import br.com.controlefrota.model.Consumo;
import br.com.controlefrota.repository.ConsumoRepository;
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

        if(busca.getNome() != null && busca.getNome().size() > 0 ){

            while(i < busca.getNome().size()){
                List<Consumo> result= consumoService.findByNomeCondutor(busca.getNome().get(i));

                for (int j = 0; j < result.size(); j++) {
                    listaFiltrada.add(result.get(j));
                }
                i++;
            }
        }


        
        return listaFiltrada;
    }
}
