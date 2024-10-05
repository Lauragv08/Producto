package com.producto.producto.service;

import java.util.List;

import com.producto.producto.model.Producto;

public interface TiendaServiceIface {
    
    public List<Producto> obtenerProductosTodos();
    public void guardarProducto(Producto producto);
    public Producto obtenerProductoPorId(Long id);
    public void eliminarProductoPorId(Long id);
}
