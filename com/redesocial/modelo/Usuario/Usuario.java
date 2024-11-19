package com.redesocial.modelo.Usuario;
import com.redesocial.modelo.Post.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private Integer id;
    private String nome;
    private String username;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;
    private List<Usuario> amigos;
    private List<Post> posts;

    public Usuario(String nome, String username, String email, String senha, LocalDateTime dataCadastro, List<Usuario> amigos, List<Post> posts) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.amigos = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Usuario" +
                "id: " + id +
                "nome: " + nome +
                "username: " + username +
                "email: " + email +
                "senha: " + senha +
                "dataCadastro: " + dataCadastro +
                "amigos: " + amigos +
                "posts: " + posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

   public boolean adicionarAmigo(Usuario amigo) {
        if (!amigos.contains(amigo)){
            amigos.add(amigo);
            return true;
        }
        return false;
   }

    public boolean removerAmigo(Usuario amigo){
        if (amigos.contains(amigo)){
            amigos.remove(amigo);
            return true;
        }
        return false;
    }

    public boolean adicionarPost(Post post){
        if (!posts.contains(post)){
            posts.add(post);
            return true;
        }
        return false;
    }

//    private boolean validarUsuario(Usuario usuario){
//        return usuario.getNome() != null && !usuario.getNome().isEmpty() &&
//                usuario.getUsername() != null && !usuario.getUsername().isEmpty() &&
//                usuario.getEmail() != null && !usuario.getEmail().isEmpty() &&
//                usuario.getSenha() != null && !usuario.getSenha().isEmpty();
//    }
}
