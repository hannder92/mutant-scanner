package com.mercadolibre.mutant.scanner.mutantscanner.domain.dto;


import com.mercadolibre.mutant.scanner.mutantscanner.domain.validators.DNAPatternValidation;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.validators.NxNValidation;
import com.mercadolibre.mutant.scanner.mutantscanner.utils.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DNARequestDTO {

    @NotNull(message = "DNA can not be null")
    @NotEmpty(message = "DNA can not be empty")
    @DNAPatternValidation
    @NxNValidation
    @ApiModelProperty(name = "Dna pattern",required = true, example = Constants.DNA_PATTERN_EXAMPLE)
    private String[] dna;

}
