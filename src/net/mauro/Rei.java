package net.mauro;

import acm.graphics.GImage;

public class Rei extends SoldatGeneral {

  private static final double PAUSA = 10;
  boolean reiArriba = false;

  public Rei(GImage imatgeSoldat) {
    super(imatgeSoldat);
  }

  public void mouSoldat() {

    this.getImatge().move(0, velocitat);
    this.getImatge().pause(PAUSA);

  }

  public boolean soldatArriba(final Camp pissarra, final int ubicacio) {

    double posicioY = this.getImatge().getY();
    double alçada = this.getImatge().getHeight();

    if ((posicioY >= pissarra.getHEIGHT() - alçada + 5) || (posicioY <= 0)) {
      this.setHaArribat(true);
      return true;
    } else {
      this.setHaArribat(false);
      return false;
    }

  }


}
