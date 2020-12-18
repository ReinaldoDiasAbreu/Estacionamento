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

import br.edu.ifnmg.poo.estacionamento.entity.Aluguel;
import br.edu.ifnmg.poo.estacionamento.entity.Cliente;
import br.edu.ifnmg.poo.estacionamento.entity.Vaga;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Operações de persistência com a entidade Aluguel.
 * 
 * @author Reinaldo Junio Dias de Abreu
 * @version 0.0.1, 14/12/2020
 */
public class AluguelDao extends AbstractDao<Aluguel, Long> {

    @Override
    public String getDeclaracaoInsert() {
        return "INSERT INTO ALUGUEL (id, cliente, vagaid, horaentrada, horasaida, valortotal) VALUES (default, ?, ?, ?, ?, ?);";
    }
    @Override
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM ALUGUEL WHERE id = ?;";
    }

    @Override
    public String getDeclaracaoSelectTodos() {
        return "SELET * FROM ALUGUEL";
    }

    @Override
    public String getDeclaracaoUpdate() {
        return "UPDATE ALUGUEL SET cliente = ?, vagaid = ?, horaentrada = ?,"
                + " horasaida = ?, valortotal = ? WHERE id = ?;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "DELETE FROM ALUGUEL WHERE id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Aluguel o) {
        try {
            
            if (o.getId() == null || o.getId() == 0) {
                pstmt.setLong(1, o.getCliente().getId());
                pstmt.setLong(2, o.getVaga().getId());
                pstmt.setTimestamp(3, o.getHorararioEntrada());
                pstmt.setTimestamp(4, o.getHorarioSaida());
                pstmt.setFloat(5, o.getValorTotal());
            } else {
                pstmt.setLong(1, o.getCliente().getId());
                pstmt.setLong(2, o.getVaga().getId());
                pstmt.setTimestamp(3, o.getHorararioEntrada());
                pstmt.setTimestamp(4, o.getHorarioSaida());
                pstmt.setFloat(5, o.getValorTotal());
                pstmt.setLong(6, o.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AluguelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Aluguel extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem do Aluguel
        Aluguel aluguel = new Aluguel();
        Cliente cliente;
        Vaga vaga;

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado do Aluguel a ser mapeado
        try {

            aluguel.setId(resultSet.getLong("id"));
            
            cliente = new ClienteDao().localizarPorId(resultSet.getLong("cliente"));
            aluguel.setCliente(cliente);
            
            vaga = new VagaDao().localizarPorId(resultSet.getLong("vagaid"));
            aluguel.setVaga(vaga);
            
            aluguel.setHorararioEntrada(resultSet.getTimestamp("horaentrada"));
            aluguel.setHorarioSaida(resultSet.getTimestamp("horasaida"));
            
            aluguel.setValorTotal(resultSet.getFloat("valortotal"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve a tarefa mapeada
        return aluguel;
    }

    @Override
    public ArrayList<Aluguel> extrairObjetos(ResultSet resultSet) {
        // Cria referência para inserção das tarefas a serem mapeadas
        ArrayList<Aluguel> alugueis = new ArrayList<>();
        
        // Tenta...
        try {
            // ... entquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem do aluguel
                Aluguel aluguel = new Aluguel();
                Cliente cliente;
                Vaga vaga;
                // Tenta recuperar dados do registro retornado pelo banco 
                // de dados e ajustar o estado do aluguel a ser mapeado
                 aluguel.setId(resultSet.getLong("id"));
            
                cliente = new ClienteDao().localizarPorId(resultSet.getLong("cliente"));
                aluguel.setCliente(cliente);

                vaga = new VagaDao().localizarPorId(resultSet.getLong("vagaid"));
                aluguel.setVaga(vaga);

                aluguel.setHorararioEntrada(resultSet.getTimestamp("horaentrada"));
                aluguel.setHorarioSaida(resultSet.getTimestamp("horasaida"));

                aluguel.setValorTotal(resultSet.getFloat("valortotal"));

                // Insere o cliente na lista de tarefas recuperadas
                alugueis.add(aluguel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de alugueis reconstituídas dos registros do banco 
        // de dados
        return alugueis;
    }
    
}
