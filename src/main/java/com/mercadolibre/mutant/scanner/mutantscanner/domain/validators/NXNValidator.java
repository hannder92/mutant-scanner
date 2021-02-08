package com.mercadolibre.mutant.scanner.mutantscanner.domain.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NXNValidator implements ConstraintValidator<NxNValidation, String[]> {

    @Override
    public void initialize(NxNValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String[] value, ConstraintValidatorContext context) {
        if (value == null || value.length == 0 || value[0].length() != value.length) {
            return false;
        }
        return true;
    }
}
