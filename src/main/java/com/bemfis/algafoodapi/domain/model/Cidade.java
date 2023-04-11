package com.bemfis.algafoodapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cidade {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Estado estado;
}
