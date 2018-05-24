package com.heb.j01.grocery.web;

import com.heb.j01.grocery.domain.Grocery;
import com.heb.j01.grocery.services.GroceryServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class IndexController {
    private static final Logger LOGGER = LogManager.getLogger(IndexController.class);

    @Autowired
    GroceryServices groceryServices;

    @RequestMapping(value = {"/", "/search/{search}"}, method = RequestMethod.GET)
    public String index(@PathVariable(required = false) String search, Model model) {
        LOGGER.info("index hit!");

        try {
            List<Grocery> groceryList = null;
            if (StringUtils.isEmpty(search)) {
                groceryList = groceryServices.getGroceries();
            } else {
                // do search.
                model.addAttribute("search", search);
                groceryList = groceryServices.searchGroceries(search);
            }
            model.addAttribute("groceryList", groceryList);

        } catch (SQLException e) {
            LOGGER.error("Ouch!", e);
        } catch (NamingException e) {
            LOGGER.error("Ouch!", e);
        }
        return "index";
    }
}
