package com.ferreteria.maab.controller;

import com.ferreteria.maab.model.Producto;
import org.apache.el.lang.ELArithmetic;
import org.springframework.ui.Model;
import com.ferreteria.maab.service.IProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/productos")// no consume al ProductoRestContoller

public class ProductoWebController {

// inyección de dependencia; misma que ProductoRestContoller;

private final IProductoService productoService;

public ProductoWebController(IProductoService productoService) {
		this.productoService = productoService;
	}

// get para traer la lista de productos
@GetMapping

public String traerProductos(Model model) {model.addAttribute(
		"productos",
		productoService.traerProductos()
);
return "productos/listaProductos";
}


// Get para traer pagina del formulario;
@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
	model.addAttribute("producto",new Producto());
	model.addAttribute("titulo","Registrar Producto");

	return "productos/formulario";

}

// Post para guardar el formulario

@PostMapping("/crear")
public String crearProducto(@ModelAttribute Producto producto,Model model) {

Producto resultado;

if(producto.getCodProducto() == null){
resultado = productoService.crearProducto(producto);
} else  {
resultado = productoService.editarProducto(producto.getCodProducto(), producto);
}

if(resultado == null){
model.addAttribute("producto",producto);
model.addAttribute("titulo",
		producto.getCodProducto() == null ? "Registrar producto" : "Editar producto"

);

model.addAttribute(
		"error",
		"Revisar datos. Nombre, marca y categoría son obligatorios. Precio > 0"

);

return "productos/formulario";

}

return "redirect:/productos";

}

@GetMapping("/editar/{codProducto}")

	public String mostrarFromularioEditar(
			@PathVariable Long codProducto, Model model) {

	Producto producto = productoService.buscarProducto(codProducto);
	if(producto == null){
		return "redirect:/productos";
	}
	model.addAttribute("producto",producto);
	model.addAttribute("titulo","Editar Producto");
	return "productos/formulario";

}


@PostMapping("/eliminar/{codProducto}")

public String eliminarProducto(@PathVariable Long codProducto) {

productoService.eliminarProducto(codProducto);
	return "redirect:/productos";
}













}
