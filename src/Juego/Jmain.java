package Juego;
import Casillas.Casilla;
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
    public Casilla casillaActualMario, casillaActualLuigi, casillaActualToad, casillaActualYoshi;
    public JButton btnmkt, btndados,btnend;
    protected SimpleList PlayerList, StarList, CoinList, CLabelList, SLabelList;
    protected Player pmario,pluigi,ptoad,pyoshi,playing;
    public int jugadores, rounds;
    private int jugactual = 0;
    public int Xmario,Ymario,Xluigi,Yluigi,Xtoad,Ytoad,Xyoshi,Yyoshi,posMario,posLuigi,posToad,posYoshi,movimientosrestantes;
    public boolean marioA,marioB,marioC,marioD,marioP,marioSaleD,marioReversa,luigiA,luigiB,luigiC,luigiD,luigiP,luigiSaleD,luigiReversa,toadA,toadB,toadC,toadD,toadP,toadSaleD,toadReversa,yoshiA,yoshiB,yoshiC,yoshiD,yoshiP,yoshiSaleD,yoshiReversa;
    private Star star;
    private static Jmain instance = null;
    private JPanel panel4;
    /**
     * Jmain
     *Este constructor crea un frame, un panel y aloja objetos en ellos
     *@authors Mauricio C. , Naheem Johnson , Jose Espinoza

     */
    public Jmain() {
        this.casillaActualMario = null;
        this.casillaActualLuigi = null;
        this.casillaActualToad = null;
        this.casillaActualYoshi = null;
        this.posMario = 0;
        this.posLuigi = 0;
        this.posToad = 0;
        this.posYoshi = 0;
        this.Xmario = 719;
        this.Ymario = 809;
        this.Xluigi = 719;
        this.Yluigi = 809;
        this.Xtoad = 719;
        this.Ytoad = 809;
        this.Xyoshi = 719;
        this.Yyoshi = 809;
        this.marioA = false;
        this.marioB = false;
        this.marioC = false;
        this.marioD = false;
        this.marioP = true;
        this.marioSaleD = false;
        this.marioReversa = false;
        this.luigiA = false;
        this.luigiB = false;
        this.luigiC = false;
        this.luigiD = false;
        this.luigiP = true;
        this.luigiSaleD = false;
        this.luigiReversa = false;
        this.toadA = false;
        this.toadB = false;
        this.toadC = false;
        this.toadD = false;
        this.toadP = true;
        this.toadSaleD = false;
        this.toadReversa = false;
        this.yoshiA = false;
        this.yoshiB = false;
        this.yoshiC = false;
        this.yoshiD = false;
        this.yoshiP = true;
        this.yoshiSaleD = false;
        this.yoshiReversa = false;
        Map mapa = Map.getInstance();
        //EventStack pilaEv = EventStack.getInstance();
        this.PlayerList = new SimpleList(){};
        this.rounds = 0;
        jugadores = Main.getInstance().getPlayers();
        System.out.println(jugadores);
        this.CLabelList = new SimpleList(){};
        CLabelList.add(cnp1);
        CLabelList.add(cnp2);
        CLabelList.add(cnp3);
        CLabelList.add(cnp4);
        this.SLabelList = new SimpleList(){};
        SLabelList.add(str1);
        SLabelList.add(str2);
        SLabelList.add(str3);
        SLabelList.add(str4);
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
        mario.setBounds(697, 781, 50, 50);
        ImageIcon bgurl35 = new ImageIcon(getClass().getResource("/Juego/P1.png"));
        mario.setIcon(bgurl35);
        mario.setVisible(true);
        panel4.add(mario);
        validate();


        luigi = new JLabel();
        luigi.setBounds(697, 781, 50, 50);
        ImageIcon bgurl36 = new ImageIcon(getClass().getResource("/Juego/P2.png"));
        luigi.setIcon(bgurl36);
        luigi.setVisible(true);
        panel4.add(luigi);
        validate();


        toad = new JLabel();
        toad.setBounds(697, 781, 50, 50);
        ImageIcon bgurl37 = new ImageIcon(getClass().getResource("/Juego/P3.png"));
        toad.setIcon(bgurl37);
        toad.setVisible(true);
        panel4.add(toad);
        validate();

        yoshi = new JLabel();
        yoshi.setBounds(697, 781, 50, 50);
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
    ///////////////////////////////////////////CREAR JUGADORES//////////////////////////////////////////////////////////

    public void createPlayers(int jugadores){
        switch (jugadores) {
            case 2:
                pmario = new Player(1);
                pluigi = new Player(2);
                PlayerList.add(pmario);
                PlayerList.add(pluigi);
                toad.setVisible(false);
                yoshi.setVisible(false);
                actualizarLabels();
                break;
            case 3:
                pmario = new Player(1);
                pluigi = new Player(2);
                ptoad = new Player(3);
                PlayerList.add(pmario);
                PlayerList.add(pluigi);
                PlayerList.add(ptoad);
                yoshi.setVisible(false);
                actualizarLabels();
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
                actualizarLabels();
                break;
        }
        CoinList = new SimpleList();
        StarList = new SimpleList();
        for(int i = 0; i < PlayerList.getLength(); i++){
            CoinList.add(Integer.toString(castToPlayer(PlayerList.getPos(i)).monedas));
            StarList.add(Integer.toString(castToPlayer(PlayerList.getPos(i)).estrellas));
        }
    }
    ////////////////////////////////////////////////////MANEJO DE TURNOS////////////////////////////////////////////////////////////////////
    public void turns(){
        if (jugactual == 0 && jugactual != Jmain.getInstance().PlayerList.getLength()){
            playing = castToPlayer(Jmain.getInstance().getPlayerList().getPos(0));
            System.out.println("ES TURNO DE MARIO");
        }
        else if (jugactual == 1 && jugactual != Jmain.getInstance().PlayerList.getLength()){
            playing = castToPlayer(Jmain.getInstance().getPlayerList().getPos(1));
            System.out.println("ES TURNO DE LUIGI");
        }
        else if(jugactual == 2 && jugactual != Jmain.getInstance().PlayerList.getLength()){
            playing = castToPlayer(Jmain.getInstance().getPlayerList().getPos(2));
            System.out.println("ES TURNO DE TOAD");
        }
        else if(jugactual == 3 && jugactual != Jmain.getInstance().PlayerList.getLength()){
            playing = castToPlayer(Jmain.getInstance().getPlayerList().getPos(3));
            System.out.println("ES TURNO DE YOSHI");
        }
        if(rounds == 1){
            Star.getInstance().placeStar();
        }
        if(rounds == 20){
            //terminarJuego();
        }
        else{
            jugactual = 0;
            turns();
        }

    }
    ////////////////////////////////////////////////////////LANZA DADO////////////////////////////////////////////////////////////////
    public void lanzarDado(){
        Dados.getInstance().tirarDado();

    }
    ///////////////////////////////////////////////////////METODOS DE ACTUALIZACIÓN DE OBJETOS////////////////////////////////////
    public void actualizarlistasMS(){
        for(int i = 0; i < PlayerList.getLength(); i++){
            CoinList.add(Integer.toString(castToPlayer(PlayerList.getPos(i)).monedas));
            StarList.add(Integer.toString(castToPlayer(PlayerList.getPos(i)).estrellas));
        }
    }
    public void actualizarLabels(){
        if(PlayerList.getLength()==2){
            cnp1.setText(Integer.toString(castToPlayer(PlayerList.getPos(0)).monedas));
            cnp2.setText(Integer.toString(castToPlayer(PlayerList.getPos(1)).monedas));
            str1.setText(Integer.toString(castToPlayer(PlayerList.getPos(0)).estrellas));
            str2.setText(Integer.toString(castToPlayer(PlayerList.getPos(1)).estrellas));
        }
        if(PlayerList.getLength()==3){
            cnp1.setText(Integer.toString(castToPlayer(PlayerList.getPos(0)).monedas));
            cnp2.setText(Integer.toString(castToPlayer(PlayerList.getPos(1)).monedas));
            cnp3.setText(Integer.toString(castToPlayer(PlayerList.getPos(2)).monedas));
            str1.setText(Integer.toString(castToPlayer(PlayerList.getPos(0)).estrellas));
            str2.setText(Integer.toString(castToPlayer(PlayerList.getPos(1)).estrellas));
            str3.setText(Integer.toString(castToPlayer(PlayerList.getPos(2)).estrellas));
        }
        if(PlayerList.getLength()==4){
            cnp1.setText(Integer.toString(castToPlayer(PlayerList.getPos(0)).monedas));
            cnp2.setText(Integer.toString(castToPlayer(PlayerList.getPos(1)).monedas));
            cnp3.setText(Integer.toString(castToPlayer(PlayerList.getPos(2)).monedas));
            cnp4.setText(Integer.toString(castToPlayer(PlayerList.getPos(3)).monedas));
            str1.setText(Integer.toString(castToPlayer(PlayerList.getPos(0)).estrellas));
            str2.setText(Integer.toString(castToPlayer(PlayerList.getPos(1)).estrellas));
            str3.setText(Integer.toString(castToPlayer(PlayerList.getPos(2)).estrellas));
            str4.setText(Integer.toString(castToPlayer(PlayerList.getPos(3)).estrellas));
        }
        if(Jmain.getInstance().star == null && rounds != 0){
            Jmain.getInstance().star = Star.getInstance();
        }
        round.setText(Integer.toString(rounds));
    }

    ////////////////////////////////////////////////////////////COLOCA EL LABEL EN LAS POSICIONES DE LA CLASE ESTRELLA///////////////////////
    public void colocarEstrella(){
        estrella.setLocation(star.posX,star.posY);
    }

    ///////////////////////////////////////////////////////////RETORNA LA LISTA DE LOS JUGADORES////////////////////////////////////////////
    public SimpleList getPlayerList(){
        return PlayerList;
    }

    //////////////////////////////////////////////////////////RETORNA UN JUGADOR ALEATORIO DE LA LISTA/////////////////////////////////////
    public Player getRandomPlayer(){
        int pos = new Random().nextInt(PlayerList.getLength());
        return (Player)PlayerList.getPos(pos);
    }
    //////////////////////////////////////SINGLETON DE JMAIN//////////////////////////////////////////////////////////////////////////////
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
    /////////////////////////////////////////////////////////////////////////CONVIERTE A PLAYER UN OBJETO//////////////////////////////////////
    private Player castToPlayer (Object object) {
        return (Player) object;
    }

    ////////////////////////////////////////////////////////////////////////MANEJA BOTONES////////////////////////////////////////////////////
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
            lanzarDado();

        }
        if(e.getSource() == btnend){
            btndados.setEnabled(true);
            btnend.setEnabled(false);
            System.out.println("El jugador ha terminado su turno");
            if(jugactual >= Jmain.getInstance().getPlayerList().getLength()){
                rounds++;
                actualizarLabels();
            }
            Jmain.getInstance().jugactual++;
            turns();
            actualizarlistasMS();


        }
    }
    /////////////////////////////////////////////////////////MOVIMIENTO DE JUGADORES///////////////////////////////////////////////////
    public void MovePlayer(int moves){
        movimientosrestantes += moves;
        if (jugactual == 0){
            if(movimientosrestantes == 0){
                if(casillaActualMario.getReferencia()== 17){
                    marioC = true;
                    verificarFase();
                }
            }


        }
        else if (jugactual == 1){

        }
        else if(jugactual == 2) {

        }
        else if(jugactual == 3){

        }

    }
    public void verificarFase(){
        if (jugactual == 0){
            if(casillaActualMario.getReferencia()>0 && casillaActualMario.getReferencia()<=46){
                this.marioA = false;
                this.marioB = false;
                this.marioC = false;
                this.marioD = false;
                this.marioP = true;
                this.marioSaleD = false;
                this.marioReversa = false;
            }
            if(casillaActualMario.getReferencia()>46 && casillaActualMario.getReferencia() <= 49){
                this.marioA = true;
                this.marioB = false;
                this.marioC = false;
                this.marioD = false;
                this.marioP = false;
                this.marioSaleD = false;
                this.marioReversa = false;
            }
            if(casillaActualMario.getReferencia()>49 && casillaActualMario.getReferencia() <= 52){
                this.marioA = false;
                this.marioB = true;
                this.marioC = false;
                this.marioD = false;
                this.marioP = false;
                this.marioSaleD = false;
            }
            if(casillaActualMario.getReferencia()>52 && casillaActualMario.getReferencia() <= 55){
                this.marioA = false;
                this.marioB = false;
                this.marioC = true;
                this.marioD = false;
                this.marioP = false;
                this.marioSaleD = false;
                this.marioReversa = false;
            }
            if(casillaActualMario.getReferencia()>55 && casillaActualMario.getReferencia() <= 65){
                this.marioA = false;
                this.marioB = false;
                this.marioC = false;
                this.marioD = true;
                this.marioP = false;
                this.marioSaleD = false;
            }
        }
        else if (jugactual == 1){
            if(casillaActualMario.getReferencia()>0 && casillaActualMario.getReferencia()<=46){
                this.luigiA = false;
                this.luigiB = false;
                this.luigiC = false;
                this.luigiD = false;
                this.luigiP = true;
                this.luigiSaleD = false;
                this.luigiReversa = false;
            }
            if(casillaActualMario.getReferencia()>46 && casillaActualMario.getReferencia() <= 49){
                this.luigiA = true;
                this.luigiB = false;
                this.luigiC = false;
                this.luigiD = false;
                this.luigiP = false;
                this.luigiSaleD = false;
                this.luigiReversa = false;
            }
            if(casillaActualMario.getReferencia()>49 && casillaActualMario.getReferencia() <= 52){
                this.luigiA = false;
                this.luigiB = true;
                this.luigiC = false;
                this.luigiD = false;
                this.luigiP = false;
                this.luigiSaleD = false;
            }
            if(casillaActualMario.getReferencia()>52 && casillaActualMario.getReferencia() <= 55){
                this.luigiA = false;
                this.luigiB = false;
                this.luigiC = true;
                this.luigiD = false;
                this.luigiP = false;
                this.luigiSaleD = false;
                this.luigiReversa = false;
            }
            if(casillaActualMario.getReferencia()>55 && casillaActualMario.getReferencia() <= 65){
                this.luigiA = false;
                this.luigiB = false;
                this.luigiC = false;
                this.luigiD = true;
                this.luigiP = false;
                this.luigiSaleD = false;
            }

        }
        else if(jugactual == 2) {
            if(casillaActualMario.getReferencia()>0 && casillaActualMario.getReferencia()<=46){
                this.toadA = false;
                this.toadB = false;
                this.toadC = false;
                this.toadD = false;
                this.toadP = true;
                this.toadSaleD = false;
                this.toadReversa = false;
            }
            if(casillaActualMario.getReferencia()>46 && casillaActualMario.getReferencia() <= 49){
                this.toadA = true;
                this.toadB = false;
                this.toadC = false;
                this.toadD = false;
                this.toadP = false;
                this.toadSaleD = false;
                this.toadReversa = false;
            }
            if(casillaActualMario.getReferencia()>49 && casillaActualMario.getReferencia() <= 52){
                this.toadA = false;
                this.toadB = true;
                this.toadC = false;
                this.toadD = false;
                this.toadP = false;
                this.toadSaleD = false;
            }
            if(casillaActualMario.getReferencia()>52 && casillaActualMario.getReferencia() <= 55){
                this.toadA = false;
                this.toadB = false;
                this.toadC = true;
                this.toadD = false;
                this.toadP = false;
                this.toadSaleD = false;
                this.toadReversa = false;
            }
            if(casillaActualMario.getReferencia()>55 && casillaActualMario.getReferencia() <= 65){
                this.toadA = false;
                this.toadB = false;
                this.toadC = false;
                this.toadD = true;
                this.toadP = false;
                this.toadSaleD = false;
            }
        }
        else if(jugactual == 3){
            if(casillaActualMario.getReferencia()>0 && casillaActualMario.getReferencia()<=46){
                this.yoshiA = false;
                this.yoshiB = false;
                this.yoshiC = false;
                this.yoshiD = false;
                this.yoshiP = true;
                this.yoshiSaleD = false;
                this.yoshiReversa = false;
            }
            if(casillaActualMario.getReferencia()>46 && casillaActualMario.getReferencia() <= 49){
                this.yoshiA = true;
                this.yoshiB = false;
                this.yoshiC = false;
                this.yoshiD = false;
                this.yoshiP = false;
                this.yoshiSaleD = false;
                this.yoshiReversa = false;
            }
            if(casillaActualMario.getReferencia()>49 && casillaActualMario.getReferencia() <= 52){
                this.yoshiA = false;
                this.yoshiB = true;
                this.yoshiC = false;
                this.yoshiD = false;
                this.yoshiP = false;
                this.yoshiSaleD = false;
            }
            if(casillaActualMario.getReferencia()>52 && casillaActualMario.getReferencia() <= 55){
                this.yoshiA = false;
                this.yoshiB = false;
                this.yoshiC = true;
                this.yoshiD = false;
                this.yoshiP = false;
                this.yoshiSaleD = false;
                this.yoshiReversa = false;
            }
            if(casillaActualMario.getReferencia()>55 && casillaActualMario.getReferencia() <= 65){
                this.yoshiA = false;
                this.yoshiB = false;
                this.yoshiC = false;
                this.yoshiD = true;
                this.yoshiP = false;
                this.yoshiSaleD = false;
            }
        }

    }
    public void actualizarCasillaActual(){
        if (jugactual == 0){
            if (marioA){ casillaActualMario = Map.getInstance().getCasilla(posMario,"a");}
            else if(marioB){casillaActualMario = Map.getInstance().getCasilla(posMario,"b");}
            else if(marioC){casillaActualMario = Map.getInstance().getCasilla(posMario,"c");}
            else if(marioD){casillaActualMario = Map.getInstance().getCasilla(posMario,"d");}
            else{casillaActualMario = Map.getInstance().getCasilla(posMario,"p");}
            Jmain.getInstance().actualizarLabels();
        }
        else if (jugactual == 1){
            if (luigiA){ casillaActualLuigi = Map.getInstance().getCasilla(posLuigi,"a");}
            else if(luigiB){casillaActualLuigi = Map.getInstance().getCasilla(posLuigi,"b");}
            else if(luigiC){casillaActualLuigi = Map.getInstance().getCasilla(posLuigi,"c");}
            else if(luigiD){casillaActualLuigi = Map.getInstance().getCasilla(posLuigi,"d");}
            else{casillaActualLuigi = Map.getInstance().getCasilla(posLuigi,"p");}
            Jmain.getInstance().actualizarLabels();
        }
        else if(jugactual == 2) {
            if (toadA){ casillaActualToad = Map.getInstance().getCasilla(posToad,"a");}
            else if(toadB){casillaActualToad = Map.getInstance().getCasilla(posToad,"b");}
            else if(toadC){casillaActualToad = Map.getInstance().getCasilla(posToad,"c");}
            else if(toadD){casillaActualToad = Map.getInstance().getCasilla(posToad,"d");}
            else{casillaActualToad = Map.getInstance().getCasilla(posToad,"p");}
            Jmain.getInstance().actualizarLabels();
        }
        else if(jugactual == 3){
            if (yoshiA){ casillaActualYoshi = Map.getInstance().getCasilla(posYoshi,"a");}
            else if(yoshiB){casillaActualYoshi = Map.getInstance().getCasilla(posYoshi,"b");}
            else if(yoshiC){casillaActualYoshi = Map.getInstance().getCasilla(posYoshi,"c");}
            else if(yoshiD){casillaActualYoshi = Map.getInstance().getCasilla(posYoshi,"d");}
            else{casillaActualYoshi = Map.getInstance().getCasilla(posYoshi,"p");}
            Jmain.getInstance().actualizarLabels();
        }
    }
}

