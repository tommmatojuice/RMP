package com.company;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class Searchinfo {

    @SerializedName("totalhits")
    @Expose
    private int totalhits;

    /**
     * No args constructor for use in serialization
     *
     */
    public Searchinfo() {
    }

    /**
     *
     * @param totalhits
     */
    public Searchinfo(int totalhits) {
        super();
        this.totalhits = totalhits;
    }

    public int getTotalhits() {
        return totalhits;
    }

    public void setTotalhits(int totalhits) {
        this.totalhits = totalhits;
    }

    @Override
    public String toString() {
        return "totalhits " + totalhits;
    }

}