package com.heb.j01.grocery.services;

import com.heb.j01.grocery.domain.Grocery;
import com.heb.j01.grocery.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Service
public class GroceryServicesImpl implements GroceryServices {

    @Autowired
    GroceryRepository groceryRepository;

    public List<Grocery> getGroceries() throws SQLException, NamingException {
        return groceryRepository.getGroceries();
    }

    @Override
    public List<Grocery> searchGroceries(String search) throws SQLException, NamingException {
        return groceryRepository.searchGroceries(search);
    }
}
