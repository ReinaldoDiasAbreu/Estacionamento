/*
 * The MIT License (MIT)
 *
 * Copyright (c) [2020] [Cauã Ribeiro da Costa e Aguiar]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package br.edu.ifnmg.poo.estacionamento.entity;

/**
 *
 * @author Cauã Ribeiro
 * @version 1.0
 */
public class Funcionario extends Entidade {
/**
 * Nome do funcionário
 */
    private String nome;
/**
 * Senha do funcionário
 */
    private String senha;
/**
 * CPF do funcionário
 */
    private String cpf;
/**
 * Telefone do funcionário
 */
    private String telefone;

    public Funcionario() {

    }

    ;
/**
 * Construtor sobrecarregado
 * @param nome Nome do funcionario
 * @param senha senha do funcionario
 * @param cpf Cpf do funcionario
 * @param telefone Telefone do funcionario
 */
    public Funcionario(String nome, String senha, String cpf, String telefone) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

//</editor-fold>
/**
 * Representação dos atributos da classe
 * @return Uma string com os valores dos atrbutos
 */
    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", senha=" + senha + ", cpf=" + cpf + ", telefone=" + telefone + '}';
    }
    
    
}
