package Minijuegos.Runner;

import Juego.Jmain;

/**
 * SG5
 *Esta clase se encarga de ejecutar el minijuego runner dependiendo de la cantidad de jugadores
 *@author Mauricio C.

 */
public class SG5 {

    /**
     * SG3
     *
     *               este parametro es la cantidad de jugadores en juego
     *Este constructor utiliza la cantidad de jugadores para definir el minijuego que sera ejecutado
     *@author Mauricio C.

     */
    public SG5(){


        if(Jmain.getInstance().PlayerList.getLength() == 2){
            Runner2 player2 = new Runner2();

        }
        if(Jmain.getInstance().PlayerList.getLength()== 3){
            Runner3 player2 = new Runner3();

        }
        if(Jmain.getInstance().PlayerList.getLength() == 4){
            Runner4 player2 = new Runner4();

        }







    }



}

