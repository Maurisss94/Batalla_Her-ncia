package net.mauro;

import acm.graphics.GImage;

/**
 * Classe Viking que hereda de SoldatGeneral.
 * @author mauro
 *
 */
public class SoldatViking extends SoldatGeneral {

  /**
   * Constructor del Viking amb la seva imatge i les vides de cada Viking.
   * @param imatgeSoldat imatge del soldat Viking.
   * @param vides vides del Viking.
   */
  public SoldatViking(final GImage imatgeSoldat, final int vides) {
    super(imatgeSoldat);
    this.vides = vides;
  }


}
