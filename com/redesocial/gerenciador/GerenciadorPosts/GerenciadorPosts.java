package com.redesocial.gerenciador.GerenciadorPosts;

import com.redesocial.Exception.UsuarioException;
import com.redesocial.Exception.ValidadorException;
import com.redesocial.Exception.PostException;
import com.redesocial.modelo.Comentario.Comentario;
import com.redesocial.modelo.Post.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorPosts {
    private List<Post> posts;
    private List<Comentario> comentarios;
    private int proximoId ;

    public GerenciadorPosts() {
        posts = new ArrayList<>();
        proximoId = 1;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getProximoId() {
        return proximoId;
    }

    public void setProximoId(int proximoId) {
        this.proximoId = proximoId;
    }

    public void criar(Post post){
        try{
            validarPost(post);
            posts.add(post);
        } catch (ValidadorException e){
            throw e;
        } catch (Exception e){
            throw new PostException("Erro ao criar post", e);
        }
    }

    public Post buscarPorId(int id){
        try {
            return posts.stream()
                    .filter(post -> post.getId() == id)
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new UsuarioException("Erro ao buscar id: " + e.getMessage(), e);
        }
    }

    public List<Post> buscarPorUsuario(int idUsuario){
        try {
            if (idUsuario >= 1){
                throw new ValidadorException("O id tem que ser maior que 1");
            }
            return posts.stream()
                    .filter(user -> user.getId() == idUsuario)
                    .collect(Collectors.toList());
        } catch (ValidadorException e) {
            throw e;
        } catch (Exception e){
            throw new UsuarioException("Erro ao buscar id: " + e.getMessage(), e);
        }
    }

    public void curtir(int idPost, int idUsuario){
        try {
            validarPost(buscarPorId(idPost));
            validarPost(buscarPorId(idUsuario));
            posts.add(buscarPorId(idPost));
            posts.add(buscarPorId(idUsuario));
        } catch (ValidadorException e) {
            throw e;
        } catch (Exception e){
            throw new UsuarioException("Erro ao curtir: " + e.getMessage(), e);
        }
    }

    public void descurtir(int idPost, int idUsuario){
        try {
            validarPost(buscarPorId(idPost));
            validarPost(buscarPorId(idUsuario));
            posts.remove(buscarPorId(idPost));
            posts.remove(buscarPorId(idUsuario));
        } catch (ValidadorException e) {
            throw e;
        } catch (Exception e){
            throw new UsuarioException("Erro ao descurir: " + e.getMessage(), e);
        }
    }

    public void comentar(Comentario comentario){
        try {
            validarComentario(comentario);
            comentarios.add(comentario);
        } catch (ValidadorException e) {
            throw e;
        } catch (Exception e){
            throw new UsuarioException("Erro ao comentar: " + e.getMessage(), e);
        }
    }

    public boolean deletar(int id){
        try {
            return posts.removeIf(p -> p.getId() == id);
        } catch (ValidadorException e){
            throw e;
        } catch (Exception e) {
            throw new PostException("Erro ao deletar post: " + e.getMessage(), e);
        }
    }

    private void validarPost(Post post){
        if (post == null){
            throw new ValidadorException("O post não pode ser nulo");
        }
        if (post.getConteudo() == null || post.getConteudo().trim().isEmpty()){
            throw new ValidadorException("O conteúdo não pode estar vazio.");
        }
        if (post.getConteudo().length() > 500) {
            throw new ValidadorException("O conteúdo do post excede o tamanho máximo permitido de 500 caracteres.");
        }
        if (post.getAutor() == null) {
            throw new ValidadorException("O autor do post não pode ser nulo.");
        }
    }

    private void validarComentario(Comentario comentario){
        if (comentario == null){
            throw new ValidadorException("O comentario não pode ser nulo.");
        }
        if (comentario.getConteudo() == null || comentario.getConteudo().trim().isEmpty()){
            throw new ValidadorException("O conteúdo não pode estar vazio.");
        }
        if (comentario.getAutor() == null) {
            throw new ValidadorException("O autor do post não pode ser nulo.");
        }
        if (comentario.getPost() == null) {
            throw new ValidadorException("O post não pode ser nulo.");
        }
    }
}
