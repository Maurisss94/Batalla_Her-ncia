package net.mauro;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public abstract class SoldatGeneral {

  private static double PAUSA;
  GImage imatge;
  int vides;
  int velocitat;
  boolean haArribat;

  public SoldatGeneral(GImage imatgeSoldat){

    this.imatge = imatgeSoldat;

  }


  public static double getPausa() {
    return PAUSA;
  }


  public static void setPausa(double pausa) {
    PAUSA = pausa;
  }




  public int getVides() {
    return vides;
  }


  public void setVides(int vides) {
    this.vides = vides;
  }


  /**
   * Getter de la velocitat del soldat.
   * @return velocitat soldat.
   */
  public final int getVelocitat() {
  return velocitat;
  }
  /**
   * Setter de la velocitat del soldat.
   * @param velocitatSoldat del soldat.
   */
  public final  void setVelocitat(final int velocitatSoldat) {
  this.velocitat = velocitatSoldat;
  }

  /**
   * Propietat del soldat per saber is ha arribat.
   * @return true or false depen de si ha arribat al final del camp.
   */
  public final boolean isHaArribat() {
  return haArribat;
  }
  /**
   * Setter per indicar true or false a la propietat haArribat.
   * @param haArribatSoldat propietat haarribat.
   */
  public final  void setHaArribat(final boolean haArribatSoldat) {
  this.haArribat = haArribatSoldat;
  }

  /**
   * Getter de la imatge del soldat.
   * @return la imatge del soldat.
   */
  public final  GImage getImatge() {
      return imatge;
  }
  /**
   * Setter de la imatge del soldat.
   * @param imatgeSoldat imatge del soldat en el sistema.
   */
  public final void setImatge(final GImage imatgeSoldat) {
      this.imatge = imatgeSoldat;
  }


  /**
   * Metode que ens indica on s'ha de localitzar el soldat.
   * @param x Posicio x del soldat.
   * @param y Posicio y del soldat.
   */
  public final void vesA(final double x, final double y) {

    imatge.setLocation(x, y);
  }
  /**
   * Metode per saber si el soldat ha arribat al final del camp.
   * @param pissarra camp de batalla.
   * @param ubicacio ubicacio del exercit.
   * @return retorna true o false depen si ha arribat el soldat.
   */
  public final boolean soldatArriba(final Camp pissarra, final int ubicacio) {

    double posicioSoldat = this.getImatge().getX();
    double ampladaSoldat = this.getImatge().getWidth();

    if (ubicacio == 1) {
      if (posicioSoldat > pissarra.getWIDTH() - ampladaSoldat) {
        this.haArribat = true;
        return true;
      } else {
        this.haArribat = false;
        return false;
      }
    } else {
      if (posicioSoldat <= 0) {
        this.haArribat = true;
        return true;
      } else {
        this.haArribat = false;
        return false;
      }
    }

  }
  public void mouSoldat() {


    this.getImatge().move(velocitat, 0);
    this.getImatge().pause(PAUSA);

  }

  //abstract void mouSoldat();


  /**
   * Metode que et retorna la caixa de la imatge.
   * @return el rectangle de la imatge.
   */
  public final  GRectangle rectangle() {
    return getImatge().getBounds();

}
  /**
   * Metode que comprova si una imatge intersecciona amb un altre.
   * @param soldatEnemic soldat de l'altre exercit.
   * @return si ha tocat o no.
   */
  public final boolean morts(final SoldatGeneral soldatEnemic) {

    return this.rectangle().intersects(soldatEnemic.rectangle());

}


}
