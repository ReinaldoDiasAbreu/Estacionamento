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
 * Representação do Estacionamento
 *
 * @author Cauã Ribeiro
 * @version 1.0 , 15/12/2020
 */
public class Estacionamento extends Entidade {

    /**
     * Nome do estacionamento
     */
    private String nome;
    /**
     * Endereço do estacionamento
     */
    private String endereco;
    /**
     * Telefone do estacionamento
     */
    private String telefone;
    /**
     * Preço da hora do estacionamento
     */
    private Float precoHora;
    /**
     * Quantidade de vagas do estacionamento
     */
    private Integer quantVagas;

    public Estacionamento() {
    }

    /**
     * Construtor sobrecarregado
     *
     * @param nome Nome do estacionamento
     * @param endereco Endereço do estacionamento
     * @param telefone Telefone do estacionamento
     * @param precoHora Preço da Hora do estacionamento
     * @param qtdVaga Quantidades de Vagas do estacionamento
     */
    public Estacionamento(String nome, String endereco, String telefone, Float precoHora, Integer qtdVaga) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.precoHora = precoHora;
        this.quantVagas = qtdVaga;
    }


    /**
     * Getters e Setters dos atributos da classe
     *
     */
//<editor-fold defaultstate="collapsed" desc="Get/Set">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Float getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(Float precoHora) {
        this.precoHora = precoHora;
    }

    public Integer getQuantVagas() {
        return quantVagas;
    }

    public void setQuantVagas(Integer quantVagas) {
        this.quantVagas = quantVagas;
    }

//</editor-fold>

    /**
     * Gera representação textual do objeto atual.
     *
     * @return Texto representativo do objeto atual
     */
    @Override
    public String toString() {
        return "Estacionamento{" + "nome=" + nome + ", endereco=" + endereco
                + ", telefone=" + telefone + ", precoHora=" + precoHora
                + ", quantVagas=" + quantVagas + '}';
    }

}
