package org.eduardomango.practicaspringweb.model.services;


import lombok.AllArgsConstructor;
import org.eduardomango.practicaspringweb.model.Mapper.UserMapper;
import org.eduardomango.practicaspringweb.model.entities.*;
import org.eduardomango.practicaspringweb.model.exceptions.SaleNotFounException;
import org.eduardomango.practicaspringweb.model.repositories.IRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class SaleService {
    private final IRepository<SaleEntity> saleRepository;
    private final ProductService productService;
    private final UserService userService;

    //METODOS
    public List<SaleEntity> findAll(){return saleRepository.findAll();}

    public SaleResponse save(SaleDTO saleDTO){
        ProductEntity product=productService.findById(saleDTO.getIdProducto());
        UserMapper userMapper=new UserMapper();
        UserEntity user= userMapper.toEntity(userService.findById(saleDTO.getIdCliente()));
       SaleEntity entity = SaleEntity.builder()
                .products(product)
                .quantity(saleDTO.getCantidad())
                .client(user)
                .saleDate(LocalDate.now())
                .build();

       SaleEntity saved = saleRepository.save(entity);

       return SaleResponse.builder()
               .client(saved.getClient())
               .id(saved.getId())
               .products(saved.getProducts())
               .quantity(saved.getQuantity())
               .build();
    }


    public SaleResponse findById(long id) {
       SaleEntity sale = saleRepository.findAll()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(SaleNotFounException::new);

       return SaleResponse.builder()
               .client(sale.getClient())
               .id(sale.getId())
               .products(sale.getProducts())
               .quantity(sale.getQuantity())
               .build();
    }

    public void save (SaleEntity saleEntity){
        saleRepository.save(saleEntity);
    }

    public void delete (SaleResponse saleResponse){

        SaleEntity sale= SaleEntity.builder()
                .client(saleResponse.getClient())
                .quantity(saleResponse.getQuantity())
                .id(saleResponse.getId())
                .products(saleResponse.getProducts())
                .build();

        saleRepository.delete(sale);
    }

    public void update (SaleEntity saleEntity){
        saleRepository.update(saleEntity);
    }

}
