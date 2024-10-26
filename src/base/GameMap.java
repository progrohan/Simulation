package base;

import base.entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    Map<Coordinates, Entity> entity_list;
    private final int length;
    private final int width;

    GameMap(){
        entity_list = new HashMap<>();
        this.length = 10;
        this.width = 10;
    }

    GameMap(int length, int width){
        entity_list = new HashMap<>();
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
        return !entity_list.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates){
        return entity_list.get(coordinates);
    }

    public Map<Coordinates, Entity> getEntitiesList(){
        return entity_list;
    }

    public void putEntity(Coordinates coordinates, Entity entity){
        entity_list.put(coordinates, entity);
    }

    public void removeEntity(Coordinates coordinates){
        entity_list.remove(coordinates);
    }

    public void moveEntity(Coordinates from, Coordinates to){
        Entity entity = getEntity(from);
        removeEntity(from);
        putEntity(to, entity);
    }
}
