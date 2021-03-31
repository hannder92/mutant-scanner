package com.mercadolibre.mutant.scanner.mutantscanner.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@ApiModel(description = "Mutant/Human stadistics information")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StatsResponseDTO {
    @ApiModelProperty(name = "Mutant count", example = "40")
    private long countMutantDNA;

    @ApiModelProperty(name = "Human count", example = "100")
    private long countHumanDNA;

    @ApiModelProperty(name = "Ratio Mutant/Human", example = "0.4")
    private Double ratio;

    @Override
    public String toString() {
        return "{" +
                "countMutantDNA:" + countMutantDNA +
                ", countHumanDNA:" + countHumanDNA +
                ", ratio:" + ratio +
                '}';
    }


}
