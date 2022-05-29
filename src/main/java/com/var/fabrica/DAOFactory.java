package com.var.fabrica;

import com.var.interfaces.BienesDAO;
import com.var.interfaces.CondicionDAO;
import com.var.interfaces.ProveedorDAO;
import com.var.interfaces.TrabajadorDAO;
import com.var.interfaces.UsuarioDAO;

public abstract class DAOFactory {
	// los posibles orígenes de datos
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    // Existirá un método get por cada DAO que exista en el sistema
    // Ejemplo:
    //public abstract ArticuloDAO getArticuloDAO();
    // registramos nuestros daos
    public abstract BienesDAO getBienesDAO();
    public abstract ProveedorDAO getProveedorDAO();
    public abstract TrabajadorDAO getTrabajadorDAO();
    public abstract CondicionDAO getCondicionDAO();
    public abstract UsuarioDAO getUsuarioDAO();
     
    public static DAOFactory getDAOFactory(int whichFactory){
        switch(whichFactory){
       	case MYSQL:
        	   return new MySqlDAOFactory();
        	case XML:
        	    //return new XmlDAOFactory();
        	case ORACLE:
        	    //return new OracleDAOFactory();
        	/*case DB2:
        	    return new Db2DAOFactory();*/
        	case SQLSERVER:
        	    return new SqlServerDAOFactory();
        	/*case XML:
        	    return new XmlDAOFactory();*/
        	default:
        	    return null;
        }
     }
}
