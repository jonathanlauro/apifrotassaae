package br.com.controlefrota.service;

import br.com.controlefrota.model.BuscaDeConsumo;
import br.com.controlefrota.model.Consumo;

import java.util.List;

public interface FiltroConsumo {

    List<Consumo> filtrar(BuscaDeConsumo busca);
}
