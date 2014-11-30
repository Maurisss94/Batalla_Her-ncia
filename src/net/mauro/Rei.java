package net.mauro;

import acm.graphics.GImage;

/**
 * Classe rei que hereda de SoldatGeneral.
 * @author mauro
 *
 */
public class Rei extends SoldatGeneral {

  /**
   * Pausa del moviment del moviment del rei.
   */
  private static final double PAUSA = 10;

  /**
   * Constructor del rei amb la seva imatge.
   * @param imatgeSoldat imatge del soldat.
   */
  public Rei(final GImage imatgeSoldat) {
    super(imatgeSoldat);
  }

  /**
   * metode que sobreescriu el de moure els Soldats.
   */
  public final void mouSoldat() {

    this.getImatge().move(0, velocitat);
    this.getImatge().pause(PAUSA);

  }

  /**
   * metode que sobreescriu el metode de SoldatArriba del SoldatGeneral.
   * @param pissarra Camp de batalla.
   * @param ubicacio ubicacio de l'exercit.
   * @return true or false si el rei ha arribat al seu desti.
   */
  public final boolean soldatArriba(final Camp pissarra, final int ubicacio) {

    double posicioY = this.getImatge().getY();
    double alcadaRei = this.getImatge().getHeight();

    if ((posicioY >= pissarra.getHEIGHT() - alcadaRei + PAUSA)
        || (posicioY <= 0)) {
      this.setHaArribat(true);
      return true;
    } else {
      this.setHaArribat(false);
      return false;
    }

  }


}
