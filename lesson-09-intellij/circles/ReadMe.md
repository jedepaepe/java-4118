# Exercice cercles #
Créons une application qui affiche des cercles concentriques
lorsque l'utilisateur clique.\
Le premier cercle a 10 pixels de diamètre.\
Le second, 20 pixels.\
Le troisième, 30 pixels.\
...\
Chaque cercle est centré sur la position de la souris au moment du click.

Les cercles sont dessinés au rythme de 5 cercles toutes les secondes.
Nous utilisons donc la méthode `frameRate` de processing.

Toutes les séries de cercles ont une couleur différente,
tirée au hazard par l'application, au moment du click.
Nous utiliserons pour cela la méthode `random` de PApplet:
```java
int red = random(255);
int green = random(255);
int blue = random(255);
stroke(red, green, blue);
```

Voici le résultat d'une exécution:

![résultat]()