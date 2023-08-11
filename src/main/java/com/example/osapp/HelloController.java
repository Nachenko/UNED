package com.example.osapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private TextField usuarioField;
    @FXML
    private PasswordField contraseñaField;
    @FXML
    private Label welcomeText;
    @FXML
    private Button iniciarSesionButton;

    //Metodos
    private List<Usuario> listaUsuarios = new ArrayList<>();

    // Ruta del archivo JSON para almacenar usuarios
    private static final String USUARIOS_JSON_FILE = "usuarios.json";

    private UsuarioDataManager usuarioDataManager;

    @FXML
    private void initialize() {
        usuarioDataManager = new UsuarioDataManager();
        cargarUsuarios();
    }

    private void cargarUsuarios() {
       listaUsuarios = usuarioDataManager.cargarUsuarios();
    }

    private void guardarUsuarios() {
     usuarioDataManager.guardarUsuarios();
    }

    @FXML
    private void iniciarSesion() {
        String usuario = usuarioField.getText();
        String contraseña = contraseñaField.getText();

        // Buscar el usuario en la lista o base de datos
        Usuario usuarioEncontrado = buscarUsuarioPorNombre(usuario);

        if (usuarioEncontrado != null && BCrypt.checkpw(contraseña, usuarioEncontrado.getContraseña())) {
            welcomeText.setText("Bienvenido, " + usuarioEncontrado.getNombre());
            // Realizar la acción después de iniciar sesión exitosamente
        } else {
            welcomeText.setText("Credenciales inválidas");
        }
    }

    private Usuario buscarUsuarioPorNombre(String nombreUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }
}
