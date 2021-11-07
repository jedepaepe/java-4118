# Exercices #
Ce projet propose quelques exercices simples avec pour objectif:
- pratiquer IntelliJ
- revoir les notions de bases:
    - if
    - switch
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
![résultat attendu](https://github.com/jedepaepe/java-4118/blob/master/lesson-09-intellij/exercices/Ex2Switch.png?raw=true)

Nous implémentons (@override) les méthodes suivantes de PApplet:
- settings
- setup
- draw
- keyReleased

Nous utilisons les méthodes suivantes de PApplet:
- size
- background
- fill
- circle

Une solution est disponible [sur github](https://github.com/jedepaepe/java-4118/blob/master/lesson-09-intellij/exercices/src/Ex2Switch.java).

## Exercice for ##
Réalisons une application utilisant l'instruction for. 
Pour rappel, voici un exemple d'utilisation de for:

```java
for (int x = 10; x <= 50; ++x) {
    line(x, 0, x, height);
} 
```
Ce code dessine 6 lignes verticales:

![résultat](https://github.com/jedepaepe/java-4118/blob/master/lesson-09-intellij/exercices/For.png?raw=true)

Notre application dessine 4 carrés jaunes centrés sur la souris de 15, 30, 45, 60 pixels
lorsque nous cliquons. Voici un exemple de résultats possibles:

![résultat](https://github.com/jedepaepe/java-4118/blob/master/lesson-09-intellij/exercices/Ex3For.png?raw=true)

Nous implémenterons (override) les méthodes suivantes de PApplet:
- settings
- setup
- draw
- mousePressed

Nous utiliserons les méthodes suivantes de PApplet:
- background
- noFill
- stroke
- rectMode
- square

Une solution est disponible [sur github](https://github.com/jedepaepe/java-4118/blob/master/lesson-09-intellij/exercices/src/Ex3For.java).