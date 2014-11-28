package net.mauro;

import acm.graphics.GImage;

public class Rei extends SoldatGeneral{

  private static final double PAUSA = 10;

  public Rei(GImage imatgeSoldat) {
    super(imatgeSoldat);
  }

  public final void mouSoldat() {


    this.getImatge().move(0, velocitat);
    this.getImatge().pause(PAUSA);

  }

  public  boolean soldatArriba(final Camp pissarra, final int ubicacio) {

    double posicioSoldat = this.getImatge().getY();
    double alçadaSoldat = this.getImatge().getHeight();

    if (ubicacio == 1) {
      if (posicioSoldat > pissarra.getHEIGHT() - alçadaSoldat-50) {
        this.haArribat = true;
        return true;
      } else {
        this.haArribat = false;
        return false;
      }
    } else {
      if (posicioSoldat > pissarra.getHEIGHT() - alçadaSoldat-50) {
        this.haArribat = true;
        return true;
      } else {
        this.haArribat = false;
        return false;
      }
    }

  }















}
