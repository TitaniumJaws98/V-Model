
package com.mycompany.puntodeventablrv;

import java.sql.Connection;
import java.util.List;
import com.mycompany.puntodeventablrv.database.ConexionSQLite;
import com.mycompany.puntodeventablrv.database.UsuarioDAO;

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
        
        MainMenu mm = new MainMenu();
        mm.MainMenuLoop();
        
        System.out.println("Saliendo ...");
        System.exit(0);
        
        
        Connection conexion =  ConexionSQLite.conectar();
        
        UsuarioDAO usuarioDao = new UsuarioDAO(conexion);
        
        List<Usuario> usuarios;
        usuarios = usuarioDao.leerTodosLosUsuarios();
        imprimirUsuarios(usuarios);
        
        
        
        ConexionSQLite.cerrarConexion();
    }
    
    public static void imprimirUsuarios(List<Usuario> usuarios){
        
        if(!usuarios.isEmpty()){
            System.out.println("=============== USUARIOS ===============");
        
            for(Usuario usuario : usuarios){
                System.out.println(usuario);
            }
        }else{
            System.err.println("No hay usuarios registrados");
        }
    }
}
