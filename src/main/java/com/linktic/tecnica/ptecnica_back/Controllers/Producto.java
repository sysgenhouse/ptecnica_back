package com.linktic.tecnica.ptecnica_back.Controllers;

import com.linktic.tecnica.ptecnica_back.Entities.ProductoEntity;
import com.linktic.tecnica.ptecnica_back.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class Producto {

    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public ResponseEntity<List<ProductoEntity>> findAll() {
        try {
            List<ProductoEntity> productos = productoService.findAll();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Esto mostrará el error en la consola
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoEntity> find(@PathVariable Long id) {
        try {
            Optional<ProductoEntity> producto = productoService.findById(id);
            return producto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<ProductoEntity> create(@RequestBody ProductoEntity entity) {
        try {
            ProductoEntity nuevoProducto = productoService.save(entity);
            return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<ProductoEntity> update(@RequestBody ProductoEntity entity) {
        try {
            if (productoService.existsById(entity.getId())) {
                ProductoEntity productoActualizado = productoService.save(entity);
                return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductoEntity> partialUpdate(@PathVariable Long id, @RequestBody ProductoEntity partialProducto) {
        try {
            Optional<ProductoEntity> updatedProducto = productoService.partialUpdate(id, partialProducto);
            return updatedProducto.map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            if (productoService.existsById(id)) {
                productoService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
