package base.entities.creatures;

import base.Coordinates;
import base.GameMap;

public class Herbivore extends Creature{
    String sprite = "\uD83D\uDC30";
    public Herbivore() {
        super(5, 1, "Grass");
    }


    @Override
    public String getSprite() {
        return sprite;
    }

    @Override
    public void attackTarget(Coordinates hunterCoordinates, Coordinates targetCoordinates, GameMap map) {
        map.removeEntity(targetCoordinates);
    }

    public void getDamage(int damage){
         health.setCurHP(health.getCurHP() - damage);
    }
    public boolean isAlive(){
        return health.getCurHP() > 0;
    }
}
