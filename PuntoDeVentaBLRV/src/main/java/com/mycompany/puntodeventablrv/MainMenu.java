
package com.mycompany.puntodeventablrv;

import java.util.Scanner;

/**
 *
 * @autor Braiyan Leonardo Ramirez Vargas
 * @archivo PuntoDeVenta.java
 * @clase Verificación y validación de software
 * @ciclo 2025-1
 *
 */
public class MainMenu {
    private final String printMenu = "\n\n\n\n\n          MENU         "
            + "\n1) Empleados"
            + "\n2) Provedores"
            + "\n3) Ctalogo"
            + "\n4) Invetario"
            + "\n5) Reportes"
            + "\n\nX) Salir";
    
    public void MainMenuLoop(){
        
        boolean salir = false;
        
        // Crear loop de eventos
        do{
            System.out.println(printMenu);
            System.out.print("\n\nSelecciona una opción: ");
            String seleccion = obtenerSeleccion();
            
            switch (seleccion) {
                case "1":
                    MenuEmpleados empleados = new MenuEmpleados();
                    empleados.MenuEmpleadosLoop();
//                    System.out.println("No se ha implementado el menu Empleados");
                    break;
                    
                case "2":
                    System.out.println("No se ha implementado el menu Provedores");
                    break;
                    
                case "3":
                    System.out.println("No se ha implementado el menu Catalogo");
                    break;
                    
                case "4":
                    System.out.println("No se ha implementado el menu Inventario");
                    break;
                    
                case "5":
                    System.out.println("No se ha implementado el menu Reportes");
                    break;
                    
                case "X":
                    salir = true;
                    
                default:
                    System.out.println("Selección no válida.");
            }
            
        } while(!salir);
    }
    
    private String obtenerSeleccion(){
        Scanner kb = new Scanner(System.in);
        
        return kb.nextLine();
    }
}
