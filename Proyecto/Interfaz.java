package Java.Objetos.CORTE_4.Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Interfaz extends JFrame implements MouseListener {

    //variables
    String User_name, User_lastname, User_phone, pedidotipo, pago;
    LocalDateTime fecha;
    int cantidad_productos, User_id, codigo;
    double suma;
    Cliente unicocliente;
    GridLayout posicion = new GridLayout(4, 4);
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd                                HH:mm:ss");
    LocalDateTime ahora = LocalDateTime.now();

    // botones e imagenes de bebidas
    JButton frias1, frias2;
    ImageIcon cocacola, descripcioncocacola, jugo, descripcionjugo;
    JButton caliente1, caliente2;
    ImageIcon capuchino, descripcioncapuchino, chocolate, descripcionchocolate;

    // botones e imagenes de postres
    JButton postre1, postre2, postre3, postre4;
    ImageIcon mousse, pie, petit, yogurt;
    ImageIcon descripcionmousse, descripcionpie, descripcionpetit, descripcionyogurt;

    // botones e imagenes de platos
    JButton fuerte1, fuerte2, fuerte3, fuerte4;
    ImageIcon Costillas, descripcioncostillas, hamburguesa, descripcionhaburtguesa, salmon, descripcionsalmon, spaghetti, descripcionsepaghetti;
    JButton entrada1, entrada2, entrada3, entrada4;
    ImageIcon ceviche, descripcionceviche, empanadas, descripcionempanadas, nachos, descripcionnachos, patacones, descripcionpatacones;

    // componentes menu
    JMenuBar barra;
    JMenu menu_principal;
    JMenuItem item_Registro;
    JTextField Nombre, Apellido, Id, Telefono;
    JButton registro;
    Choice tipo_de_pedido, tipo_de_pago;

    // llamada DE CLASES
    Producto[] productos;
    Pedido pedidito;
    int i = 0;
    String impresiones;
    Boolean permiso = false;    

    public Interfaz() {

        // Creacion del cuadro
        setTitle("RESTAURANTE GOURMET BOGOTA"); //TITULO
        setSize(2000, 2000);
        setLayout(posicion);
        posicion.setHgap(4);//Para separar botones Horizontal
        posicion.setVgap(4);//Para separar botones Vertical

        setResizable(true);//Redimensionable

        // Cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // menu

        // Creacion del menu
        barra = new JMenuBar();
        menu_principal = new JMenu("Menu");
        Nombre = new JTextField("Nombre");
        Apellido = new JTextField("Apellido");
        Id = new JTextField("ID");
        Telefono = new JTextField("Telefono");
        tipo_de_pago = new Choice();
        tipo_de_pago.addItem("Efectivo");
        tipo_de_pago.addItem("Tarjeta");
        tipo_de_pago.addItem("Transferencia");
        tipo_de_pedido = new Choice();
        tipo_de_pedido.addItem("Domicilio");
        tipo_de_pedido.addItem("Mesa");
        registro = new JButton("Registrar         ");// El espacio para que el boton no sea pequeño

        // añadir el menu
        barra.add(menu_principal);
        menu_principal.add(Nombre);
        menu_principal.add(Apellido);
        menu_principal.add(Id);
        menu_principal.add(Telefono);
        menu_principal.add(tipo_de_pago);
        menu_principal.add(tipo_de_pedido);
        menu_principal.add(registro);

        setJMenuBar(barra);

        // AdctionListener activacion
        Nombre.addActionListener(this::actionPerformed);
        Apellido.addActionListener(this::actionPerformed);
        Id.addActionListener(this::actionPerformed);
        Telefono.addActionListener(this::actionPerformed);
        registro.addActionListener(this::actionPerformed);
        
        //OBTENER EL ITEM SELECCIONADO
        pedidotipo = tipo_de_pedido.getSelectedItem();
        pago = tipo_de_pago.getSelectedItem();

        // Muestro JFrame (lo último para que lo pinte todo correctamanete)
        setVisible(true);

        // imagenes bebidas
        cocacola = new ImageIcon(getClass().getResource("ImagenesMenu/Bebidas/Cocacola.jpg"));
        descripcioncocacola = new ImageIcon(getClass().getResource("ImagenesMenu/Bebidas/CocacolaNegro.jpg"));
        jugo = new ImageIcon(getClass().getResource("ImagenesMenu/Bebidas/JugoNaranja.jpg"));
        descripcionjugo = new ImageIcon(getClass().getResource("ImagenesMenu/Bebidas/JugoNaranjaNegro.jpg"));
        descripcioncapuchino = new ImageIcon(getClass().getResource("ImagenesMenu/Bebidas/Capuchino.jpg"));
        capuchino = new ImageIcon(getClass().getResource("ImagenesMenu/Bebidas/capuchino-casero.jpg"));
        descripcionchocolate = new ImageIcon(getClass().getResource("ImagenesMenu/Bebidas/Chocolate.jpg"));
        chocolate = new ImageIcon(getClass().getResource("ImagenesMenu/Bebidas/chocolatecaliente.jpg"));
        // botones bebidas
        frias1 = new JButton("fria1");
        frias1.setIcon(new ImageIcon(cocacola.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH))); //Para acomodar el tamaño de la imagen
        add(frias1);
        frias1.addMouseListener(this);
        frias2 = new JButton("fria2");
        frias2.setIcon(new ImageIcon(jugo.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(frias2);
        frias2.addMouseListener(this);

        caliente1 = new JButton("caliente 1");
        caliente1.setIcon(new ImageIcon(capuchino.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(caliente1);
        caliente1.addMouseListener(this);
        caliente2 = new JButton("Boton 2");
        caliente2.setIcon(new ImageIcon(chocolate.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(caliente2);
        caliente2.addMouseListener(this);

        // imagenes postres
        mousse = new ImageIcon(getClass().getResource("ImagenesMenu/Postres/moussecava.jpg"));
        pie = new ImageIcon(getClass().getResource("ImagenesMenu/Postres/pai-de-manzana.jpg"));
        petit = new ImageIcon(getClass().getResource("ImagenesMenu/Postres/petit.jpg"));
        descripcionyogurt = new ImageIcon(getClass().getResource("ImagenesMenu/Postres/yogurt.jpg"));
        descripcionmousse = new ImageIcon(getClass().getResource("ImagenesMenu/Postres/mousseCavaNegro.jpg"));
        descripcionpie = new ImageIcon(getClass().getResource("ImagenesMenu/Postres/paiManzanaNEGRO.jpg"));
        descripcionpetit = new ImageIcon(getClass().getResource("ImagenesMenu/Postres/petitNegro.jpg"));
        yogurt = new ImageIcon(getClass().getResource("ImagenesMenu/Postres/yogurt-helado-con-cerezas-1.jpg"));

        // botones postres
        postre1 = new JButton("postre 1");
        postre1.setIcon(new ImageIcon(mousse.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(postre1);
        postre1.addMouseListener(this);

        postre2 = new JButton("postre 2");
        postre2.setIcon(new ImageIcon(pie.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(postre2);
        postre2.addMouseListener(this);

        postre3 = new JButton("postre 3");
        postre3.setIcon(new ImageIcon(petit.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(postre3);
        postre3.addMouseListener(this);

        postre4 = new JButton("postre 4");
        postre4.setIcon(new ImageIcon(yogurt.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(postre4);
        postre4.addMouseListener(this);

        // imagenes platos
        Costillas = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Fuertes/Costillitas.jpg"));
        descripcioncostillas = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Fuertes/CostillitasNegro.jpg"));
        hamburguesa = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Fuertes/hamburguesa.jpg"));
        descripcionhaburtguesa = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Fuertes/HamburguesaNegro.jpg"));
        salmon = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Fuertes/salmon.jpg"));
        descripcionsalmon = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Fuertes/SalmonNegro.jpg"));
        spaghetti = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Fuertes/spaghetti.jpg"));
        descripcionsepaghetti = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Fuertes/spaghettiNegro.jpg"));
        ceviche = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Entradas/Ceviche.jpg"));
        descripcionceviche = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Entradas/CevicheNEGRO.jpg"));
        descripcionempanadas = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Entradas/Empanadas.jpg"));
        empanadas = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Entradas/EmpanadasImg.jpg"));
        nachos = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Entradas/nachos-con-queso.jpg"));
        descripcionnachos = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Entradas/nachos.jpg"));
        patacones = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Entradas/patacones.jpg"));
        descripcionpatacones = new ImageIcon(getClass().getResource("ImagenesMenu/Platos/Entradas/pataconesNegro.jpg"));

        // botones platos
        fuerte1 = new JButton("fuerte 1");
        fuerte1.setIcon(new ImageIcon(Costillas.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(fuerte1);
        fuerte1.addMouseListener(this);
        fuerte2 = new JButton("Boton 2");
        fuerte2.setIcon(new ImageIcon(hamburguesa.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(fuerte2);
        fuerte2.addMouseListener(this);
        fuerte3 = new JButton("Boton 3");
        fuerte3.setIcon(new ImageIcon(salmon.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(fuerte3);
        fuerte3.addMouseListener(this);
        fuerte4 = new JButton("Boton 4");
        fuerte4.setIcon(new ImageIcon(spaghetti.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(fuerte4);
        fuerte4.addMouseListener(this);

        entrada1 = new JButton("entrada 1");
        entrada1.setIcon(new ImageIcon(ceviche.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(entrada1);
        entrada1.addMouseListener(this);
        entrada2 = new JButton("Boton 2");
        entrada2.setIcon(new ImageIcon(empanadas.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(entrada2);
        entrada2.addMouseListener(this);
        entrada3 = new JButton("Boton 3");
        entrada3.setIcon(new ImageIcon(nachos.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(entrada3);
        entrada3.addMouseListener(this);
        entrada4 = new JButton("Boton 4");
        entrada4.setIcon(new ImageIcon(patacones.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        add(entrada4);
        entrada4.addMouseListener(this);

        setVisible(true);

        // creacion del codigo para el pedido
        Random objetorandom = new Random();
        int valoraleatorio = objetorandom.nextInt(4) + 1;

        codigo = valoraleatorio;

        //Creacion de objeto pedido.
        pedidito = new Pedido(codigo, ahora, pedidotipo, pago);

    }

    public void actionPerformed(ActionEvent e) {//Accion 
        if (e.getSource() == Nombre) {
            User_name = Nombre.getText();//pasar de JTextField a String

        }
        if (e.getSource() == Apellido) {
            User_lastname = Apellido.getText();//pasar de JTextField a String

        }
        if (e.getSource() == Telefono) {
            User_phone = Telefono.getText();//pasar de JTextField a String

        }
        if (e.getSource() == Id) {
            User_id = Integer.parseInt(Id.getText());//pasar de JTextField a Int

        }
        if (e.getSource() == registro) {
            unicocliente = new Cliente(User_name, User_lastname, User_phone, User_id);//Creacion del objeto cliente 
            JOptionPane.showMessageDialog(null, "Se registro el cliente");//ventana emergente que avisa que se creo el objeto cliente
            String cant_productos = JOptionPane.showInputDialog("Cuantos productos desea ordenar? : "); //solicitar numero para crear tamaño de lista
            //Todo en true, para que se puedan utilizar los botones
            frias1.setEnabled(true);
            frias2.setEnabled(true);
            caliente1.setEnabled(true);
            caliente2.setEnabled(true);
            entrada1.setEnabled(true);
            entrada2.setEnabled(true);
            entrada3.setEnabled(true);
            entrada4.setEnabled(true);
            fuerte1.setEnabled(true);
            fuerte2.setEnabled(true);
            fuerte3.setEnabled(true);
            fuerte4.setEnabled(true);
            postre1.setEnabled(true);
            postre2.setEnabled(true);
            postre3.setEnabled(true);
            postre4.setEnabled(true);
            //Se pasa de String a int lo escrito en el JOptionPane
            cantidad_productos = Integer.parseInt(cant_productos);
            productos = new Producto[cantidad_productos];//Uso con tamaño definido de la lista
            pedidito.cliente1 = unicocliente; // relacion
            permiso = true;//Perimso es la variable que permitira o no que se ejecuten losclick si registro o no un cliente

        }

    }

    public void mouseClicked(MouseEvent e) {//Accion de Mouse

        if (permiso == true) {//Condicional para que puedan utilizarse botones

            if (i != cantidad_productos) {//Condicional para que no se puedan presionar mas botones despues de llenar la lista

                // eventos bebidas

                if (e.getSource() == frias1) {//Eventos para clickear los botones y que se agregen a la lista
                    JOptionPane.showMessageDialog(null, "se agrego cocacola al pedido");//Ventana Emergente avisa que se agrego el producto.
                    productos[i] = new Bebida("Bebida", "Coca-Cola", 2500, "Fria");//Producto en la posicion i.
                    suma = suma + productos[i].Valor; //Sumatoria para tener el valor total de los productos.
                    pedidito.producto1 = productos[i];//relacion de la clase producto con pedido.
                    i++;// variable i aunmentada para que se vaya recorriendo la lista con cada click.
                }
                if (e.getSource() == frias2) {//Se repite lo anterior con cada boton
                    JOptionPane.showMessageDialog(null, "se agrego jugo de naranja al pedido");
                    productos[i] = new Bebida("Bebida", "Jugo de naranja", 2000, "Fria");
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }
                if (e.getSource() == caliente1) {
                    JOptionPane.showMessageDialog(null, "se agrego capuchino al pedido");
                    productos[i] = new Bebida("Bebida", "Capuchino", 3000, "Caliente");
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }
                if (e.getSource() == caliente2) {
                    JOptionPane.showMessageDialog(null, "se agrego chocolate al pedido");
                    productos[i] = new Bebida("Bebida", "Chocolate", 1200, "Caliente");
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }

                // eventos postres

                if (e.getSource() == postre1) {
                    JOptionPane.showMessageDialog(null, "se agrego mousse al pedido");
                    productos[i] = new Postre("Postre", "Mousse de Cava", 10000, 210);
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                } else if (e.getSource() == postre2) {
                    JOptionPane.showMessageDialog(null, "se agrego pai al pedido");
                    productos[i] = new Postre("Postre", "Pai de manzana", 9700, 237);
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }
                if (e.getSource() == postre3) {
                    JOptionPane.showMessageDialog(null, "se agrego petit al pedido");
                    productos[i] = new Postre("Postre", "Petit de chocolate", 9000, 210);
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }
                if (e.getSource() == postre4) {
                    JOptionPane.showMessageDialog(null, "se agrego helado de yogurt al pedido");
                    productos[i] = new Postre("Postre", "Helado de cerezas y yogurt", 8000, 300);
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }

                // eventos platos

                if (e.getSource() == fuerte1) {
                    JOptionPane.showMessageDialog(null, "se agrego Costillitas al pedido");
                    productos[i] = new Plato("Plato", "Costillitas glaseadas", 25000, "Plato Fuerte");
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }
                if (e.getSource() == fuerte2) {
                    JOptionPane.showMessageDialog(null, "se agrego hamburguesa al pedido");
                    productos[i] = new Plato("Plato", "Hamburguesa de Res Clasica", 20000, "Plato Fuerte");
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }
                if (e.getSource() == fuerte3) {
                    JOptionPane.showMessageDialog(null, "se agrego salmon al pedido");
                    productos[i] = new Plato("Plato", "Salmon Balsamico", 23000, "Plato Fuerte");
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }
                if (e.getSource() == fuerte4) {
                    JOptionPane.showMessageDialog(null, "se agrego spaghetti al pedido");
                    productos[i] = new Plato("Plato", "Spaghetti a la bologñesa", 18000, "Plato Fuerte");
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }
                if (e.getSource() == entrada1) {
                    JOptionPane.showMessageDialog(null, "se agrego ceviche al pedido");
                    productos[i] = new Plato("Plato", "Ceviche", 10000, "Entrada");
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }
                if (e.getSource() == entrada2) {
                    JOptionPane.showMessageDialog(null, "se agrego empanadas al pedido");
                    productos[i] = new Plato("Plato", "Empanadas x 6", 7000, "Entrada");
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }
                if (e.getSource() == entrada3) {
                    JOptionPane.showMessageDialog(null, "se agrego nachos al pedido");
                    productos[i] = new Plato("Plato", "Nachos con queso", 6000, "Entrada");
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }
                if (e.getSource() == entrada4) {
                    JOptionPane.showMessageDialog(null, "se agrego patacones al pedido");
                    productos[i] = new Plato("Plato", "Patacones", 6000, "Entrada");
                    suma = suma + productos[i].Valor;
                    pedidito.producto1 = productos[i];
                    i++;
                }
            } else {// Condicion en la cual entra cuando la lista de productos queda completa.
                //Todo se pone en Enabled(false) para que se desactiven los botones
                //de esta forma no puede ingresar productos a la lista
                frias1.setEnabled(false);
                frias2.setEnabled(false);
                caliente1.setEnabled(false);
                caliente2.setEnabled(false);
                entrada1.setEnabled(false);
                entrada2.setEnabled(false);
                entrada3.setEnabled(false);
                entrada4.setEnabled(false);
                fuerte1.setEnabled(false);
                fuerte2.setEnabled(false);
                fuerte3.setEnabled(false);
                fuerte4.setEnabled(false);
                postre1.setEnabled(false);
                postre2.setEnabled(false);
                postre3.setEnabled(false);
                postre4.setEnabled(false);
                //Utilizacion del metodo imprimir despues de llenar la lista
                imprimir();
                //System exit para cerrar el programa luego de que se ejecite el metodo imprimir.
                System.exit(0);
            }
        } else {//Condicional para que no utilicen los botones sin antes registrar un usuario
            //todo deshabilitado para que no sirvan los clicks
            frias1.setEnabled(false);
            frias2.setEnabled(false);
            caliente1.setEnabled(false);
            caliente2.setEnabled(false);
            entrada1.setEnabled(false);
            entrada2.setEnabled(false);
            entrada3.setEnabled(false);
            entrada4.setEnabled(false);
            fuerte1.setEnabled(false);
            fuerte2.setEnabled(false);
            fuerte3.setEnabled(false);
            fuerte4.setEnabled(false);
            postre1.setEnabled(false);
            postre2.setEnabled(false);
            postre3.setEnabled(false);
            postre4.setEnabled(false);

        }
    }

    @Override//Metodo obligatoria de la clase MouseListener
    public void mousePressed(MouseEvent e) {

    }

    @Override//Metodo obligatoria de la clase MouseListener
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {//Clase que se usa para cuando se pasa el cursor del mouse sobre algo.
        // eventos bebidas
        if (e.getSource() == frias1) {//Si pasa por el boton x, se activa la imagen dentro del condicional.
            frias1.setIcon(new ImageIcon(descripcioncocacola.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == frias2) {
            frias2.setIcon(new ImageIcon(descripcionjugo.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == caliente1) {
            caliente1.setIcon(new ImageIcon(descripcioncapuchino.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == caliente2) {
            caliente2.setIcon(new ImageIcon(descripcionchocolate.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        // eventos postres
        if (e.getSource() == postre1) {
            postre1.setIcon(new ImageIcon(descripcionmousse.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == postre2) {
            postre2.setIcon(new ImageIcon(descripcionpie.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == postre3) {
            postre3.setIcon(new ImageIcon(descripcionpetit.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == postre4) {
            postre4.setIcon(new ImageIcon(descripcionyogurt.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        // eventos platos
        if (e.getSource() == fuerte1) {
            fuerte1.setIcon(new ImageIcon(descripcioncostillas.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == fuerte2) {
            fuerte2.setIcon(new ImageIcon(descripcionhaburtguesa.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == fuerte3) {
            fuerte3.setIcon(new ImageIcon(descripcionsalmon.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == fuerte4) {
            fuerte4.setIcon(new ImageIcon(descripcionsepaghetti.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == entrada1) {
            entrada1.setIcon(new ImageIcon(descripcionceviche.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == entrada2) {
            entrada2.setIcon(new ImageIcon(descripcionempanadas.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == entrada3) {
            entrada3.setIcon(new ImageIcon(descripcionnachos.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == entrada4) {
            entrada4.setIcon(new ImageIcon(descripcionpatacones.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) { //Metodo usado para cuando deja de tocar la imagen con el cursor del mouse
        // eventos bebidas
        if (e.getSource() == frias1) {// Si deja de tocar el boton x, vuelve la imagen principal
            frias1.setIcon(new ImageIcon(cocacola.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == frias2) {
            frias2.setIcon(new ImageIcon(jugo.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == caliente1) {
            caliente1.setIcon(new ImageIcon(capuchino.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == caliente2) {
            caliente2.setIcon(new ImageIcon(chocolate.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        // eventos postres
        if (e.getSource() == postre1) {
            postre1.setIcon(new ImageIcon(mousse.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == postre2) {
            postre2.setIcon(new ImageIcon(pie.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == postre3) {
            postre3.setIcon(new ImageIcon(petit.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == postre4) {
            postre4.setIcon(new ImageIcon(yogurt.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        // eventos platos
        if (e.getSource() == fuerte1) {
            fuerte1.setIcon(new ImageIcon(Costillas.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == fuerte2) {
            fuerte2.setIcon(new ImageIcon(hamburguesa.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == fuerte3) {
            fuerte3.setIcon(new ImageIcon(salmon.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == fuerte4) {
            fuerte4.setIcon(new ImageIcon(spaghetti.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == entrada1) {
            entrada1.setIcon(new ImageIcon(ceviche.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == entrada2) {
            entrada2.setIcon(new ImageIcon(empanadas.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == entrada3) {
            entrada3.setIcon(new ImageIcon(nachos.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
        if (e.getSource() == entrada4) {
            entrada4.setIcon(new ImageIcon(patacones.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
        }
    }

    public void imprimir() {//Metodo en el cual se imprimen los productos y la factura en general.
        for (int j = 0; j < cantidad_productos; j++) {
            impresiones = (j + 1) + " - " + productos[j].getDescripcion() + ".... $" + productos[j].getValor() + "\n";
            JOptionPane.showMessageDialog(null, "--RESTAURANTE GOURMET BOGOTA--\nProducto " + impresiones);//Productos seleccionados por cleinte.
        }

        JOptionPane.showMessageDialog(null,formato.format(ahora)+"\n--RESTAURANTE GOURMET BOGOTA--\nCliente: " + Nombre.getText() + " " + Apellido.getText()
                        + "\nDocumento: " + Id.getText() + "\nCodigo: " + codigo + "\nProductos: " + cantidad_productos
                        + "\nPrecio Total: $" + suma + "\n");//Factura
    }

    public static void main(String[] args) {
        new Interfaz();//Main
    }
}
