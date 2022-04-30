public class Person2 {
    private String name;
    private String family;
    private Integer age;
    private Integer egn;
    private String status;

    public Person2(String name, String family, int age, int egn) {
        this(name);
        this.family = family;
        setAge(age);
        setEgn(egn);
    }

    public Person2(String name, String family, int age) {
        this(name);
        this.family = family;
        setAge(age);
    }

    public void setStatus() {
        if (age > 65) {
            status = "retired";
        } else if (age <= 25) {
            status = "student";
        } else {
            status = "adult";
        }
    }

    public String getStatus() {
        return status;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEgn(Integer egn) {
        this.egn = egn;
    }

    public void setEgn(int egn) {
        if (String.valueOf(egn).length() != 10) {
            throw new IllegalArgumentException("EGN should be exactly 10 digits long!");
        }
        this.egn = egn;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        }
        this.age = age;
        setStatus();
    }

    public Person2(String name, String family) {
        this(name);
        this.family = family;
    }

    public Person2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getAge() {
        return age;
    }

    public int getEgn() {
        return egn;
    }

    @Override
    public String toString() {
        return (name == null ? "" : "name: " + name + System.lineSeparator()) +
                (family == null ? "" : "Family name: " + family + System.lineSeparator()) +
                (age == null ? "" : "age:" + age + System.lineSeparator()) +
                (egn == null ? "" : "EGN: " + egn);
    }
}
