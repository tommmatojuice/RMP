package com.company;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class Continue {

    @SerializedName("sroffset")
    @Expose
    private int sroffset;
    @SerializedName("continue")
    @Expose
    private String _continue;

    /**
     * No args constructor for use in serialization
     *
     */
    public Continue() {
    }

    /**
     *
     * @param _continue
     * @param sroffset
     */
    public Continue(int sroffset, String _continue) {
        super();
        this.sroffset = sroffset;
        this._continue = _continue;
    }

    public int getSroffset() {
        return sroffset;
    }

    public void setSroffset(int sroffset) {
        this.sroffset = sroffset;
    }

    public String getContinue() {
        return _continue;
    }

    public void setContinue(String _continue) {
        this._continue = _continue;
    }

    @Override
    public String toString() {
        return "sroffset " + sroffset + "_continue " + _continue;
    }
}