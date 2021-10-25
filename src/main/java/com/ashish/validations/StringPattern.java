package com.ashish.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy=StringPatternValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringPattern {
    ErrorCode errorCode();
    // This attribute supports using the same ErrorCode in different contexts -
    // normal create/update (where it might be required) and patch (always optional)
    boolean patch() default false;
    String message() default "data input error";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}