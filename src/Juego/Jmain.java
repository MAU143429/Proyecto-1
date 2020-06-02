package Juego;
import Dados.Dados;
import EstructurasDatos.SimpleList;
import Inicio.Main;
import Market.market;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Jmain
 *Esta clase es la que ejecuta la ventana donde se aloja el juego
 *@authors Mauricio C. , Naheem Johnson , Jose Espinoza

 */
public class Jmain extends JFrame implements ActionListener {

    public JFrame frm2;
    public JLabel bg2,cnp1,cnp2,cnp3,cnp4,str1,str2,str3,str4,round,pgame,mario,luigi,toad,yoshi,dado1,dado2,estrella;
    public JButton btnmkt, btndados,btnend;
    protected SimpleList PlayerList, StarList, CoinList, CLabelList, SLabelList;
    protected Player pmario,pluigi,ptoad,pyoshi,playing;
    int jugadores, rounds;
    public boolean nowplaying;
    protected Star star;
    private static Jmain instance = null;
    public JPanel panel4;

    /**
     * Jmain
     *Este constructor crea un frame, un panel y aloja objetos en ellos
     *@authors Mauricio C. , Naheem Johnson , Jose Espinoza

     */
    public Jmain() {
        Map mapa = Map.getInstance();
        //EventStack pilaEv = EventStack.getInstance();
        this.PlayerList = new SimpleList(){};
        this.rounds = 0;
        this.nowplaying = false;
        jugadores = Main.getInstance().getPlayers();
        System.out.println(jugadores);
        this.CLabelList = new SimpleList(){};
        CLabelList.add(cnp1);
        CLabelList.add(cnp2);
        CLabelList.add(cnp3);
        CLabelList.add(cnp4);
        this.SLabelList = new SimpleList(){};
        SLabelList.add(str1);
        SLabelList.add(str1);
        SLabelList.add(str1);
        SLabelList.add(str1);
        //############################Frame###############################
        frm2 = new JFrame("Datos Party 1");
        frm2.setBounds(0, 0, 1295, 947);
        frm2.setTitle("Datos Party 1");
        frm2.setLocationRelativeTo(null);
        frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //############################Panel###############################
        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setSize(1330, 947);
        frm2.add(panel4);

        //############################Botones###############################
        btnmkt = new JButton();
        btnmkt.setBounds(1184, 811, 80, 80);
        ImageIcon btnurl7 = new ImageIcon(getClass().getResource("/Juego/carrito.png"));
        btnmkt.setIcon(btnurl7);
        btnmkt.setBorderPainted(false);
        btnmkt.setContentAreaFilled(false);
        btnmkt.setOpaque(false);
        btnmkt.addActionListener(this);

        panel4.add(btnmkt);


        btndados = new JButton("TIRAR DADOS");
        btndados.setBounds(870, 700, 385, 82);
        ImageIcon btnurl12 = new ImageIcon(getClass().getResource("/Juego/roll.png"));
        btndados.setIcon(btnurl12);
        btndados.addActionListener(this);

        panel4.add(btndados);

        btnend = new JButton("END TURN");
        btnend.setBounds(870,600,385,82);
        ImageIcon fotofin = new ImageIcon(getClass().getResource("/Juego/btnend.png"));
        btnend.setIcon(fotofin);
        btnend.setEnabled(false);
        btnend.addActionListener(this);

        panel4.add(btnend);

        //############################Labels###############################

        //##Stars##

        str1 = new JLabel("0");
        str1.setFont(new Font("Serif",Font.BOLD,40));
        str1.setForeground(Color.WHITE);
        str1.setBounds(1007,75,40,40);
        panel4.add(str1);

        str2 = new JLabel("0");
        str2.setFont(new Font("Serif",Font.BOLD,40));
        str2.setForeground(Color.WHITE);
        str2.setBounds(1007,160,40,40);
        panel4.add(str2);

        str3 = new JLabel("0");
        str3.setFont(new Font("Serif",Font.BOLD,40));
        str3.setForeground(Color.WHITE);
        str3.setBounds(1007,235,40,40);
        panel4.add(str3);

        str4 = new JLabel("0");
        str4.setFont(new Font("Serif",Font.BOLD,40));
        str4.setForeground(Color.WHITE);
        str4.setBounds(1007,305,40,40);
        panel4.add(str4);

        //##Coins##

        cnp1 = new JLabel("0");
        cnp1.setFont(new Font("Serif",Font.BOLD,40));
        cnp1.setForeground(Color.WHITE);
        cnp1.setBounds(1187,75,40,40);
        panel4.add(cnp1);

        cnp2 = new JLabel("0");
        cnp2.setFont(new Font("Serif",Font.BOLD,40));
        cnp2.setForeground(Color.WHITE);
        cnp2.setBounds(1187,160,40,40);
        panel4.add(cnp2);

        cnp3 = new JLabel("0");
        cnp3.setFont(new Font("Serif",Font.BOLD,40));
        cnp3.setForeground(Color.WHITE);
        cnp3.setBounds(1187,235,40,40);
        panel4.add(cnp3);

        cnp4 = new JLabel("0");
        cnp4.setFont(new Font("Serif",Font.BOLD,40));
        cnp4.setForeground(Color.WHITE);
        cnp4.setBounds(1187,305,40,40);
        panel4.add(cnp4);


        pgame = new JLabel("Turn of Player");
        pgame.setFont(new Font("Serif",Font.BOLD,30));
        pgame.setForeground(Color.WHITE);
        pgame.setBounds(867,830,400,40);
        panel4.add(pgame);

        round = new JLabel("Round: 0");
        round.setFont(new Font("Serif",Font.BOLD,30));
        round.setForeground(Color.WHITE);
        round.setBounds(867,795,400,40);
        panel4.add(round);

        estrella = new JLabel("star");
        estrella.setBounds(5000,5000,50,50);
        ImageIcon fotostar = new ImageIcon(getClass().getResource("/Juego/estrella.png"));
        estrella.setIcon(fotostar);
        panel4.add(estrella);
        //###########################Jugadores##########################################

        mario = new JLabel();
        mario.setBounds(645, 800, 50, 50);
        ImageIcon bgurl35 = new ImageIcon(getClass().getResource("/Juego/P1.png"));
        mario.setIcon(bgurl35);
        mario.setVisible(true);
        panel4.add(mario);
        validate();


        luigi = new JLabel();
        luigi.setBounds(745, 800, 50, 50);
        ImageIcon bgurl36 = new ImageIcon(getClass().getResource("/Juego/P2.png"));
        luigi.setIcon(bgurl36);
        luigi.setVisible(true);
        panel4.add(luigi);
        validate();


        toad = new JLabel();
        toad.setBounds(665, 847, 50, 50);
        ImageIcon bgurl37 = new ImageIcon(getClass().getResource("/Juego/P3.png"));
        toad.setIcon(bgurl37);
        toad.setVisible(true);
        panel4.add(toad);
        validate();

        yoshi = new JLabel();
        yoshi.setBounds(720, 847, 50, 50);
        ImageIcon bgurl38 = new ImageIcon(getClass().getResource("/Juego/P4.png"));
        yoshi.setIcon(bgurl38);
        yoshi.setVisible(true);
        panel4.add(yoshi);
        validate();

        //#####################DADOS#####################################################
        dado1 = new JLabel();
        dado1.setBounds(889,432,160,160);
        ImageIcon imagendado = new ImageIcon(getClass().getResource("/Juego/dadoroll1.png"));
        dado1.setIcon(imagendado);

        dado2 = new JLabel();
        dado2.setBounds(1069,432,160,160);
        dado2.setIcon(imagendado);

        panel4.add(dado1);
        panel4.add(dado2);
        //##Background####################################################################
        bg2 = new JLabel();
        bg2.setBounds(0, 0, 1280, 900);
        ImageIcon bgurl1 = new ImageIcon(getClass().getResource("/Juego/Jfondo.png"));
        bg2.setIcon(bgurl1);
        validate();

        panel4.add(bg2);

        frm2.setVisible(true);


    }
    public void createPlayers(int jugadores){
        switch (jugadores) {
            case 2:
                pmario = new Player(1);
                pluigi = new Player(2);
                PlayerList.add(pmario);
                PlayerList.add(pluigi);
                toad.setVisible(false);
                yoshi.setVisible(false);
                break;
            case 3:
                pmario = new Player(1);
                pluigi = new Player(2);
                ptoad = new Player(3);
                PlayerList.add(pmario);
                PlayerList.add(pluigi);
                PlayerList.add(ptoad);
                yoshi.setVisible(false);
                break;
            case 4:
                pmario = new Player(1);
                pluigi = new Player(2);
                ptoad = new Player(3);
                pyoshi = new Player(4);
                PlayerList.add(pmario);
                PlayerList.add(pluigi);
                PlayerList.add(ptoad);
                PlayerList.add(pyoshi);
                break;
        }
        CoinList = new SimpleList();
        StarList = new SimpleList();
        for(int i = 0; i < PlayerList.getLength(); i++){
            CoinList.add(Integer.toString(castToPlayer(PlayerList.getPos(i)).monedas));
            StarList.add(Integer.toString(castToPlayer(PlayerList.getPos(i)).estrellas));
        }
    }
    protected void turns(){
        if(!nowplaying){
            for(int i = 0; i < PlayerList.getLength(); i++){
                if(!castToPlayer(PlayerList.getPos(i)).jugado){
                    this.playing = castToPlayer(PlayerList.getPos(i));
                    castToPlayer(PlayerList.getPos(i)).jugado = true;
                    return;
                }
            }
            for(int i = 0; i < PlayerList.getLength(); i++){
                castToPlayer(PlayerList.getPos(i)).jugado = false;
            }
            rounds++;
            round.setText(Integer.toString(rounds));
        }
    }
    public void actualizarLabels(){
        for(int i = 0; i < PlayerList.getLength(); i++){
            castToLabel(CLabelList.getPos(i)).setText(Integer.toString(castToPlayer(PlayerList.getPos(i)).monedas));
            castToLabel(SLabelList.getPos(i)).setText(Integer.toString(castToPlayer(PlayerList.getPos(i)).estrellas));
            round.setText(String.valueOf(rounds));
        }
        try{
            TimeUnit.MILLISECONDS.sleep(300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if(Jmain.getInstance().star == null && rounds != 0){
            Jmain.getInstance().star = Star.getInstance();
        }
    }
    public Label castToLabel(Object object){
        return (Label)object;

    }
    public SimpleList getPlayerList(){
        return PlayerList;
    }
    public Player getRandomPlayer(){
        int pos = new Random().nextInt(PlayerList.getLength());
        return (Player)PlayerList.getPos(pos);
    }

    public static Jmain getInstance(){
        if(instance == null){
            instance = new Jmain();
        }
        return instance;
    }
    /**
     * actionPerformed
     *Este metodo abstracto del actionlistener permite darle las funcionalidades a los botones
     *@authors Mauricio C. , Naheem Johnson , Jose Espinoza

     */

    private Player castToPlayer (Object object) {
        return (Player) object;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnmkt) {
            System.out.println("Abriendo Market");
            System.out.println("Market abierto");
            market prueba1 = new market();


        }

        if (e.getSource() == btndados) {
            btndados.setEnabled(false);
            btnend.setEnabled(true);
            System.out.println("Se estan tirando los dados");
            System.out.println("Dados tirados");
            Dados prueba2 = new Dados();
            int suma = prueba2.retornarsuma();
        }
        if(e.getSource() == btnend){
            btndados.setEnabled(true);
            btnend.setEnabled(false);
            System.out.println("El jugador ha terminado su turno");


        }
    }
}

