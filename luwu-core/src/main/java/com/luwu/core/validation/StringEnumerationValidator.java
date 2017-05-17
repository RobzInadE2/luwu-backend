package com.luwu.core.validation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringEnumerationValidator implements ConstraintValidator<StringEnumeration, String> {

    private Set<String> validEnumValues;

    @Override
    public void initialize(StringEnumeration constraintAnnotation) {
        final Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClass();
        final Enum<?>[] enumConstants = enumClass.getEnumConstants();
        this.validEnumValues = Stream.of(enumConstants).map(Enum::name).collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isBlank(value) || validEnumValues.contains(value);
    }
}
