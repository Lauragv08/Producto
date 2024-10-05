package com.producto.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.producto.producto.model.Producto;

@Repository
public interface ProductoDAOIface extends JpaRepository<Producto, Long>{
    
}
