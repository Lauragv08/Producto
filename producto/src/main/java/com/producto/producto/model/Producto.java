package com.producto.producto.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty 
    @NotBlank
    @Size(min = 3)
    @Column(length = 60, nullable = false)
    private String descripcion;

    @NotEmpty
    @Column(name = "catgo_descricion")
    private String categoria;

    @DecimalMin(value = "0.1")
    @Column(nullable = false)
    private Double precio;

    @Min(value = 1)
    @Column(nullable = false)
    private Integer stock;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    private Date ultimoIngreso;
    
    @AssertTrue
    private boolean disponible;

    @NotEmpty // @Email
    @Column(length = 60, nullable = false)
    private String observacion;

    public Producto() {
    }

    public Producto(Long id, String descripcion, String categoria, Double precio, Integer stock, Date ultimoIngreso,
            boolean disponible, String observacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.ultimoIngreso = ultimoIngreso;
        this.disponible = disponible;
        this.observacion = observacion;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public Double getPrecio() {
        return precio;
    }


    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public Integer getStock() {
        return stock;
    }


    public void setStock(Integer stock) {
        this.stock = stock;
    }


    public Date getUltimoIngreso() {
        return ultimoIngreso;
    }


    public void setUltimoIngreso(Date ultimoIngreso) {
        this.ultimoIngreso = ultimoIngreso;
    }


    public boolean isDisponible() {
        return disponible;
    }


    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


    public String getObservacion() {
        return observacion;
    }


    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    @Override
    public String toString() {
        return "Producto [id=" + id + ", descripcion=" + descripcion + ", categoria=" + categoria + ", precio=" + precio
                + ", stock=" + stock + ", ultimoIngreso=" + ultimoIngreso + ", disponible=" + disponible
                + ", observacion=" + observacion + "]";
    }

}
