package com.example.myapplication;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RPGClub";
    public static final String TABLE_CONTACTS = "contacts";

    public static String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_CLASS = "class";
    public static final String KEY_LVL = "lvl";
    public static final String KEY_EXP = "exp";
    public static final String KEY_RACE = "race";
    public static final String KEY_BACKSTORY = "backstory";
    public static final String KEY_WORDLVIEW = "worldview";
    public static final String KEY_PNAME = "pname";
    public static final String KEY_ADD = "addd";
    public static final String KEY_ATF = "atf";
    public static final String KEY_ATS = "ats";
    public static final String KEY_ATT = "att";
    public static final String KEY_ADDAT = "addat";
    public static final String KEY_STR = "str";
    public static final String KEY_DEX = "dex";
    public static final String KEY_CON = "con";
    public static final String KEY_INT = "int";
    public static final String KEY_WIS = "wis";
    public static final String KEY_CHARIS = "charis";
    public static final String KEY_CHAROFSPELLS = "charofspells";
    public static final String KEY_DICEOFSPELLS = "diceofspells";
    public static final String KEY_ADDOFSPELLS = "addofspells";
    public static final String KEY_CHARMS = "charms";
    public static final String KEY_DICESTR = "dicestr";
    public static final String KEY_DICEDEX = "dicedex";
    public static final String KEY_DICECON = "dicecon";
    public static final String KEY_DICEINT = "diceint";
    public static final String KEY_DICEWIS = "dicewis";
    public static final String KEY_DICECHARIS = "dicecharis";
    public static final String KEY_EQP = "eqp";
    public static final String KEY_GOLD = "gold";
    public static final String KEY_SILVER = "silver";
    public static final String KEY_COPPER = "copper";
    public static final String KEY_GUILD = "guild";
    public static final String KEY_LVLOFSPELLS= "lvlofsplees";
    public static final String KEY_OTHERANDLANG = "otherandlang";
    public static final String KEY_PERSONAL = "personal";
    public static final String KEY_SPECIAL = "special";
    public static final String KEY_STORY = "story";
    public static final String KEY_TREASURE = "treasure";
    public static final String KEY_HPANDECT = "hpandect";
    public static final String KEY_LOVE = "love";
    public static final String KEY_IDEAL = "ideal";
    public static final String KEY_BAD = "bad";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        db.execSQL("create table " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " text," + KEY_CLASS + " text," + KEY_LVL + " text, " +
                 KEY_EXP + " text," + KEY_RACE + " text," + KEY_BACKSTORY + " text," + KEY_WORDLVIEW + " text," + KEY_PNAME +
                " text," + KEY_ADD + " text," + KEY_ATF + " text," + KEY_ATS + " text," + KEY_ATT + " text," + KEY_ADDAT +
                " text," + KEY_STR + " text," + KEY_DEX + " text," + KEY_CON + " text," + KEY_INT + " text," + KEY_WIS +
                " text," + KEY_CHARIS + " text," + KEY_CHAROFSPELLS + " text," + KEY_DICEOFSPELLS + " text," + KEY_ADDOFSPELLS + " text," + KEY_CHARMS +
                " text," + KEY_DICESTR + " text," + KEY_DICEDEX + " text," + KEY_DICECON + " text," + KEY_DICEINT + " text," + KEY_DICEWIS + " text," + KEY_DICECHARIS +
                " text," + KEY_EQP + " text," + KEY_GOLD + " text," + KEY_SILVER + " text," + KEY_COPPER + " text," + KEY_GUILD + " text," + KEY_LVLOFSPELLS + " text," + KEY_OTHERANDLANG +
                " text," + KEY_PERSONAL + " text," + KEY_SPECIAL + " text," + KEY_STORY + " text," + KEY_TREASURE + " text," + KEY_HPANDECT + " text," + KEY_LOVE + " text," + KEY_BAD + " text,"
                + KEY_IDEAL + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CONTACTS);

        onCreate(db);

    }

    public Cursor viewData(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "Select * from " + TABLE_CONTACTS;
        Cursor cursor = database.rawQuery(query, null);

        return cursor;
    }
}