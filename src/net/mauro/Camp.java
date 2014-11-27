package net.mauro;

import java.util.ArrayList;

/**
 * Classe Camp de batalla.
 * @author mauro
 *
 */
public class Camp {

    /**
     * variable on es guardarà la alçada del camp.
     */
    private double heightCamp;
    /**
     * variable on es guardará la amplada del camp.
     */
    private double widthCamp;
    /**
     * ArrayList on guardarem els dos exercits.
     */
    private ArrayList<Exercit> exercits = new ArrayList<>();

    /**
     * Constructor per defecte.
     */
    Camp() {

    }

    /**
     * Constructor de l'objecte camp.
     * @param width amplada del camp.
     * @param height alçada del camp.
     */
    public Camp(final int width, final int height) {
        this.widthCamp = width;
        this.heightCamp = height;

    }

    /**
     * Getter de l'amplada del camp.
     * @return retorna l'amplada del camp en double.
     */
    public final double getWIDTH() {
        return widthCamp;
    }

    /**
     * Setter que aplica el width del camp.
     * @param wIDTH amplada del camp.
     */
    public final void setWIDTH(final int wIDTH) {
        widthCamp = wIDTH;
    }

    /**
     * Getter de l'alçada del camp.
     * @return retorna l'alçada del camp.
     */
    public final double getHEIGHT() {
        return heightCamp;
    }

    /**
     * Setter que aplica el height del camp.
     * @param hEIGHT alçada del camp.
     */
    public final void setHEIGHT(final int hEIGHT) {
        heightCamp = hEIGHT;
    }

    /**
     * Getter del ArrayList de Exercits.
     * @return retorna l'array de exercits.
     */
    public final ArrayList<Exercit> getExercits() {
        return exercits;
    }

    /**
     * Setter del arraylist de exercits.
     * @param arrayExercits parametre d'exercits.
     */
    public final void setExercits(final ArrayList<Exercit> arrayExercits) {
        this.exercits = arrayExercits;
    }

    /**
     * Metode que afegeix els exercits al Array.
     * @param exercitaAfegir Exercit que s'ha de afegir a l'array.
     */
    public final  void afegirExercits(final Exercit exercitaAfegir) {

        exercits.add(exercitaAfegir);

    }

    /**
     * Metode que comprova si queda algun soldat viu.
     * @return un boolea que ens diu si hi han soldats o no.
     */
    public final  boolean shaAcabat() {

        return exercits.get(0).soldatsExercit.size() == 0;
    }

}
