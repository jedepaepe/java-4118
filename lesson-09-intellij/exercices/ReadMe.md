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

Nous réimplémentons (@override) les méthodes suivantes de PApplet:
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

## array ##
Les arrays sont des listes for simples, par exemple:

```java
int[] listeDEntiers ={ 10, 3, 20, 15 };

// multiplier par 2 tous les éléments
for (int i = 0; i < listeDEntiers.length; ++i) {
    listeDEntiers[i] = listeDEntiers[i] * 2;
}

// affichier le résultat dans la console
for (int item : listDEntiers) {
    System.out.println(item);
}
```

Réalisons une application qui affiche 5 carrés centrés sur la souris dont les largeurs sont 10, 20, 35, 50
en utilisant l'array:

```java
int[] sizes = {10, 20, 35, 52, 71};
```

Nous "ralletissons" l'application en diminuant le frameRate à 4 "images" par seconde:

```java
frameRate(4);
```

Voici un résultat possible:

![résultat](https://github.com/jedepaepe/java-4118/blob/master/lesson-09-intellij/exercices/Ex4Array.png?raw=true)

Nous réimplémentons (@override) les méthodes suivantes de PApplet:
- settings
- setup
- draw

Nous utilions les méthodes suivantes:
- size
- frameRate
- rectMode
- background
- noFill
- stroke
- square

Une solution est disponible [sur github](https://github.com/jedepaepe/java-4118/blob/master/lesson-09-intellij/exercices/src/Ex4Array.java).

## Etat ##
L'état contient l'information nécessaire à l'application pour fonctionner.

Lorsqu'on travaille avec PApplet, nous placerons les variables d'état juste après la déclaration de la classe,
par exemple:

```java
import processing.core.PApplet;

public class MaClasse extends PApplet {
    int stateVar1 = 10;
    String stateVar2 = "hello";
}
```

### Etat : exercice simple ###
Ecrivons une application qui affiche un écran 

### Etat : exercice complexe ###
Créons un programme qui affiche une fenêtre rouge.

Lorsque l'utilisateur clique ou tape un touche clavier, 
la fenêtre devient successivement verte, bleue, rouge, verte, bleue, rouge, ... 



1. dessine un cercle centré sur la souris lorsque l'utilisateur clique;
1. redessine tous les cercles en
   - rouge lorsque l'utilisateur tape r ou R
   - vert lorsque l'utilisateur tape v ou V
   - bleu lorsque l'utilisateur tape b ou B
   - blanc pour tout autre caratère
  
Pour gérer les couleurs, nous pouvons nous inspirer de l'exercice "switch".

Pour mémoriser la position des cercles, nous aurons besoin de trois variables d'état:
```java
// nombre maximum de cercles
final int maxCircle = 10;

// nombre de cercles
int nrCircle = 0;

// index du dernier cercle dessiné
int index = 0;

// positions x des cercles
int[] positionXs = new int[maxCircle];

// positions y des cercles
int[] positionYs = new int[maxCircle];
```

Notons que nos listes sont limitées à 10 éléments.
Il faudra gérer le dépassement de 10.

Une solution consiste à limiter les index à [0, 10[,
ce que nous pouvons faire avec un if:

```java
if (index >= maxCircle) index = 0;
```

où plus élégant:

```java
index = index % maxCircle;
```

Nous obteons ce type de résultats:

![résultat](https://github.com/jedepaepe/java-4118/blob/master/lesson-09-intellij/exercices/Ex5State.png?raw=true)

Nous réimplémentons (@override) les méthodes suivantes de PApplet:
- settings
- draw
- mousePressed

Nous utilisons les méthodes suivantes:
- size
- background
- fill
- circle

Une solution est disponible [sur github](https://github.com/jedepaepe/java-4118/blob/master/lesson-09-intellij/exercices/src/Ex6State.java).
