/**
 * 
 */
package mx.tec.web.lab.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.web.lab.manager.PruductManager;
import mx.tec.web.lab.vo.Product;

/**
 * @author mario
 *
 */
@RestController
public class ProductController {
	@Resource
	private PruductManager productManager;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productManager.getProducts();
		
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable(value = "id") String id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.OK);
		}
		
		return responseEntity;
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		System.out.println("newProduct.id " + newProduct.getId());
		
		Optional<Product> product = productManager.addProduct(newProduct);
		
		if (product.isPresent()) {
			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.CREATED);
		}
		
		return responseEntity;
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> modifyProduct(@PathVariable(value = "id") String id, @RequestBody Product product) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		List<Product> products = productManager.getProducts();
		
		Optional<Product> productToModify = productManager.getProduct(id);
		
		if (productToModify.isPresent()) {
			int index = products.indexOf(productToModify.get());
			Optional<Product> modifiedProduct = productManager.modifyProduct(index, product);
			
			if (modifiedProduct.isPresent()) {
				responseEntity = new ResponseEntity<>(modifiedProduct.get(), HttpStatus.OK);
			}
		}
		return responseEntity;
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") String id) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		List<Product> products = productManager.getProducts();
		
		Optional<Product> productToDelete = productManager.getProduct(id);
		
		if (productToDelete.isPresent()) {
			int index = products.indexOf(productToDelete.get());
			boolean deletedProduct = productManager.deleteProduct(index);
			
			if (deletedProduct) {
				responseEntity = new ResponseEntity<>("Product Deleted", HttpStatus.OK);
			}
		}
		return responseEntity;
	}	
}

