package base.entities.creatures;

import base.Coordinates;
import base.GameMap;
import base.PathFinder;
import base.entities.Entity;
import base.entities.utils.Health;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public abstract class Creature extends Entity {
    Health health;
    int speed;
    int[][] moveSet;
    String target;

    Creature(int hp, int speed, String target){
        this.health = new Health(hp);
        this.speed = speed;
        this.target = target;
        moveSet = new int[4][2];
        moveSet[0] = new int[]{1, 0};
        moveSet[1] = new int[]{-1, 0};
        moveSet[2] = new int[]{0,1};
        moveSet[3] = new int[]{0, -1};
    }

    public void makeMove(GameMap map, Coordinates curCoordinates){
        List<Coordinates> pathToTarget = PathFinder.findPathToTarget(map, curCoordinates, target);
        if(!pathToTarget.isEmpty()){
            if(pathToTarget.size() > 5) makeRandomMove(map, curCoordinates);
            else{
                for (int i = 0; i < speed; i++){
                    Coordinates newCoords = pathToTarget.get(pathToTarget.size() - 2 - i);
                    if(!map.isFree(newCoords)) attackTarget(curCoordinates, newCoords, map);
                    else {
                        map.moveEntity(curCoordinates, newCoords);
                        curCoordinates = newCoords;
                    }
                }
            }
        }else makeRandomMove(map, curCoordinates);
    }

    public abstract void attackTarget(Coordinates hunterCoordinates, Coordinates targetCoords, GameMap map);

    public void makeRandomMove(GameMap map, Coordinates curCoordinates){
        Random random = new Random();
        Coordinates newCoordinates;
        int randMove;
        for (int i = 0; i < speed; i++) {
            do{
                randMove = random.nextInt(0, 4);
                newCoordinates = Coordinates.coordinatesToMove(curCoordinates, moveSet[randMove]);
            }while(!Coordinates.isValidCoordinates(newCoordinates, map));
            if(map.isFree(newCoordinates)) map.moveEntity(curCoordinates, newCoordinates);
        }
    }



    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }
}
