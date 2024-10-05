package com.producto.producto.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.producto.producto.model.Producto;
import com.producto.producto.repository.ProductoDAOIface;

@Service
public class TiendaServiceSql implements TiendaServiceIface {
    private final ProductoDAOIface productoDAO;

    public TiendaServiceSql(ProductoDAOIface productoDAO) {
        this.productoDAO = productoDAO;
    }

        @Override
        @Transactional(readOnly = true)
        public List<Producto> obtenerProductosTodos() {
            return productoDAO.findAll();
        }

        @Override
        @Transactional
        public void guardarProducto(Producto producto) {
            productoDAO.save(producto);
        }

        @Override
        @Transactional(readOnly = true)
        public Producto obtenerProductoPorId(Long id) {
          return productoDAO.findById(id).orElse(null);
        }

        @Override
        public void eliminarProductoPorId(Long id) {
          productoDAO.deleteById(id);
        }

}