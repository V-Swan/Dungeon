package fr.campus.dungeon.enemy;

import fr.campus.dungeon.character.Character;

public abstract class Enemy extends Character {

    public Enemy(String name, int lifePoints, int baseAttack) {
        super(name, lifePoints, baseAttack);
    }
}