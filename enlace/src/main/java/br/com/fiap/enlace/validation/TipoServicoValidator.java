package br.com.fiap.enlace.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoServicoValidator implements ConstraintValidator<TipoServico, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Adicione aqui os tipos de serviço de casamento que deseja validar
        return value.equals("FOTOGRAFIA") || value.equals("BUFFET") || value.equals("DECORAÇÃO");
    }

}
