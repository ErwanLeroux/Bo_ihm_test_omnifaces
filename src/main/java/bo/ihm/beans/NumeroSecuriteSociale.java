package bo.ihm.beans;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumeroSecuriteSocialeValidator.class)
public @interface NumeroSecuriteSociale {

    Class<?>[] groups() default {};

    String message() default "${validatedValue} is not valid";

    Class<? extends Payload>[] payload() default {};
}
