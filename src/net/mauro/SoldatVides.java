package net.mauro;

import acm.graphics.GImage;

/**
 * Classe del Soldat amb vides, que hereda de SoldatGeneral.
 * @author mauro
 *
 */
public class SoldatVides extends SoldatGeneral {

  /**
   * Constructor del soldat amb vides.
   * @param imatgeSoldat Imatge del soldat amb vides.
   * @param vides Vides del soldat.
   */
  public SoldatVides(final GImage imatgeSoldat, final int vides) {
    super(imatgeSoldat);
    this.vides = vides;
  }









}
