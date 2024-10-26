package base.actions;

import base.Coordinates;
import base.GameMap;
import base.entities.creatures.Herbivore;
import base.entities.creatures.Predator;
import base.entities.objects.Grass;
import base.entities.objects.Rock;
import base.entities.objects.Tree;
import base.utils;

public class EntitySpawnAction {
    public static void spawnAllEntities(GameMap map){
        spawnPredators(map);
        spawnHerbivores(map);
        spawnGrass(map);
        spawnRocks(map);
        spawnTrees(map);
    }

    public static void spawnPredators(GameMap map){
        for (int i = 0; i < utils.maxPredatorCount; i++) {
            Coordinates coordinates = Coordinates.generateFreeCoordinates(map);
            map.putEntity(coordinates, new Predator());
        }
    }

    public static void spawnHerbivores(GameMap map){
        for (int i = 0; i < utils.maxHerbivoreCount; i++) {
            Coordinates coordinates = Coordinates.generateFreeCoordinates(map);
            map.putEntity(coordinates, new Herbivore());
        }
    }

    public static void spawnGrass(GameMap map){
        for (int i = 0; i < utils.maxGrassCount; i++) {
            Coordinates coordinates = Coordinates.generateFreeCoordinates(map);
            map.putEntity(coordinates, new Grass());
        }
    }

    public static void spawnRocks(GameMap map){
        for (int i = 0; i < utils.maxRockCount; i++) {
            Coordinates coordinates = Coordinates.generateFreeCoordinates(map);
            map.putEntity(coordinates, new Rock());
        }
    }

    public static void spawnTrees(GameMap map){
        for (int i = 0; i < utils.maxTreeCount; i++) {
            Coordinates coordinates = Coordinates.generateFreeCoordinates(map);
            map.putEntity(coordinates, new Tree());
        }
    }
}
