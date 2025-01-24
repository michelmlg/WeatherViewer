package br.com.srvletapi;

import java.util.regex.Pattern;

public class ValidationUtils {
    public static boolean isValidPassword(String password) {
        // Expressão regular para validar a senha
        // A senha deve conter pelo menos:
        // 1 letra maiúscula, 1 número, 1 caractere especial e ter pelo menos 6 caracteres no total
        String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).{6,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        return pattern.matcher(password).matches();
    }

    public static boolean isValidEmail(String email) {
        // Expressão regular para validar o formato do e-mail
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
