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
           return SaleEntity.builder()
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
    public SaleEntity findById(long id) {
        return saleRepository.findAll()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(ProductNotFoundException::new);
    }

    public void save (SaleEntity saleEntity){
        saleRepository.save(saleEntity);
    }

    public void delete (SaleEntity saleEntity){
        try {
            saleRepository.delete(saleEntity);
        } catch ( ProductNotFoundException e) {
            throw new ProductNotFoundException("Elemento n o encontrado");
        }
    }

    public void update (SaleEntity saleEntity){
        try {
            saleRepository.update(saleEntity);
        }catch (ProductNotFoundException e) {
            throw new ProductNotFoundException("Producto no encontrado");
        }
    }





}
