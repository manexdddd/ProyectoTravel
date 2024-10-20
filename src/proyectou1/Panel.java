package proyectou1;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import com.Micheckbox.zcheck.zCheckBox;
import com.Miboton.zBoton.zBoton;
import java.awt.Cursor;
import java.awt.Dimension;
import com.MiRadioButton.zradioboton.zRadioBoton;
import java.awt.Point;
import funciones.precio;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import static proyectou1.Interfaz.CONTROLADOR;
import static proyectou1.Interfaz.PASS;
import static proyectou1.Interfaz.URL_BD;
import static proyectou1.Interfaz.USER;

/**
 *
 * @author ManeV
 */
public class Panel extends JFrame implements KeyListener {

    //crear objetos
    //comboboxes
    private JComboBox listaorigen;
    private JComboBox listadestino;
    private JComboBox cant_personas;
    //etiquetas
    private JLabel personas;
    private JLabel origen1;
    private JLabel destino1;
    private JLabel precio1;
    private JLabel precio2;
    private JLabel tclases;
    private JLabel imagen1;
    private JLabel imagen2;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JLabel fechas;
    private JLabel vuelos;
    private JLabel travel;
    private JLabel ticket;
    private JLabel bienvenido;
    private JLabel gracias;
    private JLabel sel;
    private JLabel linea10;
    private JLabel linea12;
    private JLabel anuncio;
    private JLabel topicos;
    private JLabel equipo;
    private JLabel toñe;
    private JLabel people;
    private JLabel money;
    private JLabel robot;
    //grupo de botones
    private ButtonGroup clases;
    //radiobutons
    private JRadioButton Primera_clase;
    private JRadioButton Premium;
    private JRadioButton Economica;
    //elejidores de fecha
    private JDateChooser ida;
    private JDateChooser vuelta;
    //paneles
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;
    private JPanel panel9;
    private JPanel panel10;
    private JPanel panel11;
    private JPanel panel12;
    private JPanel panel13;
    private JPanel panel14;
    private JPanel panel17;
    private JPanel panel16;
    private JPanel panel15;
    private JPanel panelrobot;
    //textarea
    private JTextArea areaTexto;
    //variable del precio
    private int preciototal = 0;
    private String usuario;
    private String consultatexto;
    //botones de otra galeria
    private JButton comprar;
    private zBoton aceptar;
    private JButton continuar;
    private JButton atras;
    private JButton atras2;
    private JButton sig1;
    private JButton sig2;
    private JButton sig3;
    private JButton back1;
    private JButton back2;
    private JButton informacion;
    private JButton generar;
    private JButton basedata;
    private JButton base;
    private zCheckBox acepto;
    private Cursor micursor;
    private Cursor micursor2;
    private Interfaz interfaz;

    public static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    public static final String URL_BD = "jdbc:mysql://localhost:3306/travel?serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASS = "mane";

    // listas de destinos y origenes
    private String origenes[] = {
        "Ciudad de Mexico,CDMX 🥑", "Tijuana,Baja California 🍺", "Monterrey,NL 🍗"
    };
    private String destinos[] = {
        "Puerto Vallarta,Jalisco 🐟", "Cancun,Quintana Roo 🌴", "Los Cabos,Baja C. ⛵"
    };
    private String tarjetas[] = {
        "BBVA", "Bansefi", "Bancoppel"
    };
    //lista de personas
    private String persona[] = {
        "1", "2", "3"//🚶🚶🚶
    };
    //listas de los archivos
    private String nombres1[] = {
        "combobox/mx1.jpg", "combobox/tijuana.jpg", "combobox/monterrey1.png"

    };
    private String nombres2[] = {
        "combobox/vallarta.jpg", "combobox/cancun.jpg", "combobox/cabos.jpg"

    };

    private String nombres3[] = {
        "iconos/one.png", "iconos/two.png", "iconos/three.png"

    };

    ///importar iconos
    private Icon imagenes1[] = {
        new ImageIcon(getClass().getResource(nombres1[0])),
        new ImageIcon(getClass().getResource(nombres1[1])),
        new ImageIcon(getClass().getResource(nombres1[2])),};

    private Icon imagenes2[] = {
        new ImageIcon(getClass().getResource(nombres2[0])),
        new ImageIcon(getClass().getResource(nombres2[1])),
        new ImageIcon(getClass().getResource(nombres2[2])),};

