package Inicio;

import Juego.Jmain;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Main
 *Esta clase es la que ejecuta la ventana principal
 *@author Mauricio C.

 */

public class Main extends JFrame implements ActionListener {


    private JButton btn2p, btn3p, btn4p;
    private JFrame frm1;
    int players = 0;

    /**
     * Main
     *Este constructor crea un frame, un panel y aloja objetos en ellos
     *@author Mauricio C.

     */
    public Main() {
        frm1 = new JFrame("Datos Party 1");
        frm1.setBounds(0, 0, 1280, 900);
        frm1.setTitle("Datos Party 1");
        frm1.setLocationRelativeTo(null);
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(1330,947);
        frm1.add(panel);

        btn2p = new JButton();
        btn3p = new JButton();
        btn4p = new JButton();


        btn2p.setBounds(874,494,80,80);
        ImageIcon btnurl1 = new ImageIcon(getClass().getResource("/Inicio/2P.png"));
        btn2p.setIcon(btnurl1);
        btn2p.addActionListener(this);
        panel.add(btn2p);

        btn3p.setBounds(874,632,80,80);
        ImageIcon btnurl2 = new ImageIcon(getClass().getResource("/Inicio/3P.png"));
        btn3p.setIcon(btnurl2);
        btn3p.addActionListener(this);
        panel.add(btn3p);

        btn4p.setBounds(874,763,80,80);
        ImageIcon btnurl3 = new ImageIcon(getClass().getResource("/Inicio/4P.png"));
        btn4p.setIcon(btnurl3);
        btn4p.addActionListener(this);
        panel.add(btn4p);


        JLabel bg = new JLabel();
        bg.setBounds(0,0,1280,900);
        ImageIcon bgurl = new ImageIcon(getClass().getResource("/Inicio/Fondo1.png"));
        bg.setIcon(bgurl);
        validate();

        panel.add(bg);


        frm1.setVisible(true);
        JOptionPane.showMessageDialog(null, "Welcome to Datos Party 1!! \n Select number of players!  \n Enjoy!");

    }

    public static void main(String args[]) {

        Main window1 = new Main();


    }

    /**
     * actionPerformed
     *Este metodo abstracto del actionlistener permite darle las funcionalidades a los botones
     *@author Mauricio C.

     */
    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource()==btn2p) {
            System.out.println("Jugaran 2 jugadores");
            players = 2;
            System.out.println(players +" Jugadores Jugando ahora");
            Jmain prueba = new Jmain(players);
            frm1.setVisible(false);


        }
        if (e.getSource()==btn3p) {
            System.out.println("Jugaran 3 jugadores");
            players = 3;
            System.out.println(players + " Jugadores Jugando ahora");
            Jmain prueba = new Jmain(players);
            frm1.setVisible(false);

        }
        if (e.getSource()==btn4p) {
            System.out.println("Jugaran 4 jugadores");
            players = 4;
            System.out.println(players+ " Jugadores Jugando ahora");
            Jmain prueba = new Jmain(players);
            frm1.setVisible(false);
        }

    }

}