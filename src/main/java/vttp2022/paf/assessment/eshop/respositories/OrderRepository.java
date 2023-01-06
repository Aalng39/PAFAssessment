package vttp2022.paf.assessment.eshop.respositories;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Customer;
import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.models.Order;

import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Repository
public class OrderRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String insertOrder(Customer customerDetails, List<LineItem> lineItems){

		Order order = new Order();
		order.setOrderId(order.getOrderId());

		order.setCustomer(customerDetails);
		order.getCustomer();

		order.setOrderDate(order.getOrderDate());
		
		Integer orderInserted = jdbcTemplate.update(SQL_INSERT_ORDER, 
            order.getOrderId(), order.getName(), order.getAddress(), order.getEmail(), order.getOrderDate());

		for (LineItem lineItem : lineItems){

			Integer lineItemInserted = jdbcTemplate.update(SQL_INSERT_LINEITEMS,
            order.getOrderId(), lineItem.getItem(), lineItem.getQuantity());

			if(lineItemInserted>0 && orderInserted>0)
			return order.getOrderId();
		}
		
		return null;
    };

}
