package com.company;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class Search {

    @SerializedName("ns")
    @Expose
    private int ns;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("pageid")
    @Expose
    private int pageid;
    @SerializedName("size")
    @Expose
    private int size;
    @SerializedName("wordcount")
    @Expose
    private int wordcount;
    @SerializedName("snippet")
    @Expose
    private String snippet;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    /**
     * No args constructor for use in serialization
     *
     */
    public Search() {
    }

    /**
     *
     * @param snippet
     * @param wordcount
     * @param size
     * @param ns
     * @param title
     * @param pageid
     * @param timestamp
     */
    public Search(int ns, String title, int pageid, int size, int wordcount, String snippet, String timestamp) {
        super();
        this.ns = ns;
        this.title = title;
        this.pageid = pageid;
        this.size = size;
        this.wordcount = wordcount;
        this.snippet = snippet;
        this.timestamp = timestamp;
    }

    public int getNs() {
        return ns;
    }

    public void setNs(int ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageid() {
        return pageid;
    }

    public void setPageid(int pageid) {
        this.pageid = pageid;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWordcount() {
        return wordcount;
    }

    public void setWordcount(int wordcount) {
        this.wordcount = wordcount;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRequest() {
        String request = this.snippet.substring(snippet.indexOf(">")+1, snippet.indexOf('/')-1);
        return request;
    }

    @Override
    public String toString() {
        return  snippet.replaceAll("<span class=\"searchmatch\">" + getRequest() + "</span>", getRequest());
    }
}