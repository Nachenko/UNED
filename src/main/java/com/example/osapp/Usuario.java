package com.example.osapp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {
    private String nombre;
    private String cedula;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    private String telefonoContacto;
    private String contraseña;
    private List<Curso> cursosAsignados;  // Lista de cursos asignados

    public Usuario() {
        cursosAsignados = new ArrayList<>();
    }

    public Usuario(String nombre, String cedula, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, String correoElectronico, String telefonoContacto, String contraseña, List<Curso> cursosAsignados) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.telefonoContacto = telefonoContacto;
        this.contraseña = contraseña;
        this.cursosAsignados = cursosAsignados;
    }

    //agregando Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    //Metodos

    public void asignarCurso(Curso curso) {
        cursosAsignados.add(curso);
    }

    public List<Curso> getCursosAsignados() {
        return cursosAsignados;
    }

}
