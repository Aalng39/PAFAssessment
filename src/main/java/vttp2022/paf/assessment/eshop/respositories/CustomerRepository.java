package vttp2022.paf.assessment.eshop.respositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Customer;

import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Repository
public class CustomerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// You cannot change the method's signature
	public Optional<Customer> findCustomerByName(String name) {
		SqlRowSet rs = jdbcTemplate.queryForRowSet(
            SQL_CHECK_FOR_USER, name);
		
		if (rs.first()){
			Customer customer = new Customer();
			return Optional.of(customer.create(rs));
		}
		return Optional.empty();			 
    }
		// TODO: Task 3 
}
