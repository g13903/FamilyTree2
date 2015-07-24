package DB;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mirai16 on 2015/07/10.
 */
public class DBBrother {

    DBOpenHelper helper;
    String me = "";
    String brother = "";

    public DBBrother(DBOpenHelper helper) {

    }
    public  DBBrother(String me, String brother, DBOpenHelper helper) {
        this.me = me;
        this.brother = brother;
        this.helper = helper;
    }

    // データベースをオープン
    public void insert() {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO Brother(me, brother, father, mother) " +
                "values(" + me + ", " + brother + ")");
        db.execSQL("INSERT INTO Brother(me, brother, father, mother) " +
                "values(" + brother + ", " + me + ")");
        db.close();
    }
}
