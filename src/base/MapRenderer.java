package base;

import base.entities.Entity;

public class MapRenderer {

    public void render(GameMap map){
        int length = map.getLength();
        int width = map.getWidth();
        System.out.println("\n==============================");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if(!map.isFree(coordinates)){
                    Entity entity = map.getEntity(coordinates);
                    System.out.print(entity.getSprite() + " ");
                }else{
                    System.out.print(".. ");
                }
            }
            System.out.println();
        }
        System.out.println("==============================");
    }
}
