package org.eduardomango.practicaspringweb.model.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.eduardomango.practicaspringweb.model.exceptions.ProductNotFoundException;
import org.eduardomango.practicaspringweb.model.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> listProduct(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> findById (@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity newProduct){
       if(productService.findAll().contains(newProduct)){
          return ResponseEntity.badRequest().build();
       }else {
           productService.save(newProduct);
           return ResponseEntity.status(HttpStatus.CREATED).build();
       }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody ProductEntity productUp){
       if (productService.findById(id)!= null){
           productService.update(productUp);
           return ResponseEntity.ok().build();
       }else {
           return ResponseEntity.notFound().build();
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductEntity> deleteProduct(@PathVariable Long id){
        try{
            productService.delete(productService.findById(id));
            return ResponseEntity.ok().build();
        }catch (ProductNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }


}
