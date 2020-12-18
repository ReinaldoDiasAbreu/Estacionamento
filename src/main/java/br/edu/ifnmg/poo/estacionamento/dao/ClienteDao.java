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

import br.edu.ifnmg.poo.estacionamento.entity.Cliente;
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
public class ClienteDao extends AbstractDao<Cliente, Long> {

    @Override
    public String getDeclaracaoInsert() {
        return "INSERT INTO CLIENTE (id, cpf, nome, telefone, endereco, placa, modelo, fabricante, cor) VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?);";
    }
    @Override
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM CLIENTE WHERE id = ?;";
    }

    @Override
    public String getDeclaracaoSelectTodos() {
        return "SELECT * FROM CLIENTE;";
    }
    
    public String getInformacaoClientes(){
        return "SELECT id, cpf, nome, telefone, endereco FROM CLIENTE;";
    }

    @Override
    public String getDeclaracaoUpdate() {
        return "UPDATE CLIENTE SET cpf = ?, nome = ?, telefone = ?, endereco = ?, "
                + "placa = ?, modelo = ?, fabricante = ?, cor = ? WHERE id = ?;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "DELETE FROM CLIENTE WHERE id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Cliente o) {
        try {
            if (o.getId() == null || o.getId() == 0) {
                pstmt.setString(1, o.getCpf());
                pstmt.setString(2, o.getNome());
                pstmt.setString(3, o.getTelefone());
                pstmt.setString(4, o.getEndereco());
                pstmt.setString(5, o.getPlaca());
                pstmt.setString(6, o.getModelo());
                pstmt.setString(7, o.getFabricante());
                pstmt.setString(8, o.getCor());
            } else {
                pstmt.setString(1, o.getCpf());
                pstmt.setString(2, o.getNome());
                pstmt.setString(3, o.getTelefone());
                pstmt.setString(4, o.getEndereco());
                pstmt.setString(5, o.getPlaca());
                pstmt.setString(6, o.getModelo());
                pstmt.setString(7, o.getFabricante());
                pstmt.setString(8, o.getCor());
                pstmt.setLong(9, o.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem do cliente
        Cliente cliente = new Cliente();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado do cliente a ser mapeado
        try {
            
            cliente.setId(resultSet.getLong("id"));
            cliente.setCpf(resultSet.getString("cpf"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setTelefone(resultSet.getString("telefone"));
            cliente.setEndereco(resultSet.getString("endereco"));
            cliente.setPlaca(resultSet.getString("placa"));
            cliente.setModelo(resultSet.getString("modelo"));
            cliente.setFabricante(resultSet.getString("fabricante"));
            cliente.setCor(resultSet.getString("cor"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve a tarefa mapeada
        return cliente;
    }

    @Override
    public ArrayList<Cliente> extrairObjetos(ResultSet resultSet) {
        // Cria referência para inserção dos clientes a serem mapeadas
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        // Tenta...
        try {
            // ... entquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem do cliente
                Cliente cliente = new Cliente();

                // Tenta recuperar dados do registro retornado pelo banco 
                // de dados e ajustar o estado do cliente a ser mapeado
                cliente.setId(resultSet.getLong("id"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setPlaca(resultSet.getString("placa"));
                cliente.setModelo(resultSet.getString("modelo"));
                cliente.setFabricante(resultSet.getString("fabricante"));
                cliente.setCor(resultSet.getString("cor"));
                
                // Insere o cliente na lista de clientes recuperados
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de clientes reconstituídas dos registros do banco 
        // de dados
        return clientes;
    }
    
    /**
     * Cria lista de objetos Cliente recuperados do banco de dados
     * somente incluindo id, cpf, nome, telefone e endereço
     * @param resultSet Resultado proveniente do banco de dados relacional.
     * @return ArrayList Cliente
     */
    public ArrayList<Cliente> extrairObjetosCliente(ResultSet resultSet) {
        // Cria referência para inserção das tarefas a serem mapeadas
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        // Tenta...
        try {
            // ... entquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem do cliente
                Cliente cliente = new Cliente();

                // Tenta recuperar dados do registro retornado pelo banco 
                // de dados e ajustar o estado do cliente a ser mapeado
                cliente.setId(resultSet.getLong("id"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEndereco(resultSet.getString("endereco"));
                
                // Insere o cliente na lista de clientes recuperados
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de clientes reconstituídos dos registros do banco 
        // de dados
        return clientes;
    }
    
    /**
     * Retorna ArrayList do cliente com seus dados 
     * ( id, cpf, nome, telefone e endereço)
     * @return ArrayList Cliente
     */
    public ArrayList<Cliente> retornaDadosClientes() {

        // Declara referência para reter o(s) objeto(s) a ser(em) recuperado(s)
        ArrayList<Cliente> objetos = new ArrayList<>();

        // Tenta preparar uma sentença SQL para a conexão já estabelecida
        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        // Sentença SQL para recuperação de todos os registros
                        getInformacaoClientes())) {

            // Executa o comando SQL
            ResultSet resultSet = pstmt.executeQuery();

            // Extrai objeto(s) do(s) respectivo(s) registro(s) do banco de dados
            objetos = extrairObjetosCliente(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Devolve uma lista vazia (nenhum registro encontrado) 
        // ou a relação de objeto(s) recuperado(s)
        return objetos;
    }
}
