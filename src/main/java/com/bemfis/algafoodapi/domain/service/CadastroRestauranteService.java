package com.bemfis.algafoodapi.domain.service;

import com.bemfis.algafoodapi.domain.model.Restaurante;
import com.bemfis.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CadastroRestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;
    public List<Restaurante> listar(){
        return restauranteRepository.listar();
    }
    public Restaurante buscar(Long restauranteId){
        return restauranteRepository.buscar(restauranteId);
    }

}
