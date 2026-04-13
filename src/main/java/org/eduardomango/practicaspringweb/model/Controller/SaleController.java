package org.eduardomango.practicaspringweb.model.Controller;

import lombok.AllArgsConstructor;
import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.eduardomango.practicaspringweb.model.entities.SaleEntity;
import org.eduardomango.practicaspringweb.model.entities.SaleResponse;
import org.eduardomango.practicaspringweb.model.exceptions.ProductNotFoundException;
import org.eduardomango.practicaspringweb.model.services.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sales")
@AllArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<List<SaleEntity>> getAll(){
        return ResponseEntity.ok(saleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponse> findById (@PathVariable Long id){
        return ResponseEntity.ok(saleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SaleEntity> createProduct(@RequestBody SaleEntity newSale){
        if(saleService.findAll().contains(newSale)){
            return ResponseEntity.badRequest().build();
        }else {
            saleService.save(newSale);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleEntity> updateProduct(@PathVariable Long id, @RequestBody SaleEntity saleUp){
        if (saleService.findById(id)!= null){
            saleService.update(saleUp);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SaleResponse> deleteProduct(@PathVariable Long id){
        saleService.delete(saleService.findById(id));
        return ResponseEntity.ok().build();
    }




}
