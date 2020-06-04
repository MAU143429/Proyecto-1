package Casillas;

import Juego.Player;

public class CasillaAmarilla extends Casilla {
    public CasillaAmarilla(int posX, int posY, int posList,int referencia) {
        this.posX = posX;
        this.posY = posY;
        this.posList = posList;
        this.referencia = referencia;
        this.msg = "Amarilla";
    }

    /**
     * Hace pop a un evento de la pila de eventos. Si la pila está vacía, la vuelve a crear.
     */
    @Override
    public void evento(Player player) {
        System.out.println("SE LLAMÓ UN EVENTO");
    }

}