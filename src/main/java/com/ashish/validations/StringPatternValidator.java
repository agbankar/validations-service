package com.ashish.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringPatternValidator implements ConstraintValidator<StringPattern, String> {
    private ErrorCode errorCode;

    @Override
    public void initialize(StringPattern constraintAnnotation) {
        this.errorCode = constraintAnnotation.errorCode();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return validate(value, context, errorCode);
    }

    public static boolean validate(String value, ConstraintValidatorContext context, ErrorCode errorCode) {


        // validate pattern
        boolean matches = errorCode.getPattern().matcher(value).matches();
        if (!matches) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorCode.getErrorDescription())
                    .addConstraintViolation();
        }
        return matches;
    }


}
