package com.bemfis.algafoodapi.api.controller.expEstudo;

import com.bemfis.algafoodapi.domain.model.Cozinha;
import com.bemfis.algafoodapi.domain.model.Restaurante;
import com.bemfis.algafoodapi.domain.repository.CozinhaRepository;
import com.bemfis.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/por-nome") //podemos tirar o @RequestParam que por padrão já é feita essa função
    public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome){
        return cozinhaRepository.findByNome(nome);
    }
    @GetMapping("/cozinhas/parte-nome")
    public List<Cozinha> cozinhasPorParteNome(String nome){
        return cozinhaRepository.findByNomeContaining(nome);
    }
    @GetMapping("/restaurantes/taxa-frete")
    public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal){
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }
    @GetMapping("/restaurantes/por-nome-cozinhaid")
    public List<Restaurante> restaurantesPorNomeCozinhaId(String nome, Long cozinhaId){
        return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
    }

}
