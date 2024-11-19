package com.redesocial.modelo.Post;

import com.redesocial.modelo.Comentario.Comentario;
import com.redesocial.modelo.Usuario.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Post {

    private Integer id;
    private Usuario autor;
    private String conteudo;
    private LocalDateTime dataPublicacao;
    private List<Usuario> curtidas;
    private List<Comentario> comentarios;

    public Post(Usuario autor, String conteudo, LocalDateTime dataPublicacao, List<Usuario> curtidas, List<Comentario> comentarios) {
        this.autor = autor;
        this.conteudo = conteudo;
        this.dataPublicacao = dataPublicacao;
        this.curtidas = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Usuario> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Usuario> curtidas) {
        this.curtidas = curtidas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Post" +
                "id: " + id +
                "autor: " + autor +
                "conteudo: " + conteudo +
                "dataPublicacao: " + dataPublicacao +
                "curtidas: " + curtidas +
                "comentarios: " + comentarios;
    }

    public boolean adicionarCurtida(Usuario usuario){
        if (!curtidas.contains(usuario)){
            curtidas.add(usuario);
            return true;
        }
        return false;
    }
    public boolean removerCurtida(Usuario usuario){
        if (curtidas.contains(usuario)){
            curtidas.remove(usuario);
            return true;
        }
        return false;
    }

    public boolean adicionarComentario(Comentario comentario){
        if (!comentarios.contains(comentario)){
            comentarios.add(comentario);
            return true;
        }
        return false;
    }
}
