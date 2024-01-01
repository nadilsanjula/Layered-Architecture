package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dto.Summary;

import java.sql.SQLException;

public interface QueryDAO {
    Summary customerItemDetails() throws SQLException, ClassNotFoundException;
}
