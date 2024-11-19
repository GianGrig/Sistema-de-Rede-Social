package com.redesocial.modelo.Comentario;

import com.redesocial.modelo.Post.Post;
import com.redesocial.modelo.Usuario.Usuario;

import java.time.LocalDateTime;

public class Comentario {
    private Integer id;
    private Usuario autor;
    private String conteudo;
    private LocalDateTime dataComentario;
    private Post post;
}
