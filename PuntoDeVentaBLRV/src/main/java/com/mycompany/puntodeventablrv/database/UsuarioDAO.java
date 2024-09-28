package com.mycompany.puntodeventablrv.database;

import com.mycompany.puntodeventablrv.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @autor Braiyan Leonardo Ramirez Vargas
 * @archivo UsuarioDAO.java
 * @clase Verificación y validación de software
 * @ciclo 2025-1
 *
 */
public class UsuarioDAO {
    public void crearUsuario(Usuario usuario){
        String sql = "INSERT INTO usuarios ("
                + "id = ?,"
                + "nombre = ?,"
                + "correo = ?,"
                + "contra = ?,"
                + "rol = ?,"
                + ")";
        
        Connection conexion = ConexionSQLite.conectar();
         
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)){
            
            pstmt.setInt(1, usuario.getId());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getCorreo());
            pstmt.setString(4, usuario.getContra());
            pstmt.setString(5, usuario.getRol());
            
            pstmt.executeUpdate(sql);
            
            System.out.println("Usuario registrado: " + usuario.getNombre());
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Usuario> leerTodosLosUsuarios(){
    
    }
    
    public Usuario leerUsuarioPorCorreo(String correo){
        return new Usuario(0, null, null, null, null);
    }
    
    public void actualizarUsuario(Usuario usuario){
        
    }
    
    public void eliminarUsuario(Usuario usuario){
        
    }
    
}
