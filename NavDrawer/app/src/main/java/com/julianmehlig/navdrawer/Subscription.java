package com.julianmehlig.navdrawer;

import android.support.annotation.NonNull;

public class Subscription implements Comparable<Subscription>
{
    private int id;
    private String name;
    private double cost;

    public Subscription(int id, String name, double cost)
    {
        id=this.id;
        name=this.name;
        cost=this.cost;
    }
    public Subscription(String name, double cost)
    {
        name=this.name;
        cost=this.cost;
    }
    public Subscription(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return name;
    }

    public String returnCost()
    {
        return cost + "€";
    }

    @Override
    public int compareTo(@NonNull Subscription subscription) {
        return 0;
    }
}
