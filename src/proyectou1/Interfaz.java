package proyectou1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author manem
 */
public class Interfaz extends JFrame {

    private JTextArea area;
    private String consultatexto;
    private JButton late;
    private JButton insertar;
    private JButton actualizar;
    private JButton editar;
    private JPanel tablero;
    private JPanel front;
    private JLabel etiqueta;
    public static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    public static final String URL_BD = "jdbc:mysql://localhost:3306/travel?serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASS = "mane";

    public Interfaz() {
        super("Base de Datos Manager");

        //importar propio icono
        Toolkit TK = Toolkit.getDefaultToolkit();
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass()
                .getResource("iconos/plane.png"));
        setIconImage(iconoPropio);
        setVisible(true);

        //inatanciar objetos
        area = new JTextArea();
        area.setPreferredSize(new Dimension(1100, 600));
        late = new JButton();
        late.setText("Eliminar");
        late.setFont(new Font("Serief", Font.PLAIN+Font.BOLD, 13));
        late.setCursor(new Cursor(12));

        insertar = new JButton();
        insertar.setText("Insertar");
        insertar.setFont(new Font("Serief", Font.PLAIN+Font.BOLD, 13));
        insertar.setCursor(new Cursor(12));

        editar = new JButton();
        editar.setText("Editar");
        editar.setFont(new Font("Serief",Font.PLAIN+Font.BOLD, 13));
        editar.setCursor(new Cursor(12));

        actualizar = new JButton();
        actualizar.setText("Actualizar");
        actualizar.setFont(new Font("Serief", Font.PLAIN+Font.BOLD, 13));
        actualizar.setCursor(new Cursor(12));

        //etiqueta de columna
        etiqueta = new JLabel("---- Id: " + "---------- Nombre-----" + 
                "----------- Origen: --------" + "-------------- Destino: "
                + "-----------"
                + "--------- Ida: -------" + "----- Vuelta: ----"
                + "---- Clase: ------" + "-- Cantidad: -" + "- Precio$ -- ");
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("Serief", Font.PLAIN, 16));

        // instanciar paneles
        tablero = new JPanel();
        tablero.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        tablero.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));

        front = new JPanel();
        front.setLayout(new FlowLayout(FlowLayout.LEFT));
        front.setBackground(new Color(179, 206, 236));
        front.setPreferredSize(new Dimension(1100, 30));

