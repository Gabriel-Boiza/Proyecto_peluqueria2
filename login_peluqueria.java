
import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {

    /**
     * 
     */
    public LoginPage() {
        // Configuración de la ventana principal
        setTitle("DREAM'S ");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Panel principal con BorderLayout para organizar cabecera y el contenido central
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(0xEAE5E0)); // Color de fondo 

        // ---------- Cabecera (Logo o título) ----------
        JPanel panelCabecera = new JPanel();
        panelCabecera.setLayout(new BoxLayout(panelCabecera, BoxLayout.Y_AXIS)); // Layout para apilar verticalmente
        panelCabecera.setBackground(new Color(0xEAE5E0)); // Mismo color de fondo que la ventana
        panelCabecera.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espaciado arriba y abajo

        // Título "DREAM'S"
        JLabel labelTitulo = new JLabel("DREAM'S");
        labelTitulo.setFont(new Font("Roboto", Font.BOLD, 36));
        labelTitulo.setForeground(new Color(0x3A3B38)); // Color gris oscuro
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Subtítulo "Perruqueria"
        JLabel labelSubTitulo = new JLabel("Perruqueria");
        labelSubTitulo.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelSubTitulo.setForeground(Color.GRAY); // Color gris para el subtítulo
        labelSubTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir título y subtítulo al panel de cabecera
        panelCabecera.add(labelTitulo);
        panelCabecera.add(labelSubTitulo);

        // ---------- Línea divisoria blanca personalizada ----------
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
        panelFormularioCentrado.setBackground(new Color(0xEAE5E0)); // Color de fondo
        panelFormularioCentrado.setLayout(new BoxLayout(panelFormularioCentrado, BoxLayout.Y_AXIS));

        // Añadir espacio flexible arriba del formulario para centrar verticalmente
        panelFormularioCentrado.add(Box.createVerticalGlue());

        // ---------- Contenido del formulario ----------
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        panelFormulario.setBackground(new Color(0xEAE5E0)); // Mismo color de fondo

        // Campos de texto para usuario y contraseña
        JTextField campoUsuario = new JTextField();
        campoUsuario.setMaximumSize(new Dimension(300, 40));  // Se ajusta a un ancho fijo
        campoUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoUsuario.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE, 1), "USUARIO"));

        JPasswordField campoContrasena = new JPasswordField();
        campoContrasena.setMaximumSize(new Dimension(300, 40));  // Se ajusta a un ancho fijo
        campoContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoContrasena.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE, 1), "CONTRASEÑA"));
        
        // Botón de Entrar
        JButton botonEntrar = new JButton("ENTRAR");
        botonEntrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonEntrar.setBackground(Color.DARK_GRAY);
        botonEntrar.setForeground(Color.WHITE);
        botonEntrar.setMaximumSize(new Dimension(100, 40)); // Ancho fijo

        // Añadir componentes al formulario
        panelFormulario.add(campoUsuario);
        panelFormulario.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre los campos
        panelFormulario.add(campoContrasena);
        panelFormulario.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre contraseña y botón
        panelFormulario.add(botonEntrar);

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
