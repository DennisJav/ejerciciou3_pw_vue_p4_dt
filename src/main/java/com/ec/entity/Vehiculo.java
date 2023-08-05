package com.ec.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_id_vehi")
    @SequenceGenerator(name = "sec_id_vehi", sequenceName = "sec_id_vehi", allocationSize = 1)
    @Column(name = "vehi_id")
    private Integer id;
    @Column(name = "vehi_placa")
    private String placa;
    @Column(name = "vehi_modelo")
    private String modelo;
    @Column(name = "vehi_marca")
    private String marca;
    @Column(name = "vehi_anio_fabricacion")
    private String anioFabricacion;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(String anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", anioFabricacion='" + anioFabricacion + '\'' +
                '}';
    }
}
