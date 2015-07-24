package Model;

/**
 * Created by mirai16 on 2015/07/07.
 */import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    int sex;
    Person father, mother;
    List<Person> child;
    List<Person> brother;

    public Person() {
        name = "";
        sex = 0;
        father = null;
        mother = null;
        child = new ArrayList<Person>();
        brother = new ArrayList<Person>();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public void setFather(Person p) {
        this.father = p;
    }
    public void setMother(Person p) {
        this.mother = p;
    }
    public void setBrother(Person p) {
        brother.add(p);
    }
    void setChild(Person p) {
        child.add(p);
    }

    String getName() {
        return name;
    }
    int getSex() {
        return sex;
    }
    Person getFather() {
        return father;
    }
    Person getMother() {
        return mother;
    }
    List<Person> getBrother() {
        return brother;
    }
    List<Person> getChild() {
        return child;
    }

}

