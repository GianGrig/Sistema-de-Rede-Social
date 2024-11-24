package com.redesocial.Exception;

public class ValidadorException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Construtor que cria uma nova exceção com uma mensagem específica.
     *
     * @param mensagem A mensagem detalhando o erro de validação
     */
    public ValidadorException(String mensagem) {
        super(mensagem);
    }

    /**
     * Construtor que cria uma nova exceção com uma mensagem e uma causa.
     *
     * @param mensagem A mensagem detalhando o erro de validação
     * @param causa A causa raiz do erro (exceção que causou este erro)
     */
    public ValidadorException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
