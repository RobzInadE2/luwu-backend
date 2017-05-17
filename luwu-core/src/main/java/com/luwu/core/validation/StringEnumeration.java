package com.luwu.core.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = StringEnumerationValidator.class)
@Target({ FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StringEnumeration {

    Class<? extends Enum<?>> enumClass();

    String message() default "{com.luwu.core.validation.StringEnumeration.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
