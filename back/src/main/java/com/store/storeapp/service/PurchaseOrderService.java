package com.store.storeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.storeapp.dto.ProductOrderDto;
import com.store.storeapp.dto.PurchaseOrderDto;
import com.store.storeapp.models.Customer;
import com.store.storeapp.models.Product;
import com.store.storeapp.models.ProductOrder;
import com.store.storeapp.models.PurchaseOrder;
import com.store.storeapp.models.StatusOrder;
import com.store.storeapp.repository.ProductOrderRepository;
import com.store.storeapp.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {
	
	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	private StatusOrderService statusOrderService;
	
	@Autowired
	private ProductService productService;
	
	public List<PurchaseOrder> getAllPurchaseOrderByCustomer (Customer customer){
		//purchaseOrderRepository.totalPrice(customer);
		return purchaseOrderRepository.getAllPurchaseOrderByCustomer(customer);
	}
	
	public PurchaseOrder getByCustomerAndStatus(Customer customer) {
		return purchaseOrderRepository.getPurchaseOrderByStatus(customer);
	}
	
	public Optional<PurchaseOrder> getOnePurchaseOrderByCustomer(Customer customer, PurchaseOrder purchaseOrder){
		List<PurchaseOrder> allPurchaseOrder = getAllPurchaseOrderByCustomer(customer);
		
		if(allPurchaseOrder.contains(purchaseOrder)) {
			int index = allPurchaseOrder.indexOf(purchaseOrder);
			return Optional.of(allPurchaseOrder.get(index));
		}
		return Optional.empty();
	}
	
	public PurchaseOrder setPurchaseOrder(PurchaseOrderDto order) {
		PurchaseOrder purchaseOrder =  new PurchaseOrder();
		Optional<Customer> optionalCustomer = customerService.getOneCustomer(order.getCustomerId());
		Customer customer = optionalCustomer.get();
		Optional<StatusOrder> optionalStatus = statusOrderService.getOneStatus(order.getStatusOrderId());
		StatusOrder status = optionalStatus.get();
		
		purchaseOrder.setCustomer(customer);
		purchaseOrder.setOrderStatus(status);
		purchaseOrder.setOrderDate(order.getDate());
		purchaseOrder.setTotal(order.getTotal());
		purchaseOrderRepository.save(purchaseOrder);
		
		for(ProductOrderDto items : order.getProductOrder()) {
			ProductOrder productOrder = new ProductOrder();
			productOrder.setPurhcaseOrder(purchaseOrder);
			Optional<Product> optionalProduct = productService.getOneProduct(items.getProductId());
			Product product = optionalProduct.get();
			productOrder.setProduct(product);
			productOrder.setQuantityProduct(items.getQuantityProduct());
			productOrderRepository.save(productOrder);

		}
		return purchaseOrder;
	}
	
	public Optional<PurchaseOrder> updatePurchase(PurchaseOrder updatePurchaseOrder, Long id){
		Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepository.findById(id);
		if(purchaseOrder.isPresent()) {
			return purchaseOrderRepository.findById(id)
					.map(record -> {
						record.setOrderStatus(updatePurchaseOrder.getOrderStatus());
						PurchaseOrder update = purchaseOrderRepository.save(record);
						return update;
					});
		}
		return null;
	}
}
