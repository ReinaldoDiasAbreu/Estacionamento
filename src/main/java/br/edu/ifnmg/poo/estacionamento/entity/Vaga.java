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

import br.edu.ifnmg.poo.estacionamento.dao.VagaDao;

/**
 * Representação da Vaga
 *
 * @author Cauã Ribeiro
 * @version 1.0 , 15/12/2020
 */
public class Vaga extends Entidade {

    /**
     * Estado da vaga se está disponivel ou não
     */
    private Integer disponivel;

    public Vaga() {

    }

    /**
     * Construtor sobrecarregado
     *
     * @param id Id da vaga
     * @param disponivel Disponibilidade
     */
    public Vaga(Long id, Integer disponivel) {
        super(id);
        this.disponivel = disponivel;
    }

    /**
     * Torna a vaga disponivel.
     *
     * @return Long id
     */
    public Long liberaVaga() {
        if (this.disponivel == 0) {
            this.disponivel = 1;

            Long id = new VagaDao().salvar(this);
            return id;
        } else {
            return null;
        }
    }

    /**
     * Torna a vaga ocupada.
     *
     * @return Long id
     */
    public Long ocupaVaga() {
        if (this.disponivel == 1) {
            this.disponivel = 0;
            Long id = new VagaDao().salvar(this);
            return id;
        } else {
            return null;
        }
    }

    /**
     * Getters e Setters dos atributos da classe
     *
     * @return
     */
//<editor-fold defaultstate="collapsed" desc="Get/Set">
    public Integer getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Integer disponivel) {
        this.disponivel = disponivel;
    }
//</editor-fold>

    /**
     * Gera representação textual do objeto atual.
     *
     * @return Texto representativo do objeto atual
     */
    @Override
    public String toString() {
        return "Vaga: " + getId();
    }
}
