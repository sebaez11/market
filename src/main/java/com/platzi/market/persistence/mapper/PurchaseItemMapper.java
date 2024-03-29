package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entities.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    //Los campos que se llamen igual, no hay necesidad de mapearlos

    @Mappings({
            @Mapping(source = "id.idProducto" , target = "productId"),
            @Mapping(source = "cantidad" , target = "quantity"),
            @Mapping(source = "estado" , target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra" , ignore = true),
            @Mapping(target = "producto" , ignore = true),
            @Mapping(target = "id.idCompra" , ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}
