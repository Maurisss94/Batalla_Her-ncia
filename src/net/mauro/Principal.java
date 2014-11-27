package net.mauro;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * Classe principal que conté el run.
 * @author mauro
 *
 */
public final class Principal extends GraphicsProgram {

  /**
   * Numero maxim de soldats.
   */
  private static final int NUMERO_SOLDATS = 22;
  /**
   * Alçada del camp.
   */
  private static final int HEIGHT = 600;
  /**
   * Llargada del camp.
   */
  private static final int WIDTH = 1000;
  /**
   * Creem el camp amb una mida.
   */
     private Camp campBatalla = new Camp(WIDTH, HEIGHT);



     /**
      * metode que crea els soldats.
      * @param rutaImatge ruta de on es troba la imatge del soldat.
      * @return un Array de Soldats.
      */
    public ArrayList<SoldatGeneral> crearSoldats(final String rutaImatge, String rutaImatge2, String rutaImatge3) {

        ArrayList<SoldatGeneral> soldats = new ArrayList<SoldatGeneral>();

        for (int i = 0; i < NUMERO_SOLDATS; i++) {

          if(i< 12){
            Soldat soldat1 = new Soldat(new GImage(rutaImatge));
            soldats.add(soldat1);
          }


            if((i > 13)&&(i<=18)){
              SoldatVides soldat2 = new SoldatVides(new GImage(rutaImatge2), 3);
              soldats.add(soldat2);
            }
            if((i >= 19)&&(i<=22)){
              SoldatViking soldat3 = new SoldatViking(new GImage(rutaImatge3),4);
              soldats.add(soldat3);
            }


        }
        return soldats;
    }

    /**
     * Metode que ubica exercits.
     */
    public void ubicarExercits() {


        for (int i = 0; i < campBatalla.getExercits().size(); i++) {
            if (campBatalla.getExercits().get(i).getUbicacio() == 1) {

                campBatalla.getExercits().get(i).posiciona(0.0, 0.0);

            } else {
                campBatalla.getExercits().get(i)
                .posiciona(campBatalla.getWIDTH(), 0.0);


            }

        }
    }
    /**
     * Meotde que pinta els exercits.
     * @param exercits arraylist de exercits.
     */
    public void pintarExercits(final ArrayList<Exercit> exercits) {

        for (int i = 0; i < exercits.size(); i++) {


            ArrayList<SoldatGeneral> arraysoldats = exercits.get(i).soldatsExercit;
            for (int j = 0; j < arraysoldats.size(); j++) {

                this.add(arraysoldats.get(j).getImatge());
            }

        }

    }
    /**
     * Metode que forma als Exercits.
     */
    public void formarExercits() {


        for (int i = 0; i < campBatalla.getExercits().size(); i++) {
          campBatalla.getExercits().get(i).formar(campBatalla);
        }

    }
    /**
     * Metode que ordena a moure els exercits.
     */
    public void moureExercits() {



      while (!campBatalla.shaAcabat()) {


        for (int i = 0; i < campBatalla.getExercits().size(); i++) {
          campBatalla.getExercits().get(i).aplicarVelocitat();
          campBatalla.getExercits().get(i).moureExercit(campBatalla);

          campBatalla.getExercits().get(i).comprovarMorts(
          campBatalla.getExercits().get(oponent(i)).soldatsExercit);


        }




      }



    }
    /**
     * Metode que intercanvia les ubicacions dels exercits.
     * @param exercitOponent exercit oponent.
     * @return un 1 o un 0.
     */
    public int oponent(final int exercitOponent) {

      if (exercitOponent == 0) {
        return 1;
      } else {
        return 0;
      }
    }



    /**
     * Metode run, el principal.
     */
    public void run() {

        this.setSize((int) campBatalla.getWIDTH(),
           (int) campBatalla.getHEIGHT());
        Exercit exercit1 = new Exercit(crearSoldats("soldat.png", "vides.png", "viking.png"), 1);
        Exercit exercit2 = new Exercit(crearSoldats("soldat2.png", "vides2.png", "viking2.png"), 2);
        campBatalla.afegirExercits(exercit1);
        campBatalla.afegirExercits(exercit2);
        ubicarExercits();
        pintarExercits(campBatalla.getExercits());
        formarExercits();
        moureExercits();


    }

}
