package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.IProductoCrudRepository;
import com.platzi.market.persistence.entities.Producto;

import java.util.List;
import java.util.Optional;

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
}