    private Icon imagenes3[] = {
        new ImageIcon(getClass().getResource(nombres3[0])),
        new ImageIcon(getClass().getResource(nombres3[1])),
        new ImageIcon(getClass().getResource(nombres3[2])),};

//constructor
    public Panel() throws HeadlessException {
        //poner nombre a la ventana
        super("Agencia de Viajes TRAVEL");

        //agregar icono  del avion
        Toolkit TK = Toolkit.getDefaultToolkit();
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconos/plane.png"));
        setIconImage(iconoPropio);
        setVisible(true);

//instanciar comboboxes
        listaorigen = new JComboBox(origenes);
        listaorigen.setMaximumRowCount(3);
        listadestino = new JComboBox(destinos);
        listadestino.setMaximumRowCount(3);
        cant_personas = new JComboBox(persona);
        cant_personas.setMaximumRowCount(3);

//instanciar etiquetas
        origen1 = new JLabel("🗻Origen:");
        origen1.setForeground(Color.BLACK);
        origen1.setFont(new Font("Serief", Font.PLAIN, 18));
        destino1 = new JLabel("🚩Destino:");
        destino1.setForeground(Color.BLACK);
        destino1.setFont(new Font("Serief", Font.PLAIN, 18));
        personas = new JLabel("🏃Cantidad de Personas:");
        personas.setForeground(Color.BLACK);
        personas.setFont(new Font("Serief", Font.PLAIN, 18));
        precio1 = new JLabel("💰Precio");
        precio2 = new JLabel("$0.00 MXN");
        tclases = new JLabel("💍Elija su Clase: ");
        tclases.setForeground(Color.BLACK);
        tclases.setFont(new Font("Serief", Font.PLAIN, 18));

        imagen1 = new JLabel("");
        imagen2 = new JLabel("");
        etiqueta1 = new JLabel("🕛Ida ");
        etiqueta1.setFont(new Font("Serief", Font.PLAIN, 14));
        etiqueta2 = new JLabel("🕦Vuelta ");
        etiqueta2.setFont(new Font("Serief", Font.PLAIN, 14));
        fechas = new JLabel("🕑Elija las fechas de: ");
        fechas.setFont(new Font("Serief", Font.PLAIN, 18));
        fechas.setForeground(new Color(0, 0, 0));
        vuelos = new JLabel(" Vuelos Nacionales ✈ ");
        bienvenido = new JLabel(" 👉   Bienvenido a la Agencia de Viajes TRAVEL    👌 ");
        gracias = new JLabel("");
        sel = new JLabel(" Seleccione su Vuelo");

        vuelos.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        bienvenido.setFont(new Font("Serif", Font.BOLD, 30));
        gracias.setFont(new Font("Serif", Font.BOLD, 25));
        sel.setFont(new Font("Serif", Font.BOLD, 15));

//instanciar radiobuton
        Primera_clase = new JRadioButton();
        Primera_clase.setSelected(true);
        Primera_clase.setFont(new Font("Serief", Font.PLAIN, 14));
        Primera_clase.setText("Primera clase 💸");
        Primera_clase.setCursor(micursor2);

        Premium = new JRadioButton();
        Premium.setSelected(false);
        Premium.setForeground(new Color(0, 0, 0));
        Premium.setFont(new Font("Serief", Font.PLAIN, 14));
        Premium.setText("Premium 💎");
        Premium.setCursor(micursor2);

        Economica = new JRadioButton();
        Economica.setSelected(false);
        Economica.setFont(new Font("Serief", Font.PLAIN, 14));
        Economica.setText("Economica 🎫");
        Economica.setCursor(micursor2);

        //instanciar grupo de botones
        clases = new ButtonGroup();

        //instanciar Area de texto
        areaTexto = new JTextArea("EL TICKET SE GENERA AQUI \n(control+x para limpiar el Texto📜)");
        areaTexto.setColumns(20);
        areaTexto.setRows(20);

        //agregar imagenes
        Icon icono1 = new ImageIcon(getClass().getResource("combobox/mx.jpg"));
        Icon icono2 = new ImageIcon(getClass().getResource("combobox/vallarta.jpg"));
        Icon icono5 = new ImageIcon(getClass().getResource("imagenes/gif.gif"));
        Icon icono7 = new ImageIcon(getClass().getResource("imagenes/maleta.gif"));
        Icon icono8 = new ImageIcon(getClass().getResource("imagenes/cut.gif"));
        Icon icono9 = new ImageIcon(getClass().getResource("iconos/right.png"));
        Icon icono10 = new ImageIcon(getClass().getResource("iconos/right2.png"));
        Icon icono11 = new ImageIcon(getClass().getResource("iconos/accept.png"));
        Icon icono12 = new ImageIcon(getClass().getResource("iconos/accept2.png"));
        Icon icono13 = new ImageIcon(getClass().getResource("iconos/anterior.png"));
        Icon icono14 = new ImageIcon(getClass().getResource("iconos/souble.png"));
        Icon icono15 = new ImageIcon(getClass().getResource("imagenes/plane.gif"));
        Icon icono20 = new ImageIcon(getClass().getResource("iconos/info.png"));
        Icon icono21 = new ImageIcon(getClass().getResource("iconos/info2.png"));
        Icon icono22 = new ImageIcon(getClass().getResource("iconos/generar1.png"));
        Icon icono23 = new ImageIcon(getClass().getResource("iconos/generar2.png"));
        Icon icono24 = new ImageIcon(getClass().getResource("info0.jpg"));
        Icon icono25 = new ImageIcon(getClass().getResource("info1.jpg"));
        Icon icono26 = new ImageIcon(getClass().getResource("info3.jpg"));

        Icon iconodata1 = new ImageIcon(getClass().getResource("iconos/bd1.png"));
        Icon iconodata2 = new ImageIcon(getClass().getResource("iconos/bd2.png"));

        Icon iconodata3 = new ImageIcon(getClass().getResource("iconos/dev.png"));
        Icon iconodata4 = new ImageIcon(getClass().getResource("iconos/dev2.png"));

        Icon icono27 = new ImageIcon(getClass().getResource("iconos/back1.png"));
        Icon iconopep = new ImageIcon(getClass().getResource("iconos/one.png"));
        Icon icono28 = new ImageIcon(getClass().getResource("iconos/back2.png"));
        Icon icono29 = new ImageIcon(getClass().getResource("iconos/coin.png"));
        Icon iconopremium = new ImageIcon(getClass().getResource("iconos/premium.png"));
        Icon iconofirst = new ImageIcon(getClass().getResource("iconos/badge.png"));
        Icon rebot = new ImageIcon(getClass().getResource("iconos/robot.png"));
        Icon icono16 = new ImageIcon(getClass().getResource("imagenes/caliente.gif"));
        ImageIcon icono17 = new ImageIcon(getClass().getResource("iconos/cursor1.png"));
        ImageIcon icono18 = new ImageIcon(getClass().getResource("iconos/cursor2.png"));

        //Importar los cursores
        this.micursor = TK.createCustomCursor(icono17.getImage(), new Point(2, 2), "Cursor 01");
        this.micursor2 = TK.createCustomCursor(icono18.getImage(), new Point(2, 2), "Cursor 02");
        this.setCursor(micursor);

        //agregar imagenes a etiquetas
        ticket = new JLabel(icono8, SwingConstants.CENTER);
        imagen1 = new JLabel(icono1, SwingConstants.CENTER);
        imagen2 = new JLabel(icono2, SwingConstants.CENTER);
        people = new JLabel(iconopep, SwingConstants.CENTER);
        travel = new JLabel(icono5, SwingConstants.CENTER);
        anuncio = new JLabel(icono16, SwingConstants.CENTER);
        anuncio.setCursor(micursor2);
        linea12 = new JLabel(icono15, SwingConstants.CENTER);
        toñe = new JLabel(icono26, SwingConstants.CENTER);
        toñe.setCursor(micursor2);
        topicos = new JLabel(icono24, SwingConstants.CENTER);
        equipo = new JLabel(icono25, SwingConstants.CENTER);
        money = new JLabel(iconofirst, SwingConstants.CENTER);
        robot = new JLabel(rebot, SwingConstants.CENTER);
        //instanciar botonees
        comprar = new JButton(icono11);
        comprar.setRolloverIcon(icono12);
        comprar.setForeground(Color.black);
        comprar.setFocusPainted(false);
        comprar.setBorderPainted(false);
        comprar.setContentAreaFilled(false);
        comprar.setCursor(micursor2);

        informacion = new JButton(icono20);
        informacion.setRolloverIcon(icono21);
        informacion.setForeground(Color.black);
        informacion.setFocusPainted(false);
        informacion.setBorderPainted(false);
        informacion.setContentAreaFilled(false);
        informacion.setCursor(micursor2);

        generar = new JButton(icono22);
        generar.setRolloverIcon(icono23);
        generar.setForeground(Color.black);
        generar.setFocusPainted(false);
        generar.setBorderPainted(false);
        generar.setContentAreaFilled(false);
        generar.setCursor(micursor2);

        basedata = new JButton(iconodata1);
        basedata.setRolloverIcon(iconodata2);
        basedata.setForeground(Color.black);
        basedata.setFocusPainted(false);
        basedata.setBorderPainted(false);
        basedata.setContentAreaFilled(false);
        basedata.setCursor(micursor2);

        base = new JButton(iconodata3);
        base.setRolloverIcon(iconodata4);
        base.setForeground(Color.black);
        base.setFocusPainted(false);
        base.setBorderPainted(false);
        base.setContentAreaFilled(false);
        base.setCursor(micursor2);

        continuar = new JButton(icono9);
        continuar.setRolloverIcon(icono10);
        continuar.setForeground(Color.black);
        continuar.setFocusPainted(false);
        continuar.setBorderPainted(false);
        continuar.setContentAreaFilled(false);
        continuar.setCursor(micursor2);
        aceptar = new zBoton();
        aceptar.setPreferredSize(new Dimension(145, 50));
        aceptar.setCursor(micursor2);
        atras = new JButton(icono14);
        atras.setRolloverIcon(icono13);
        atras.setFocusPainted(false);
        atras.setBorderPainted(false);
        atras.setContentAreaFilled(false);
        atras.setCursor(micursor2);

        sig1 = new JButton(icono9);
        sig1.setRolloverIcon(icono10);
        sig1.setFocusPainted(false);
        sig1.setBorderPainted(false);
        sig1.setContentAreaFilled(false);
        sig1.setCursor(micursor2);

        sig3 = new JButton(icono9);
        sig3.setRolloverIcon(icono10);
        sig3.setFocusPainted(false);
        sig3.setBorderPainted(false);
        sig3.setContentAreaFilled(false);
        sig3.setCursor(micursor2);

        sig2 = new JButton(icono9);
        sig2.setRolloverIcon(icono10);
        sig2.setFocusPainted(false);
        sig2.setBorderPainted(false);
        sig2.setContentAreaFilled(false);
        sig2.setCursor(micursor2);

        back1 = new JButton(icono27);
        back1.setRolloverIcon(icono28);
        back1.setFocusPainted(false);
        back1.setBorderPainted(false);
        back1.setContentAreaFilled(false);
        back1.setCursor(micursor2);

        back2 = new JButton(icono27);
        back2.setRolloverIcon(icono28);
        back2.setFocusPainted(false);
        back2.setBorderPainted(false);
        back2.setContentAreaFilled(false);
        back2.setCursor(micursor2);

        atras2 = new JButton(icono14);
        atras2.setRolloverIcon(icono13);
        atras2.setFocusPainted(false);
        atras2.setBorderPainted(false);
        atras2.setContentAreaFilled(false);

        atras2.setCursor(micursor2);
//instanciar calendarios
        ida = new JDateChooser();
        ida.setPreferredSize(new Dimension(125, 25));
        vuelta = new JDateChooser();
        vuelta.setPreferredSize(new Dimension(125, 25));
        acepto = new zCheckBox();
        acepto.setFont(new Font("Serief", Font.PLAIN, 18));
        acepto.setText(" 🎧 NO soy un robot ");
        acepto.setCursor(micursor2);
        //asignar fecha minima a  los calendarios
        ida.setMinSelectableDate(new Date());
        vuelta.setMinSelectableDate(new Date());

        //instanciar panel 1
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
        panel1.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));

        //instanciar panel 2
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 3, 10, 10));
        panel2.setBackground(new Color(179, 206, 236));

        //instanciar panel3
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(3, 1, 10, 10));
        panel3.setBackground(new Color(179, 206, 236));

        //instanciar panel4
        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(3, 1, 40, 40));
        panel4.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));

        // instanciar panel5
        panel5 = new JPanel();
        panel5.setLayout(new GridLayout(3, 1, 40, 40));
        panel5.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));

        // instanciar panel6
        panel6 = new JPanel();
        panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel6.setBackground(new Color(170,213,247));

        // instanciar panel7
        panel7 = new JPanel();
        panel7.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
        panel7.setBackground(new  Color(152,192,246));

        // instanciar panel8
        panel8 = new JPanel();
        panel8.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 80));
        panel8.setBackground(Color.GREEN);

        // instanciar panel8
        panelrobot = new JPanel();
        panelrobot.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panelrobot.setBackground(new Color(133,152,214));
        // instanciar panel9
        panel9 = new JPanel();
        panel9.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 80));
        panel9.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));

        // instanciar panel10
        panel10 = new JPanel();
        panel10.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel10.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));

        // instanciar panel11
        panel11 = new JPanel();
        panel11.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 8));
        panel11.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));

        // instanciar panel12
        panel12 = new JPanel();
        panel12.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel12.setBackground(new Color(179, 206, 236));

        // instanciar panel13
        panel13 = new JPanel();
        panel13.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panel13.setBackground(new Color(179, 206, 236));

        // instanciar panel14
        panel14 = new JPanel();
        panel14.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panel14.setBackground(new Color(179, 206, 236));

        // instanciar panel15
        panel15 = new JPanel();
        panel15.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel15.setBackground(new Color(179, 206, 236));

        // instanciar panel16
        panel16 = new JPanel();
        panel16.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel16.setBackground(new Color(179, 206, 236));

        // instanciar panel17
        panel17 = new JPanel();
        panel17.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel17.setBackground(new Color(179, 206, 236));

        //asignar colores a los elementos
        listaorigen.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));
        listadestino.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));
        Economica.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));
        Premium.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));
        Primera_clase.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));
        cant_personas.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));
        acepto.setBackground(Color.getHSBColor(0.5000f, 0.1292f, 0.9412f));

        //agregar chismoso a lista de origen
        listaorigen.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evento) {
                if (evento.getStateChange() == ItemEvent.SELECTED) {
                    imagen1.setIcon(imagenes1[listaorigen.getSelectedIndex()]);

                }
            }
        });

        //agregar chismoso a lista destino
        listadestino.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evento) {
                if (evento.getStateChange() == ItemEvent.SELECTED) {
                    imagen2.setIcon(imagenes2[listadestino.getSelectedIndex()]);

                }
            }
        });

        //agregar chismoso a lista destino
        cant_personas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evento) {
                if (evento.getStateChange() == ItemEvent.SELECTED) {
                    people.setIcon(imagenes3[cant_personas.getSelectedIndex()]);

                }
            }
        });

        panel6.setPreferredSize(new Dimension(800, 70));
        panel7.setPreferredSize(new Dimension(800, 90));
        panelrobot.setPreferredSize(new Dimension(800, 90));
        panel11.setPreferredSize(new Dimension(800, 90));
        //agregar elemenstos a los paneles
        panel14.add(informacion);
        panel14.add(generar);
        panel14.add(basedata);
        panel2.add(panel12);
        panel13.add(vuelos);
        panel2.add(panel13);
        panel2.add(panel14);
        panelrobot.add(money);
        //  panel6.add(travel);
        panel1.add(travel);
        panel1.add(imagen2);

        panel1.add(imagen1);
        panel1.add(panel6);

        //agregar origen
        panel6.add(origen1);
        panel6.add(listaorigen);

        panel6.add(destino1);
        panel6.add(listadestino);
        //agregar destino
        /* panel7.add(destino1);
        panel7.add(listadestino);
        panel7.add(imagen2);*/

        //agregar fechas y eligidores de fecha
        panel6.add(fechas);
        panel6.add(etiqueta1);
        panel6.add(ida);
        panel6.add(etiqueta2);
        panel6.add(vuelta);

        panel1.add(panel7);
        panel1.add(panelrobot);
        //panel1.add(panel8);
        panel7.add(tclases);
        panel7.add(Primera_clase);
        panel7.add(Premium);
        panel7.add(Economica);
        panel7.add(robot);

        //agregar radiobutons a  grupo de botones 
        clases.add(Primera_clase);
        clases.add(Premium);
        clases.add(Economica);

