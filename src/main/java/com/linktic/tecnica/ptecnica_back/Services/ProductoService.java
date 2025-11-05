package com.linktic.tecnica.ptecnica_back.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.tecnica.ptecnica_back.Entities.ProductoEntity;
import com.linktic.tecnica.ptecnica_back.Repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoEntity> findAll() {
        return productoRepository.findAll();
    }

    public Optional<ProductoEntity> findById(Long id) {
        return productoRepository.findById(id);
    }

    public ProductoEntity save(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return productoRepository.existsById(id);
    }

    public Optional<ProductoEntity> partialUpdate(Long id, ProductoEntity partialProducto) {
        return productoRepository.findById(id).map(existingProducto -> {
            if (partialProducto.getName() != null) {
                existingProducto.setName(partialProducto.getName());
            }
            if (partialProducto.getPrecio() != null) {
                existingProducto.setPrecio(partialProducto.getPrecio());
            }
            if (partialProducto.getSku() != null) {
                existingProducto.setSku(partialProducto.getSku());
            }
            return productoRepository.save(existingProducto);
        });
    }
}