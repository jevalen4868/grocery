package com.heb.j01.grocery.repository;

import com.heb.j01.grocery.domain.Grocery;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface GroceryRepository {

    public List<Grocery> getGroceries() throws SQLException, NamingException;

    public List<Grocery> searchGroceries(String search) throws SQLException, NamingException;

}
