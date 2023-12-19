package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.*;

public class PlaceOrderDAOImpl {



    public static String genarateNewId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = connection.createStatement().executeQuery("SELECT oid FROM 'Orders' ORDER BY id DESC LIMIT 1;");

        return rst.next()? String.format("OID-%03d",(Integer.parseInt(rst.getString("oid").replace("OID-",""))+1)):"OID-001";
    }
}
