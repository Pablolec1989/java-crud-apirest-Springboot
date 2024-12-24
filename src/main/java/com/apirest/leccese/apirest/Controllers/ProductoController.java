package com.apirest.leccese.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.leccese.apirest.Entities.Producto;
import com.apirest.leccese.apirest.Repository.ProductoRepository;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;


    @GetMapping
    public List<Producto> getAllProductos(){

        return productoRepository.findAll();

    }

    @GetMapping("/{id}")
    public Producto getProductobyId(@PathVariable Long id){

        return productoRepository.findById(id)
        .orElseThrow(()->new RuntimeException("No se encontro el producto con el id: "+id));

    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){

            return productoRepository.save(producto);

    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto detalleProducto){

        Producto producto = productoRepository.findById(id)
        .orElseThrow(()->new RuntimeException("No se encontro el producto con el id: "+id));

        producto.setNombre(detalleProducto.getNombre());
        producto.setPrecio(detalleProducto.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deleleteProducto(@PathVariable Long id){
        Producto producto = productoRepository.findById(id)
        .orElseThrow(()->new RuntimeException("No se encontro el producto con el id: "+id));

        productoRepository.delete(producto);

        return "El producto "+producto.getNombre()+" ha sido eliminado";



}
