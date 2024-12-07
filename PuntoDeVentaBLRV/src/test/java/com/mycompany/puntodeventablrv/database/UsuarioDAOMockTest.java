package com.mycompany.puntodeventablrv.database;
import static org.junit.Assert.*;
import com.mycompany.puntodeventablrv.Usuario;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @autor Braiyan Leonardo Ramirez Vargas
 * @clase Verificación y validación de software
 * @ciclo 2025-1
 *
 */

public class UsuarioDAOMockTest {
    
    private UsuarioDAO usuarioDAOMock;
    
    private Usuario crearUsuario(){
        return new Usuario(9, "Leonardo Ramirez", "blramirez@ucgdl.edu.mx","12345", "estudiante");
    }
    
    
    @Test
    public void _001_1_testCrearUsuario() {
        // Crear usuario simulado
        usuarioDAOMock = Mockito.mock(UsuarioDAO.class);
        
        Usuario usuario = crearUsuario();
                
        // Simular respuesta de metodo crearUsuario
        Mockito.when(usuarioDAOMock.crearUsuario(usuario))
                .thenReturn(Boolean.TRUE);
        
        usuarioDAOMock.crearUsuario(usuario);
        
        // Simular respuesta de lectura
        Mockito.when(usuarioDAOMock.leerUsuarioPorCorreo("blramirez@ucgdl.edu.mx"))
                .thenReturn(usuario);
        
        Usuario lectura = usuarioDAOMock.leerUsuarioPorCorreo("blramirez@ucgdl.edu.mx");
        
        Mockito.verify(usuarioDAOMock).crearUsuario(usuario);
        
        assertEquals(lectura.getNombre(), usuario.getNombre());
        assertEquals(lectura.getCorreo(), usuario.getCorreo());
        assertEquals(lectura.getContra(), usuario.getContra());
        assertEquals(lectura.getRol(), usuario.getRol());
    }
        
    @Test
    public void _001_2_UsuarioExistente(){
        
        usuarioDAOMock = Mockito.mock(UsuarioDAO.class);
        
        Usuario usuario = crearUsuario();
        
        Mockito.when(usuarioDAOMock.crearUsuario(usuario))
                .thenReturn(Boolean.FALSE);
        
        boolean crear = usuarioDAOMock.crearUsuario(usuario);
        
        Mockito.verify(usuarioDAOMock).crearUsuario(usuario);
        
        assertFalse(crear);
    }
    
    @Test
    public void _002_1_testLeerUsuarioPorCorreo() {
        // Crear usuario simulado
        usuarioDAOMock = Mockito.mock(UsuarioDAO.class);
        
        Usuario usuario = crearUsuario();
        
        // Simular respuesta de lectura
        Mockito.when(usuarioDAOMock.leerUsuarioPorCorreo("blramirez@ucgdl.edu.mx"))
                .thenReturn(usuario);
        
        Usuario lectura = usuarioDAOMock.leerUsuarioPorCorreo("blramirez@ucgdl.edu.mx");
        
        Mockito.verify(usuarioDAOMock).leerUsuarioPorCorreo("blramirez@ucgdl.edu.mx");
        
        assertEquals(lectura.getNombre(), usuario.getNombre());
        assertEquals(lectura.getCorreo(), usuario.getCorreo());
        assertEquals(lectura.getContra(), usuario.getContra());
        assertEquals(lectura.getRol(), usuario.getRol());
    }
}
