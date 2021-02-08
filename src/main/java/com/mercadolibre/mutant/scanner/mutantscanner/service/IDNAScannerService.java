package com.mercadolibre.mutant.scanner.mutantscanner.service;

public interface IDNAScannerService {
	/**
	 * Return true if the dna is from a mutant or false if is from a human
	 * 
	 * @param dna
	 * @return boolean
	 */
	boolean isMutant(String[] dna);
}
