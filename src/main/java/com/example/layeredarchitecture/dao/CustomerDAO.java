package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;

     boolean saveCustomer(String id,String name,String address) throws SQLException, ClassNotFoundException;

     boolean updateCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException ;


    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

     String genarateNewId() throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;
}
