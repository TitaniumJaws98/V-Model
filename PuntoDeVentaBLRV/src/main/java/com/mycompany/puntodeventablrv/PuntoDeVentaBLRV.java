package com.mycompany.puntodeventablrv;
import com.mycompany.puntodeventablrv.database.ConexionSQLite;
import com.mycompany.puntodeventablrv.database.UsuarioDAO;
import java.sql.Connection;
import java.util.List;

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
        ConexionSQLite.conectar();
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        List<Usuario> usuarios;
        usuarios = usuarioDao.leerTodosLosUsuarios();
        imprimirUsuarios(usuarios);
        
        usuarioDao.crearUsuario(new Usuario(0, "Leonardo", "leo@mail.com", "12345", "admin"));
        usuarios = usuarioDao.leerTodosLosUsuarios();
        imprimirUsuarios(usuarios);
        
        Usuario leo = usuarioDao.leerUsuarioPorCorreo("leo@mail.com");
        
        if(leo != null){
            leo.setNombre("Leonardo Ramirez");
            
            usuarioDao.actualizarUsuario(leo);
            usuarios = usuarioDao.leerTodosLosUsuarios();
            imprimirUsuarios(usuarios);
            
            usuarioDao.eliminarUsuario(leo.getId());            
            usuarios = usuarioDao.leerTodosLosUsuarios();
            imprimirUsuarios(usuarios);
        }
        
        
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
