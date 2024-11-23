
package com.mycompany.puntodeventablrv;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

public class MenuEmpleados {
    
    private final String PREFIJO = "\n\n\n";
        
    private final Connection conexion;
    private final UsuarioDAO usuarioDAO;
    
    private List<Usuario> empleados = new ArrayList<>();
    
    Scanner kb = new Scanner(System.in);
    
    public MenuEmpleados(){
        conexion = ConexionSQLite.conectar();
        usuarioDAO = new UsuarioDAO(conexion);
    }
    
    private void printMenu(){
        for(int i = 0; i<empleados.size(); i++){
            Usuario u = empleados.get(i);
            System.out.println(u.getId() + "\t" + u.getNombre() + "\t" + u.getCorreo() + "\t" + u.getRol());
        }
        
        System.out.println("\n\n1) Registrar\t2) Editar\tR) Regresar");
    }
    
    public void MenuEmpleadosLoop(){
    
        boolean regresar = false;
        do{
            empleados = leerEmpleados();
            
            System.out.println(PREFIJO  + "          EMPLEADOS         ");
            printMenu();
            System.out.print("Selecciona una opción: ");
            
            String seleccion = kb.nextLine();
            
            switch (seleccion) {
                case "1":
//                    System.out.println("No se ha implementado menu Registrar ");
                    registrarEmpleado();
                    break;
                    
                case "2":
//                    System.out.println("No se ha implementado menu Editar ");
                    
                    System.out.print("Ingresa id de usuario a editar: ");
                    int id = kb.nextInt();
                    
                    boolean idValido = false;
                    for(Usuario u : empleados){
                        if(u.getId() == id){
                            idValido = true;
                            editarEmpleado(u);
                            break;
                        }
                    }
                    
                    if(!idValido){
                        System.err.println("El id " + id + " no es válido");
                    }
                    
                    break;
                case "R":
                    regresar = true;
                    break;
                    
                default:
                    System.out.println("Selección no válida.");
            }
            
            
        }while(!regresar);
    }
    
    private List<Usuario> leerEmpleados(){
//        System.err.println("Implementar función leerEmpleados");
        return usuarioDAO.leerTodosLosUsuarios();
    }
    
    private void registrarEmpleado(){
        
        boolean finalizarRegistro = false;
    
        do{
            System.out.println(PREFIJO + "          REGISTRAR          ");

            System.out.print("\nIngresar nombre completo: ");
            String nombre = kb.nextLine();

            System.out.print("\nIngresar correo: ");
            String correo = kb.nextLine();

            String contra;

            String rol = null; 

            boolean iguales = false;
            do{

                System.out.print("\nIngresar contreaseña: ");
                contra = kb.nextLine();

                System.out.print("\nConfirmar contraseña: ");
                String confimacion = kb.nextLine();

                if(contra == null ? confimacion == null : contra.equals(confimacion)){
                    iguales = true;
                }else{
                    System.err.println("Las contraseñas no coinciden");
                }

            }while(!iguales);


            do{
                System.out.println("\nRoles: ");
                System.out.println("1) Admin");
                System.out.println("2) Vendedor");
                System.out.println("3) Almacenista");
                
                System.out.print("\nSelecciona un rol: ");
                String seleccion_rol = kb.nextLine();


                switch (seleccion_rol) {
                    case "1":
                        rol = "Admin";
                        break;

                    case "2":
                        rol = "Vendedor";
                        break;

                    case "3":
                        rol = "Almacenista";
                        break;

                    default:
                        System.out.println("Selección no válida.");
                }

            }while(rol == null);

            Usuario nuevo = new Usuario(0, nombre, correo, contra, rol);

            System.out.println("Registrar");
            System.out.println(nuevo);
            
            
            System.out.println("¿Los datos son correctos? [s]/N: ");                

            String dc = kb.nextLine();

            if( dc.equals("s")){
                // Registrar usuario
                boolean success = usuarioDAO.crearUsuario(nuevo);
                if(!success){
                    System.out.println("Error al registrar Empleado");
                }
                
                finalizarRegistro = true;
            }
                
            
            
            
        }while(!finalizarRegistro);
    }
    
    private void editarEmpleado(Usuario empleado){
        boolean finalizarEdicion = false;
        
        do{

            System.out.println(PREFIJO + "          EDITAR " + empleado.getNombre() + "          ");
            System.out.println(empleado.getId() + "\t" + empleado.getNombre() + "\t" + empleado.getCorreo() + "\t" + empleado.getRol());
            
            System.out.println("\n1) Cambiar nombre");
            System.out.println("\n2) Cambiar contraseña");
            System.out.println("\n3) Cambiar rol");
            
            System.out.println("\n\nR) Menu Empleado");
            
            System.err.print("Selecciona una opción: ");
            String seleccion_editar = kb.nextLine();
            
            switch (seleccion_editar) {
                case "1":
//                    System.out.println("No se ha implementado menu Cambiar nombre ");
                    editarNombre(empleado);
                    break;

                case "2":
                    System.out.println("No se ha implementado menu Cambiar contraseña ");
                    break;

                case "3":
//                    System.out.println("No se ha implementado menu Cambiar rol ");
                    editarRol(empleado);
                    break;

                case "R":
                    finalizarEdicion = true;
                    break;

                default:
                    System.out.println("Selección no válida.");
            }
            

        }while(!finalizarEdicion);
    }
    
    private void editarNombre(Usuario empleado){
        boolean editarNombreFinalizado = false;
        
        do{
            System.out.print("Ingresa nuevo nombre: ");
            String nuevoNombre = kb.nextLine();
            
            System.out.println("Cambiando nombre de " + empleado.getNombre() + " a " + nuevoNombre);
            
            System.out.println("¿Los datos son correctos? [s]/N: ");                
            String dc = kb.nextLine();

            if( dc.equals("s")){
                // Editar usuario
                empleado.setNombre(nuevoNombre);
                usuarioDAO.actualizarUsuario(empleado);
                editarNombreFinalizado = true;
            }
            
        }while(!editarNombreFinalizado);
    }
    
    private void editarRol(Usuario empleado){
        String rol = null;
        do{
                System.out.println("\nRoles: ");
                System.out.println("1) Admin");
                System.out.println("2) Vendedor");
                System.out.println("3) Almacenista");
                
                System.out.print("\nSelecciona un rol: ");
                String seleccion_rol = kb.nextLine();


                switch (seleccion_rol) {
                    case "1":
                        rol = "Admin";
                        break;

                    case "2":
                        rol = "Vendedor";
                        break;

                    case "3":
                        rol = "Almacenista";
                        break;

                    default:
                        System.out.println("Selección no válida.");
                }
                
                // Actualizar rol
                empleado.setRol(rol);
                usuarioDAO.actualizarUsuario(empleado);

            }while(rol == null);
    }
}
