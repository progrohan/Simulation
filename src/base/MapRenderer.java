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
                    System.out.print(getSprite(entity) + " ");
                }else{
                    System.out.print(".. ");
                }
            }
            System.out.println();
        }
        System.out.println("==============================");
    }

    private String getSprite(Entity entity){
        return switch (entity.getType()) {
            case "Herbivore" -> "\uD83D\uDC30";
            case "Predator" -> "\uD83D\uDC3A";
            case "Grass" -> "\uD83C\uDF3F";
            case "Rock" -> "\uD83E\uDEA8";
            case "Tree" -> "\uD83C\uDF32";
            default -> "";
        };
    }
}
