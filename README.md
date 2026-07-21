## Ajout d'une classe `Consumable`

Le sujet regroupe les boucliers et les potions dans `DefensiveEquipment`, mais ces objets ont des comportements différents.

J'ai choisi de créer une classe `Consumable` pour séparer les objets équipables (comme les boucliers) des objets utilisables une seule fois (comme les potions).

Cette séparation respecte le principe de responsabilité unique et facilite l'ajout de nouveaux objets consommables dans les futures itérations.

Structure :

```
Equipment
│
├── OffensiveEquipment
├── DefensiveEquipment
└── Consumable
```

Les équipements récupérés sont stockés dans l'inventaire indépendamment de leur compatibilité avec la classe du personnage. La compatibilité est vérifiée uniquement lors de l'équipement.
