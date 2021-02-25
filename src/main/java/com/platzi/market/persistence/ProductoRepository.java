package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.IProductoCrudRepository;
import com.platzi.market.persistence.entities.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private IProductoCrudRepository iProductoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) iProductoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return iProductoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return iProductoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad , true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return iProductoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return iProductoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        iProductoCrudRepository.deleteById(idProducto);
    }

}
