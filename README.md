## Organisation du code et choix d'architecture

Le sujet initial proposait une organisation simple des équipements avec les classes `OffensiveEquipment` et `DefensiveEquipment`. J'ai choisi de faire évoluer cette structure afin de mieux représenter les responsabilités de chaque objet.

### Hiérarchie des équipements

La structure a été adaptée de la manière suivante :


- `Equipment`
  - `OffensiveEquipment` (classe abstraite)
    - `Weapon`
    - `Spell`
  - `DefensiveEquipment` (classe abstraite)
    - `Shield`
  - `Consumable`


Les classes `Weapon`, `Spell` et `Shield` héritent de leurs classes parentes afin de permettre une meilleure distinction des types d'équipements et de préparer les futures interactions entre personnages et objets.

### Pourquoi cette modification ?

Le sujet demandait initialement de différencier les équipements principalement grâce à leur type. J'ai choisi d'utiliser l'héritage à la place afin de profiter davantage des concepts de la programmation orientée objet :

- chaque classe possède une responsabilité claire ;
- le type d'un objet est directement représenté par sa classe ;
- l'utilisation du polymorphisme sera facilitée pour les futures interactions du jeu.

Par exemple, un personnage pourra facilement différencier une arme d'un sort grâce au type de l'objet :

Weapon → équipement physique
Spell → équipement magique
Shield → équipement défensif
Consumable → objet utilisable


Cette organisation permettra également d'ajouter plus facilement de nouveaux objets dans les futures itérations (nouvelles armes, sorts, potions ou équipements spécifiques).
