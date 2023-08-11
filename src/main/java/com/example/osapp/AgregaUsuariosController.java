package com.example.osapp;

import com.example.osapp.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.mindrot.jbcrypt.BCrypt;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AgregaUsuariosController {

    @FXML
    private TextField nombreField;
    @FXML
    private TextField cedulaField;
    @FXML
    private TextField primerApellidoField;
    @FXML
    private TextField segundoApellidoField;
    @FXML
    private DatePicker fechaNacimientoPicker;
    @FXML
    private TextField correoElectronicoField;
    @FXML
    private TextField telefonoContactoField;
    @FXML
    private PasswordField contraseñaField;
    @FXML
    private PasswordField reingresarContraseñaField;
    @FXML
    private Button crearUsuarioButton;

    private List<Usuario> listaUsuarios = new ArrayList<>();

    @FXML
    private void initialize() {
        // Configuración inicial, si es necesaria
    }

    @FXML
    private void crearUsuario() {
        String nombre = nombreField.getText();
        String cedula = cedulaField.getText();
        String primerApellido = primerApellidoField.getText();
        String segundoApellido = segundoApellidoField.getText();
        LocalDate fechaNacimiento = fechaNacimientoPicker.getValue();
        String correoElectronico = correoElectronicoField.getText();
        String telefonoContacto = telefonoContactoField.getText();
        String contraseña = contraseñaField.getText();
        String reingresarContraseña = reingresarContraseñaField.getText();

        if (!contraseña.equals(reingresarContraseña)) {
            // Mostrar mensaje de error: Las contraseñas no coinciden
            return;
        }
        String salt = BCrypt.gensalt();  // Generar un salt aleatorio
        String contraseñaEncriptada = BCrypt.hashpw(contraseña, salt);


        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCedula().equals(cedula)) {
                // Mostrar mensaje de error: Ya existe un usuario con esa cédula
                return;
            }
        }

        // Crear instancia de Usuario y asignar valores
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setCedula(cedula);
        nuevoUsuario.setPrimerApellido(primerApellido);
        nuevoUsuario.setSegundoApellido(segundoApellido);
        nuevoUsuario.setFechaNacimiento(fechaNacimiento);
        nuevoUsuario.setCorreoElectronico(correoElectronico);
        nuevoUsuario.setTelefonoContacto(telefonoContacto);
        nuevoUsuario.setContraseña(contraseñaEncriptada); // Guardar la contraseña encriptada

        // Agregar el nuevo usuario a la lista
        listaUsuarios.add(nuevoUsuario);

        // Mostrar mensaje de éxito
        // Limpiar campos de entrada

    }

    // Otros métodos y manejo de eventos
}
