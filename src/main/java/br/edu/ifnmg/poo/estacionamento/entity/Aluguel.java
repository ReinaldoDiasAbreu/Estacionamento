package br.edu.ifnmg.poo.estacionamento.entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Aluguel extends Entidade{

    private Cliente cliente;

    private Vaga vaga;

    private LocalDateTime dataEntrada;

    private LocalDateTime dataSaida;

    private Float valorTotal;

    public Aluguel() {

    }

    public Aluguel(Vaga vaga, Cliente cliente) {
        this.vaga = vaga;
        this.cliente = cliente;
        this.registraEntrada();
    }

    /**
     * Registra a entrada do cliente na vaga
     * @return Boolean caso entrada confirmada.
     */
    public Boolean registraEntrada() {
        this.dataEntrada = LocalDateTime.now();
        return vaga.ocupaVaga() != null;
    }

    /**
     * Registra a saida do cliente da vaga
     *
     * @param precoHora
     */
    public void registrarSaida(Float precoHora) {
        this.dataSaida = LocalDateTime.of(2020, 12, 9, 20, 42, 25);
        calcularPreco(precoHora);
        vaga.liberaVaga();
        //desaloca a vaga

    }

    /**
     * Calcula o preço baseado no precoHora*(o tempo de saida menos tempo de
     * entrada)
     *
     * @param precoHora
     * @return O valor do preço
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

    @Override
    public String toString() {
        return "Aluguel{ cliente=" + cliente + ", vaga=" + vaga + ", horarioEntrada=" + dataEntrada + ", horarioSaida=" + dataSaida + ", valorTotal=" + valorTotal + '}';
    }

}
