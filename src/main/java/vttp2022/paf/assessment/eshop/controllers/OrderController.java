package vttp2022.paf.assessment.eshop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp2022.paf.assessment.eshop.models.Customer;
import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.respositories.CustomerRepository;
import vttp2022.paf.assessment.eshop.respositories.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private OrderRepository orderRepo;

	@PostMapping(path="/")
	public ResponseEntity<String> checkoutOrder(@RequestBody String name, @RequestBody List<LineItem> lineItems){
		Optional<Customer> optCustomer = customerRepo.findCustomerByName(name);
        
        if (optCustomer.isPresent()){
            Customer customerDetails = optCustomer.get();
            String savedOrderId = orderRepo.insertOrder(customerDetails, lineItems);

			if(savedOrderId==null){

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
								.contentType(MediaType.APPLICATION_JSON)
								.build();
			}

		JsonObject orderSaved = Json.createObjectBuilder().add("result", savedOrderId + "saved").build();    
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(orderSaved.toString());
		}
        JsonObject jsonErrorObject = Json.createObjectBuilder().add("error", "Customer " + name + " not found").build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(jsonErrorObject.toString());
    
	}
}
