
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
        
//        usuarioDao.crearUsuario(new Usuario(0, "Jose", "jose@mail.com", "12345", "admin"));
//        usuarioDao.crearUsuario(new Usuario(0, "Alicia", "alicia@mail.com", "12345", "vendedor"));
//        usuarioDao.crearUsuario(new Usuario(0, "Juan", "juan@mail.com", "12345", "inventarios"));
//        
//        
//        usuarios = usuarioDao.leerTodosLosUsuarios();
//        imprimirUsuarios(usuarios);
//        
//        Usuario pedro = usuarioDao.leerUsuarioPorCorreo("pedro@mail.com");
//        
//        if(pedro != null){
//            pedro.setNombre("Pedro Valenzuela");
//            
//            usuarioDao.actualizarUsuario(pedro);
//            usuarios = usuarioDao.leerTodosLosUsuarios();
//            imprimirUsuarios(usuarios);
//            
//            usuarioDao.eliminarUsuario(pedro.getId());            
//            usuarios = usuarioDao.leerTodosLosUsuarios();
//            imprimirUsuarios(usuarios);
//        }
        
        
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
