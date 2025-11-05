package com.linktic.tecnica.ptecnica_back.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linktic.tecnica.ptecnica_back.Entities.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
    // Por ejemplo: Optional<ProductoEntity> findBySku(String sku);
}