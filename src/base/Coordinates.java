package base;

import java.util.Objects;
import java.util.Random;

public class Coordinates {
    private final int x;
    private final int y;
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Coordinates generateFreeCoordinates(GameMap map){
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
    public static Coordinates coordsToMove(Coordinates coordsFrom, int[] move){
        int newX = coordsFrom.getX() + move[0];
        int newY = coordsFrom.getY() + move[1];
        return new Coordinates(newX, newY);
    }

    public static boolean isValidCoords(Coordinates coordinates, GameMap map){
        int x = coordinates.getX();
        int y = coordinates.getY();
        return (y >= 0 && y < map.getWidth()) && (x >= 0 && x < map.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
