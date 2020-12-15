package br.edu.ifnmg.poo.estacionamento.entity;

import br.edu.ifnmg.poo.estacionamento.dao.VagaDao;

public class Vaga extends Entidade{

    private Integer disponivel;

    public Vaga() {

    }

    public Vaga(Long id, Integer disponivel) {
        super(id);
        this.disponivel = disponivel;
    }

    /**
     * Torna a vaga disponivel.
     *@return Long id
     */
    public Long liberaVaga() {
        if(this.disponivel == 0){
            this.disponivel = 1;
        
            Long id = new VagaDao().salvar(this);
            return id;
        }
        else{
            return null;
        }
    }

    /**
     * Torna a vaga ocupada
     * @return Long id
     */
    public Long ocupaVaga() {
        if(this.disponivel == 1){
            this.disponivel = 0;
            Long id = new VagaDao().salvar(this);
            return id;
        }else{
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

    @Override
    public String toString() {
        return "Vaga: " + getId();
    }
}
