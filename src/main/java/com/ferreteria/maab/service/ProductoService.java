package com.ferreteria.maab.service;

import com.ferreteria.maab.model.Producto;
import com.ferreteria.maab.repository.IProductoRepository;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.List;

@Service
// marcar como service

public class ProductoService implements IProductoService {

    private final IProductoRepository productoRepository;// instancia de interface iproducrepository

    // inyección de dependencia: el productservice se comunica con el repository
    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> traerProductos() {
        return productoRepository.findAll();// metodo de jpa para buscar elementos
    }

    @Override
    public Producto buscarProducto(Long codProducto) {
        return productoRepository.findById(codProducto).orElse(null);
    }

    @Override
    public Producto crearProducto(Producto producto) {
        if(producto == null){
            return null;
        }
       //retorno producto completo guardado con id ytodo;
        //id se genera automaticamente en bd
      return productoRepository.save(producto);

    }

    @Override
    public Producto editarProducto(long codProducto, Producto producto) {
    // buscar producto
     Producto productoExist = buscarProducto(codProducto);
     // validacion
        if(productoExist== null){
           return null;
        }
        productoExist.setCategoria(producto.getCategoria());
        productoExist.setDescripcion(producto.getDescripcion());
        productoExist.setMarca(producto.getMarca());
        productoExist.setStock(producto.getStock());
        productoExist.setNombre(producto.getNombre());
        productoExist.setPrecio(producto.getPrecio());

        return productoRepository.save(productoExist);
    }

    @Override
    public boolean eliminarProducto(Long codProducto) {
    // buscar
     Producto productoExist = buscarProducto(codProducto);
     if(productoExist == null){
         return false;
     }
    productoRepository.delete(productoExist);
     return true;
    }



}
