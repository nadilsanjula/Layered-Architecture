package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
     String genarateNewId() throws SQLException, ClassNotFoundException ;

     ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException ;

     boolean saveItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException ;

     boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

     boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;

      boolean existItem(String code) throws SQLException, ClassNotFoundException ;

     ItemDTO findItemByCode(String newItemCode) throws SQLException, ClassNotFoundException;


}
