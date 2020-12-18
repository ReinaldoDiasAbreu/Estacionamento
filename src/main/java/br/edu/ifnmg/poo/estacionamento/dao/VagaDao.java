/*
 * The MIT License (MIT)
 *
 * Copyright (c) [2020] [Reinaldo Junio Dias de Abreu]
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
package br.edu.ifnmg.poo.estacionamento.dao;

import br.edu.ifnmg.poo.estacionamento.entity.Vaga;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Operações de persistência com a entidade Vaga.
 * 
 * @author Reinaldo Junio Dias de Abreu
 * @version 0.0.1, 14/12/2020
 */
public class VagaDao extends AbstractDao <Vaga, Long> {

    @Override
    public String getDeclaracaoInsert() {
        return "INSERT INTO VAGA (id, disponivel) VALUES (default, ?);";
    }
    @Override
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM VAGA WHERE id = ?;";
    }

    @Override
    public String getDeclaracaoSelectTodos() {
        return "SELECT * FROM VAGA";
    }

    @Override
    public String getDeclaracaoUpdate() {
        return "UPDATE VAGA SET disponivel = ? WHERE id = ?;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "DELETE FROM VAGA WHERE id = ?;";
    }
    
    public String getDeclaracaoVagasDisponiveis() {
        return "SELECT * FROM VAGA WHERE disponivel = 1;";
    }
    
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Vaga o) {
        try {
            if (o.getId() == null || o.getId() == 0) {
                pstmt.setInt(1, o.getDisponivel());
            } else {
                pstmt.setLong(1, o.getDisponivel());
                pstmt.setLong(2, o.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Vaga extrairObjeto(ResultSet resultSet) { // Cria referência para montagem do cliente
        Vaga vaga = new Vaga();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado da vaga a ser mapeada
        try {
            vaga.setId(resultSet.getLong("id"));
            vaga.setDisponivel(resultSet.getInt("disponivel"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve a vaga mapeada
        return vaga;
    }

    @Override
    public ArrayList<Vaga> extrairObjetos(ResultSet resultSet) {
        // Cria referência para inserção das vagas a serem mapeadas
        ArrayList<Vaga> vagas = new ArrayList<>();
        
        // Tenta...
        try {
            // ... enquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem da vaga
                Vaga vaga = new Vaga();

                // Tenta recuperar dados do registro retornado pelo banco 
                // de dados e ajustar o estado da vaga a ser mapeadas
                vaga.setId(resultSet.getLong("id"));
                vaga.setDisponivel(resultSet.getInt("disponivel"));
                
                // Insere o cliente na lista de tarefas recuperadas
                vagas.add(vaga);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de vagas reconstituídas dos registros do banco 
        // de dados
        return vagas;
    }
    
    /**
     * Retorna lista de vagas disponíveis
     * @return ArrayList vaga
     */
    public ArrayList<Vaga> localizarVagasDisponiveis() {

        // Declara referência para reter o(s) objeto(s) a ser(em) recuperado(s)
        ArrayList<Vaga> objetos = new ArrayList<>();

        // Tenta preparar uma sentença SQL para a conexão já estabelecida
        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        // Sentença SQL para recuperação de todos os registros
                        getDeclaracaoVagasDisponiveis())) {

            // Executa o comando SQL
            ResultSet resultSet = pstmt.executeQuery();

            // Extrai objeto(s) do(s) respectivo(s) registro(s) do banco de dados
            objetos = extrairObjetos(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Devolve uma lista vazia (nenhum registro encontrado) 
        // ou a relação de objeto(s) recuperado(s)
        return objetos;
    }
}
