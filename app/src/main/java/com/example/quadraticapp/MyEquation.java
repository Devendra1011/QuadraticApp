package com.example.quadraticapp;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticapp.databinding.ActivityMainBinding;

public class MyEquation extends BaseObservable {
    String a;
    String b;
    String c;
    ActivityMainBinding binding;



    public MyEquation(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public MyEquation() {
    }


    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void solveEquation(View view){

        // Converting String to Integers

        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        // Calculating the Discriminant
        double discriminant = b*b -4*a*c;


        // finding the solutions
        double x1,x2;
        if (discriminant >0){
            // Two real and distinct roots (solutions)
            x1 = (-b + Math.sqrt(discriminant))/2*a;
            x2 = (-b - Math.sqrt(discriminant))/2*a;

            // Display the results in the textview
            binding.tvResult.setText("X1 = "+x1+"X2 = "+x2);
        } else if (discriminant <0){
            binding.tvResult.setText("No Real Roots");
        } else {
            // One Real Solution (double root)
            x1 = -b /(2*a);
            binding.tvResult.setText("x = "+x1);

        }
    }
}
