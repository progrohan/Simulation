package base;


import base.actions.EntitySpawnAction;
import base.actions.MoveAllCreaturesAction;

public class Simulation {
    private GameMap gameMap;
    private MapRenderer renderer;
    private int stepCounter;
    private boolean isRunning;

    Simulation(){
        this.gameMap = new GameMap();
        this.renderer = new MapRenderer();
        this.stepCounter = 0;
        this.isRunning = false;
        EntitySpawnAction.spawnAllEntities(this.gameMap);
    }

    public void nextTurn(){
        MoveAllCreaturesAction.moveAllCreatures(gameMap);
        renderer.render(gameMap);
    }

    public void startSimulation() {
        isRunning = true;
        while(isRunning){
            nextTurn();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopSimulation(){
        isRunning = false;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public MapRenderer getRenderer() {
        return renderer;
    }


    public int getStepCounter() {
        return stepCounter;
    }

}
