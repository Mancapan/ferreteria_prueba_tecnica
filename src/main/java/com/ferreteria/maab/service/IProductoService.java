package com.ferreteria.maab.service;
import com.ferreteria.maab.model.Producto;
import java.util.List;

public interface IProductoService {


        //READ

        List<Producto> traerProductos();
        Producto buscarProducto(Long id);

        // CREATE

        Producto crearProducto(Producto producto);

        // UPDATE

        Producto Editar (Producto producto);


        void eliminarProducto(Long id);





}//interface
