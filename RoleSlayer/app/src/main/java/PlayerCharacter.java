import java.util.ArrayList;

/**
 * Created by vincentcote on 2018-03-26.
 */

public class PlayerCharacter {
    // Data Members

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

    // Methods

    PlayerCharacter() {
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
        // TO IMPLEMENT
    }
}
