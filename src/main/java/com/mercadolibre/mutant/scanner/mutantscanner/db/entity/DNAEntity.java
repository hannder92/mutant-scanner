package com.mercadolibre.mutant.scanner.mutantscanner.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "dna")
public class DNAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dna_pattern",nullable = false ,unique = true)
    private String dnaPattern;

    @Column(name = "mutant", nullable = false)
    private boolean mutant;

    public DNAEntity() {
    }

    public DNAEntity(Long id, String dnaPattern, boolean mutant) {
        this.id = id;
        this.dnaPattern = dnaPattern;
        this.mutant = mutant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDnaPattern(String s) {
        return dnaPattern;
    }

    public void setDnaPattern(String dnaPattern) {
        this.dnaPattern = dnaPattern;
    }

    public boolean isMutant() {
        return mutant;
    }

    public void setMutant(boolean mutant) {
        this.mutant = mutant;
    }
}
