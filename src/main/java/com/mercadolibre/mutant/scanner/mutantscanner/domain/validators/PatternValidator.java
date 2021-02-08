package com.mercadolibre.mutant.scanner.mutantscanner.domain.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PatternValidator implements ConstraintValidator<DNAPatternValidation, String[]> {

    @Override
    public void initialize(DNAPatternValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String[] value, ConstraintValidatorContext context) {
        if (value == null || value.length == 0 ){
            return false;
        }else{
            for (String s: value) {
                if(!Pattern.matches("[ATCG]+",s)){
                    return false;
                }
            }
        }
    return true;
    }
}
