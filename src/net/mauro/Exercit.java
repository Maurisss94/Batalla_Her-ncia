package net.mauro;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe Exercit.
 * @author mauro
 *
 */
public class Exercit {


  /**
   * Separació per la col·locació dels soldats.
   */
  private static final int SEPARACIO = 50;
  /**
   * variable que conté la velocitat dels soldats.
   */
  private static final int VELOCITAT_SOLDAT = 10;
  /**
   * Numero per restar a la amplada del camp, per pintar els soldats.
   */
    private static final int NUMERO_RESTA = 100;
    /**
     * Array on es guardaran els soldats.
     */
    ArrayList<SoldatGeneral> soldatsExercit;
    /**
     *Variable on es guardara la ubicacio dels exercits.
     */
    private int ubicacio;

    /**
     * Constructor per defecte del exercit.
     */
    Exercit() {

    }
    /**
     * Constructor del Exercit.
     * @param soldats array de soldats.
     * @param ubicacioExercit ubicacio dels exercits
     */
    public Exercit(final ArrayList<SoldatGeneral> soldats,
        final int ubicacioExercit) {
        this.soldatsExercit = soldats;
        this.ubicacio = ubicacioExercit;
    }
    /**
     * Getter de la ubicacio del exercit.
     * @return la ubicacio del exercit.
     */
    public final int getUbicacio() {
        return ubicacio;
    }
    /**
     * Setter de la ubicacio.
     * @param ubicacioExercit ubicacio de l'exercit.
     */
    public final void setUbicacio(final int ubicacioExercit) {
        this.ubicacio = ubicacioExercit;
    }

    /**
     * Metode que posiciona els soldats.
     * @param x posicio x del soldat.
     * @param y posicio y del soldat.
     */
    public final void posiciona(final double x, final double y) {



        if (this.ubicacio == 1) {
            for (int i = 0; i < soldatsExercit.size(); i++) {
                soldatsExercit.get(i).vesA(x, y);
            }
        }
        if (this.ubicacio == 2) {
            for (int i = 0; i < soldatsExercit.size(); i++) {
              double posicioX = x
                  - soldatsExercit.get(i).getImatge().getWidth();
                soldatsExercit.get(i).vesA(posicioX, y);
            }
        }

    }

    /**
     * Metode que forma els soldats, col·loca al camp.
     * @param pissarra camp de batalla.
     */
    public final void formar(final Camp pissarra) {

      double y = 0.0;
      double x = soldatsExercit.get(0).getImatge().getWidth();

        if (this.ubicacio == 1) {


          soldatsExercit.get(0).vesA(0, 0);
          soldatsExercit.get(soldatsExercit.size() - 1)
          .vesA(0, pissarra.getHEIGHT() / 2 - SEPARACIO);
            for (int i = 0; i < soldatsExercit.size() - 1; i++) {


                  if (y < pissarra.getHEIGHT() - soldatsExercit
                      .get(i).getImatge().getHeight() - NUMERO_RESTA) {
                    soldatsExercit.get(i).vesA(x, y);
                    y += soldatsExercit.get(i).getImatge().getHeight();



                  } else {
                    soldatsExercit.get(i).vesA(x, y);
                    x += soldatsExercit.get(i).getImatge().getWidth();
                    y = 0;


                  }



                }
            }

        if (this.ubicacio == 2) {

          double x2 = pissarra.getWIDTH() - soldatsExercit.get(0)
              .getImatge().getWidth() * 2;

          soldatsExercit.get(0).vesA(x2, 0);
          soldatsExercit.get(soldatsExercit.size() - 1)
          .vesA(pissarra.getWIDTH() - soldatsExercit.get(0)
              .getImatge().getWidth(), pissarra.getHEIGHT() / 2 - SEPARACIO);
      for (int i = 0; i < soldatsExercit.size() - 1; i++) {



        if (y < pissarra.getHEIGHT() - soldatsExercit.get(i)
            .getImatge().getWidth() - NUMERO_RESTA) {

          soldatsExercit.get(i).vesA(x2, y);
          y += soldatsExercit.get(i).getImatge().getHeight();

        } else {
          soldatsExercit.get(i).vesA(x2, y);
          x2 -= soldatsExercit.get(i).getImatge().getWidth();
          y = 0;

        }

      }

        }


        }
    /**
     * Metode que reubica els exercits al camp quan arriben al final.
     * @param pissarra camp de batalla.
     */
    public final void reubicarExercits(final Camp pissarra) {

      if (this.soldatsArriben()) {
      if (this.ubicacio == 1) {
        this.setUbicacio(2);
      } else {
        this.setUbicacio(1);
      }
      this.formar(pissarra);
    }

    }



    /**
     * Metode que mou els soldats, per tant l'exercit tambe.
     * @param pissarra camp de batalla.
     */
    public final void moureExercit(final Camp pissarra) {

      Random rn = new Random();

            int mou = rn.nextInt(soldatsExercit.size());


            if (!soldatsExercit.get(mou)
                .soldatArriba(pissarra, this.ubicacio)) {
                  soldatsExercit.get(mou).mouSoldat();




                } else {

                  this.reubicarExercits(pissarra);

                }



      }

    /**
     * Metode que comprova si els soldats han arribat al final del camp.
     * @return true or false, depen de si han arribat.
     */
    public final boolean soldatsArriben() {
      int cont = 0;
      for (int i = 0; i < soldatsExercit.size(); i++) {
          if (soldatsExercit.get(i).isHaArribat()) {
              cont++;
          }
      }

      if (cont == soldatsExercit.size()) {

         return true;
     }
      return false;
 }
    /**
     * Metode que aplica velocitat als soldats.
     */
    public final void aplicarVelocitat() {

      for (int i = 0; i < soldatsExercit.size(); i++) {
        if (this.getUbicacio() == 1) {
          soldatsExercit.get(i).setVelocitat(VELOCITAT_SOLDAT);
          soldatsExercit.get(i);
          SoldatGeneral.setPausa(VELOCITAT_SOLDAT);
        } else {
          soldatsExercit.get(i).setVelocitat(-VELOCITAT_SOLDAT);
          soldatsExercit.get(i);
          SoldatGeneral.setPausa(VELOCITAT_SOLDAT);

        }
      }
    }
    /**
     * Metode que mata els soldats.
     * @param atacats array que conté els altres soldats.
     */
    public final void comprovarMorts(final ArrayList<SoldatGeneral> atacats) {

      int vides;
      for (int i = atacats.size() - 1; i >= 0; i--) {

        vides = atacats.get(i).getVides();

        for (int j = this.soldatsExercit.size() - 1; j >= 0; j--) {

          if (atacats.get(i).morts(soldatsExercit.get(j))) {

            if (vides == 0) {

              atacats.get(i).getImatge().getParent()
              .remove(atacats.get(i).getImatge());
              atacats.remove(i);
              break;
            } else {

              atacats.get(i).setVides(vides--);
            }




          }

        }
      }




    }







    }