//agregar objetos a panel front
        front.add(etiqueta);
        tablero.add(area, BorderLayout.CENTER);

        //agregst objetos a panel tablero
        tablero.add(late);
        tablero.add(insertar);
        tablero.add(editar);
        tablero.add(actualizar);
        add(front, BorderLayout.NORTH);
        add(tablero, BorderLayout.CENTER);

        //imprimir valores en area de texto
        Connection conexion = null;
        Statement intruccion = null;
        ResultSet consulta = null;
        //Conexion a la BD
        consultatexto = "";
        area.setText(consultatexto);
        try {
            //Cargar el controlador
            Class.forName(CONTROLADOR);
            //Establecer la conexion
            conexion = (Connection) DriverManager.getConnection(URL_BD, USER, PASS);

            intruccion = conexion.createStatement();

            consulta = intruccion.executeQuery(
                    "SELECT * FROM registro ");
            ResultSetMetaData metaDatos = consulta.getMetaData();

            int numColumnas = metaDatos.getColumnCount();

            area.setEditable(false);
            consultatexto = "";

            //imprimir
            while (consulta.next()) {
                for (int i = 1; i < numColumnas + 1; i++) {
                    consultatexto += ("     " + consulta.getObject(i).toString() + "   ");

                }
                consultatexto += "   \n\n";
                // System.out.println("");
                area.setText(consultatexto);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                consulta.close();
                intruccion.close();
                conexion.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //chismoso de eliminar
        late.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {

                //input de el campo a eliminar
                String idNumero1 = JOptionPane.showInputDialog
        (null, "Seleccione el id a eliminar", "✈TRAVEL",
                        JOptionPane.DEFAULT_OPTION );
                int idNumero = Integer.valueOf(idNumero1);
                Connection conexion = null;
                PreparedStatement intruccion = null;

                //Conexion a la BD
                try {
                    //Cargar el controlador
                    Class.forName(CONTROLADOR);
                    //Establecer la conexion
                    conexion = (Connection) DriverManager.getConnection(URL_BD, USER, PASS);

                    //instruccion eliminar
                    intruccion = conexion.prepareStatement("DELETE FROM registro WHERE(id=?)");

                    //ystem.out.print("ingrese el id al eliminar;");
                    intruccion.setInt(1, idNumero);

                    intruccion.executeUpdate();

                    intruccion.executeUpdate();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } finally {

                    try {
                        // consulta.close();
                        intruccion.close();
                        conexion.close();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        //chismoso de boton siguiente
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {

                //input del nuevo id
                String idNumero1 = JOptionPane.showInputDialog(null, "Ingrese un id", "✈TRAVEL",
                        JOptionPane.DEFAULT_OPTION /*icono19, tarjetas, tarjetas[0]*/);
                if (idNumero1 != null) {
                    int idNumero = Integer.valueOf(idNumero1);
                    Connection conexion = null;
                    PreparedStatement intruccion = null;

                    //Conexion a la BD
                    try {
                        //Cargar el controlador
                        Class.forName(CONTROLADOR);
                        //Establecer la conexion
                        conexion = (Connection) DriverManager.getConnection(URL_BD, USER, PASS);

                        intruccion = conexion.prepareStatement
        ("INSERT INTO registro VALUES(?,?,?,?,?,?,?,?,?)");

                        //Joption para ingresar datos
                        String nombre = JOptionPane.showInputDialog
        (null, "Ingrese el usuario", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );

                        String origen = JOptionPane.showInputDialog
        (null, "Ingrese el origen", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );
                        String destino = JOptionPane.showInputDialog
        (null, "Ingrese el destino", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );
                        String ida = JOptionPane.showInputDialog
        (null, "Ingrese la ida", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );
                        String vuelta = JOptionPane.showInputDialog(
                                null, "Ingresa la vuelta", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );

                        String clase = JOptionPane.showInputDialog
        (null, "Ingrese la clase", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );
                        String cant = JOptionPane.showInputDialog
        (null, "Ingrese la cantidad (1,2,3)", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );
                        String precio = JOptionPane.showInputDialog
        (null, "Ingrese el precio", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION);

                        int precio2 = Integer.valueOf(precio);
                        int cant2 = Integer.valueOf(cant);

                        intruccion.setInt(1, idNumero);
                        intruccion.setString(2, nombre);
                        intruccion.setString(3, origen);
                        intruccion.setString(4, destino);
                        intruccion.setString(5, ida);
                        intruccion.setString(6, vuelta);
                        intruccion.setString(7, clase);
                        intruccion.setInt(8, cant2);
                        intruccion.setInt(9, precio2);

                        intruccion.executeUpdate();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    } finally {

                        try {
                            // consulta.close();
                            intruccion.close();
                            conexion.close();

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                }

            }
        });

        //chismoso actualizar
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                //conexiones
                Connection conexion = null;
                Statement intruccion = null;
                ResultSet consulta = null;
                //Conexion a la BD
                consultatexto = "";
                area.setText(consultatexto);
                try {
                    //Cargar el controlador
                    Class.forName(CONTROLADOR);
                    //Establecer la conexion
                    conexion = (Connection) DriverManager.getConnection(URL_BD, USER, PASS);

                    intruccion = conexion.createStatement();

                    //instruccion actualizar
                    consulta = intruccion.executeQuery(
                            "SELECT * FROM registro ");
                    ResultSetMetaData metaDatos = consulta.getMetaData();

                    int numColumnas = metaDatos.getColumnCount();

                    area.setEditable(false);
                    consultatexto = "";
                    while (consulta.next()) {
                        for (int i = 1; i < numColumnas + 1; i++) {
                            consultatexto += ("     " + consulta.getObject(i).toString() + "   ");

                        }
                        consultatexto += "   \n\n";
                        area.setText(consultatexto);

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        consulta.close();
                        intruccion.close();
                        conexion.close();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

        });

//chismoso editar
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {

                Connection conexion = null;
                PreparedStatement intruccion = null;
                ResultSet consulta = null;
                //Conexion a la BD
                String idNumero1 = JOptionPane.showInputDialog
        (null, "Ingrese el id a editar", "✈TRAVEL",
                        JOptionPane.DEFAULT_OPTION );

                if (idNumero1 != null) {
                    try {
                        //Cargar el controlador
                        Class.forName(CONTROLADOR);
                        //Establecer la conexion
                        conexion = (Connection) DriverManager.getConnection(URL_BD, USER, PASS);

                        intruccion = 
                                conexion.prepareStatement
        ("UPDATE registro SET usuario=(?),origen=(?),destino=(?)"
                                + ",ida=(?),vuelta=(?),clase=(?),cant=(?),precio=(?)"
                                + ""
                                + ""
                                + ""
                                + "WHERE (id=?)");
                        //     UPDATE autores SET nombre=(nombre=?),apellido=(apellido=?), WHERE (id=?);

                        //ingresar valores al Joption para editar
                        String nombre = JOptionPane.showInputDialog(null, "usuario", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );

                        String origen = JOptionPane.showInputDialog(null, "origen", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );
                        String destino = JOptionPane.showInputDialog(null, "destino", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );
                        String ida = JOptionPane.showInputDialog(null, "ida", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );
                        String vuelta = JOptionPane.showInputDialog(null, "vuelta", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );

                        String clase = JOptionPane.showInputDialog(null, "clase", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );
                        String cant = JOptionPane.showInputDialog(null, "cantidad (1,2,3)", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );
                        String precio = JOptionPane.showInputDialog(null, "precio", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION );
                        int idNumero = Integer.valueOf(idNumero1);

                        int precio2 = Integer.valueOf(precio);
                        int cant2 = Integer.valueOf(cant);

                        intruccion.setInt(9, idNumero);
                        intruccion.setString(1, nombre);
                        intruccion.setString(2, origen);
                        intruccion.setString(3, destino);
                        intruccion.setString(4, ida);
                        intruccion.setString(5, vuelta);
                        intruccion.setString(6, clase);
                        intruccion.setInt(7, cant2);
                        intruccion.setInt(8, precio2);

                        intruccion.executeUpdate();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            intruccion.close();
                            conexion.close();

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                }

            }

        });

    }

}
