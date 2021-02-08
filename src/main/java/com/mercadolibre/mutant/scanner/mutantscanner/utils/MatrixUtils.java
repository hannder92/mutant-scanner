package com.mercadolibre.mutant.scanner.mutantscanner.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixUtils {

    /**
     * return final matrix to evaluate from string[]
     * @param dnaList
     * @return String[][]
     */
    public static String[][] getMatrixByStringArray(String[] dnaList){
        int N = dnaList[0].length();
        String[][] finalMatrix = new String[N][N];
        int count = 0;
        char[] charArray;
        for (String string: Arrays.asList(dnaList)) {
            charArray = string.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                finalMatrix[count][i] = String.valueOf(charArray[i]);
            }
            count+=1;
        }
        return finalMatrix;
    }

    /**
     * Evaluate the all possible combinations
     * @param combinations
     * @return boolean
     */
    public static boolean evaluateArrays(List<String[]> combinations) {
        int count;
        String auxLetter;
        for (String[] combination : combinations) {
            auxLetter = combination[0];
            count = 1;
            for (int i = 1; i < combination.length; i++) {
                if (combination[i]!=null && combination[i].equals(auxLetter)) {
                    count += 1;
                    if (count >= 4) return true;
                } else {
                    count = 1;
                    auxLetter = combination[i];
                }
            }
        }
        return false;
    }

    /**
     *
     * @param matrix
     * @return List<Sting[]> combinations
     */
    public static List<String[]> getCombinations(String[][] matrix) {
        List<String[]> combinations = new ArrayList<>();
        String[] combinationRow = new String[matrix.length];
        String[] combinationColumn = new String[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                combinationRow[j] = matrix[i][j];
                combinationColumn[j] = matrix[j][i];
            }
            combinations.add(combinationRow.clone());
            combinations.add(combinationColumn.clone());
            combinations.addAll(getDiagonalCombinations(matrix));
            combinations.addAll(getDiagonalCombinations(getMirrorMatrix(matrix)));
        }
        return combinations;
    }

    /**
     *  return diagonals combinations
     * @param matrix
     * @return List<String[]> diagonalCombinations
     */
    public static List<String[]> getDiagonalCombinations(String[][] matrix) {
        int N = matrix.length;
        String[] combination = new String[N];
        List<String[]> combinations  = new ArrayList<>();

        for(int j=N-1; j>=0; j--){
            for(int k=0; k<N; k++){
                if ((j + k) < N) {
                    combination[k] = matrix[k][j + k];
                } else {
                    break;
                }
            }
            combinations.add(combination.clone());
        }

        for(int i=1; i<N; i++){
            for(int j=i, k=0; j<N && k<N; j++, k++){
                combination[k] = matrix[j][k];
            }
            combinations.add(combination.clone());
        }
        return combinations;
    }

    /**
     *
     * @param originalMatrix
     * @return String[][] mirrorMatrix
     */
    public static String[][] getMirrorMatrix(String[][] originalMatrix){
        int N = originalMatrix.length;
        String[][] mirrorMatrix = new String[N][N];
        for (int i=0; i<N;i++){
            for (int j=N-1,k=0;j>=0 && k<N;j--,k++){
                mirrorMatrix[i][k]= originalMatrix[i][j];
            }
        }
        return mirrorMatrix;
    }

}

