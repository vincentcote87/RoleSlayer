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
    private Integer characterHeight = 0;
    private Integer WT = 0;

    private Integer st = 0;
    private Integer dx = 0 ;
    private Integer iq = 0;
    private Integer ht = 0;
    private Integer hp = 0;
    private Integer wil = 0;
    private Integer per = 0;
    private Integer fp = 0;
    private Integer basic_lift = 0;
    private Integer basic_move = 0;
    private Float basic_speed = null;
    private String thrust = "";
    private String swing = "";

//    skills = new ArrayList<Skill>();
//        in.readList(skills,null);
//    inventory = new ArrayList<Item>();
//in.readList(inventory, null);

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
        parcel.writeInt(characterHeight);
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

    public PlayerCharacter() {
    }

    private PlayerCharacter(Parcel in) {
        name = in.readString();
        info = in.readString();
        race = in.readString();
        sex = in.readString();
        description = in.readString();
        age = in.readInt();
        characterHeight = in.readInt();
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

    public Integer getCharacterHeight() {
        return characterHeight;
    }

    public void setCharacterHeight(Integer characterHeight) {
        this.characterHeight = characterHeight;
    }

    public Integer getWT() {
        return WT;
    }

    public void setWT(Integer WT) {
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
        this.st = st;
    }

    public Integer getDx() {
        return dx;
    }

    public void setDx(Integer dx) {
        this.dx = dx;
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
}

