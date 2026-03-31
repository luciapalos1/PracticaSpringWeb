package org.eduardomango.practicaspringweb.model.services;


import lombok.AllArgsConstructor;
import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.eduardomango.practicaspringweb.model.entities.SaleEntity;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.eduardomango.practicaspringweb.model.exceptions.ProductNotFoundException;
import org.eduardomango.practicaspringweb.model.repositories.IRepository;
import org.eduardomango.practicaspringweb.model.repositories.SaleRepository;
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

    public SaleEntity save(Long idProducto,Long idCliente, Long cantidad){
        try {
            ProductEntity product=productService.findById(idProducto);
            UserEntity user= userService.findById(idCliente);
            SaleEntity.builder()
                    .id(idProducto)
                    .products(product)
                    .quantity(cantidad)
                    .client(user)
                    .saleDate(LocalDate.now())
                    .build();
        } catch (ProductNotFoundException e) {
            throw new ProductNotFoundException("");
        }





    }





}
