package DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mirai16 on 2015/07/10.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    static private String DB_NAME = "familyTree.db";
    static private int DB_VERSION = 1;
    public DBOpenHelper ( Context context ) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Family (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " name TEXT NOT NULL," +
                        " sex TEXT NOT NULL," +
                        " father TEXT," +
                        " mother TEXT," +
                        " partner TEXT);"

        );
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Brother (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " me TEXT NOT NULL," +
                        " brother TEXT NOT NULL);"
        );
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Child (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " me TEXT NOT NULL," +
                        " child TEXT NOT NULL);"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
