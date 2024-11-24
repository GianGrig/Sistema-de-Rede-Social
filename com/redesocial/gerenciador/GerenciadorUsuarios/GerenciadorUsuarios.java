package com.redesocial.gerenciador.GerenciadorUsuarios;

import com.redesocial.modelo.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GerenciadorUsuarios {

    private List<Usuario> usuarios;
    private int proximoId;

    public GerenciadorUsuarios() {
        this.usuarios = new ArrayList<>();
        this.proximoId = 1;
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

    public void cadastrar(Usuario usuario){
        try {
            validarUsuario(usuario);
            usuario.setId(proximoId++);
            usuarios.add(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar usuario." + e.getMessage(), e);
        }
    }

    public Usuario buscarPorId(int id){
        try {
            return usuarios.stream()
                    .filter(usuario -> usuario.getId() == id)
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar usuario: " + e.getMessage(), e);
        }
    }

    public Usuario buscarPorUsername(String username){
        try {
            return usuarios.stream()
                    .filter(usuario -> usuario.getUsername().equals(username))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar username: " + e.getMessage(), e);
        }
    }

    public List<Usuario> buscarPorNome(String nome){
        try {
            if (nome == null || nome.trim().isEmpty()) {
                throw new RuntimeException("Nome de busca não pode ser vazio");
            }

            return usuarios.stream()
                    .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produtos por nome: " + e.getMessage(), e);
        }
    }

    public boolean atualizar(Usuario usuario){
        try {
            validarUsuario(usuario);

            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getId().equals(usuario.getId())) {
                    usuarios.set(i, usuario);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar usuario: " + e.getMessage(), e);
        }
    }

    public boolean deletar(int id){
        try {
            return usuarios.removeIf(p -> p.getId() == id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar usuario: " + e.getMessage(), e);
        }
    }
    public void adicionarAmizade(int idUsuario1, int idUsuario2){
        try {

        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar usuario." + e.getMessage(), e);
        }
    }

    private void validarUsuario(Usuario usuario){
        if (usuario == null){
            throw new RuntimeException("O usuario não pode ser nulo.");
        }
        if (usuario.getNome() == null || usuario.getNome().trim().length() < 2){
            throw new RuntimeException("O nome do usuario deve ter pelo menos 2 caracteres.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()){
            throw new RuntimeException("O Email deve ser valido.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().trim().length() < 6){
            throw new RuntimeException("A senha deve ter pelo menos 6 caracteres.");
        }
        if (usuario.getUsername() == null || usuario.getUsername().isEmpty()){
            throw new RuntimeException("O username deve ser unico.");
        }
    }
}
