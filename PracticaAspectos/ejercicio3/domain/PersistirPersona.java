package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PersistirPersona {

	private static String jdbcUrl = "jdbc:mysql://localhost:3306/tp-Aspectos";
	private static String username = "root";
	private static String password = "";

	private static String consulta = "INSERT INTO personas (nombre) VALUES (?)";

	@Time
	public void agregarPersonas(List<String> personas) {
		try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
				PreparedStatement statement = conn.prepareStatement(consulta,
						PreparedStatement.RETURN_GENERATED_KEYS)) {

			for (String nombre : personas) {
				statement.setString(1, nombre);
				statement.executeUpdate();
			}

			System.out.println("Personas agregadas correctamente a la base de datos.");
		} catch (SQLException e) {
			System.err.println("Error al agregar personas a la base de datos: " + e.getMessage());
		}

	}

}
