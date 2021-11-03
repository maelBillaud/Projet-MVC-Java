package fr.mael;

import java.lang.Math;

public class Lemniscate extends Way{
    //Attibuts
    private final double a;//Constante qui corresponds à la valeure maximale de x
    private double alpha ;//Angle (en radiant) qui permet, en fonction de sa valeur, de faire le tracé du lemniscate

    //Constructeur
    public Lemniscate(String name, double a){
        super(name);
        this.a = a;
        alpha = 0;
    }

    //Methodes
    //Fonction qui renvoit la valeur de x
    public double f(double alpha){
        return a * Math.cos(alpha) / (1 + Math.pow(Math.sin(alpha), 2));
    }

    //Fonction qui revoit la valeur de y
    public double g(double alpha){
        return a * Math.cos(alpha) * Math.sin(alpha)/ (1 + Math.pow(Math.sin(alpha), 2));
    }

    public void baseWay(double pas){
        for (alpha = Math.PI/2; alpha < Math.PI; alpha += pas){
            getRoad().add(new Point(f(alpha), g(alpha)));
        }
        for (alpha = Math.PI; alpha < 2*Math.PI; alpha += pas){
            getRoad().add(new Point(f(alpha), g(alpha)));
        }
        for (alpha = 0; alpha < Math.PI/2; alpha += pas){
            getRoad().add(new Point(f(alpha), g(alpha)));
        }
    }
}
