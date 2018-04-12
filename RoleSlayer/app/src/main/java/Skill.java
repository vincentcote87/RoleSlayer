public class Skill {
    // Data members

    String name, attribute;
    int difficulty, relative_level, level;

    // Methods

    Skill(String nm, String stat, int diff, int base)
    {
        name = nm;
        attribute = stat;
        difficulty = diff;
        relative_level = rlInit(difficulty);
        // 1 build point -- how to pass back?
        calculate(base);
    }

    void calculate(int base)
    {
        level = relative_level + base;
    }

    int rlInit(int diff)
    {
        return 1 - diff;
    }


}
