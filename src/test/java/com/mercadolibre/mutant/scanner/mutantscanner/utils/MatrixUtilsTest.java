package com.mercadolibre.mutant.scanner.mutantscanner.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatrixUtilsTest {

    @Test
    public void getCombinations() {
        String[][] humanMatrix = MatrixUtils.getMatrixByStringArray(TestConstants.HUMAN_DNA);
        String[][] mutantMatrix = MatrixUtils.getMatrixByStringArray(TestConstants.MUTANT_DNA);
        String[][] mutantDiagonal = MatrixUtils.getMatrixByStringArray(TestConstants.MUTANT_DIAGONALS);

        assertFalse(MatrixUtils.evaluateArrays(MatrixUtils.getCombinations(humanMatrix)));
        assertTrue(MatrixUtils.evaluateArrays(MatrixUtils.getCombinations(mutantMatrix)));
        assertTrue(MatrixUtils.evaluateArrays(MatrixUtils.getDiagonalCombinations(mutantDiagonal)));
    }
}




