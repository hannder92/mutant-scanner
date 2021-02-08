package com.mercadolibre.mutant.scanner.mutantscanner.domain.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PatternValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DNAPatternValidation {

    String message() default "Invalid DNA pattern only accepts letters {A,T,C,G}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
