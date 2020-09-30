package com.company;

import static com.company.Vector.SetRandomVectors;

public class Main {
    public static void main(String[] args) {
	    Vector v1 = new Vector(2, 5, 6);
	    Vector v2 = new Vector(3.1, 4.5, 9.8);
        System.out.println("Length of v1 = " + v1.Length());
        System.out.println("Length of v2 = " + v2.Length());
        System.out.println("Scalar product of vectors = " + v1.ScalarProduct(v2));
        System.out.println("Cross product of vectors = " + v1.CrossProduct(v2));
        System.out.println("Angel between vectors = " + v1.Angle(v2));
        System.out.println("Sum of vectors = " + v1.Sum(v2));
        System.out.println("Difference of vectors = " + v1.Diff(v2));
        for(Vector v : SetRandomVectors(4)){
            System.out.println(v);
        }
    }
}
