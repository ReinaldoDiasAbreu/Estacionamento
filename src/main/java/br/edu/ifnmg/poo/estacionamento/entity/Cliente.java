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
 * Representação do Cliente
 *
 * @author Cauã Ribeiro
 * @version 1.0 , 15/12/2020
 */
public class Cliente extends Entidade {

    /**
     * CPF do cliente
     */
    private String cpf;
    /**
     * Nome do cliente
     */
    private String nome;
    /**
     * Telefone do cliente
     */
    private String telefone;
    /**
     * Endereço do cliente
     */
    private String endereco;
    /**
     * Placa do carro do cliente
     */
    private String placa;
    /**
     * Modelo do carro do cliente
     */
    private String modelo;
    /**
     * Fabricante do carro do cliente
     */
    private String fabricante;
    /**
     * Cor do carro do cliente
     */
    private String cor;

    public Cliente() {

    }

    /**
     * Construtor sobrecarregado
     *
     * @param id Identidade do Cliente
     * @param cpf CPF do cliente
     * @param nome Nome do cliente
     * @param telefone Telefone do cliente
     * @param endereco Endereço do cliente
     * @param placa Placa do carro do cliente
     * @param modelo Modelo do carro do cliente
     * @param fabricante Fabricante do carro do cliente
     * @param cor Cor do carro do cliente
     */
    public Cliente(Long id, String cpf, String nome, String telefone, String endereco, String placa, String modelo, String fabricante, String cor) {
        super(id);
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.cor = cor;
    }

//<editor-fold defaultstate="collapsed" desc="Get/Set">    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

//</editor-fold>
    /**
     * Gera representação textual do objeto atual.
     *
     * @return Texto representativo do objeto atual
     */
    @Override
    public String toString() {
        return getId() + " | " + nome + " | " + cpf + " | " + telefone + " | " + endereco;
    }

}
