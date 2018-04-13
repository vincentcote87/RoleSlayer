import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by vincentcote on 2018-03-26.
 */

public class PlayerCharacter implements Parcelable {
    // Data Members

    // (build points)
//    static final int ST_PTS=10, DX_PTS=20, IQ_PTS=20, HT_PTS=10;
//    static final int HP_PTS=2, WIL_PTS=5, PER_PTS=5, FP_PTS=3;
//    static final int BS_PTS=5, BM_PTS=5;

    // Basics
    String name, race, age, sex, height, weight, description;

    // Stats
    int st=10, dx=10, iq=10, ht=10, hp=10, wil=10, per=10, fp=10;
    int basic_lift;
    float basic_speed = (dx + ht) / 4;
    int basic_move = (int)basic_speed;
    String thrust, swing;

    // Perks/Quirks
//    ArrayList<String> advantages, disadvantages;

    // Skills
    ArrayList<Skill> skills;

    // Inventory
    ArrayList<Item> inventory;
    int total_weight;

    // Notes
    String notes;

    //Other
//    int build_points=0;

    // Methods

    PlayerCharacter() {
        calcLift();
        calcDmg();

    }

    private PlayerCharacter(Parcel in) {
        name = in.readString();
        race = in.readString();
        age = in.readString();
        sex = in.readString();
        height = in.readString();
        weight = in.readString();
        description = in.readString();
        st = in.readInt();
        dx = in.readInt();
        iq = in.readInt();
        ht = in.readInt();
        hp = in.readInt();
        wil = in.readInt();
        per = in.readInt();
        fp = in.readInt();
        basic_lift = in.readInt();
        basic_move = in.readInt();
        basic_speed = in.readFloat();
        thrust = in.readString();
        swing = in.readString();
        skills = new ArrayList<Skill>();
        in.readList(skills,null);
        inventory = new ArrayList<Item>();
        in.readList(inventory, null);
    }

    PlayerCharacter(String n)
    {
        name = n;
        calcLift();
        calcDmg();

    }

    // Helpers

    private void calcLift()
    {
        basic_lift = (st * st) / 5;
    }

    private void calcSkills(String stat, int score)
    {
        for (Skill sk : skills)
            if (stat == sk.attribute)
                sk.calculate(score);
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

    // Setters

    void setSt(int score)
    {
        int diff = score - st;
//        build_points += diff * ST_PTS;
        st = score;
        calcLift();
        calcDmg();
        setHp(hp + diff);
    }

    void setDx(int score)
    {
        int diff = score - dx;
        float sDiff = diff / 4;
//        build_points += diff * DX_PTS;
        dx = score;
        setBasic_speed(basic_speed + sDiff);
        calcSkills("dx", dx);
    }

    void setIq(int score)
    {
        int diff = score - iq;
//        build_points += diff * IQ_PTS;
        iq = score;
        calcSkills("iq", iq);
        setWil(wil + diff);
        setPer(per + diff);
    }

    void setHt(int score)
    {
        int diff = score - ht;
        float sDiff = diff / 4;
//        build_points += diff * HT_PTS;
        ht = score;
        setBasic_speed(basic_speed + sDiff);
        calcSkills("ht", ht);
        setFp(fp + diff);
    }

    void setHp(int score)
    {
//        int diff = score - hp;
//        build_points += diff * HP_PTS;
        hp = score;
    }

    void setWil(int score)
    {
//        int diff = score - wil;
//        build_points += diff * WIL_PTS;
        wil = score;
        calcSkills("wil", wil);
    }

    void setPer(int score)
    {
//        int diff = score - per;
//        build_points += diff * PER_PTS;
        per = score;
        calcSkills("per", per);
    }

    void setFp(int score)
    {
//        int diff = score - fp;
//        build_points += diff * FP_PTS;
        fp = score;
    }

    void setBasic_speed(float score)
    {
        if((int)score != (int)basic_speed)
        {
            int iDiff = (int)score - (int)basic_speed;
            setBasic_move(basic_move + iDiff);
        }
        basic_speed = score;
    }

    void setBasic_move(int score)
    {
        basic_move = score;
    }

/*    void addAdvantage(String name, int pts)
    {

    }

    void addDisadvantage(String name, int pts)
    {

    }
*/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public static final Parcelable.Creator<PlayerCharacter> CREATOR = new Parcelable.Creator<PlayerCharacter>() {
        public PlayerCharacter createFromParcel(Parcel in) {
            return new PlayerCharacter(in);
        }
        public PlayerCharacter[] newArray(int size) {
            return new PlayerCharacter[size];
        }
    };

}