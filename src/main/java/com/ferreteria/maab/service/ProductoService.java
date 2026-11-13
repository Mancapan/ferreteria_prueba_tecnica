package com.ferreteria.maab.service;

import com.ferreteria.maab.model.Producto;
import com.ferreteria.maab.repository.IProductoRepository;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private final IProductoRepository productoRepository;

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
        return null;
    }

    @Override
    public boolean eliminarProducto(Long codProducto) {
        return false;
    }
}
