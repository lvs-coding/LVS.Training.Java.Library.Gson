
package com.example.traininggson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pos {

    @SerializedName("code")
    @Expose
    private Object code;
    @SerializedName("title")
    @Expose
    private Object title;

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

}
