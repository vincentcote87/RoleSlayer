import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by vincentcote on 2018-03-26.
 */

public class PlayerCharacter implements Parcelable
{
    // Data Members

    // Constants
    static final int ST_PTS=10, DX_PTS=20, IQ_PTS=20, HT_PTS=10;
    static final int HP_PTS=2, WIL_PTS=5, PER_PTS=5, FP_PTS=3;
    static final int BS_PTS=5, BM_PTS=5;

    // Basics
    String name, race, age, sex, height, weight, description;

    // Stats
    int st=10, dx=10, iq=10, ht=10, hp=10, wil=10, per=10, fp=10, basic_lift, basic_move;
    float basic_speed;
    String thrust, swing;

    // Perks/Quirks
    ArrayList<String> advantages, disadvantages;

    // Skills
    ArrayList<Skill> skills;

    // Inventory
    ArrayList<Item> inventory;

    // Notes
    ArrayList<String> notes;

    //Other
    int build_points=0;

    // Methods

    PlayerCharacter() {
        calcSpeed();
        calcLift();

    }

    private PlayerCharacter(Parcel in) {
        name = in.readString();
        // ETC
    }

    PlayerCharacter(String n)
    {
        name = n;
        calcSpeed();
        calcLift();

    }

    void calcSpeed()
    {
        basic_speed = (dx + ht) / 4;
        basic_move = (int)basic_speed;
    }

    void calcLift()
    {
        basic_lift = (st * st) / 5;
    }

    void calcSkills(String stat, int score)
    {
        // Loop through skills looking for stat == attribute,
        // And call skill.calculate(score)
    }

    void calcDmg()
    {
        // Do I just use a table/big long switch I guess?
    }

    void setSt(int score)
    {
        int diff = score - st;
        build_points += diff * ST_PTS;
        st = score;
        calcLift();
        calcDmg();
        setHp(hp + diff);
    }

    void setDx(int score)
    {
        int diff = score - dx;
        build_points += diff * DX_PTS;
        dx = score;
        calcSpeed();
        calcSkills("dx", dx);
    }

    void setIq(int score)
    {
        int diff = score - iq;
        build_points += diff * IQ_PTS;
        iq = score;
        calcSkills("iq", iq);
        setWil(wil + diff);
        setPer(per + diff);
    }

    void setHt(int score)
    {
        int diff = score - ht;
        build_points += diff * HT_PTS;
        ht = score;
        calcSpeed();
        calcSkills("ht", ht);
        setFp(fp + diff);
    }

    void setHp(int score)
    {
        int diff = score - hp;
        build_points += diff * HP_PTS;
        hp = score;
    }

    void setWil(int score)
    {
        int diff = score - wil;
        build_points += diff * WIL_PTS;
        wil = score;
        calcSkills("wil", wil);
    }

    void setPer(int score)
    {
        int diff = score - per;
        build_points += diff * PER_PTS;
        per = score;
        calcSkills("per", per);
    }

    void setFp(int score)
    {
        int diff = score - fp;
        build_points += diff * FP_PTS;
        fp = score;
    }



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
