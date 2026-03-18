package be.kdg.mypaint.model;

import javafx.scene.paint.Color;

public class Point {
    private  final int X;
    private  final int Y;
    private  final int PENSIZE;
    private  final Color COLOR;
    public Point(int x,int y, int PENSIZE, Color COLOR) {
        this.X=x;
        this.Y=y;
        this.PENSIZE=PENSIZE;
        this.COLOR=COLOR;


    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getPENSIZE() {
        return PENSIZE;
    }

    public Color getCOLOR() {
        return COLOR;
    }


}