//agregar cantidad de personas
        panel6.add(personas);
        panel6.add(cant_personas);
        panel6.add(people);
        panelrobot.add(acepto);
        panel11.add(atras2);
        panel11.add(back1);
        panel11.add(back2);
        panel11.add(comprar);

        //agregar sig
        panel11.add(sig1);
        panel11.add(sig2);
        panel11.add(sig3);
        panel1.add(panel11);

//agregar area de texto
        panel15.add(ticket);
        panel16.add(areaTexto);
        panel17.add(anuncio);

        panel3.add(panel15);
        panel3.add(panel16);
        panel3.add(panel17);

        linea10 = new JLabel(icono7, SwingConstants.CENTER);

        //agregar continuar y bienvenido
        panel4.add(linea10);
        panel9.add(bienvenido);
        panel10.add(continuar);
        panel4.add(panel9);
        panel4.add(panel10);

        //agregar gracias
        add(panel4, BorderLayout.CENTER);

        //elementos ocultos 
        aceptar.setVisible(false);
        comprar.setVisible(false);
        //panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        tclases.setVisible(false);
        Primera_clase.setVisible(false);
        Premium.setVisible(false);
        Economica.setVisible(false);
        personas.setVisible(false);
        cant_personas.setVisible(false);
        precio1.setVisible(false);
        precio2.setVisible(false);
        acepto.setVisible(false);
        travel.setVisible(false);
        atras2.setVisible(false);
        panel4.setVisible(true);
        destino1.setVisible(false);
        listadestino.setVisible(false);
        sig2.setVisible(false);
        sig3.setVisible(false);
        back2.setVisible(false);
        back1.setVisible(false);
        imagen2.setVisible(false);
        fechas.setVisible(false);
        people.setVisible(false);
        etiqueta1.setVisible(false);
        ida.setVisible(false);
        etiqueta2.setVisible(false);
        vuelta.setVisible(false);
        sig1.setVisible(true);
        money.setVisible(false);
        panel7.setVisible(false);
        panelrobot.setVisible(false);
        robot.setVisible(false);
        // base.setVisible(false);
        panel5.setVisible(true);
        //manejador de eventos de palomita
        ManejadorEvento manejador = new ManejadorEvento();
        comprar.addActionListener(manejador);

        //chismoso de boton continuar
        continuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                //agregar paneles
                add(panel2, BorderLayout.NORTH);
                add(panel3, BorderLayout.EAST);
                add(panel1, BorderLayout.CENTER);
                //volver visibles algunos elementos
                panel1.setVisible(true);
                panel2.setVisible(true);
                panel3.setVisible(true);
                panel4.setVisible(false);
                UIManager UI = new UIManager();

                UI.put("OptionPane.background", new Color(179, 206, 236));
                UI.put("Panel.background", new Color(179, 206, 236));

            }
        });

        //chismoso del boton informacion
        informacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {

                ticket.setVisible(false);
                areaTexto.setVisible(false);
                anuncio.setVisible(false);
                panel15.add(topicos);
                panel16.add(equipo);
                panel17.add(toñe);

                topicos.setVisible(true);
                equipo.setVisible(true);
                toñe.setVisible(true);
                aceptar.setVisible(false);
                panel17.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
            }
        });

        //boton de generar
        generar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                //agregar paneles
                ticket.setVisible(true);
                areaTexto.setVisible(true);
                anuncio.setVisible(true);

                topicos.setVisible(false);
                equipo.setVisible(false);
                toñe.setVisible(false);
                aceptar.setVisible(true);
                panel17.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
            }
        });

        //chismoso de boton siguiente
        sig1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {

                //volver invisibles algunos elementos
                origen1.setVisible(false);
                listaorigen.setVisible(false);
                imagen1.setVisible(false);
                sig1.setVisible(false);
                destino1.setVisible(true);
                listadestino.setVisible(true);
                imagen2.setVisible(true);
                sig2.setVisible(true);
                back1.setVisible(true);
                //sig2.setVisible(false);

            }
        });

        //chismoso de boton siguiente
        sig2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {

                //volver invisibles algunos elementos
                sig1.setVisible(false);
                sig2.setVisible(false);
                back1.setVisible(false);
                destino1.setVisible(false);
                listadestino.setVisible(false);
                imagen2.setVisible(false);
                travel.setVisible(true);
                sig3.setVisible(true);
                back2.setVisible(true);
                panel7.setVisible(true);

                fechas.setVisible(true);
                etiqueta1.setVisible(true);
                ida.setVisible(true);
                etiqueta2.setVisible(true);
                vuelta.setVisible(true);

                tclases.setVisible(true);
                Primera_clase.setVisible(true);
                Premium.setVisible(true);
                Economica.setVisible(true);
                panelrobot.setVisible(true);
                money.setVisible(true);
                robot.setVisible(false);
                acepto.setVisible(false);
                panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));
                panel7.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));
                panelrobot.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
                panel6.setPreferredSize(new Dimension(800, 113));
                panel7.setPreferredSize(new Dimension(800, 113));
                panelrobot.setPreferredSize(new Dimension(800, 110));
            }
        });

        sig3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {

                //travel.setVisible(false);
                sig3.setVisible(false);
                back2.setVisible(false);
                // panel7.setVisible(false);

                fechas.setVisible(false);
                etiqueta1.setVisible(false);
                ida.setVisible(false);
                etiqueta2.setVisible(false);
                vuelta.setVisible(false);

                tclases.setVisible(false);
                Primera_clase.setVisible(false);
                Premium.setVisible(false);
                Economica.setVisible(false);
                money.setVisible(false);
                personas.setVisible(true);
                cant_personas.setVisible(true);
                people.setVisible(true);
                acepto.setVisible(true);
                robot.setVisible(true);
                panelrobot.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));
                panel7.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
                atras2.setVisible(true);
            }
        });

        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {

                //volver invisibles algunos elementos
                origen1.setVisible(true);
                listaorigen.setVisible(true);
                imagen1.setVisible(true);
                sig1.setVisible(true);
                destino1.setVisible(false);
                listadestino.setVisible(false);
                imagen2.setVisible(false);
                sig2.setVisible(false);
                back1.setVisible(false);

            }
        });

        back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {

                //volver invisibles algunos elementos
                destino1.setVisible(true);
                listadestino.setVisible(true);
                imagen2.setVisible(true);
                sig2.setVisible(true);
                back1.setVisible(true);
                sig3.setVisible(false);
                back2.setVisible(false);
                travel.setVisible(false);
                panel7.setVisible(false);

                tclases.setVisible(false);
                Primera_clase.setVisible(false);
                Premium.setVisible(false);
                Economica.setVisible(false);

                fechas.setVisible(false);
                etiqueta1.setVisible(false);
                ida.setVisible(false);
                etiqueta2.setVisible(false);
                vuelta.setVisible(false);

                panelrobot.setVisible(false);
                money.setVisible(true);
                panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
                panel7.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
                panel6.setPreferredSize(new Dimension(800, 70));
                panel7.setPreferredSize(new Dimension(800, 90));
                panelrobot.setPreferredSize(new Dimension(800, 90));

            }
        });

        //chismoso de boton atras 2
        atras2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                sig3.setVisible(true);
                back2.setVisible(true);
                // panel7.setVisible(false);

                fechas.setVisible(true);
                etiqueta1.setVisible(true);
                ida.setVisible(true);
                etiqueta2.setVisible(true);
                vuelta.setVisible(true);

                tclases.setVisible(true);
                Primera_clase.setVisible(true);
                Premium.setVisible(true);
                Economica.setVisible(true);
                money.setVisible(true);
                personas.setVisible(false);
                cant_personas.setVisible(false);
                people.setVisible(false);
                atras2.setVisible(false);
                acepto.setVisible(false);
                robot.setVisible(false);
                acepto.setSelected(false);
                panelrobot.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
                panel7.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));
            }
        });
        //chismoso de boton comprar
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                //agregar paneles
                Connection conexion = null;
                Statement intruccion = null;
                ResultSet consulta = null;
                //Conexion a la BD
                consultatexto = "";
                //interfaz..setText(consultatexto);

                Icon icono19 = new ImageIcon(getClass().getResource(""
                        + "iconos/visa.png"));
                //agregar input de tarjeta de crediuto

                Object tarjeta = JOptionPane.showInputDialog(null, "Seleccione su Tarjeta de Credito", "✈TRAVEL",
                        JOptionPane.DEFAULT_OPTION, icono19, tarjetas, tarjetas[0]);

                try {
                    tarjeta.toString();
                    Icon icono20 = new ImageIcon(getClass().getResource(""
                            + "iconos/cancel.png"));
                    if (tarjeta.equals("")) {
                        JOptionPane.showMessageDialog(null, "Su compra no puede proceder", "✈TRAVEL",
                                JOptionPane.DEFAULT_OPTION, icono20);
                    } else {

                        //volver invisibleas algunos elementos
                        panel1.setVisible(false);
                        panel2.setVisible(false);
                        panel3.setVisible(false);
                        panel4.setVisible(true);

                        //eliminar algunas cosas del panel
                        panel4.remove(linea10);
                        panel9.remove(bienvenido);
                        panel10.remove(continuar);
                        panel4.remove(panel9);
                        panel4.remove(panel8);
                        panel4.remove(panel10);

                        panel4.add(linea12);
                        linea12.setVisible(true);
                        panel10.add(atras);
                        panel10.add(base);
                        panel9.add(gracias);
                        panel4.add(panel9);
                        panel4.add(panel10);

                        gracias.setText(" 📜Gracias Por Comprar en TRAVEL se Hizo el Cargo a su Tarjeta : "
                                + tarjeta + " "
                                + "\nel total de $"
                                + preciototal + ".0MXN");

                        gracias.setVisible(true);
                        //  base.setVisible(true);
                    }

                } catch (Exception e) {
                }
            }
        });
        //chismoso de atras
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                //agregar paneles
                linea12.setVisible(false);
                panel5.setVisible(false);
                panel1.setVisible(true);
                panel2.setVisible(true);
                panel3.setVisible(true);
                panel4.setVisible(false);
                // base.setVisible(false);
                panel10.remove(base);
                panel5.remove(linea12);
                panel5.remove(panel12);
                panel5.remove(panel13);
            }
        });

        //boton para abrir base de datos
        basedata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                //contraseña    
                String contra = JOptionPane.showInputDialog(null, "Root", "✈TRAVEL",
                        JOptionPane.WARNING_MESSAGE);

                if (contra != null && contra.equals("123")) {
                    interfaz = new Interfaz();

                    interfaz.setSize(1130, 740);
                    interfaz.setMinimumSize(new Dimension(1120, 740));
                    //desactivamos el redimensionar la ventana
                    interfaz.setResizable(false);
                    interfaz.setVisible(true);
                }

                if (!"123".equals(contra) && contra != null) {
                    JOptionPane.showMessageDialog(null,
                            "Contraseña Incorrecta", "✈TRAVEL",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        //boton para abri base de datos al final
        base.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                //contraseña

                String contra = JOptionPane.showInputDialog(null, "Root", "✈TRAVEL",
                        JOptionPane.WARNING_MESSAGE);

                if (contra != null && contra.equals("123")) {
                    interfaz = new Interfaz();

                    interfaz.setSize(1130, 740);
                    interfaz.setMinimumSize(new Dimension(1120, 740));
                    //desactivamos el redimensionar la ventana
                    interfaz.setResizable(false);
                    interfaz.setVisible(true);
                }

                if (!"123".equals(contra) && contra != null) {
                    JOptionPane.showMessageDialog(null,
                            "Contraseña Incorrecta", "✈TRAVEL",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        Premium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                //agregar paneles
                if (Premium.isSelected()) {
                    money.setIcon(iconopremium);
                }
            }
        });

        Primera_clase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                //agregar paneles
                if (Primera_clase.isSelected()) {
                    money.setIcon(iconofirst);
                }
            }
        });

        Economica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                //agregar paneles
                if (Economica.isSelected()) {
                    money.setIcon(icono29);
                }
            }
        });

        //instanciar chismoso de checkbox
        ManejadorCB manejador2 = new ManejadorCB();
        acepto.addItemListener(manejador2);
        //chiismoso toñe
        toñe.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
