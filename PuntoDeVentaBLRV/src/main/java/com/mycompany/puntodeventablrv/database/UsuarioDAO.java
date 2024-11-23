
package com.mycompany.puntodeventablrv.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.puntodeventablrv.Usuario;

/**
 *
 * @autor Braiyan Leonardo Ramirez Vargas
 * @archivo PuntoDeVenta.java
 * @clase Verificación y validación de software
 * @ciclo 2025-1
 *
 */
public class UsuarioDAO {
    
    Connection conexion;
    
    public UsuarioDAO(Connection conexion){
        this.conexion = conexion;
    }
    
    public boolean crearUsuario(Usuario usuario){
        String sql = "INSERT INTO usuarios(nombre, correo, contra, rol) VALUES(?, ?, ?, ?)";
        
        Connection conexion = ConexionSQLite.conectar();
        
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)){
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getCorreo());
            pstmt.setString(3, usuario.getContra());
            pstmt.setString(4, usuario.getRol());
            
            pstmt.executeUpdate();
            
            System.out.println("Usuario registrado: " + usuario.getNombre());
            return true;
            
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("El correo ya existe");
            return false;
    } 
    }
    
    public List<Usuario> leerTodosLosUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        String sql = "SELECT * FROM usuarios";
        Connection conexion = ConexionSQLite.conectar();
        
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)){
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), 
                        rs.getString("correo"), rs.getString("contra"), rs.getString("rol"));
                
                usuarios.add(usuario);                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }
    
    public Usuario leerUsuarioPorCorreo(String correo){
        Usuario usuario = null;
        
        String sql = "SELECT * FROM usuarios WHERE correo = ?";
        
        Connection conexion = ConexionSQLite.conectar();
        
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)){
            
            pstmt.setString(1, correo);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), 
                        rs.getString("correo"), rs.getString("contra"), rs.getString("rol"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }
    
    public void actualizarUsuario(Usuario usuario){
        
        String sql = "UPDATE usuarios SET nombre = ?, correo = ?, contra = ?, rol = ? WHERE id = ?";
        
        Connection conexion = ConexionSQLite.conectar();
        
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)){
            
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getCorreo());
            pstmt.setString(3, usuario.getContra());
            pstmt.setString(4, usuario.getRol());
            pstmt.setInt(5, usuario.getId());
            
            pstmt.executeUpdate();
                    
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean eliminarUsuario(int id){
        
        String sql = "DELETE FROM usuarios WHERE id = ?";
        
        Connection conexion = ConexionSQLite.conectar();
        
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)){
            
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            // Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
