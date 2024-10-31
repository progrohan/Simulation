package base.entities.creatures;

import base.Coordinates;
import base.GameMap;

public class Predator extends Creature{
    private final int damage = 2;

    public Predator() {
        super(10, 1, "Herbivore");
    }

    public void attack(Creature creature){}

    public int getDamage() {
        return damage;
    }

    @Override
    public void attackTarget(Coordinates hunterCoordinates, Coordinates targetCoordinates, GameMap map) {
        Predator predator = (Predator) map.getEntity(hunterCoordinates);
        Herbivore herbivore = (Herbivore) map.getEntity(targetCoordinates);
        herbivore.getDamage(predator.getDamage());
        if(!herbivore.isAlive()) map.removeEntity(targetCoordinates);
    }

}
