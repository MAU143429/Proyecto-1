package Minijuegos.Dice;
import Juego.Jmain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dosjugadores extends JFrame {
    JLabel dado1, dado12, dado2, dado22, titulo1, titulo2, fondo, jug1, jug2, foto1, foto2;
    JButton tirar1, tirar2;
    ImageIcon imgboton, uno, dos, tres, cuatro, cinco, seis;
    int tiro1, tiro2, tiro3, tiro4;
    int suma1 = 0;
    int suma2 = 0;
    String winner, second = "";


    public dosjugadores() {
        this.setBounds(100, 100, 900, 900);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1050, 550));
        this.setTitle("DICE GAME!");
        this.setResizable(false);
        Container container = this.getContentPane();
        container.setLayout(null);

        fondo = new JLabel();
        titulo1 = new JLabel();
        titulo2 = new JLabel();
        dado1 = new JLabel();
        dado12 = new JLabel();
        dado2 = new JLabel();
        dado22 = new JLabel();
        jug1 = new JLabel();
        jug2 = new JLabel();
        foto1 = new JLabel();
        foto2 = new JLabel();

        ImageIcon ifondo = new ImageIcon(getClass().getResource("/Minijuegos/Dice/fondo_juego_dados.png"));
        ImageIcon ititulo1 = new ImageIcon(getClass().getResource("/Minijuegos/Dice/good.png"));
        ImageIcon ititulo2 = new ImageIcon(getClass().getResource("/Minijuegos/Dice/luck.png"));
        ImageIcon idado1 = new ImageIcon(getClass().getResource("/Minijuegos/Dice/dice1.png"));
        ImageIcon idado12 = new ImageIcon(getClass().getResource("/Minijuegos/Dice/dice2.png"));
        ImageIcon idado2 = new ImageIcon(getClass().getResource("/Minijuegos/Dice/dice1.png"));
        ImageIcon idado22 = new ImageIcon(getClass().getResource("/Minijuegos/Dice/dice2.png"));
        ImageIcon ijug1 = new ImageIcon(getClass().getResource("/Minijuegos/Dice/mario.png"));
        ImageIcon ijug2 = new ImageIcon(getClass().getResource("/Minijuegos/Dice/luigi.png"));
        ImageIcon ifoto1 = new ImageIcon(getClass().getResource("/Minijuegos/Dice/P1.png"));
        ImageIcon ifoto2 = new ImageIcon(getClass().getResource("/Minijuegos/Dice/P2.png"));

        fondo.setIcon(ifondo);
        titulo1.setIcon(ititulo1);
        titulo2.setIcon(ititulo2);
        dado1.setIcon(idado1);
        dado12.setIcon(idado12);
        dado2.setIcon(idado2);
        dado22.setIcon(idado22);
        jug1.setIcon(ijug1);
        jug2.setIcon(ijug2);
        foto1.setIcon(ifoto1);
        foto2.setIcon(ifoto2);

        tirar1 = new JButton("TIRAR1");
        tirar2 = new JButton("TIRAR2");

        tirar1.setBorderPainted(false);
        tirar1.setContentAreaFilled(false);
        tirar1.setOpaque(false);
        tirar2.setBorderPainted(false);
        tirar2.setContentAreaFilled(false);
        tirar2.setOpaque(false);

        imgboton = new ImageIcon(getClass().getResource("throw.png"));

        uno = new ImageIcon(getClass().getResource("/Minijuegos/Dice/1.png"));
        dos = new ImageIcon(getClass().getResource("/Minijuegos/Dice/2.png"));
        tres = new ImageIcon(getClass().getResource("/Minijuegos/Dice/3.png"));
        cuatro = new ImageIcon(getClass().getResource("/Minijuegos/Dice/4.png"));
        cinco = new ImageIcon(getClass().getResource("/Minijuegos/Dice/5.png"));
        seis = new ImageIcon(getClass().getResource("/Minijuegos/Dice/6.png"));

        tirar1.setIcon(imgboton);
        tirar2.setIcon(imgboton);

        fondo.setBounds(0, 0, 1050, 656);
        titulo1.setBounds(320, 50, 186, 52);
        titulo2.setBounds(520, 50, 187, 55);
        dado1.setBounds(60, 300, 100, 100);
        dado12.setBounds(170, 300, 100, 100);
        dado2.setBounds(400, 300, 100, 100);
        dado22.setBounds(510, 300, 100, 100);
        jug1.setBounds(40, 150, 301, 53);
        jug2.setBounds(410, 150, 299, 53);
        tirar1.setBounds(40, 420, 260, 52);
        tirar2.setBounds(380, 420, 260, 52);
        foto1.setBounds(130, 220, 50, 50);
        foto2.setBounds(475, 220, 50, 50);

        container.add(titulo1);
        container.add(titulo2);
        container.add(dado1);
        container.add(dado12);
        container.add(dado2);
        container.add(dado22);
        container.add(jug1);
        container.add(jug2);
        container.add(tirar1);
        container.add(tirar2);
        container.add(foto1);
        container.add(foto2);
        container.add(fondo);

        tirar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("TIRAR1")) {
                    tiro1 = (int) (Math.random() * 6) + 1;
                    tiro2 = (int) (Math.random() * 6) + 1;
                    System.out.println(tiro1);
                    System.out.println(tiro2);
                    if (tiro1 == 1) {
                        dado1.setIcon(uno);
                    }
                    if (tiro1 == 2) {
                        dado1.setIcon(dos);
                    }
                    if (tiro1 == 3) {
                        dado1.setIcon(tres);
                    }
                    if (tiro1 == 4) {
                        dado1.setIcon(cuatro);
                    }
                    if (tiro1 == 5) {
                        dado1.setIcon(cinco);
                    }
                    if (tiro1 == 6) {
                        dado1.setIcon(seis);
                    }
                    if (tiro2 == 1) {
                        dado12.setIcon(uno);
                    }
                    if (tiro2 == 2) {
                        dado12.setIcon(dos);
                    }
                    if (tiro2 == 3) {
                        dado12.setIcon(tres);
                    }
                    if (tiro2 == 4) {
                        dado12.setIcon(cuatro);
                    }
                    if (tiro2 == 5) {
                        dado12.setIcon(cinco);
                    }
                    if (tiro2 == 6) {
                        dado12.setIcon(seis);
                    }
                    tirar1.setEnabled(false);
                    suma1 = tiro1 + tiro2;
                    System.out.println(suma1);
                }
            }
        });
        tirar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("TIRAR2")) {
                    tiro3 = (int) (Math.random() * 6) + 1;
                    tiro4 = (int) (Math.random() * 6) + 1;
                    System.out.println(tiro3);
                    System.out.println(tiro4);
                    if (tiro3 == 1) {
                        dado2.setIcon(uno);
                    }
                    if (tiro3 == 2) {
                        dado2.setIcon(dos);
                    }
                    if (tiro3 == 3) {
                        dado2.setIcon(tres);
                    }
                    if (tiro3 == 4) {
                        dado2.setIcon(cuatro);
                    }
                    if (tiro3 == 5) {
                        dado2.setIcon(cinco);
                    }
                    if (tiro3 == 6) {
                        dado2.setIcon(seis);
                    }
                    if (tiro4 == 1) {
                        dado22.setIcon(uno);
                    }
                    if (tiro4 == 2) {
                        dado22.setIcon(dos);
                    }
                    if (tiro4 == 3) {
                        dado22.setIcon(tres);
                    }
                    if (tiro4 == 4) {
                        dado22.setIcon(cuatro);
                    }
                    if (tiro4 == 5) {
                        dado22.setIcon(cinco);
                    }
                    if (tiro4 == 6) {
                        dado22.setIcon(seis);
                    }
                    tirar2.setEnabled(false);
                    suma2 = tiro3 + tiro4;
                    System.out.println(suma2);

                    if (suma1 > suma2) {
                        Jmain.getInstance().castToPlayer(Jmain.getInstance().getPlayerList().getPos(0)).monedas += 50;
                        Jmain.getInstance().castToPlayer(Jmain.getInstance().getPlayerList().getPos(1)).monedas += 30;
                        Jmain.getInstance().actualizarLabels();
                    } else {
                        Jmain.getInstance().castToPlayer(Jmain.getInstance().getPlayerList().getPos(1)).monedas += 50;
                        Jmain.getInstance().castToPlayer(Jmain.getInstance().getPlayerList().getPos(0)).monedas += 30;
                        Jmain.getInstance().actualizarLabels();
                    }

                    JOptionPane.showMessageDialog(null, "SCORES: " + "\nPLAYER 1: " + suma1 + "\nPLAYER 2: " + suma2 + "\n\nSTANDINGS: " + "\n 1° PLACE: " + winner + "\n 2° PLACE: " + second);
                    setVisible(false);
                    dispose();
                }
            }
        });


        this.pack();
        this.validate();
        this.setVisible(true);
    }

}