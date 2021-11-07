/**
 * Ce fichier contient le code de notre programme
 * Quand nous ferons de grand projet, nous aurons plusieurs fichiers
 */

// indique que nous utilisons la classe PApplet de la librairie processing
// PApplet est la classe qui contient la partie principale du code de Processing
import processing.core.PApplet;


/**
 * ProcessingApp est le nom de la classe.
 *  Nous pouvons changer ce nom mais attention, nous devons aussi changer le nom du fichier
 *
 * extends indique que notre classe ProcessingApp étend la classe PApplet
 *  on dit aussi que ProcessingApp hérite de PApplet (POO)
 *  => ProcessingApp "reçoit" (hérite de) tout le code de PApplet
 */
public class ProcessingApp extends PApplet  {

    /**
     * main est le point d'entrée de la classe
     *  = la porte d'entrée
     *  = le code qui est exécuté lorsqu'on démarre la classe / démarre le programme
     * @param args sont les arguments de la ligne de commandes (nous verrons cela plus tard)
     */
    public static void main(String[] args) {
        // crée une instance (un objet) de la classe ProcessingApp
        ProcessingApp app = new ProcessingApp();
        // crée un tableau de String contenant une seule String "Name of application"
        String[] params = {"Name of application"};
        // demande à PApplet d'exécuter notre app
        PApplet.runSketch(params, app);
    }

    /**
     * settings est la première méthode exécutée par runSketch
     *  nous l'utilisons pour préciser la taille de la fenêtre
     */
    @Override
    public void settings() {
        size(600, 600);
    }

    /**
     * setup est la seconde méthode exécutée par runSketch
     *  nous l'utilisons pour la configuration générale de l'application
     */
    @Override
    public void setup() {
        textSize(40);
        textAlign(CENTER, CENTER);
    }

    /**
     * draw est la méthode exécutée 60x par seconde par runSketch
     *  nous l'utilisons pour écrire le code dynamique
     */
    @Override
    public void draw() {
        background(0);
        noFill();
        stroke(255);
        circle(mouseX, mouseY, 300);
        fill(255);
        text("Hello", mouseX, mouseY - 50);
        text("Processing", mouseX, mouseY);
    }
}
