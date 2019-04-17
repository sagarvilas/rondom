package org.test;
import java.util.*;


public class SkylineDrawing {

    static class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        boolean isStart;
        int height;

        @Override
        public int compareTo(BuildingPoint o) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
     }

    public List<int[]> getSkyline(int[][] buildings) {

        //for all start and end of building put them into List of BuildingPoint
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];
        int index = 0;
        for(int building[] : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart = true;
            buildingPoints[index].height = building[2];

            buildingPoints[index + 1] = new BuildingPoint();
            buildingPoints[index + 1].x = building[1];
            buildingPoints[index + 1].isStart = false;
            buildingPoints[index + 1].height = building[2];
            index += 2;
        }
        Arrays.sort(buildingPoints);

        //TreeMap<Integer, Integer> queue = new TreeMap<>();
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        queue1.add(0);
        //queue1.add(0);
        int prevMaxHeight = 0;
        List<int[]> result = new ArrayList<>();
        for(BuildingPoint buildingPoint : buildingPoints) {
            //if it is start of building then add the height to map. If height already exists then increment
            //the value
            if (buildingPoint.isStart) {
                queue1.add(buildingPoint.height);
              //  queue1.add(cp.height);
            } else { //if it is end of building then decrement or remove the height from map.
                queue1.remove(buildingPoint.height);
            }
            //peek the current height after addition or removal of building x.
            int currentMaxHeight = queue1.peek();
            //int currentMaxHeight = queue1.peek();
            //if height changes from previous height then this building x becomes critcal x.
            // So add it to the result.
            if (prevMaxHeight != currentMaxHeight) {
                result.add(new int[]{buildingPoint.x, currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int [][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};
        SkylineDrawing sd = new SkylineDrawing();
        List<int[]> criticalPoints = sd.getSkyline(buildings);
        criticalPoints.forEach(cp -> System.out.println(cp[0] + " " + cp[1]));

    }
}
