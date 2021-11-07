# Exercices #
Ce projet propose quelques exercices simples avec pour objectif:
- pratiquer IntelliJ
- revoir les notions de bases:
    - if
    - switch
    - while
    - for
    - array
    - état (variables "globales")
    
## if ##
Réalisons une application utilisant l'instruction if. Pour rappel:
```java
int clef = 5;
if (clef < 10) {
    System.out.println("clef est plus petit que 10");
} else {
    System.out.println("clef est plus grand ou égal à 10");
}
```

Cette application affiche 
un fond d'écran turquoïse lorsque la souris est dans la partie supérieure de la fenêtre
et un fond d'écran jaune lorsque la souris est dans la partie inférieure.
![resultat attentdu](https://github.com/jedepaepe/java-4118/blob/master/lesson-09-intellij/exercices/Ex1If.png?raw=true).

Nous implémenterons les méthodes suivantes de PApplet:
- settings
- setup
- draw
et nous utiliserons les méthodes suivantes de PApplet:
- size
- background
- line

Une solution est disponible [github](https://github.com/jedepaepe/java-4118/blob/master/lesson-09-intellij/exercices/src/Ex1If.java).

## switch ##
Réalisons une application utilisant l'instruction switch, pour rappel voici la syntaxe:
```java
int clef = 5;
switch (clef) {
    case 1:
        System.out.println("cas 1");
        break;
    case 5:
        System.out.println("cas 5");
        break;
    default:
        System.out.println("cas par défaut");;
        }
```

Cette application affiche un cercle de 50px de rayon centré sur la souris
et dont la couleur est:
- bleue si nous tapons b, color(0, 0, 255)
- jaune si nous tapons j, color(255, 255, 0)
- mauve si nous tapons m, color(255, 0, 255)
- noir si nous tapons n, color(0)
- orange si nous tapons o, color(255, 153, 51)
- rouge si nous tapons r, color(255, 0, 0)
- turquoise si nous tapons t, color(0, 255, 255)
- vert si nous tapons v, color(0, 255, 0)
- blanc pour tout autre caractère, color(255) (utilisation du break)

Voici un exemple de résultat à l'exécution:
[résultat attendu]