package br.edu.ifnmg.poo.estacionamento.entity;

import java.util.ArrayList;

public class Estacionamento extends Entidade{

    private String nome;

    private String endereco;

    private String telefone;

    private Float precoHora;

    private Integer quantVagas;

    private ArrayList<Vaga> vagas;

    private ArrayList<Aluguel> alugueis;

    public Estacionamento() {

        this.vagas = new ArrayList<>();
        this.alugueis = new ArrayList<>();

    }

    public Estacionamento(String nome, String endereco, String telefone, Float precoHora, Integer qtdVaga) {
        this();
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.precoHora = precoHora;
        this.quantVagas = qtdVaga;
        carregarVagas();
    }

    /**
     * Carrega todas as vagas do Banco de Dados
     */
    private void carregarVagas() {
        for (int i = 0; i < quantVagas; i++) {
           // vagas.add(new Vaga(i, Boolean.TRUE));
        }
    }

    /**
     * Procura uma vaga livre da ArrayList vagas
     *
     * @return A vaga livre se possivel
     */
    private Vaga retornaVagaLivre() {
        
        for (Vaga v : vagas){
            if(v.getDisponivel() == 1){
                return v;
            }
        }

        return null;
    }

    /**
     * Aluga uma vaga para o Cliente
     *
     * @param cliente
     * @return Se a vaga foi alugada pelo Boolean
     */
    public Boolean alugarVaga(Cliente cliente) {

        Vaga vag = retornaVagaLivre();
        if (vag == null) {
            return false;
        } else {
            Aluguel alu = new Aluguel(vag, cliente);
            this.alugueis.add(alu);
            //System.out.println("Vdd");
            return true;
        }

    }

    /**
     * Libera a vaga que estava associada a um cliente e devolve disponivel para
     * a vaga
     *
     * @param id
     */
    public void liberarVaga(Integer id) {
        boolean existe = false;
        for(Aluguel aluguel : alugueis){
            if( id.equals(aluguel.getVaga().getId()) == true ){
                aluguel.registrarSaida(precoHora);
                existe = true;
                break;
            }
        }
        
        if(existe == false){
            System.out.println("Vaga não existe!");
        }
        
        /*
        for (int i = 0; i < alugueis.size(); i++) {
            Aluguel aluguel = alugueis.get(i);
            if (aluguel.getVaga().getId() == id) {
                aluguel.registrarSaida(precoHora);
            } else {
                System.out.println("Vaga não existe!");
            }
        }
        */
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

    public ArrayList<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(ArrayList<Vaga> vagas) {
        this.vagas = vagas;
    }

    public ArrayList<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(ArrayList<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "Estacionamento{" + "nome=" + nome + ", endereco=" + endereco 
                + ", telefone=" + telefone + ", precoHora=" + precoHora 
                + ", quantVagas=" + quantVagas + ", vagas=" + vagas 
                + ", alugueis=" + alugueis + '}';
    }

}
