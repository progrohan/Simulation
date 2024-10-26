package base.entities.creatures;

import base.Coordinates;
import base.GameMap;

public class Predator extends Creature{
    String sprite = "\uD83D\uDC3A";
    private final int damage = 2;

    public Predator() {
        super(10, 1, "Herbivore");
    }

    @Override
    public String getSprite() {
        return sprite;
    }

    public void attack(Creature creature){}

    public int getDamage() {
        return damage;
    }

    @Override
    public void attackTarget(Coordinates hunterCoords, Coordinates targetCoords, GameMap map) {
        Predator predator = (Predator) map.getEntity(hunterCoords);
        Herbivore herbivore = (Herbivore) map.getEntity(targetCoords);
        herbivore.getDamage(predator.getDamage());
        if(!herbivore.isAlive()) map.removeEntity(targetCoords);
    }

}
