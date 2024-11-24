package com.redesocial.gerenciador.GerenciadorUsuarios;

import com.redesocial.Exception.UsuarioException;
import com.redesocial.Exception.ValidadorException;
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
        } catch (ValidadorException e){
            throw e;
        } catch (Exception e) {
            throw new UsuarioException("Erro ao cadastrar usuario." + e.getMessage(), e);
        }
    }

    public Usuario buscarPorId(int id){
        try {
            return usuarios.stream()
                    .filter(usuario -> usuario.getId() == id)
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new UsuarioException("Erro ao buscar usuario: " + e.getMessage(), e);
        }
    }

    public Usuario buscarPorUsername(String username){
        try {
            return usuarios.stream()
                    .filter(usuario -> usuario.getUsername().equals(username))
                    .findFirst()
                    .orElse(null);
        } catch (ValidadorException e){
            throw e;
        } catch (Exception e) {
            throw new UsuarioException("Erro ao buscar username: " + e.getMessage(), e);
        }
    }

    public List<Usuario> buscarPorNome(String nome){
        try {
            if (nome == null || nome.trim().isEmpty()) {
                throw new ValidadorException("Nome de busca não pode ser vazio");
            }

            return usuarios.stream()
                    .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                    .collect(Collectors.toList());
        } catch (ValidadorException e){
            throw e;
        } catch (Exception e) {
            throw new UsuarioException("Erro ao buscar produtos por nome: " + e.getMessage(), e);
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
        } catch (ValidadorException e){
            throw e;
        } catch (Exception e) {
            throw new UsuarioException("Erro ao atualizar usuario: " + e.getMessage(), e);
        }
    }

    public boolean deletar(int id){
        try {
            return usuarios.removeIf(p -> p.getId() == id);
        } catch (ValidadorException e){
            throw e;
        } catch (Exception e) {
            throw new UsuarioException("Erro ao deletar usuario: " + e.getMessage(), e);
        }
    }
    public void adicionarAmizade(int idUsuario1, int idUsuario2){
        try {
            validarUsuario(buscarPorId(idUsuario1));
            validarUsuario(buscarPorId(idUsuario2));
            usuarios.add(buscarPorId(idUsuario1));
            usuarios.add(buscarPorId(idUsuario2));
        } catch (ValidadorException e){
            throw e;
        } catch (Exception e) {
            throw new UsuarioException("Erro ao adicionar amigo." + e.getMessage(), e);
        }
    }

    public void removerAmizade(int idUsuario1, int idUsuario2){
        try {
            validarUsuario(buscarPorId(idUsuario1));
            validarUsuario(buscarPorId(idUsuario2));
            usuarios.remove(buscarPorId(idUsuario1));
            usuarios.remove(buscarPorId(idUsuario2));
        } catch (ValidadorException e){
            throw e;
        } catch (Exception e) {
            throw new UsuarioException("Erro ao remover amigo." + e.getMessage(), e);
        }
    }

    private void validarUsuario(Usuario usuario){
        if (usuario == null){
            throw new ValidadorException("O usuario não pode ser nulo.");
        }
        if (usuario.getNome() == null || usuario.getNome().trim().length() < 2){
            throw new ValidadorException("O nome do usuario deve ter pelo menos 2 caracteres.");
        }
        if (usuario.getEmail() == null || !usuario.getEmail().matches("^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,}$")){
            throw new ValidadorException("O Email deve ser valido.");
        }
        if (usuarios.stream().anyMatch(u -> u.getEmail().equalsIgnoreCase(usuario.getEmail()))) {
            throw new ValidadorException("O email já está em uso.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().trim().length() < 6){
            throw new ValidadorException("A senha deve ter pelo menos 6 caracteres.");
        }
        if (usuario.getUsername() == null || usuario.getUsername().trim().isEmpty()){
            throw new ValidadorException("O username não pode ser vazio.");
        }
        if (usuarios.stream().anyMatch(u -> u.getUsername().equalsIgnoreCase(usuario.getUsername()))) {
            throw new ValidadorException("O username já está em uso.");
        }
    }
}
