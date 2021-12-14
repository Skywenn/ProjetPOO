Projet POO
Un projet de Qualité


Pour utiliser javafx :
- installer javafx sdk sur https://gluonhq.com/products/javafx/
- installer le plugin de javafx  : ouvrir eclipse, onglet help, eclipse marketplace, rechercher "javafx", installer le premier/ "e(fx)clipse 3.7.0"
-creer ou telecharger un projet de javafx
-creer une bibliothèque utilisateur : onglet window, preference,  java, build path, user libraries, new, add external jars, puis retrouver l'endroit ou le java sdk a été installé,  lib, et selectionner tous les "javafx", open, apply and close
-utiliser la bibliothèque : clic droit sur le projet javafx, build path, add libraries, user libraries, et selectionner la bibliothèque précédemment créé
-deplacer la bibliothèque dans le module : build path, configure build path, déplacer la bibliothèque précédemment créé dans "Modulepath"
-ajouter  les arguments VM : aller sur le 3. du site https://openjfx.io/openjfx-docs/ et copier la ligne correspondant a l'OS, clic droit sur le projet javafx, run as, run configurations, armguments, coller dans "VM arguments", modifier la partie entre guillemets avec le lien vers la bibliothèque qui a été utilisé pour sélectionner tous les jar "javafx"

Normalement après toutes ces étapes ça devrait fonctionner
