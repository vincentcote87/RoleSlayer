package com.roleslayin.roleslayer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class PlayerCharacter implements Parcelable {


    private String name = "";
    private String info = "";
    private String race = "";
    private String sex = "";
    private String description = "";
    private String playerNotes = "";
    private Integer age = 0;
    private String characterHeight = "0.0 ft";
    private String WT = "0 lbs";
    private Integer st = 10;
    private Integer dx = 10 ;
    private Integer iq = 10;
    private Integer ht = 10;
    private Integer hp = 10;
    private Integer wil = 0;
    private Integer per = 0;
    private Integer fp = 10;
    private Integer basic_lift = 0;
    private Integer basic_move = 0;
    private float basic_speed = 0;
    private String thrust = "";
    private String swing = "";

    ArrayList<CharacterItem> inventory = new ArrayList<>();

    public PlayerCharacter() {
        runCalcs();
    }

    private void runCalcs() {
        calcDmg();
        calcLift();
        calcSpeed();
    }

    private void calcDmg()
    {
        switch(st)
        {
            case 1:
                thrust = "1d-6";
                swing = "1d-5";
                break;
            case 2:
                thrust = "1d-6";
                swing = "1d-5";
                break;
            case 3:
                thrust = "1d-5";
                swing = "1d-4";
                break;
            case 4:
                thrust = "1d-5";
                swing = "1d-4";
                break;
            case 5:
                thrust = "1d-4";
                swing = "1d-3";
                break;
            case 6:
                thrust = "1d-4";
                swing = "1d-3";
                break;
            case 7:
                thrust = "1d-3";
                swing = "1d-2";
                break;
            case 8:
                thrust = "1d-3";
                swing = "1d-2";
                break;
            case 9:
                thrust = "1d-2";
                swing = "1d-1";
                break;
            case 10:
                thrust = "1d-2";
                swing = "1d";
                break;
            case 11:
                thrust = "1d-1";
                swing = "1d+1";
                break;
            case 12:
                thrust = "1d-1";
                swing = "1d+2";
                break;
            case 13:
                thrust = "1d";
                swing = "2d-1";
                break;
            case 14:
                thrust = "1d";
                swing = "2d";
                break;
            case 15:
                thrust = "1d+1";
                swing = "2d+1";
                break;
            case 16:
                thrust = "1d+1";
                swing = "2d+2";
                break;
            case 17:
                thrust = "1d+2";
                swing = "3d-1";
                break;
            case 18:
                thrust = "1d+2";
                swing = "3d";
                break;
            case 19:
                thrust = "2d-1";
                swing = "3d+1";
                break;
            case 20:
                thrust = "2d-1";
                swing = "3d+2";
                break;

        }
    }

    private void calcLift() {
        basic_lift = (st * st) / 5;
    }

    private void calcSpeed() {
        basic_speed = (float)(dx + fp) /4;
        basic_move = (int)basic_speed;
    }

    public void addItem(CharacterItem x) {
        inventory.add(x);
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

    public String getCharacterHeight() {
        return characterHeight;
    }

    public void setCharacterHeight(String characterHeight) {
        this.characterHeight = characterHeight;
    }

    public String getWT() {
        return WT;
    }

    public void setWT(String WT) {
        this.WT = WT;
    }

    public String getPlayerNotes() {
        return playerNotes;
    }

    public void setPlayerNotes(String playerNotes) {
        this.playerNotes = playerNotes;
    }
    public Integer getSt() {
        return st;
    }

    public void setSt(Integer st) {
        int diff = st - this.st;
//        build_points += diff * ST_PTS;
        this.st = st;
//        setHp(this.st + diff);
        runCalcs();
    }

    public Integer getDx() {
        return dx;
    }

    public void setDx(Integer dx) {
        this.dx = dx;
        runCalcs();
    }

    public Integer getIq() {
        return iq;
    }

    public void setIq(Integer iq) {
        this.iq = iq;
    }

    public Integer getHt() {
        return ht;
    }

    public void setHt(Integer ht) {
        this.ht = ht;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getWil() {
        return wil;
    }

    public void setWil(Integer wil) {
        this.wil = wil;
    }

    public Integer getPer() {
        return per;
    }

    public void setPer(Integer per) {
        this.per = per;
    }

    public Integer getFp() {
        return fp;
    }

    public void setFp(Integer fp) {
        this.fp = fp;
        runCalcs();
    }

    public Integer getBasic_lift() {
        return basic_lift;
    }

    public void setBasic_lift(Integer basic_lift) {
        this.basic_lift = basic_lift;
    }

    public Integer getBasic_move() {
        return basic_move;
    }

    public void setBasic_move(Integer basic_move) {
        this.basic_move = basic_move;
    }

    public Float getBasic_speed() {
        return basic_speed;
    }

    public void setBasic_speed(Float basic_speed) {
        this.basic_speed = basic_speed;
    }

    public String getThrust() {
        return thrust;
    }

    public void setThrust(String thrust) {
        this.thrust = thrust;
    }

    public String getSwing() {
        return swing;
    }

    public void setSwing(String swing) {
        this.swing = swing;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeString(name);
//        parcel.writeString(info);
//        parcel.writeString(race);
//        parcel.writeString(sex);
//        parcel.writeString(description);
//        parcel.writeInt(age);
//        parcel.writeInt(characterHeight);
//        parcel.writeInt(WT);

    }

    public static final Parcelable.Creator<PlayerCharacter> CREATOR = new Parcelable.Creator<PlayerCharacter>() {
        public PlayerCharacter createFromParcel(Parcel in) {
            return new PlayerCharacter(in);
        }

        public PlayerCharacter[] newArray(int size) {
            return new PlayerCharacter[size];
        }
    };

    private PlayerCharacter(Parcel in) {
//        name = in.readString();
//        info = in.readString();
//        race = in.readString();
//        sex = in.readString();
//        description = in.readString();
//        age = in.readInt();
//        characterHeight = in.readInt();
//        WT = in.readInt();
    }
}

