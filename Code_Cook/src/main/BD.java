package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class BD {
	

	
	    private static final String URL = "jdbc:sqlite:BD.db";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL);
	    }

	    public static void initDatabase() {
	        try (Connection conn = getConnection()) {
	            conn.createStatement().execute(
	                "CREATE TABLE IF NOT EXISTS mesas (" +
	                "id INTEGER PRIMARY KEY, " +
	                "capacidad INTEGER, " +
	                "estado TEXT CHECK(estado IN ('libre', 'ocupada', 'reservada'))"
	            );
	            // Crear tablas para Platos, Pedidos.
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

