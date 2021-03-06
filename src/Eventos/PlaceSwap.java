package Eventos;

import Casillas.Casilla;
import Juego.Jmain;
import Juego.Player;

import javax.swing.*;

/**
 * PlaceSwap
 * Clase del evento de cambiar lugar
 * @author Naheem J.
 * @author Mauricio C.
 */
public class PlaceSwap extends Evento{

    public Player cambio;
    int newX, newY,newX2, newY2,newabspos, newabspos2;
    public Casilla cas1,cas2;
    public JFrame frmcam;
    public JLabel bg377;

    /**
     * evento
     * @param player
     * Método heredado de la clase padre en la que se crea la lógica del evento cambiar lugar
     * @author Mauricio C.
     * @author Naheem J.
     */
    @Override
    public void evento(Player player) {

        cambio = Jmain.getInstance().getRandomPlayer();

        while(player == cambio){
            cambio = Jmain.getInstance().getRandomPlayer();
        }


        if (cambio == Jmain.getInstance().getPlayerList().getPos(0)){

            newabspos = cambio.posJug;
            newabspos2 = player.posJug;

            newX = cambio.posX;
            newY = cambio.posY;
            newX2 = player.posX;
            newY2 = player.posY;

            cas1 = player.casillaActual;
            cas2 = cambio.casillaActual;

            player.estaenReversa = false;
            cambio.estaenReversa = false;

            player.posJug = newabspos;
            cambio.posJug = newabspos2;


            player.movTotal = player.posJug;
            cambio.movTotal = cambio.posJug;


            player.casillaActual = cas2;
            cambio.casillaActual = cas1;


            player.posX = newX;
            player.posY = newY;

            cambio.posX = newX2;
            cambio.posY = newY2;


            Jmain.getInstance().mario.setLocation((cambio.posX-22),(cambio.posY-28));
            Jmain.getInstance().mario.repaint();



            if(player.referencia == 2){
                Jmain.getInstance().luigi.setLocation((player.posX-22),(player.posY-28));
            }
            if(player.referencia == 3){
                Jmain.getInstance().toad.setLocation((player.posX-22),(player.posY-28));
            }
            if(player.referencia == 4){
                Jmain.getInstance().yoshi.setLocation((player.posX-22),(player.posY-28));
            }


            player.verifyPath();
            cambio.verifyPath();
            Jmain.getInstance().panel4.repaint();


        }
        if (cambio == Jmain.getInstance().getPlayerList().getPos(1)){

            newabspos = cambio.posJug;
            newabspos2 = player.posJug;

            newX = cambio.posX;
            newY = cambio.posY;
            newX2 = player.posX;
            newY2 = player.posY;

            cas1 = player.casillaActual;
            cas2 = cambio.casillaActual;

            player.estaenReversa = false;
            cambio.estaenReversa = false;

            player.posJug = newabspos;
            cambio.posJug = newabspos2;


            player.movTotal = player.posJug;
            cambio.movTotal = cambio.posJug;


            player.casillaActual = cas2;
            cambio.casillaActual = cas1;


            player.posX = newX;
            player.posY = newY;

            cambio.posX = newX2;
            cambio.posY = newY2;

            Jmain.getInstance().luigi.setLocation((cambio.posX-22),(cambio.posY-28));
            Jmain.getInstance().luigi.repaint();



            if(player.referencia == 1){
                Jmain.getInstance().mario.setLocation((player.posX-22),(player.posY-28));
            }
            if(player.referencia == 3){
                Jmain.getInstance().toad.setLocation((player.posX-22),(player.posY-28));
            }
            if(player.referencia == 4){
                Jmain.getInstance().yoshi.setLocation((player.posX-22),(player.posY-28));
            }


            player.verifyPath();
            cambio.verifyPath();
            Jmain.getInstance().panel4.repaint();
        }
        if (cambio == Jmain.getInstance().getPlayerList().getPos(2)){
            newabspos = cambio.posJug;
            newabspos2 = player.posJug;

            newX = cambio.posX;
            newY = cambio.posY;
            newX2 = player.posX;
            newY2 = player.posY;

            cas1 = player.casillaActual;
            cas2 = cambio.casillaActual;

            player.estaenReversa = false;
            cambio.estaenReversa = false;

            player.posJug = newabspos;
            cambio.posJug = newabspos2;


            player.movTotal = player.posJug;
            cambio.movTotal = cambio.posJug;


            player.casillaActual = cas2;
            cambio.casillaActual = cas1;


            player.posX = newX;
            player.posY = newY;

            cambio.posX = newX2;
            cambio.posY = newY2;

            Jmain.getInstance().toad.setLocation((cambio.posX-22),(cambio.posY-28));
            Jmain.getInstance().toad.repaint();


            if(player.referencia == 1){
                Jmain.getInstance().mario.setLocation((player.posX-22),(player.posY-28));
            }
            if(player.referencia == 2){
                Jmain.getInstance().luigi.setLocation((player.posX-22),(player.posY-28));
            }
            if(player.referencia == 4){
                Jmain.getInstance().yoshi.setLocation((player.posX-22),(player.posY-28));
            }


            player.verifyPath();
            cambio.verifyPath();
            Jmain.getInstance().panel4.repaint();
        }
        if (cambio == Jmain.getInstance().getPlayerList().getPos(3)){
            newabspos = cambio.posJug;
            newabspos2 = player.posJug;

            newX = cambio.posX;
            newY = cambio.posY;
            newX2 = player.posX;
            newY2 = player.posY;

            cas1 = player.casillaActual;
            cas2 = cambio.casillaActual;

            player.estaenReversa = false;
            cambio.estaenReversa = false;

            player.posJug = newabspos;
            cambio.posJug = newabspos2;


            player.movTotal = player.posJug;
            cambio.movTotal = cambio.posJug;


            player.casillaActual = cas2;
            cambio.casillaActual = cas1;


            player.posX = newX;
            player.posY = newY;

            cambio.posX = newX2;
            cambio.posY = newY2;

            Jmain.getInstance().yoshi.setLocation((cambio.posX-22),(cambio.posY-28));
            Jmain.getInstance().yoshi.repaint();


            if(player.referencia == 1){
                Jmain.getInstance().mario.setLocation((player.posX-22),(player.posY-28));
            }
            if(player.referencia == 2){
                Jmain.getInstance().luigi.setLocation((player.posX-22),(player.posY-28));
            }
            if(player.referencia == 3){
                Jmain.getInstance().toad.setLocation((player.posX-22),(player.posY-28));
            }


            player.verifyPath();
            cambio.verifyPath();
            Jmain.getInstance().panel4.repaint();
        }


    }
    /**
     * ventanaEvento
     * @param player
     * Este método se encarga de crear la ventana de aviso en caso de que se de un evento
     */
    @Override
    public void ventanaEvento(Player player) {

        Jmain.getInstance().corriendoJuego = true;


        frmcam = new JFrame();
        frmcam.setBounds(740, 130, 450, 305);
        frmcam.setUndecorated(true);
        frmcam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JPanel panel100 = new JPanel();
        panel100.setLayout(null);
        panel100.setSize(600, 410);
        frmcam.add(panel100);

        bg377 = new JLabel();
        bg377.setBounds(0, 0, 450, 310);
        ImageIcon bgurl100 = new ImageIcon(getClass().getResource("/Eventos/cambiolug.png"));
        bg377.setIcon(bgurl100);


        panel100.add(bg377);


        frmcam.setVisible(true);


        evento(player);
        Jmain.getInstance().actualizarLabels();
        JOptionPane.showMessageDialog(null, "TE CAMBIARAS DE LUGAR  CON UN JUGADOR ALEATORIO");


        frmcam.dispose();


        Jmain.getInstance().corriendoJuego = false;

    }


}
