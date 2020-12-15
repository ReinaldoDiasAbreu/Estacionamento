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

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Representação do Aluguel
 *
 * @author Cauã Ribeiro da Costa e Aguiar
 * @version 1.0 , 15/12/2020
 */
public class Aluguel extends Entidade {

    /**
     * Cliente que está no aluguel
     */
    private Cliente cliente;
    /**
     * Vaga que está no aluguel
     */
    private Vaga vaga;
    /**
     * Data da entrada na vaga
     */
    private LocalDateTime dataEntrada;
    /**
     * Data da saida da vaga
     */
    private LocalDateTime dataSaida;
    /**
     * Valor total que o cliente devera pagar
     */
    private Float valorTotal;

    public Aluguel() {

    }

    /**
     * Construtor sobrecarregado.
     *
     * @param vaga Vaga do estacionamento
     * @param cliente Cliente que vai alugar
     */
    public Aluguel(Vaga vaga, Cliente cliente) {
        this.vaga = vaga;
        this.cliente = cliente;
        this.registraEntrada();
    }

    /**
     * Registra a entrada do cliente na vaga
     *
     * @return Boolean caso entrada confirmada.
     */
    public Boolean registraEntrada() {
        this.dataEntrada = LocalDateTime.now();
        return vaga.ocupaVaga() != null;
    }

    /**
     * Registra a saida do cliente da vaga E chama a função para calcular o
     * preço que o cliente ira pagar
     *
     * @param precoHora O preço da hora que o estacionamento definiu
     */
    public void registrarSaida(Float precoHora) {
        this.dataSaida = LocalDateTime.now();
        calcularPreco(precoHora);
        vaga.liberaVaga();
    }

    /**
     * Calcula o preço baseado no precoHora*(o tempo de saida menos tempo de
     * entrada)
     *
     * @param precoHora O preço da hora que o estacionamento definiu
     * @return valorTotal O valor total do preço que o cliente ira pagar
     */
    public Float calcularPreco(Float precoHora) {
        if (ChronoUnit.MINUTES.between(dataEntrada, dataSaida) < 60L) {
            return valorTotal = precoHora;
        } else {
            valorTotal = precoHora * ((ChronoUnit.MINUTES.between(dataEntrada, dataSaida)) / 60.F);
            return valorTotal;
        }

    }

    /**
     * Getters e Setters dos atributos da classe
     *
     */
//<editor-fold defaultstate="collapsed" desc="Get/Set">
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public LocalDateTime getHorararioEntrada() {
        return dataEntrada;
    }

    public void setHorararioEntrada(LocalDateTime horararioEntrada) {
        this.dataEntrada = horararioEntrada;
    }

    public LocalDateTime getHorarioSaida() {
        return dataSaida;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.dataSaida = horarioSaida;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
//</editor-fold>

    /**
     * Gera representação textual do objeto atual.
     *
     * @return Texto representativo do objeto atual
     */
    @Override
    public String toString() {
        return "Aluguel{ cliente=" + cliente + ", vaga=" + vaga + ", horarioEntrada=" + dataEntrada + ", horarioSaida=" + dataSaida + ", valorTotal=" + valorTotal + '}';
    }

}
