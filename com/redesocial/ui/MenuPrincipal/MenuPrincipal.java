package com.redesocial.ui.MenuPrincipal;

import com.redesocial.modelo.Usuario.Usuario;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner entradaTeclado;

    public MenuPrincipal(Scanner entradaTeclado) {
        this.entradaTeclado = new Scanner(System.in);
    }

    public void exibirMenu(){
        boolean continuar = true;

        while(continuar){
            System.out.println("=== Cadastro de Usuário ===");
            System.out.println("Digite seu nome: ");
            System.out.println("Digite seu username: ");
            System.out.println("Digite seu email: ");
            System.out.println("Digite seu senha: ");
            System.out.println("Usuário cadastrado com sucesso!");
            try {


            }
        }
    }



}
