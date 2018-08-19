package Profession;

public class Engineer extends Profession {
    public Engineer(String name, String profession) {
        super(name, profession);
    }

    public ProjectHouse build(House house) {
        return house;
    }
}
