package com.redesocial.gerenciador.GerenciadorUsuarios;

import com.redesocial.modelo.Post.Post;
import com.redesocial.modelo.Usuario.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuarios extends Usuario{

    private List<Usuario> usuarios;
    private int proximoId;

    public GerenciadorUsuarios(String nome, String username, String email, String senha, LocalDateTime dataCadastro, List<Usuario> amigos, List<Post> posts, List<Usuario> usuarios, int proximoId) {
        super(nome, username, email, senha, dataCadastro, amigos, posts);
        this.usuarios = new ArrayList<>();
        this.proximoId = proximoId;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public int getProximoId() {
        return proximoId;
    }

    public void setProximoId(int proximoId) {
        this.proximoId = proximoId;
    }

    private boolean validarUsuario(Usuario usuario){
        return usuario.getNome() != null && !usuario.getNome().isEmpty() &&
                usuario.getUsername() != null && !usuario.getUsername().isEmpty() &&
                usuario.getEmail() != null && !usuario.getEmail().isEmpty() &&
                usuario.getSenha() != null && !usuario.getSenha().isEmpty();
    }

    public void cadastrar(Usuario usuario){
        if (validarUsuario(usuario)){
            usuario.setId(proximoId++);
            usuarios.add(usuario);
        }
    }

    public Usuario buscarPorId(int id){
        return usuarios.stream()
                .filter(u)
    }
}
