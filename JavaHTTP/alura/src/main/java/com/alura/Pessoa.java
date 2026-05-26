package com.alura;

import com.google.gson.Gson;

public class Pessoa {
    String nome;
    int idade;
    String cidade;

    public Pessoa(String nome, int idade, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
    }

    public Pessoa(PessoaDTO pessoa){
        this.nome = pessoa.nome();
        this.idade = pessoa.idade();
        this.cidade = pessoa.cidade();
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", cidade=" + cidade + "]";
    }
    
}

record PessoaDTO(String nome,int idade, String cidade){

}

class Principal{
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = gson.toJson(new Pessoa("Caique",23,"Belo Horizonte"));
        System.out.println(json);
        Pessoa pessoaSalva = new Pessoa(gson.fromJson(json, PessoaDTO.class));
        System.out.println(pessoaSalva);
    }
}