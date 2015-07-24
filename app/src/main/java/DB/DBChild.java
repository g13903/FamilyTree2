package DB;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mirai16 on 2015/07/10.
 */
public class DBChild {

    DBOpenHelper helper;
    String me = "";
    String child = "";

    public DBChild(DBOpenHelper helper) {

    }
    public  DBChild(String me, String child, DBOpenHelper helper) {
        this.me = me;
        this.child = child;
        this.helper = helper;
    }

    // データベースをオープン
    public void insert() {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO child(me, child, father, mother) " +
                "values(" + me + ", " + child + ")");
        db.execSQL("INSERT INTO child(me, child, father, mother) " +
                "values(" + child + ", " + me + ")");
        db.close();
    }
}
