package profession;

public class Teacher extends Profession {
    public Teacher(String name, String profession) {
        super(name, profession);
    }

    public Rating teach(Student student) {
        return student;
    }
}
