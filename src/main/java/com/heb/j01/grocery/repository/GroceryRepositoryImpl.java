package com.heb.j01.grocery.repository;

import com.heb.j01.grocery.domain.Grocery;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GroceryRepositoryImpl implements GroceryRepository {

    // Apache Result Handler needs to be able to map these to the objects.
    private static final String COLUMNS_TO_PROPERTIES = " id, display_id AS displayId, description, last_sold AS lastSold, shelf_life AS shelfLife, department, price, unit, x_for AS xFor, cost ";
    private static String SEARCH_WHERE_CLAUSE =
            " WHERE display_id like ? " +
                    " OR description like ? " +
                    " OR department like ? ";
    @Autowired
    DataSource groceryDataSource;

    private static ResultSetHandler<List<Grocery>> getHandler() {
        // Use the BeanListHandler implementation to convert all ResultSet rows
        // into a List of Grocery JavaBeans.
        return new BeanListHandler<>(Grocery.class);
    }

    /**
     * @return
     * @throws SQLException
     * @throws NamingException
     */
    public List<Grocery> getGroceries() throws SQLException, NamingException {
        List<Grocery> groceryList = RepoUtils.executeQuery(groceryDataSource, "select " + COLUMNS_TO_PROPERTIES + " from grocery", getHandler());
        return groceryList;
    }

    /**
     * @param search
     * @return
     * @throws SQLException
     * @throws NamingException
     */
    @Override
    public List<Grocery> searchGroceries(String search) throws SQLException, NamingException {
        List<Grocery> groceryList = RepoUtils.executeQuery(groceryDataSource, "select " + COLUMNS_TO_PROPERTIES + " from grocery " + SEARCH_WHERE_CLAUSE, getHandler(), search, search, search);
        return groceryList;
    }
}
