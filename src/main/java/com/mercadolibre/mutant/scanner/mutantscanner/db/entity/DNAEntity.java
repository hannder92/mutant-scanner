package com.mercadolibre.mutant.scanner.mutantscanner.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "dna")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DNAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dna_pattern",nullable = false ,unique = true)
    private String dnaPattern;

    @Column(name = "mutant", nullable = false)
    private boolean mutant;
}
