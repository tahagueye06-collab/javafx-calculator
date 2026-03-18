package be.kdg.mypaint.model;

import java.util.ArrayList;
import java.util.List;

public class PaintModel {
    private List<Point> points= new ArrayList<>();

    public void addPoint(Point p){
        points.add(p);
    }

    public void clear(){
        points.clear();
    }

    public List<Point> getPoints() {
        return points;
    }
    public void undoLast(){
        if(points.size() >0) {
            points.remove(points.size() -1);
        }
    }
}
