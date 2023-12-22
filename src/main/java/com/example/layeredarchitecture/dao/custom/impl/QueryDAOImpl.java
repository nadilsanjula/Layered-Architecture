package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.Summary;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public Summary customerItemDetails() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT o.oid,o.date,o.customerID,d.itemCode,i.description,d.qty,d.unitPrice\n" +
                "FROM Orders o\n" +
                "JOIN OrderDetails d ON o.oid = d.oid\n" +
                "JOIN Item i ON d.itemCode = i.code\n" +
                "ORDER BY o.oid ASC;");


        resultSet.next();
        return new Summary(
                resultSet.getString(1),
                resultSet.getDate(2).toLocalDate(),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getInt(6),
                resultSet.getBigDecimal(7));
        }
}