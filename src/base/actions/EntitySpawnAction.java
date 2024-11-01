package base.actions;

import base.Coordinates;
import base.GameMap;
import base.Utils;
import base.entities.creatures.Herbivore;
import base.entities.creatures.Predator;
import base.entities.objects.Grass;
import base.entities.objects.Rock;
import base.entities.objects.Tree;

import java.util.Random;

public class EntitySpawnAction {
    public static void spawnAllEntities(GameMap map){
        spawnPredators(map);
        spawnHerbivores(map);
        spawnGrass(map);
        spawnRocks(map);
        spawnTrees(map);
    }

    public static void spawnPredators(GameMap map){
        for (int i = 0; i < Utils.maxPredatorCount; i++) {
            Coordinates coordinates = generateFreeCoordinates(map);
            map.putEntity(coordinates, new Predator());
        }
    }

    public static void spawnHerbivores(GameMap map){
        for (int i = 0; i < Utils.maxHerbivoreCount; i++) {
            Coordinates coordinates = generateFreeCoordinates(map);
            map.putEntity(coordinates, new Herbivore());
        }
    }

    public static void spawnGrass(GameMap map){
        for (int i = 0; i < Utils.maxGrassCount; i++) {
            Coordinates coordinates = generateFreeCoordinates(map);
            map.putEntity(coordinates, new Grass());
        }
    }

    public static void spawnRocks(GameMap map){
        for (int i = 0; i < Utils.maxRockCount; i++) {
            Coordinates coordinates = generateFreeCoordinates(map);
            map.putEntity(coordinates, new Rock());
        }
    }

    public static void spawnTrees(GameMap map){
        for (int i = 0; i < Utils.maxTreeCount; i++) {
            Coordinates coordinates = generateFreeCoordinates(map);
            map.putEntity(coordinates, new Tree());
        }
    }

    private static Coordinates generateFreeCoordinates(GameMap map){
        int width = map.getWidth();
        int length = map.getLength();
        Random random = new Random();
        int randomX;
        int randomY;
        Coordinates coordinates;
        do{
            randomX = random.nextInt(0,width);
            randomY = random.nextInt(0, length);
            coordinates = new Coordinates(randomX, randomY);
        }while(!map.isFree(coordinates));
        return coordinates;
    }
}
