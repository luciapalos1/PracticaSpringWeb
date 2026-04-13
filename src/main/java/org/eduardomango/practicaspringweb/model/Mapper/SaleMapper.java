package org.eduardomango.practicaspringweb.model.Mapper;

import org.eduardomango.practicaspringweb.model.entities.SaleDTO;
import org.eduardomango.practicaspringweb.model.entities.SaleEntity;
import org.modelmapper.ModelMapper;

public class SaleMapper implements Mapper<SaleEntity, SaleDTO> {
    private ModelMapper modelMapper;

    @Override
    public SaleEntity toDTO(SaleDTO saleDTO) {
        return modelMapper.map(saleDTO, SaleEntity.class);
    }

    @Override
    public SaleDTO toEntity(SaleEntity saleEntity) {
        return modelMapper.map(saleEntity,SaleDTO.class);
    }
}
