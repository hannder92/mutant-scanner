package com.mercadolibre.mutant.scanner.mutantscanner.utils;

public class TestConstants {

    public static final String[] HUMAN_DNA = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
    public static final String[] MUTANT_DNA = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    public static final String[] MUTANT_DIAGONALS = {"ATGCGA","TAGTGC","TTATTT","AGTCGG","GCGTCA","TCACTG"};
    public static final String[] HUMAN_DNA_INVALID_CHARACTERS = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TChCTG"};
    public static final String[] HUMAN_DNA_INVALID_SIZE = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA"};
}
