package com.var.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConexion {
	
	public static Connection getConectar() {
		Connection cn=null;
		try {
			String url,user,pass;
			//carga de la clase que se encuentra en el jar "mysql-connector-java-8.0.21.jar"
			Class.forName("com.mysql.cj.jdbc.Driver");
			url="jdbc:mysql://bwinfxi4ncz6ryqu6s48-mysql.services.clever-cloud.com:3306/bwinfxi4ncz6ryqu6s48?serverTimezone=UTC";
			user="uynzxzr4kbopdg8i";
			pass="84US44dQZiMVOosIhir9";
			//establacer la conexión a la BD. 
			cn=DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
}
