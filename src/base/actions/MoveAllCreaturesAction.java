package base.actions;

import base.Coordinates;
import base.GameMap;
import base.entities.Entity;
import base.entities.creatures.Creature;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MoveAllCreaturesAction {
    public static void moveAllCreatures(GameMap map){
        ArrayList<Coordinates> entityList =  new ArrayList<>(map.getEntitiesList().keySet()) ;
        Set<Entity> alreadyMoved = new HashSet<>();
        for(Coordinates coords: entityList){
            Entity entity = map.getEntity(coords);
            if( (entity != null) && alreadyMoved.add(entity)){
                if(Objects.equals(entity.getType(), "Herbivore")
                        || Objects.equals(entity.getType(), "Predator")){
                    Creature creature = (Creature) entity;
                    creature.makeMove(map, coords);
                }
            }
        }
    }
}
