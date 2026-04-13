package org.eduardomango.practicaspringweb.model.Mapper;

import org.eduardomango.practicaspringweb.model.entities.ProductDTO;
import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.modelmapper.ModelMapper;

public class ProductMapper implements Mapper<ProductEntity, ProductDTO>{

    private ModelMapper modelMapper;

    @Override
    public ProductEntity toDTO(ProductDTO productDTO) {
        return modelMapper.map(productDTO, ProductEntity.class);
    }

    @Override
    public ProductDTO toEntity(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductDTO.class);
    }
}
