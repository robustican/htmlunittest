package com.jeremyr.sw.webapp.controllers;


import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

    private BasicDataSource _dataSource;

    public void setDataSource(BasicDataSource bd)
    {
        _dataSource = bd;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String hello(ModelMap model) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try 
        {
            con = _dataSource.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("show databases");

            String str = "";
            while (rs.next()) {
                str += rs.getString(1) + "<br/>";
            }
            model.addAttribute("message", str);
        } 
        catch (SQLException ex) 
        {
            model.addAttribute("message", ex.toString());
        } 
        finally 
        {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                model.addAttribute("message", ex.toString());
            }
        }

        // this is somehow the name of the jsp file without the jsp
        return "base";
    }
}

