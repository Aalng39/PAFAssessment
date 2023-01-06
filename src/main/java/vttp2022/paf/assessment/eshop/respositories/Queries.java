package vttp2022.paf.assessment.eshop.respositories;

public class Queries {
    
    public static final String SQL_CHECK_FOR_USER = "select * from customers where name = ?";

    public static final String SQL_INSERT_ORDER = "insert into orders(orderId, name, address, email, orderDate) values(?, ?, ?, ?, ?)";
    public static final String SQL_INSERT_LINEITEMS = "insert into lineItems(orderId, item, quantity) values(?, ?, ?)";
}
