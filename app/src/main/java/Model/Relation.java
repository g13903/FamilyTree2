package Model;

/**
 * Created by mirai16 on 2015/07/07.
 */
public class Relation {
    Person p;
    public Relation (Person p) {
        this.p = p;
    }

    public void male() {
        p.setSex(1);
    }
    public void female() {
        p.setSex(2);
    }
    public void parent_of(Person child) {
        p.setChild(child);
        if (p.getSex() == 1) {
            child.setFather(p);
        } else {
            child.setMother(p);
        }
    }
    public void brohter(Person brother) {
        p.setBrother(brother);
        brother.setBrother(p);
    }
}


