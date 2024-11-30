package revisionprueba.repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author luk0s
 */
public class MySQL {

    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/test";
    private final String user = "root";
    private final String password = "UST";

    public void connect() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a MySQL.");
        } catch (ClassNotFoundException e) {
            System.out.println("error. " + e.getMessage());
            throw new Exception("No se encontró el driver de MySQL.", e);
        }
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public int executePreparedUpdate(String query, Object... parameters) throws SQLException {
        if (connection == null) {
            throw new SQLException("No hay conexión establecida.");
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (int i = 0; i < parameters.length; i++) {
                preparedStatement.setObject(i + 1, parameters[i]);
            }
            return preparedStatement.executeUpdate();
        }
    }

    public ResultSet executePreparedQuery(String query, Object... parameters) throws SQLException {
        if (connection == null) {
            throw new SQLException("No hay conexión establecida.");
        }
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        for (int i = 0; i < parameters.length; i++) {
            preparedStatement.setObject(i + 1, parameters[i]);
        }
        return preparedStatement.executeQuery();
    }
}
