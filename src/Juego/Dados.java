package Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Dados {
    Timer tm, xm,sm;
    int x = 0;
    ImageIcon dadoimg1, dadoimg2, dadoimg3, dadoimg4, dadoimg5, dadoimg6, dadoroll;
    public int dado1, dado2, SumaDados, dadoani1, dadoani2;
    public static Dados instance = null;
    //Images Path In Array
    String[] list = {
            "/Juego/dado1.png",//0
            "/Juego/dado2.png",//1
            "/Juego/dado3.png",//2
            "/Juego/dado4.png",//3
            "/Juego/dado5.png",//4
            "/Juego/dado6.png"//5

    };
    int num = 0;

    public Dados() {
        dadoimg1 = new ImageIcon(getClass().getResource("/Juego/dado1.png"));
        dadoimg2 = new ImageIcon(getClass().getResource("/Juego/dado2.png"));
        dadoimg3 = new ImageIcon(getClass().getResource("/Juego/dado3.png"));
        dadoimg4 = new ImageIcon(getClass().getResource("/Juego/dado4.png"));
        dadoimg5 = new ImageIcon(getClass().getResource("/Juego/dado5.png"));
        dadoimg6 = new ImageIcon(getClass().getResource("/Juego/dado6.png"));
        dadoroll = new ImageIcon(getClass().getResource("/Juego/dadoroll1.png"));

        xm = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jmain.getInstance().dado1.setIcon(dadoroll);
                Jmain.getInstance().dado2.setIcon(dadoroll);
                xm.stop();
            }
        });
        tm = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                System.out.println(x);
                if (x >= list.length) {
                    x = 0;
                    dado1 = (int) (Math.random() * 6) + 1;
                    System.out.println("DADO 1: " + Dados.getInstance().dado1);
                    dado2 = (int) (Math.random() * 6) + 1;
                    System.out.println("DADO 2: " + Dados.getInstance().dado2);
                    SumaDados = dado1 + dado2;
                    System.out.println("Suma de los Dados " + SumaDados);
                    tm.stop();
                    sm.start();
                }
            }
        });
        sm = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PutFinal1((Jmain.getInstance().dado.dado1)-1);
                PutFinal2((Jmain.getInstance().dado.dado2)-1);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(num);
                Jmain.getInstance().playing.movePlayer(SumaDados);
                sm.stop();
                xm.start();
            }
        });


    }
    public void SetImageSize(int i) {
        ImageIcon icon1 = new ImageIcon(getClass().getResource(list[i]));
        ImageIcon icon2 = new ImageIcon(getClass().getResource(list[i]));
        Jmain.getInstance().dado1.setIcon(icon1);
        Jmain.getInstance().dado2.setIcon(icon2);

    }
    public void PutFinal1(int i){
        ImageIcon icon1 = new ImageIcon(getClass().getResource(list[i]));
        Jmain.getInstance().dado1.setIcon(icon1);
    }
    public void PutFinal2(int i){
        ImageIcon icon2 = new ImageIcon(getClass().getResource(list[i]));
        Jmain.getInstance().dado2.setIcon(icon2);
    }


    public static Dados getInstance() {
        if (instance == null) {
            instance = new Dados();
        }
        return instance;
    }

    public int tirarDado() {
        return SumaDados;
    }
}