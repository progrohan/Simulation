package base.entities.creatures;

import base.Coordinates;
import base.GameMap;
import base.PathFinder;
import base.entities.Entity;
import base.entities.utils.Health;

import java.util.List;
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

    public void makeMove(GameMap map, Coordinates curCoords){
        List<Coordinates> pathToTarget = PathFinder.findPathToTarget(map, curCoords, target);
        if(pathToTarget != null){
            if(pathToTarget.size() > 5) makeRandomMove(map, curCoords);
            else{
                for (int i = 0; i < speed; i++) {
                    Coordinates newCoords = pathToTarget.get(pathToTarget.size() - 2 - i);
                    if(!map.isFree(newCoords)) attackTarget(curCoords, newCoords, map);
                    else {
                        map.moveEntity(curCoords, newCoords);
                        curCoords = newCoords;
                    }
                }
            }
        }else makeRandomMove(map, curCoords);

    }

    public abstract void attackTarget(Coordinates hunterCoords, Coordinates targetCoords, GameMap map);

    public void makeRandomMove(GameMap map, Coordinates curCoords){
        Random random = new Random();
        Coordinates newCoords;
        int randMove;
        for (int i = 0; i < speed; i++) {
            do{
                randMove = random.nextInt(0, 4);
                newCoords = Coordinates.coordsToMove(curCoords, moveSet[randMove]);
            }while(!Coordinates.isValidCoords(newCoords, map));
            if(map.isFree(newCoords)) map.moveEntity(curCoords, newCoords);
        }
    }



    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }
}
