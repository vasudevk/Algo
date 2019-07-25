/**
 * Created by amit.k.mannur on 4/29/2018.
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BattleShip {

    private BattleShip() {
    }

    public static void main(String[] args) {
        BattleShip BattleShip = new BattleShip();
        System.out.println(BattleShip.solution(12, "1A 2A,12A 12A", "12A"));
    }

    private String solution(int N, String S, String T) {
        List<Ship> ships = parseShips(S);
        List<Point> hits = parseHits(T);

        int touched = 0, sunken = 0;
        for (Ship current : ships) {
            int touching = current.getHits(hits);
            if (touching > 0) {
                if (touching == current.getSize()) {
                    sunken++;
                } else {
                    touched++;
                }
            }
        }
        return "" + sunken + "," + touched;
    }

    private List<Point> parseHits(String hits) {
        List<Point> hitsList = new ArrayList<>();
        String[] coords = hits.split(" ");
        for (String coord : coords) {
            hitsList.add(new Point(coord));
        }
        return hitsList;
    }

    private List<Ship> parseShips(String ships) {
        List<Ship> shipsList = new ArrayList<>();
        String[] shipsCoords = ships.split(", ");
        for (String shipCoord : shipsCoords) {
            String[] coords = shipCoord.split(" ");
            shipsList.add(new Ship(new Point(coords[0]), new Point(coords[1])));
        }
        return shipsList;
    }

    static private class Point {
        int x;
        int y;

        private Point(String coord) {
            x = (coord.toUpperCase().charAt(1)) - ('A');
            y = (coord.charAt(0)) - ('1');
        }

        private boolean greaterOrEqual(Point other) {
            return x >= other.x && y >= other.y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    static private class Ship {
        private Point topLeft;
        private Point bottomRight;

        private Ship(Point topLeft, Point bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }

        private int getSize() {
            return (Math.abs(topLeft.x - bottomRight.x) + 1)
                    * (Math.abs(topLeft.y - bottomRight.y) + 1);
        }


        private int getHits(List<Point> shots) {
            Iterator<Point> shotIt = shots.iterator();
            int hits = 0;
            while (shotIt.hasNext()) {
                Point shot = shotIt.next();
                if (shot.greaterOrEqual(topLeft)
                        && bottomRight.greaterOrEqual(shot)) {
                    hits++;
                }
            }
            return hits;
        }
    }
}