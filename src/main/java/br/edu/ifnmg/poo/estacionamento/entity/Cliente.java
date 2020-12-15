package br.edu.ifnmg.poo.estacionamento.entity;

public class Cliente extends Entidade{

    private String cpf;

    private String nome;

    private String telefone;

    private String endereco;

    private String placa;
    
    private String modelo;
    
    private String fabricante;
    
    private String cor;

    public Cliente() {

    }

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

    /**
     * Getters e Setters dos atributos da classe
     *
     */
//<editor-fold defaultstate="collapsed" desc="Get/Set">
    public void setCor(String cor) {
        this.cor = cor;
    }

//</editor-fold>
    @Override
    public String toString() {
        return getId() + " | " + nome + " | " + cpf + " | " + telefone + " | " + endereco;
    }

    
}
