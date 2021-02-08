package com.mercadolibre.mutant.scanner.mutantscanner.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Mutant/Human stadistics information")
public class StatsResponseDTO {
    @ApiModelProperty(name = "Mutant count", example = "40")
    private long countMutantDNA;

    @ApiModelProperty(name = "Human count", example = "100")
    private long countHumanDNA;

    @ApiModelProperty(name = "Ratio Mutant/Human", example = "0.4")
    private Double ratio;

    public StatsResponseDTO() {
    }

    public StatsResponseDTO(long countMutantDNA, long countHumanDNA, Double ratio) {
        this.countMutantDNA = countMutantDNA;
        this.countHumanDNA = countHumanDNA;
        this.ratio = ratio;
    }

    public long getCountMutantDNA() {
        return countMutantDNA;
    }

    public void setCountMutantDNA(long countMutantDNA) {
        this.countMutantDNA = countMutantDNA;
    }

    public long getCountHumanDNA() {
        return countHumanDNA;
    }

    public void setCountHumanDNA(long countHumanDNA) {
        this.countHumanDNA = countHumanDNA;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "{" +
                "countMutantDNA:" + countMutantDNA +
                ", countHumanDNA:" + countHumanDNA +
                ", ratio:" + ratio +
                '}';
    }
}
