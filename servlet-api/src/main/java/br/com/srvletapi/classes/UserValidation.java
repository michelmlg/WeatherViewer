package br.com.srvletapi.classes;


import br.com.srvletapi.ValidationUtils;

public class UserValidation {

    public static void validateUser(User user) throws IllegalArgumentException{
        // Validação do nome de usuário
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("O nome de usuário é obrigatório.");
        }
        if (user.getUsername().length() < 3) {
            throw new IllegalArgumentException("O nome de usuário deve ter pelo menos 3 caracteres.");
        }

        // Validação do e-mail
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("O e-mail é obrigatório.");
        }
        if (!ValidationUtils.isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("O e-mail fornecido não é válido.");
        }

        // Validação da senha
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("A senha é obrigatória.");
        }
        if (!ValidationUtils.isValidPassword(user.getPassword())) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra maiúscula, um número, um caractere especial e pelo menos 6 caracteres.");
        }

        // Validação do papel (role)
        if (user.getRole() == null || user.getRole().isEmpty()) {
            throw new IllegalArgumentException("O papel (role) é obrigatório.");
        }
        if (!user.getRole().equals("user") && !user.getRole().equals("admin")) {
            throw new IllegalArgumentException("O papel deve ser 'user' ou 'admin'.");
        }

    }
}
