package fr.mael;

import java.util.ArrayList;

public abstract class Way {
    //Attibuts
    private String name;
    private ArrayList<Point> road = new ArrayList<>();

    //Constructeur
    public Way(String name){
        this.name = name;
    }

    //Methodes
    public ArrayList<Point> getRoad(){
        return road;
    }

    public String getName(){
        return name;
    }

    public abstract void baseWay(double pas);
}
