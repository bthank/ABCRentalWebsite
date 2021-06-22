package com.abcrentals.binu.thankachan.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/*
 * Custom constraint validation class for Email field
 * 
 * 
 * 
 */


@Documented
@Constraint(validatedBy=EmailValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface EmailConstraint2 {
	String message() default "Invalid email format. Email must be 8-30 chars and the correct format.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
