package com.example.cmproject.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JwtToken {
    @SerializedName("token")
    @Expose

    public String token ;

    public JwtToken() {
    }

    public JwtToken(String token) {
        this.token = token;
    }
}
