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

import br.edu.ifnmg.poo.estacionamento.entity.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Operações de persistência com a entidade Funcionario.
 * 
 * @author Reinaldo Junio Dias de Abreu
 * @version 0.0.1, 14/12/2020
 */
public class FuncionarioDao extends AbstractDao<Funcionario, Long>{

    @Override
    public String getDeclaracaoInsert() {
        return "INSERT INTO FUNCIONARIO (id, cpf, nome, senha, telefone) VALUES (default, ?, ?, ?, ?);";
    }
    @Override
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM FUNCIONARIO WHERE id = ?;";
    }

    @Override
    public String getDeclaracaoSelectTodos() {
        return "SELECT * FROM FUNCIONARIO;";
    }

    @Override
    public String getDeclaracaoUpdate() {
        return "UPDATE FUNCIONARIO SET cpf = ?, nome = ?, senha = ?, telefone = ? WHERE id = ?;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "DELETE FROM FUNCIONARIO WHERE id = ?;";
    }
    
    public String getFuncionarioSenha(){
        return "SELECT * FROM FUNCIONARIO WHERE cpf = ? AND senha = ?;";
    }
    
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Funcionario o) {
        try {
            if (o.getId() == null || o.getId() == 0) {
                pstmt.setString(1, o.getCpf());
                pstmt.setString(2, o.getNome());
                pstmt.setString(3, o.getSenha());
                pstmt.setString(4, o.getTelefone());
            } else {
                pstmt.setString(1, o.getCpf());
                pstmt.setString(2, o.getNome());
                pstmt.setString(3, o.getSenha());
                pstmt.setString(4, o.getTelefone());
                pstmt.setLong(5, o.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
   
    @Override
    public Funcionario extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem do funcionario
        Funcionario funcionario = new Funcionario();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado do funcionario a ser mapeado
        try {
            funcionario.setId(resultSet.getLong("id"));
            funcionario.setCpf(resultSet.getString("cpf"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setSenha(resultSet.getString("senha"));
            funcionario.setTelefone(resultSet.getString("telefone"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve a funcionario mapeado
        return funcionario;
    }

    @Override
    public ArrayList<Funcionario> extrairObjetos(ResultSet resultSet) {
        // Cria referência para inserção dos funcionarios a serem mapeadas
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
        // Tenta...
        try {
            // ... entquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem do cliente
                Funcionario funcionario = new Funcionario();

                // Tenta recuperar dados do registro retornado pelo banco 
                // de dados e ajustar o estado do funcionario a ser mapeado
                funcionario.setId(resultSet.getLong("id"));
                funcionario.setCpf(resultSet.getString("cpf"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setSenha(resultSet.getString("senha"));
                funcionario.setTelefone(resultSet.getString("telefone"));
                
                // Insere o funcionario na lista de funcionarios recuperadas
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de funcionarios reconstituídas dos registros do banco 
        // de dados
        return funcionarios;
    }
    /**
     * Insere o valor da chave primária na senteça SQL específica para seu uso.
     * @param pstmt Declaração previamente preparada.
     * @param cpf Cpf do funcionario a ser inserido na sentença
     * @param senha Senha do funcionario a ser inserida na sentença
     */
    public void ajustarIdDeclaracao(PreparedStatement pstmt, String cpf, String senha) {
        try {
            if(cpf instanceof String && senha instanceof String) {
                pstmt.setString(1, (String) cpf);
                pstmt.setString(2, (String) senha);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Retorna o funcionário do banco de dados
     * com cpf e senha do funcionário passado
     * @param func Funcionário a ser comparado
     * @return Funcionario
     */
    public Funcionario localizarPorCpfSenha(Funcionario func) {
        // Declara referência para reter o objeto a ser recuperado
        Funcionario objeto = null;

        // Tenta preparar uma sentença SQL para a conexão já estabelecida
        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        // Sentença SQL para busca por chave primária
                        getFuncionarioSenha())) {

            // Prepara a declaração com os dados do objeto passado
            ajustarIdDeclaracao(pstmt, func.getCpf(), func.getSenha());

            // Executa o comando SQL
            ResultSet resultSet = pstmt.executeQuery();

            // Se há resultado retornado...
            if (resultSet.next()) {
                // ... extrai objeto do respectivo registro do banco de dados
                objeto = extrairObjeto(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Devolve nulo (objeto não encontrado) ou o objeto recuperado
        return objeto;
    }
    
}