package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import util.Persistivel;

@Entity
@Table(name = "veiculo_usado")

public class VeiculoUsado implements Serializable, Persistivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "veiculo", referencedColumnName = "codigo")
    @ManyToOne
    private Veiculo veiculo;

    @JoinColumn(name = "motorista", referencedColumnName = "codigo")
    @ManyToOne
    private Motorista motorista;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate retirada;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate devolucao;

    public VeiculoUsado() {
    }

    public VeiculoUsado(Veiculo veiculo, Motorista motorista, LocalDate retirada, LocalDate devolucao) {
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.retirada = retirada;
        this.devolucao = devolucao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo vehicle) {
        this.veiculo = vehicle;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista driver) {
        this.motorista = driver;
    }

    public LocalDate getRetirada() {
        return retirada;
    }

    public void setRetirada(LocalDate withdraw) {
        this.retirada = withdraw;
    }

    public LocalDate getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(LocalDate devolution) {
        this.devolucao = devolution;
    }

    @Override
    public String toString() {
        return veiculo + " | " + motorista;
    }

    @Override
    public Integer getCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
