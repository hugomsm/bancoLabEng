package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public static boolean validar(String agencia, String conta, String senha) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = FabricaDeConexoes.getConnection();
			ps = con.prepareStatement("Select uname, password from Users where uname = ? and password = ?");
			ps.setString(1, agencia);
			ps.setString(2, conta);
			ps.setString(3, senha);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			FabricaDeConexoes.close(con);
		}
		return false;
	}
}