import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt; // Importar BCrypt

public class LoginPage extends Application {

    // Simulamos una contraseña hasheada (en un sistema real, esto vendría de la base de datos)
    private static final String hashedPasswordAlmacenada = BCrypt.hashpw("mi_contraseña_secreta", BCrypt.gensalt());

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #E9E5E0;");

        // Cabecera (Header)
        StackPane header = new StackPane();
        header.setPadding(new Insets(20, 0, 20, 0));

        // Sombra simulada (Texto detrás con desplazamiento)
        Label sombraTitulo = new Label("DREAM'S");
        sombraTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 46));  // Fuente grande
        sombraTitulo.setTextFill(Color.web("#C0C0C0"));  // Color gris claro para la sombra
        sombraTitulo.setTranslateX(-5);  // Desplazamos un poco hacia la derecha
        sombraTitulo.setTranslateY(3);  // Desplazamos un poco hacia abajo

        // Texto principal de "DREAM'S"
        Label titulo = new Label("DREAM'S");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 46));  // Fuente grande
        titulo.setTextFill(Color.web("#383D37"));  // Color principal

        // Creamos un StackPane para superponer la sombra y el texto principal
        StackPane tituloConSombra = new StackPane();
        tituloConSombra.getChildren().addAll(sombraTitulo, titulo);  // Superponer texto y sombra
        tituloConSombra.setAlignment(Pos.CENTER);  // Alinearlos juntos

        // Crear subtítulo con líneas a los lados
        Label subtitulo = new Label("Perruqueria");
        subtitulo.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        subtitulo.setTextFill(Color.web("#383D37"));

        Rectangle lineaIzquierda = new Rectangle(65, 2, Color.BLACK);
        Rectangle lineaDerecha = new Rectangle(65, 2, Color.BLACK);

        HBox subtituloConLineas = new HBox(0);  // Contenedor horizontal para subtítulo y líneas
        subtituloConLineas.setAlignment(Pos.CENTER);
        subtituloConLineas.getChildren().addAll(lineaIzquierda, subtitulo, lineaDerecha);

        VBox headerContent = new VBox(0);  // Contenedor vertical para título y subtítulo
        headerContent.getChildren().addAll(tituloConSombra, subtituloConLineas);
        headerContent.setAlignment(Pos.CENTER);

        header.getChildren().add(headerContent);

        // Línea divisoria
        Rectangle separator = new Rectangle(1800, 4);  // Línea blanca debajo del encabezado
        separator.setFill(Color.WHITE);
        StackPane.setMargin(separator, new Insets(100, 0, 0, 0));
        header.getChildren().add(separator);

        // Formulario de inicio de sesión
        VBox formulario = new VBox(20);  // Espaciado entre los elementos del formulario
        formulario.setAlignment(Pos.CENTER);

        TextField campoUsuario = new TextField();
        campoUsuario.setPromptText("USUARIO");
        campoUsuario.setMaxWidth(300);

        PasswordField campoContrasena = new PasswordField();
        campoContrasena.setPromptText("CONTRASEÑA");
        campoContrasena.setMaxWidth(300);

        Button botonEntrar = new Button("ENTRAR");
        botonEntrar.setStyle("-fx-background-color: #383D37; -fx-text-fill: white;");
        botonEntrar.setMaxWidth(100);

        // Acción al hacer clic en el botón "ENTRAR"
        botonEntrar.setOnAction(event -> {
            String usuarioIngresado = campoUsuario.getText();
            String contrasenaIngresada = campoContrasena.getText();

            if (!usuarioIngresado.isEmpty() && !contrasenaIngresada.isEmpty()) {
                // Verificar la contraseña ingresada
                if (BCrypt.checkpw(contrasenaIngresada, hashedPasswordAlmacenada)) {
                    // Contraseña correcta, cambiar a la siguiente página
                    cambiarAPaginaSiguiente(primaryStage);
                } else {
                    // Contraseña incorrecta
                    System.out.println("Contraseña incorrecta.");
                }
            } else {
                System.out.println("El usuario o la contraseña no pueden estar vacíos.");
            }
        });

        Label labelRecuperarContrasena = new Label("¿Olvidaste tu contraseña?");
        labelRecuperarContrasena.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        labelRecuperarContrasena.setTextFill(Color.BLUE);
        labelRecuperarContrasena.setOnMouseClicked(event -> {
            System.out.println("Se ha solicitado la recuperación de contraseña.");
        });

        formulario.getChildren().addAll(campoUsuario, campoContrasena, botonEntrar, labelRecuperarContrasena);

        // Contenido del panel
        StackPane content = new StackPane();
        content.getChildren().add(formulario);
        content.setAlignment(Pos.CENTER);

        root.setTop(header);
        root.setCenter(content);

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("DREAM'S Perruqueria");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para cambiar a la nueva página
    public void cambiarAPaginaSiguiente(Stage stage) {
        // Implementa la lógica para cambiar a la nueva página aquí
        System.out.println("Accediendo a la siguiente página...");
        // Puedes abrir una nueva ventana o cambiar la escena
    }

    public static void main(String[] args) {
        launch(args);
    }
}
