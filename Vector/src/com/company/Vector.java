package com.company;

public class Vector {
    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double Length(){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
    }

    public double ScalarProduct(Vector v){
        return (x*v.x+y*v.y+z*v.z);
    }

    public Vector CrossProduct(Vector v){
        return new Vector(y*v.z-z*v.y, z*v.x-x*v.z,x*v.y-y*v.x);
    }

    public double Angle(Vector v){
        return (this.ScalarProduct(v)/(this.Length()*v.Length()));
    }

    public Vector Sum(Vector v){
        return new Vector(x+v.x, y+v.y, z+v.z);
    }

    public Vector Diff(Vector v){
        return new Vector(x-v.x, y-v.y, z-v.z);
    }

    public static Vector[] SetRandomVectors(int N){
        Vector[] array = new Vector[N];
        for(int i=0; i< array.length; i++)
            array[i]=new Vector(Math.random()*100, Math.random()*100, Math.random()*100);
        return array;
    }

    @Override
    public String toString() {
        return "Vector(" + x +", "+ y+", " + z+")";
    }
}
