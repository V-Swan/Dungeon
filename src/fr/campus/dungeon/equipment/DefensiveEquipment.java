package fr.campus.dungeon.equipment;

public abstract class DefensiveEquipment extends Equipment{

        private int damageReduction;

        public DefensiveEquipment(String name, int damageReduction){
            super(name);
            this.damageReduction = damageReduction;

        }

        public int getDamageReduction() {
            return damageReduction;
        }

        @Override
        public String toString() {
            return super.toString() +
                    " -" + damageReduction + " dégât";
        }
    }
