package br.com.fiap.enlace.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoServicoValidator.class)
public @interface TipoServico {

    String message() default "{servico.tipo}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
