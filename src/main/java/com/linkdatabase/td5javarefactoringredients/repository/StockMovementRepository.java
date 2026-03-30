package com.linkdatabase.td5javarefactoringredients.repository;

import com.linkdatabase.td5javarefactoringredients.config.DataSource;
import com.linkdatabase.td5javarefactoringredients.entity.StockValue;
import com.linkdatabase.td5javarefactoringredients.entity.Unit;
import com.linkdatabase.td5javarefactoringredients.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.Instant;
@Repository
public class StockMovementRepository {

    public StockValue getStockValueAt(Integer ingredientId, Instant t, String unitStr) {
         Unit unit;
        try {
            unit = Unit.valueOf(unitStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Unité invalide : " + unitStr);
        }

        String sql = """
    SELECT unit, SUM(CASE WHEN type = 'OUT' THEN -quantity ELSE quantity END) AS actual_quantity
    FROM stock_movement
    WHERE id_ingredient = ? 
      AND creation_datetime <= ? 
      AND unit = CAST(? AS unit_type)
    GROUP BY unit
""";
        try (Connection conn = DataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ingredientId);
            ps.setTimestamp(2, Timestamp.from(t));
            ps.setString(3, unit.name());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    StockValue sv = new StockValue();
                    sv.setQuantity(rs.getDouble("actual_quantity"));
                    sv.setUnit(Unit.valueOf(rs.getString("unit")));
                    return sv;
                } else {
                     StockValue sv = new StockValue();
                    sv.setQuantity(0.0);
                    sv.setUnit(unit);
                    return sv;
                }
            }
        } catch (SQLException e) {
            throw new BadRequestException("Invalid unit: " + unitStr);
        }
    }
}