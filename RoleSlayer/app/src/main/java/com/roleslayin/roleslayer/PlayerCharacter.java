package com.roleslayin.roleslayer;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.IOError;
import java.util.ArrayList;

public class PlayerCharacter implements Parcelable {
    String name = "";
    String info = "";



    String race = "";
    String sex = "";
    String description = "";

    Integer age = 0;
    Integer HT = 0;
    Integer WT = 0;

    ArrayList<CharacterItem> inventory = new ArrayList<>();

    public void addItem(CharacterItem x) {
        inventory.add(x);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(info);
        parcel.writeString(race);
        parcel.writeString(sex);
        parcel.writeString(description);
        parcel.writeInt(age);
        parcel.writeInt(HT);
        parcel.writeInt(WT);

    }

    public static final Parcelable.Creator<PlayerCharacter> CREATOR = new Parcelable.Creator<PlayerCharacter>() {
        public PlayerCharacter createFromParcel(Parcel in) {
            return new PlayerCharacter(in);
        }
        public PlayerCharacter[] newArray(int size) {
            return new PlayerCharacter[size];
        }
    };

    public PlayerCharacter() {}

    private PlayerCharacter(Parcel in) {
        name = in.readString();
        info = in.readString();
        race = in.readString();
        sex = in.readString();
        description = in.readString();
        age = in.readInt();
        HT = in.readInt();
        WT = in.readInt();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }
    public String getInfo() {
        return info;
    }
    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHT() {
        return HT;
    }

    public void setHT(Integer HT) {
        this.HT = HT;
    }

    public Integer getWT() {
        return WT;
    }

    public void setWT(Integer WT) {
        this.WT = WT;
    }
}

