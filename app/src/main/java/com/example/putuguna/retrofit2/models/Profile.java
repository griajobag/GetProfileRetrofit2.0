package com.example.putuguna.retrofit2.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by putuguna on 14/06/16.
 */
public class Profile {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("job")
    private String job;
    @SerializedName("age")
    private String age;

    public Profile(String id, String name, String job, String age) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.age = age;
    }

    public Profile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
