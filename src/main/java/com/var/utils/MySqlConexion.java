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
			url="jdbc:mysql://y5h4tvtv4htlxmcg:a93xtmh8cer4shmv@ebh2y8tqym512wqs.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/c8z28d45qosw6x7m?serverTimezone=UTC";
			user="y5h4tvtv4htlxmcg";
			pass="a93xtmh8cer4shmv";
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
