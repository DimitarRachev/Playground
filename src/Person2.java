public class Person2 {
    private String name;
    private String family;
    private Integer age;
    private Integer egn;

    public Person2(String name, String family, int age, int egn) {
        this(name);
        this.family = family;
        this.age = age;
        this.egn = egn;
    }

    public Person2(String name, String family, int age) {
        this(name);
        this.family = family;
        this.age = age;
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
        StringBuilder sb = new StringBuilder();
        sb.append(name== null ? "" : "name: " + name + System.lineSeparator());
        sb.append(family== null ? "" : "Family name: " +  family + System.lineSeparator());
        sb.append(age == null ? "" : "age:" + age + System.lineSeparator());
        sb.append(egn == null ? "" : "EGN: " + egn);
        return sb.toString();
    }
}
