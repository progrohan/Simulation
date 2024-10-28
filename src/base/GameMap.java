package base;

import base.entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    Map<Coordinates, Entity> entityList;
    private final int length;
    private final int width;

    GameMap(){
        entityList = new HashMap<>();
        this.length = 10;
        this.width = 10;
    }

    GameMap(int length, int width){
        entityList = new HashMap<>();
        this.length = length;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public boolean isFree(Coordinates coordinates){
        return !entityList.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates){
        return entityList.get(coordinates);
    }

    public Map<Coordinates, Entity> getEntitiesList(){
        return entityList;
    }

    public void putEntity(Coordinates coordinates, Entity entity){
        entityList.put(coordinates, entity);
    }

    public void removeEntity(Coordinates coordinates){
        entityList.remove(coordinates);
    }

    public void moveEntity(Coordinates from, Coordinates to){
        Entity entity = getEntity(from);
        removeEntity(from);
        putEntity(to, entity);
    }
}
