package base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class PathFinder {
    public static List<Coordinates> findPathToTarget(GameMap map, Coordinates curCoordinates, String target){
        Map<Coordinates, Coordinates> toFrom = new HashMap<>();
        Queue<Coordinates> coordinatesToCheck = new LinkedList<>();
        Set<Coordinates> checkedCoordinates = new HashSet<>();
        int[][] shifts = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        coordinatesToCheck.add(curCoordinates);
        while(!coordinatesToCheck.isEmpty()){
            Coordinates cell = coordinatesToCheck.poll();
            if(!map.isFree(cell) && Objects.equals(map.getEntity(cell).getType(), target)){
                return returnPath(toFrom, cell,curCoordinates);
            }
            for(int[] shift: shifts){
                Coordinates newCoordinates = Coordinates.coordinatesToMove(cell, shift);
                if(Coordinates.isValidCoordinates(newCoordinates, map)
                        && !checkedCoordinates.contains(newCoordinates)
                        && (map.isFree(newCoordinates) || Objects.equals(map.getEntity(newCoordinates).getType(), target))){
                    coordinatesToCheck.add(newCoordinates);
                    toFrom.put(newCoordinates, cell);
                }
            }
            checkedCoordinates.add(cell);
        }
        return null;
    }

    public static List<Coordinates> returnPath(Map<Coordinates, Coordinates> toFrom, Coordinates target, Coordinates start){
        List<Coordinates> path = new ArrayList<>();
        Coordinates parent = toFrom.get(target);
        path.add(target);
        path.add(parent);
        while(parent != start){
            parent = toFrom.get(parent);
            path.add(parent);
        }
        return path;
    }
}
