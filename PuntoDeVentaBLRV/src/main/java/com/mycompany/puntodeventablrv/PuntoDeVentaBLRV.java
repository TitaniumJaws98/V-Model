package com.mycompany.puntodeventablrv;
import com.mycompany.puntodeventablrv.database.ConexionSQLite;
import java.sql.Connection;

/**
 *
 * @autor Braiyan Leonardo Ramirez Vargas
 * @archivo PuntoDeVenta.java
 * @clase Verificación y validación de software
 * @ciclo 2025-1
 * 
 */
public class PuntoDeVentaBLRV {

    public static void main(String[] args) {
        Connection conexion = ConexionSQLite.conectar();
        ConexionSQLite.crearTablaUsuario();
        
        ConexionSQLite.cerrarConexion();
    }
}
