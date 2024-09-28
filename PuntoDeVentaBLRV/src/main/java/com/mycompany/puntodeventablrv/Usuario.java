package com.mycompany.puntodeventablrv;
/**
 *
 * @autor Braiyan Leonardo Ramirez Vargas
 * @archivo Usuario.java
 * @clase Verificación y validación de software
 * @ciclo 2025-1
 *
 */
public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String contra;
    private String rol;
    
    public Usuario(int id,
                   String nombre,
                   String correo,
                   String contra,
                   String rol
                   ){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contra = contra;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
