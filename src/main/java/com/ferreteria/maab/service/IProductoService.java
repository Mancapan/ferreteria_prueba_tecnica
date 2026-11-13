package com.ferreteria.maab.service;
import com.ferreteria.maab.model.Producto;
import java.util.List;

public interface IProductoService {

        //READ
        List<Producto> traerProductos();
        Producto buscarProducto(Long codProducto);

        // CREATE
        Producto crearProducto(Producto producto);

        // UPDATE
        Producto editarProducto (long codProducto, Producto producto);

        // DELETE
        boolean eliminarProducto(Long codProducto);





}//interface
