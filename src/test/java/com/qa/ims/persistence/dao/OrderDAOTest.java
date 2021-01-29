package com.qa.ims.persistence.dao;

//import static org.junit.Assert.assertEquals;

//import java.util.ArrayList;
//import java.util.List;

import org.junit.Before;
//import org.junit.Test;

//import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DatabaseUtilities;

public class OrderDAOTest {
	
//	private final OrderDao DAO = new OrderDao();

    @Before
    public void setup() {
        DatabaseUtilities.connect();
        DatabaseUtilities.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
    }

//    @Test
//    public void testCreate() {
//        final Order created = new Order(2L, );
//        assertEquals(created, DAO.create(created));
//    }
//
//    @Test
//    public void testReadAll() {
//        List<Order> expected = new ArrayList<>();
//        expected.add(new Order(1L, ));
//        assertEquals(expected, DAO.readAll());
//    }
//
//    @Test
//    public void testReadLatest() {
//        assertEquals(new Order(), DAO.readLatest());
//    }
//
//    @Test
//    public void testRead() {
//        final long ID = 1L;
//        assertEquals(new Order(ID, ), DAO.read(ID));
//    }
//
//    @Test
//    public void testUpdate() {
//        final Order updated = new Order(1L, );
//        assertEquals(updated, DAO.update(updated));
//
//    }
//
//    @Test
//    public void testDelete() {
//        assertEquals(1, DAO.delete(1));
//    }
//        
}
