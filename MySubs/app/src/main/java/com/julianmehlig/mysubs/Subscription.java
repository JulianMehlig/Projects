package com.julianmehlig.mysubs;

import android.support.annotation.NonNull;

/**
 * Created by Julian on 07.08.2018.
 */

public class Subscription implements Comparable<Subscription>
{
    private String name;
    private String Stil;
    private double fee;

    public Subscription(String name, String Stil, double fee)
    {
        name=this.name;
        Stil=this.Stil;
        fee=this.fee;
    }

    @Override
    public int compareTo(@NonNull Subscription subscription) {
        return 0;
    }
}