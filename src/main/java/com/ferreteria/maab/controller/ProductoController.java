package com.ferreteria.maab.controller;

import com.ferreteria.maab.model.Producto;
import com.ferreteria.maab.repository.IProductoRepository;
import com.ferreteria.maab.service.IProductoService;
import com.ferreteria.maab.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/productos")

public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    // endpoints metodos http

    // read
    @GetMapping
    public List<Producto> traerProductos() {
        return productoService.traerProductos();
    }

    @GetMapping("/{codProducto}")
    public ResponseEntity<?> mostrarProducto(@PathVariable Long codProducto) {
        Producto prod = productoService.buscarProducto(codProducto);
        if(prod == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe el producto con el id: " + codProducto);
        }
        return ResponseEntity.ok(prod);
    }

    //crear
    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
     Producto productoCreado = productoService.crearProducto(producto);
        if(productoCreado == null){
            return ResponseEntity.badRequest()
                    .body("Los datos del producto no son válidos");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productoCreado);
    }

    //update
    @PutMapping("/{codProducto}")
    public ResponseEntity<?> editarProducto(@PathVariable Long codProducto, @RequestBody Producto prodAmodificar) {
        Producto productoEditado = productoService.editarProducto(codProducto, prodAmodificar);
        if(productoEditado == null){
            return ResponseEntity.badRequest()
                    .body("No fue posible editar el producto");
        }
            return ResponseEntity.ok(productoEditado);
    }

    //delete = no es buena practica, de debe hacer borrado logico!!! solo efectos del crud ejercicio;
    @DeleteMapping("/{codProducto}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long codProducto) {
    boolean eliminado = productoService.eliminarProducto(codProducto);
        if(eliminado == false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontro el producto con el id: " + codProducto);
        }
            return ResponseEntity.ok("Producto eliminado correctamente");
    }

}
