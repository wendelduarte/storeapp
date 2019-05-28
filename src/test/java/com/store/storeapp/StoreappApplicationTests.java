package com.store.storeapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.storeapp.models.Product;
import com.store.storeapp.models.ProductOrder;
import com.store.storeapp.models.PurchaseOrder;
import com.store.storeapp.repository.ProductOrderRepository;
import com.store.storeapp.repository.ProductRepository;
import com.store.storeapp.service.ProductOrderService;
import com.store.storeapp.service.ProductService;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StoreappApplicationTests {

	@InjectMocks
	private ProductService productService;
	
	@InjectMocks
	private ProductOrderService productOrderService;
	
	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private ProductOrderRepository productOrderRepository;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this); 

	}

	@Test
	public void testGetAllProducts() {
		
		Product product = new Product(1, null, null, "Doril", "Generico", 5f, "Batata");
		Product productA = new Product(2, null, null, "Novalgina", "Generico", 12f, "Macarrao");
		
		Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(product, productA));
		
		//List<Product> products = null;
		
		List<Product> products = productService.getAllProducts();
		
		assertNotNull(products);
		assertEquals(true, products.size() > 0);
		assertEquals(true, products.size() == 2);
		
	}

	@Test
	public void testGetOneProduct() {
		Optional<Product> product = Optional.of(new Product(2, null, null, "Doril", "Generico", 10f, "Batata"));
		Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(product);
		
		Optional<Product> products = productService.getOneProduct(Mockito.anyLong());
		assertEquals(product, products);
		Product productLocated = products.get();
		assertEquals(2, productLocated.getProductId());
	}
	
	@Test
	public void testPostProduct() {
		Product product = new Product();
		Mockito.when(productRepository.save(product)).thenReturn(new Product(2, null, null, "Doril", "Generico", 10f, "Batata"));
		Product newProduct = productService.setProduct(product);
		Mockito.verify(productRepository, Mockito.times(1)).save(product);
		assertNotNull(product);
		assertEquals("Batata", newProduct.getDescription());
	}
	/*
	@Test
	public void testUpdateProduct() {
		Optional<Product> product = Optional.of(new Product(2, null, null, "Doril", "Generico", 10f, "Batata"));
		Product updateProduct = product.get();
		Mockito.when(productService.getOneProduct(Mockito.anyLong())).thenReturn(product);
		Mockito.when(productRepository.save(updateProduct)).thenReturn(updateProduct);
		Mockito.verify(productRepository, Mockito.times(1)).save(updateProduct);
	}
	*/

	@Test
	public void testDeleteProduct() {
		Optional<Product> product = Optional.of(new Product(1, null, null, "Doril", "Generico", 10f, "Batata"));
		Mockito.when(productService.getOneProduct(Mockito.anyLong())).thenReturn(product);

		Product delProduct = product.get(); 
		productService.deleteProduct(delProduct.getProductId());
		Mockito.verify(productRepository, Mockito.times(1)).deleteById(delProduct.getProductId());
	}
/*
	@Test
	public void testSetProductOrder() {
		Product product = new Product(1, null, null, "Doril", "Generico", 10f, "Batata");
		PurchaseOrder purchaseOrder = new PurchaseOrder(1, 0f);
		ProductOrder productOrder = new ProductOrder();
		Mockito.when(productOrderRepository.save(productOrder)).thenReturn(productOrder = new  ProductOrder(1, purchaseOrder, product, 2));
		
		PurchaseOrder getPurchaseOrder = productOrder.getPurchaseOrder();
		
		productOrderRepository.totalPrice(getPurchaseOrder.getPurchaseOrderId());
		
		assertEquals(20, getPurchaseOrder.getTotal(), 10);	
	}
*/
}
 
