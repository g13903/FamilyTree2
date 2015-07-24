package DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mirai16 on 2015/07/10.
 */
public class DBFamily {
    DBOpenHelper helper;
    String name = "";
    String sex = "";
    String father = "";
    String mother = "";
    String partner = "";

    public DBFamily(DBOpenHelper helper) {

    }
    public  DBFamily(String name, String sex, DBOpenHelper helper) {
        this.name = name;
        this.sex = sex;
        this.helper = helper;

    }
    public DBFamily(String name, String sex, String father, String mother, String partner, DBOpenHelper helper) {
        this.name = name;
        this.sex = sex;
        this.helper = helper;
        this.father = father;
        this.mother = mother;
        this.partner = partner;
    }

    // データベースをオープン
    public void insert0() {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO Family(name, sex) VALUES('" + name + "', '" + sex + "');");
        db.close();
    }
    public void insert() {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO Family(name, sex, father, mother) " +
                "values(" + name + ", " + sex + ", " + father + ", " +
                        mother + ", " + partner + ");");
        db.close();
    }
}
