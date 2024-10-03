import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor; 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginPage extends JFrame {

    public LoginPage() {
        // Configuración de la ventana principal
        setTitle("DREAM'S Perruqueria");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Panel principal con BorderLayout para organizar cabecera y el contenido central
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(0xE9E5E0)); // Color de fondo similar al de la imagen

        // ---------- Cabecera (Logo o título) ----------
        JPanel panelCabecera = new JPanel();
        panelCabecera.setLayout(new BoxLayout(panelCabecera, BoxLayout.Y_AXIS)); // Layout para apilar verticalmente
        panelCabecera.setBackground(new Color(0xE9E5E0)); // Mismo color de fondo que la ventana
        panelCabecera.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espaciado arriba y abajo

        // Título "DREAM'S"
        JLabel labelTitulo = new JLabel("DREAM'S");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 56));
        labelTitulo.setForeground(Color.DARK_GRAY); // Color gris oscuro
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Subtítulo "Perruqueria"
        JLabel labelSubTitulo = new JLabel("Perruqueria");
        labelSubTitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        labelSubTitulo.setForeground(Color.GRAY); // Color gris para el subtítulo
        labelSubTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir título y subtítulo al panel de cabecera
        panelCabecera.add(labelTitulo);
        panelCabecera.add(labelSubTitulo);

        // ---------- Línea divisoria blanca ----------
        JPanel separadorPersonalizado = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE); // Color blanco para la línea
                g.fillRect(0, 0, getWidth(), getHeight()); // Pintar toda el área del JPanel
            }
        };
        separadorPersonalizado.setPreferredSize(new Dimension(500, 4)); // Ancho de la ventana, y grosor de la línea (4 píxeles)
        separadorPersonalizado.setMaximumSize(new Dimension(Integer.MAX_VALUE, 4)); // Para que ocupe todo el ancho
        separadorPersonalizado.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir cabecera y línea divisoria al panel de cabecera
        panelCabecera.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre el subtítulo y la línea
        panelCabecera.add(separadorPersonalizado);

        // Añadir cabecera al panel principal en la parte superior
        panelPrincipal.add(panelCabecera, BorderLayout.NORTH);

        // ---------- Panel para formulario centrado ----------
        JPanel panelFormularioCentrado = new JPanel();
        panelFormularioCentrado.setBackground(new Color(0xE9E5E0)); // Color de fondo
        panelFormularioCentrado.setLayout(new BoxLayout(panelFormularioCentrado, BoxLayout.Y_AXIS));

        // Añadir espacio flexible arriba del formulario para centrar verticalmente
        panelFormularioCentrado.add(Box.createVerticalGlue());

        // ---------- Contenido del formulario ----------
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        panelFormulario.setBackground(new Color(0xE9E5E0)); // Mismo color de fondo

        // Campos de texto para usuario y contraseña con títulos
        JTextField campoUsuario = new JTextField();
        campoUsuario.setMaximumSize(new Dimension(300, 40));  // Ancho fijo
        campoUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoUsuario.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 0), "USUARIO"));

        JPasswordField campoContrasena = new JPasswordField();
        campoContrasena.setMaximumSize(new Dimension(300, 40));  // Ancho fijo
        campoContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoContrasena.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 0), "CONTRASEÑA"));

        // Botón de Entrar
        JButton botonEntrar = new JButton("ENTRAR");
        botonEntrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonEntrar.setBackground(Color.DARK_GRAY);
        botonEntrar.setForeground(Color.WHITE);
        botonEntrar.setMaximumSize(new Dimension(100, 40)); // Ancho fijo

        // Etiqueta de "Recuperar contraseña"
        JLabel labelRecuperarContrasena = new JLabel("¿Olvidaste tu contraseña?");
        labelRecuperarContrasena.setFont(new Font("Arial", Font.PLAIN, 12));
        labelRecuperarContrasena.setForeground(Color.BLUE); // Color azul, similar a un enlace
        labelRecuperarContrasena.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambia el cursor al pasar sobre el texto
        labelRecuperarContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir efecto de "enlace" al pasar el ratón
        labelRecuperarContrasena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Acción al hacer clic en "Recuperar contraseña"
                JOptionPane.showMessageDialog(null, "Se ha solicitado la recuperación de contraseña.");
            }

           

            @Override
            public void mouseExited(MouseEvent e) {
                labelRecuperarContrasena.setText("¿Olvidaste tu contraseña?"); // Quitar el subrayado
            }
        });

        // Añadir componentes al formulario
        panelFormulario.add(campoUsuario);
        panelFormulario.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre los campos
        panelFormulario.add(campoContrasena);
        panelFormulario.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre contraseña y botón
        panelFormulario.add(botonEntrar);
        panelFormulario.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre el botón y la etiqueta de "Recuperar contraseña"
        panelFormulario.add(labelRecuperarContrasena);

        // Añadir el formulario centrado al panel de formulario centrado
        panelFormularioCentrado.add(panelFormulario);

        // Añadir espacio flexible debajo del formulario para centrar verticalmente
        panelFormularioCentrado.add(Box.createVerticalGlue());

        // Añadir el panel centrado al panel principal
        panelPrincipal.add(panelFormularioCentrado, BorderLayout.CENTER);

        // Añadir el panel principal a la ventana
        add(panelPrincipal);

        // Hacer la ventana visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(LoginPage::new);
    }
}
