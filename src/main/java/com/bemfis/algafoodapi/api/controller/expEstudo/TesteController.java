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
import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/por-nome") //podemos tirar o @RequestParam que por padrão já é feita essa função
    public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome) {
        return cozinhaRepository.findByNome(nome);
    }

    @GetMapping("/cozinhas/parte-nome")
    public List<Cozinha> cozinhasPorParteNome(String nome) {
        return cozinhaRepository.findByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/taxa-frete")
    public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    @GetMapping("/restaurantes/por-nome-cozinhaid")
    public List<Restaurante> restaurantesPorNomeCozinhaId(String nome, Long cozinhaId) {
        return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
    }

    @GetMapping("/restaurantes/first-por-nome")
    public Optional<Restaurante> restauranteFirstPorNome(String nome) {
        return restauranteRepository.findFirstByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/top2-por-nome")
    public List<Restaurante> restaurantesTop2PorNome(String nome) {
        return restauranteRepository.findTop2ByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/exists-nome")
    public boolean existsNome(String nome) {
        return restauranteRepository.existsByNome(nome);
    }

    @GetMapping("/restaurantes/count-restaurentes-by-cozinha")
    public int countRestaurantesByCozinhaId(Long cozinhaId) {
        return restauranteRepository.countByCozinhaId(cozinhaId);
    }

}
