package com.company;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class Query {

    @SerializedName("searchinfo")
    @Expose
    private Searchinfo searchinfo;
    @SerializedName("search")
    @Expose
    private List<Search> search = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Query() {
    }

    /**
     *
     * @param search
     * @param searchinfo
     */
    public Query(Searchinfo searchinfo, List<Search> search) {
        super();
        this.searchinfo = searchinfo;
        this.search = search;
    }

    public Searchinfo getSearchinfo() {
        return searchinfo;
    }

    public void setSearchinfo(Searchinfo searchinfo) {
        this.searchinfo = searchinfo;
    }

    public List<Search> getSearch() {
        return search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return search.toString().substring(1).substring(0, search.toString().length()-2);
    }

}