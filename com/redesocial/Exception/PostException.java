package com.redesocial.Exception;

public class PostException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Construtor que cria uma nova exceção com uma mensagem específica.
   *
   * @param mensagem A mensagem detalhando o erro ocorrido
   */
  public PostException(String mensagem) {
    super(mensagem);
  }

  /**
   * Construtor que cria uma nova exceção com uma mensagem e uma causa.
   *
   * @param mensagem A mensagem detalhando o erro ocorrido
   * @param causa A causa raiz do erro (exceção que causou este erro)
   */
  public PostException(String mensagem, Throwable causa) {
    super(mensagem, causa);
  }
}