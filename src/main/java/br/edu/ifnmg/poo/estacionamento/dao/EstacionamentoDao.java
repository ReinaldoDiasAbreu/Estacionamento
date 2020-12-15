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

import br.edu.ifnmg.poo.estacionamento.entity.Estacionamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Operações de persistência com a entidade Cliente.
 * 
 * @author Reinaldo Junio Dias de Abreu
 * @version 0.0.1, 14/12/2020
 */
public class EstacionamentoDao extends AbstractDao<Estacionamento, Long>{

    @Override
    public String getDeclaracaoInsert() {
        return "INSERT INTO ESTACIONAMENTO (id, nome, endereco, telefone, precohora, quantvagas) VALUES (default, ?, ?, ?, ?, ?);";
    }
    @Override
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM ESTACIONAMENTO WHERE id = ?;";
    }

    @Override
    public String getDeclaracaoSelectTodos() {
        return "SELECT * FROM ESTACIONAMENTO";
    }

    @Override
    public String getDeclaracaoUpdate() {
        return "UPDATE ESTACIONAMENTO SET nome = ?, endereco = ?, telefone = ?,"
                + " precohora = ?, quantvagas = ? WHERE id = ?;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "DELETE FROM ESTACIONAMENTO WHERE id = ?;";
    }
    
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Estacionamento o) {
        try {
            if (o.getId() == null || o.getId() == 0) {
                pstmt.setString(1, o.getNome());
                pstmt.setString(2, o.getEndereco());
                pstmt.setString(3, o.getTelefone());
                pstmt.setFloat(4, o.getPrecoHora());
                pstmt.setInt(5, o.getQuantVagas());
            } else {
                pstmt.setString(1, o.getNome());
                pstmt.setString(2, o.getEndereco());
                pstmt.setString(3, o.getTelefone());
                pstmt.setFloat(4, o.getPrecoHora());
                pstmt.setInt(5, o.getQuantVagas());
                pstmt.setLong(6, o.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstacionamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Estacionamento extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem do estacionamento
        Estacionamento estacionamento = new Estacionamento();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado do estacionamento a ser mapeado
        try {
            estacionamento.setId(resultSet.getLong("id"));
            estacionamento.setNome(resultSet.getString("nome"));
            estacionamento.setEndereco(resultSet.getString("endereco"));
            estacionamento.setTelefone(resultSet.getString("telefone"));
            estacionamento.setPrecoHora(resultSet.getFloat("precohora"));
            estacionamento.setQuantVagas(resultSet.getInt("quantvagas"));
            /*
            ArrayList<Aluguel> alugueis = new AluguelDao().localizarTodos();
            estacionamento.setAlugueis(alugueis);
            ArrayList<Vaga> vagas = new VagaDao().localizarTodos();
            estacionamento.setVagas(vagas);
            */
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve a tarefa mapeada
        return estacionamento;
    }

    @Override
    public ArrayList<Estacionamento> extrairObjetos(ResultSet resultSet) {
        // Cria referência para inserção dos estacionamentos a serem mapeados
        ArrayList<Estacionamento> estacionamentos = new ArrayList<>();
        
        // Tenta...
        try {
            // ... enquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem do estacionamento
                Estacionamento estacionamento = new Estacionamento();
                 
                estacionamento.setId(resultSet.getLong("id"));
                estacionamento.setNome(resultSet.getString("nome"));
                estacionamento.setEndereco(resultSet.getString("endereco"));
                estacionamento.setTelefone(resultSet.getString("telefone"));
                estacionamento.setPrecoHora(resultSet.getFloat("precohora"));
                estacionamento.setQuantVagas(resultSet.getInt("quantvagas"));
                /*
                ArrayList<Aluguel> alugueis = new AluguelDao().localizarTodos();
                estacionamento.setAlugueis(alugueis);
                ArrayList<Vaga> vagas = new VagaDao().localizarTodos();
                estacionamento.setVagas(vagas);
                */
                estacionamentos.add(estacionamento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstacionamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de estacionamentoss reconstituídas dos registros do banco 
        // de dados
        return estacionamentos;
    }
    
}
