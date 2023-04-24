package com.bemfis.algafoodapi.api.controller;

import com.bemfis.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.bemfis.algafoodapi.domain.model.Restaurante;
import com.bemfis.algafoodapi.domain.service.CadastroRestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteCtrl {
    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    @GetMapping
    public List<Restaurante> listar() {
        return cadastroRestauranteService.listar();
    }

    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestauranteService.buscar(restauranteId);
        if (restaurante != null) {
            return ResponseEntity.ok(restaurante);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
        try {
            Restaurante restauranteSalvo = cadastroRestauranteService.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).body(restauranteSalvo);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{restauranteId}")
    public ResponseEntity<?> atualizar(@RequestBody Restaurante restaurante, @PathVariable Long restauranteId) {
        try {
            Restaurante restauranteAtual = cadastroRestauranteService.buscar(restauranteId);
            if (restauranteAtual == null) {
                return ResponseEntity.notFound().build();
            }
            BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
            Restaurante restauranteAtualizado = cadastroRestauranteService.salvar(restauranteAtual);
            return ResponseEntity.ok(restauranteAtualizado);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
