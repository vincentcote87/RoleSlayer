import java.util.ArrayList;

/**
 * Created by vincentcote on 2018-03-26.
 */

public class PlayerCharacter {
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

    void setSt(int score)
    {

    }
}
