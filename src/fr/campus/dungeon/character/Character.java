package fr.campus.dungeon.character;

public abstract class Character {
    private String name;
    private int lifePoints;
    private int baseAttack;
        //constructeur
    public Character(String name, int lifePoints, int baseAttack) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.baseAttack = baseAttack;
    }
        //getter
    public String getName() {
        return name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getBaseAttack() {
        return baseAttack;
    }
        //gestion des dégâts
    public void takeDamage(int damage) {

        if (damage <= 0) {
            return;
        }

        if (damage >= lifePoints) {
            lifePoints = 0;
        } else {
            lifePoints -= damage;
        }
    }
        //Mort
    public boolean isDead() {
        return lifePoints == 0;
    }
    public int attack(Character target) {
        int damage = getAttack();
        target.takeDamage(damage);
        return damage;
    }
    public int getAttack() {
        return baseAttack;
    }
}