//enviar al navegador caso toñe
                    Desktop.getDesktop().browse(new URI("https://tinder.com/es"));

                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // the mouse has exited the label
            }
        });

        //chismoso anuncio
        anuncio.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
//enviar al navegador caso mane
                    Desktop.getDesktop().browse(new URI
        ("https://www.caliente.mx/ofertas/apuestas-deportivas/"));
                    

                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // the mouse has exited the label
            }
        });
        //agragar key listenner
        addKeyListener(this);
        //agregar keylistener a palomita
        comprar.addKeyListener(this);
        atras2.addKeyListener(this);

    }
// 

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {

    }

    //key listenner de cuando presionamos ctrl+x
    @Override
    public void keyPressed(KeyEvent evento) {
        if (evento.isControlDown() && evento.getKeyCode() == KeyEvent.VK_X) {
            areaTexto.setText("EL TICKET SE GENERA AQUI \n(control+x para limpiar el Texto)");
        }

    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {

    }

    //chismoso de palomita
    public class ManejadorEvento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            precio calcularprecio = new precio();
            try {
                if (preciototal == 0) {
                    usuario = JOptionPane.showInputDialog(null, "Ingrese su nombre y apellido", "✈TRAVEL",
                            JOptionPane.INFORMATION_MESSAGE);

                    /**
                     *
                     * @param var1
                     */
                    //crear nueva fecha  y asignarle la escogida por el usuario en ñla fecha ida
                    Date fecha = ida.getDate();
                    DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                    String fecha2 = f.format(fecha);

                    //crear nueva fecha  y asignarle la escogida por el usuario en ñla fecha vuelta
                    Date fecha3 = vuelta.getDate();
                    DateFormat g = new SimpleDateFormat("dd-MM-yyyy");
                    String fecha4 = g.format(fecha3);

                    //boletos
                    int precioorigen = 0;
                    String origen = origenes[listaorigen.getSelectedIndex()];
                    int precio1 = calcularprecio.origen(origen, precioorigen);

                    //boletos
                    int preciodestino = 0;
                    String destino = destinos[listadestino.getSelectedIndex()];
                    int precio2 = calcularprecio.destino(destino, preciodestino);
                    //calcular cantidad
                    int cantidad = 0;
                    cantidad = Integer.parseInt(persona[cant_personas.getSelectedIndex()]);

                    String selecion = "";
                    selecion = clases.getSelection().getActionCommand();

                    int tipo = 0;

                    if (Premium.isSelected()) {
                        selecion = "Premium";
                        tipo = 1;

                    } else if (Primera_clase.isSelected()) {
                        selecion = "Priemera Clase";
                        tipo = 2;

                    } else if (Economica.isSelected()) {

                        selecion = "Clase Economica";
                        tipo = 3;

                    }

                    //calcular el precio final
                    preciototal = calcularprecio.Preciofinal(tipo, precio1, precio2, cantidad, preciototal);

                    //imprimir los valores en el text area
                    areaTexto.setText("☑📜📜PASE DE  ABORDAJE📜📜☑ \n\n"
                            + "🕑FECHA IDA: " + fecha2 + "\n🕑FECHA VUELTA: " + fecha4 + "\n\n🗻ORIGEN: "
                            + origenes[listaorigen.getSelectedIndex()]
                            + "\n🚩DESTINO: " + destinos[listadestino.getSelectedIndex()] + "\n\n💍TIPO DE CLASE:  "
                            + selecion
                            + "\n🚹CANTIDAD:  "
                            + persona[cant_personas.getSelectedIndex()] + "\n\n💰PRECIO TOTAL: 💲" + preciototal +
                            ".0MXN");

                    String textoorigen = origenes[listaorigen.getSelectedIndex()];
                    String txtorigen = textoorigen.substring(0, textoorigen.length() - 2);

                    String textodestino = destinos[listadestino.getSelectedIndex()];
                    String txtdestino = textodestino.substring(0, textodestino.length() - 2);

//asignarle el icono a un JOptionPane
                    Icon icono18 = new ImageIcon(getClass().getResource(""
                            + "iconos/ticket.png"));
                    JOptionPane.showMessageDialog(null, "Su ticket Se HA GENERADO ✈", "✈TRAVEL",
                            JOptionPane.DEFAULT_OPTION, icono18);
                    //agregar boton de comprar
                    ticket.setVisible(true);
                    areaTexto.setVisible(true);
                    anuncio.setVisible(true);

                    topicos.setVisible(false);
                    equipo.setVisible(false);
                    toñe.setVisible(false);

                    panel17.add(aceptar);

                    // panel3.add(panel12);
                    panel17.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 60));
                    aceptar.setVisible(true);
             
                    panel17.remove(anuncio);//}
//asignar id con math random
                    int idNumero1 = (int) (Math.random() * 1000 + 10);

                    if (idNumero1 != 0) {
                        //int idNumero = Integer.valueOf(idNumero1);
                        Connection conexion = null;
                        PreparedStatement intruccion = null;

                        int cant = Integer.parseInt(persona[cant_personas.getSelectedIndex()]);
                        //Conexion a la BD
                        try {
                            //Cargar el controlador
                            Class.forName(CONTROLADOR);
                            //Establecer la conexion
                            conexion = (Connection) DriverManager.getConnection(URL_BD, USER, PASS);

                            intruccion = conexion.prepareStatement
        ("INSERT INTO registro VALUES(?,?,?,?,?,?,?,?,?)");

                            intruccion.setInt(1, idNumero1);
                            intruccion.setString(2, usuario);
                            intruccion.setString(3, txtorigen);
                            intruccion.setString(4, txtdestino);
                            intruccion.setString(5, fecha2);
                            intruccion.setString(6, fecha4);
                            intruccion.setString(7, selecion);
                            intruccion.setInt(8, cant);
                            intruccion.setInt(9, preciototal);

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

                } else {
                    preciototal = 0;
                    Icon icono17 = new ImageIcon(getClass().getResource(""
                            + "iconos/browser.png"));
                    JOptionPane.showMessageDialog(null,
                            "Por favor limpia el ticket para generar uno nuevo", "✈TRAVEL",
                            JOptionPane.DEFAULT_OPTION, icono17);
                }
                /**/
            } catch (Exception e) {
            }
        }

    }

    //chismoso del checkbox
    private class ManejadorCB implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent evento) {
            Icon iconorobot = new ImageIcon(getClass().getResource("iconos/robot.png"));
            Icon iconoh = new ImageIcon(getClass().getResource("iconos/happy.png"));
            //si el checkbox es selecionado mostrar el boton de aceptar
            if (acepto.isSelected() == true) {
                comprar.setVisible(true);
                robot.setIcon(iconoh);
            }

            if (acepto.isSelected() == false) {
                comprar.setVisible(false);
                robot.setIcon(iconorobot);
            }
        }

    }
}
