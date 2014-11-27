package net.mauro;

import acm.graphics.GImage;

public class Rei extends SoldatGeneral{

  private static final double PAUSA = 10;

  public Rei(GImage imatgeSoldat) {
    super(imatgeSoldat);
  }

  public final void mouSoldat() {


    this.getImatge().move(velocitat, 0);
    this.getImatge().pause(PAUSA);

  }






}
