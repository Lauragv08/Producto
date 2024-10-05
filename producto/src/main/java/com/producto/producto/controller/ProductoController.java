package com.producto.producto.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.producto.producto.model.Producto;
import com.producto.producto.service.TiendaServiceIface;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("producto")
public class ProductoController {

    private final TiendaServiceIface tiendaService;
    public ProductoController(TiendaServiceIface tiendaService){
        this.tiendaService = tiendaService;
    }

    @GetMapping("/formulario")
    public String formulario(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("titulo", "Registro de nuevo producto");
        return "vistas/formulario";
    }

    @GetMapping("/modificar/{id}")
    public String formulario(@PathVariable Long id, Model model){
       Producto producto = tiendaService.obtenerProductoPorId(id);
       model.addAttribute("producto", producto);
       model.addAttribute("titulo", "Regitro de un nuevo producto");
       return "vistas/formulario";
    }

    @PostMapping("/procesarform")
    public String procesarForm(@Valid @ModelAttribute Producto producto, BindingResult result, Model model, SessionStatus status){
    
        if(result.hasErrors()){
            model.addAttribute("titulo", "Registro de un nuevo producto");
            return "vistas/formulario";
        }

        System.out.println("Desde la vista: "+ producto);
        tiendaService.guardarProducto(producto);
        status.setComplete();
        return "redirect:/listado";
    }
     @GetMapping("/listado")
    public String listadoProductos(Model model) {
        List<Producto> productos = tiendaService.obtenerProductosTodos();
        model.addAttribute("titulo", "Listado de productos");
        model.addAttribute("productos", productos);
        return "vistas/listado";
    }

    @GetMapping("/consulta/{id}")
    public String consultaPV(@PathVariable Long id, Model model) {
        Producto producto = tiendaService.obtenerProductoPorId(id);
        System.out.println("*** Desde el repositorio: " + producto);
        model.addAttribute("producto", producto);
        model.addAttribute("titulo", "Consulta de una producto");
        return "vistas/consulta";
    }

    @GetMapping("/consulta")
    public String consultaRP(@RequestParam Long id, Model model) {
        Producto producto = tiendaService.obtenerProductoPorId(id);
        System.out.println("*** Desde el repositorio: " + producto);
        model.addAttribute("producto", producto);
        model.addAttribute("titulo", "Consulta del producto");
        return "vistas/consulta";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, Model model) {
        tiendaService.eliminarProductoPorId(id);
        return "redirect:/listado";
    }
    
    @ModelAttribute("categorias")
    public List<String> categorias() {
        return Arrays.asList("Informática", "Idiomas", "Algoritmos", "Programación", 
            "Matemáticas", "Estadística", "Administración", "Humanidades", "Cultura", "Deporte");
    }
}
