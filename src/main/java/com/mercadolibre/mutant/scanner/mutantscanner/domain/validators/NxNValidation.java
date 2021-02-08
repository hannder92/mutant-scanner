package com.mercadolibre.mutant.scanner.mutantscanner.domain.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NXNValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NxNValidation {

    String message() default "Invalid list size, must be NXN";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
