package com.example.osapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDataManager {
    private static final String USUARIOS_JSON_FILE = "usuarios.json";
    private List<Usuario> usuarios;

    public UsuarioDataManager() {
        usuarios = cargarUsuarios();
        if (usuarios.isEmpty()) {
            inicializarArchivoUsuarios();
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        guardarUsuarios();
    }

    // Resto de los métodos de UsuarioDataManager...

    public List<Usuario> cargarUsuarios() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.readValue(new File(USUARIOS_JSON_FILE), new TypeReference<List<Usuario>>() {});
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios desde el archivo: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void guardarUsuarios() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(USUARIOS_JSON_FILE), usuarios);

            System.out.println("Usuarios guardados en el archivo usuarios.json.");
        } catch (IOException e) {
            System.err.println("Error al guardar usuarios en el archivo: " + e.getMessage());
        }
    }

    private void inicializarArchivoUsuarios() {
        //inicializa el archivo con un acceso generico si no existe un json
        List<Usuario> usuariosIniciales = new ArrayList<>();

        // Create example users and add them to the list
        Usuario usuario1 = new Usuario(
                "admin", "123456789", "admin", "admin",
                LocalDate.of(2000, 1, 1), "ejemplo1@example.com",
                "1234567890", "admin", new ArrayList<>()
        );

        usuariosIniciales.add(usuario1);


        // Save the list of users to the JSON file
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(USUARIOS_JSON_FILE), usuariosIniciales);

            System.out.println("Usuarios iniciales guardados en el archivo usuarios.json.");
        } catch (IOException e) {
            System.err.println("Error al guardar usuarios iniciales en el archivo: " + e.getMessage());
        }
    }
}


