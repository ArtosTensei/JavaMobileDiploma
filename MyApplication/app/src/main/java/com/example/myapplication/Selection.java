package com.example.myapplication;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import java.util.ArrayList;

import static com.example.myapplication.DBHelper.KEY_ID;

public class Selection extends AppCompatActivity
{
    Dialog editionanddelete;

    String[] name = new String[0];
    private GestureDetectorCompat lSwipeDetector;

    LinearLayout selection;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    ListView namess;
    EditText name_char;
    EditText classs;
     EditText lvl ;
     EditText race ;
     EditText backstory ;
     EditText worldview ;
     EditText name_player ;
     EditText exp ;
     EditText str ;
     EditText dex ;
     EditText con;
     EditText inte ;
     EditText wis ;
     EditText charis ;
     EditText addddd;
     EditText at1 ;
     EditText at2 ;
     EditText at3 ;
     EditText adat ;
     EditText charmsss;
     EditText dicestr ;
     EditText dicedex;
     EditText dicecon ;
     EditText diceinte ;
     EditText dicewis ;
     EditText dicecharis ;
     EditText eq ;
     EditText gold;
     EditText silver ;
     EditText copper ;
     EditText treasuree ;
     EditText historyy;
     EditText spec ;
     EditText pers;
     EditText ideals ;
     EditText love ;
     EditText bad ;
     EditText otherandlangg ;
     EditText guildss ;
     EditText lvlsofspellss ;
     EditText hpandectt ;
     EditText charofspell;
     EditText diceofspell;
     EditText aaddofspell ;

     Integer c1;
     Integer idd;


    private static final int SWIPE_MIN_DISTANCE = 130;
    private static final int SWIPE_MAX_DISTANCE = 300;
    private static final int SWIPE_MIN_VELOCITY = 200;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        editionanddelete = new Dialog(Selection.this);
        editionanddelete.setContentView(R.layout.editionanddelete);
        editionanddelete.setTitle("Персонаж");


        name_char = editionanddelete.findViewById(R.id.name_char);
        classs = editionanddelete.findViewById(R.id.classs);
         lvl = editionanddelete.findViewById(R.id.lvl);
          race = editionanddelete.findViewById(R.id.race);
          backstory = editionanddelete.findViewById(R.id.backstory);
          worldview = editionanddelete.findViewById(R.id.worldview);
          name_player = editionanddelete.findViewById(R.id.name_player);
          exp = editionanddelete.findViewById(R.id.exp);
          str = editionanddelete.findViewById(R.id.str);
          dex = editionanddelete.findViewById(R.id.dex);
          con = editionanddelete.findViewById(R.id.con);
          inte = editionanddelete.findViewById(R.id.inte);
          wis = editionanddelete.findViewById(R.id.wis);
          charis = editionanddelete.findViewById(R.id.charis);
          addddd = editionanddelete.findViewById(R.id.addd);
          at1 = editionanddelete.findViewById(R.id.at1);
          at2 = editionanddelete.findViewById(R.id.at2);
          at3 = editionanddelete.findViewById(R.id.at3);
          adat = editionanddelete.findViewById(R.id.addat);
          charmsss = editionanddelete.findViewById(R.id.charmss);
          dicestr = editionanddelete.findViewById(R.id.dicestr);
          dicedex = editionanddelete.findViewById(R.id.dicedex);
          dicecon = editionanddelete.findViewById(R.id.dicecon);
          diceinte = editionanddelete.findViewById(R.id.diceinte);
          dicewis = editionanddelete.findViewById(R.id.dicewis);
          dicecharis = editionanddelete.findViewById(R.id.dicecharis);
          eq = editionanddelete.findViewById(R.id.eq);
          gold = editionanddelete.findViewById(R.id.gold);
          silver = editionanddelete.findViewById(R.id.silver);
          copper = editionanddelete.findViewById(R.id.copper);
          treasuree = editionanddelete.findViewById(R.id.treasuree);
          historyy = editionanddelete.findViewById(R.id.historyy);
          spec = editionanddelete.findViewById(R.id.spec);
          pers = editionanddelete.findViewById(R.id.pers);
          ideals = editionanddelete.findViewById(R.id.ideals);
          love = editionanddelete.findViewById(R.id.love);
          bad = editionanddelete.findViewById(R.id.bad);
          otherandlangg = editionanddelete.findViewById(R.id.otherandlangg);
          guildss = editionanddelete.findViewById(R.id.guilds);
          lvlsofspellss = editionanddelete.findViewById(R.id.lvlsofspells);
          hpandectt = editionanddelete.findViewById(R.id.hpandect);
          charofspell = editionanddelete.findViewById(R.id.charofspell);
          diceofspell = editionanddelete.findViewById(R.id.diceofspell);
          aaddofspell = editionanddelete.findViewById(R.id.aaddofspell);

        listItem = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection);
        getSupportActionBar().hide();

        dbHelper = new DBHelper(this);

        namess = findViewById(R.id.listt);

        if((listItem.isEmpty()))
        {
            viewData();
        }
        lSwipeDetector = new GestureDetectorCompat(this, new MyGestureListener());
        selection = (LinearLayout) findViewById(R.id.selection);

        Button btn1 = findViewById(R.id.btn1);
       // final Button btn2 = findViewById(R.id.btn2);

        final Button delete = editionanddelete.findViewById(R.id.btn3);
        final Button save = editionanddelete.findViewById(R.id.btn4);

        final ListView list = findViewById(R.id.listt);

        namess.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Log.i("gfdgd", String.valueOf(c1));

                loadData(position);

                idd = loadData(position);
                editionanddelete.show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent i=new Intent(Selection.this,Creation.class);
                startActivity(i);
            }
        });

       /* btn2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                    SQLiteDatabase database = dbHelper.getWritableDatabase();
                    Cursor cursor = database.rawQuery("SELECT * FROM contacts;", null);

                    if (cursor.moveToFirst()) {
                        int idIndex = cursor.getColumnIndex(String.valueOf(KEY_ID));
                        int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                        do {
                            Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                                    ", name = " + cursor.getString(nameIndex));

                        } while (cursor.moveToNext());
                    } else
                        Log.d("mLog","0 rows");

                    cursor.close();

                }
        });*/

        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();

                String nameIndex = String.valueOf(name_char.getText());
                String  classss= String.valueOf(classs.getText());
                String  lvls= String.valueOf(lvl.getText());
                String races= String.valueOf(race.getText());
                String back= String.valueOf(backstory.getText());
                String  world= String.valueOf(worldview .getText());
                String  pname= String.valueOf(name_player .getText());
                String  ex= String.valueOf(exp .getText());
                String strr = String.valueOf(str.getText());
                String  dexx= String.valueOf(dex .getText());
                String conn= String.valueOf(con.getText());
                String intel = String.valueOf(inte .getText());
                String  wiss= String.valueOf(wis.getText());
                String chariss= String.valueOf(charis .getText());
                String  ad= String.valueOf(addddd .getText());
                String atf = String.valueOf(at1 .getText());
                String ats= String.valueOf(at2.getText());
                String  att= String.valueOf(at3 .getText());
                String addat = String.valueOf(adat .getText());
                String charmss = String.valueOf(charmsss .getText());
                String dicestrr= String.valueOf(dicestr .getText());
                String  dicedexx= String.valueOf(dicedex .getText());
                String diceconn= String.valueOf(dicecon .getText());
                String diceint= String.valueOf(diceinte .getText());
                String dicewiss = String.valueOf(dicewis .getText());
                String dicechariss = String.valueOf(dicecharis.getText());
                String  eqp= String.valueOf(eq.getText());
                String goldd = String.valueOf(gold .getText());
                String  silverr = String.valueOf(silver.getText());
                String  copperr = String.valueOf(copper.getText());
                String  treas= String.valueOf(treasuree .getText());
                String  story= String.valueOf(historyy .getText());
                String  specc= String.valueOf(spec .getText());
                String per = String.valueOf(pers .getText());
                String  ideal = String.valueOf(ideals .getText());
                String loves= String.valueOf(love.getText());
                String bads= String.valueOf(bad.getText());
                String other = String.valueOf(otherandlangg .getText());
                String  guilds= String.valueOf(guildss .getText());
                String lvlof= String.valueOf(lvlsofspellss.getText());
                String  hp= String.valueOf(hpandectt .getText());
                String charof= String.valueOf(charofspell .getText());
                String diceof = String.valueOf(diceofspell.getText());
                String addof= String.valueOf(aaddofspell .getText());

                contentValues.put(DBHelper.KEY_NAME, nameIndex);
                contentValues.put(DBHelper.KEY_CLASS, classss);
                contentValues.put(DBHelper.KEY_LVL, lvls);
                contentValues.put(DBHelper.KEY_RACE, races);
                contentValues.put(DBHelper.KEY_BACKSTORY, back);
                contentValues.put(DBHelper.KEY_WORDLVIEW, world);
                contentValues.put(DBHelper.KEY_PNAME, pname);
                contentValues.put(DBHelper.KEY_EXP, ex);
                contentValues.put(DBHelper.KEY_STR, strr);
                contentValues.put(DBHelper.KEY_DEX, dexx);
                contentValues.put(DBHelper.KEY_CON, conn);
                contentValues.put(DBHelper.KEY_INT, intel);
                contentValues.put(DBHelper.KEY_WIS, wiss);
                contentValues.put(DBHelper.KEY_CHARIS, chariss);
                contentValues.put(DBHelper.KEY_OTHERANDLANG, other);
                contentValues.put(DBHelper.KEY_ADD, ad);
                contentValues.put(DBHelper.KEY_CHAROFSPELLS, charof);
                contentValues.put(DBHelper.KEY_DICEOFSPELLS, diceof);
                contentValues.put(DBHelper.KEY_ADDOFSPELLS, addof);
                contentValues.put(DBHelper.KEY_DICESTR, dicestrr);
                contentValues.put(DBHelper.KEY_DICEDEX, dicedexx);
                contentValues.put(DBHelper.KEY_DICECON, diceconn);
                contentValues.put(DBHelper.KEY_DICEINT, diceint);
                contentValues.put(DBHelper.KEY_DICEWIS, dicewiss);
                contentValues.put(DBHelper.KEY_DICECHARIS, dicechariss);
                contentValues.put(DBHelper.KEY_EQP, eqp);
                contentValues.put(DBHelper.KEY_GOLD, goldd);
                contentValues.put(DBHelper.KEY_SILVER, silverr);
                contentValues.put(DBHelper.KEY_COPPER, copperr);
                contentValues.put(DBHelper.KEY_GUILD, guilds);
                contentValues.put(DBHelper.KEY_HPANDECT, hp);
                contentValues.put(DBHelper.KEY_LVLOFSPELLS, lvlof);
                contentValues.put(DBHelper.KEY_PERSONAL, per);
                contentValues.put(DBHelper.KEY_IDEAL, ideal);
                contentValues.put(DBHelper.KEY_LOVE, loves);
                contentValues.put(DBHelper.KEY_BAD, bads);
                contentValues.put(DBHelper.KEY_ATF, atf);
                contentValues.put(DBHelper.KEY_ATS, ats);
                contentValues.put(DBHelper.KEY_ATT, att);
                contentValues.put(DBHelper.KEY_ADDAT, addat);
                contentValues.put(DBHelper.KEY_CHARMS, charmss);
                contentValues.put(DBHelper.KEY_TREASURE, treas);
                contentValues.put(DBHelper.KEY_STORY, story);
                contentValues.put(DBHelper.KEY_SPECIAL, specc);

                int updCount = database.update(DBHelper.TABLE_CONTACTS, contentValues, DBHelper.KEY_ID + "=" +idd, null);
                listItem.clear();

                viewData();
                editionanddelete.cancel();
            }
        });

        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                listItem.remove(0);

                database.delete(DBHelper.TABLE_CONTACTS, DBHelper.KEY_ID + "=" + idd, null);

                viewData1();

                editionanddelete.cancel();

            }
        });

        selection.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return lSwipeDetector.onTouchEvent(event);
            }
        });
    }

    private void viewData() {
        Cursor cursor = dbHelper.viewData();

        while(cursor.moveToNext())
        {
                listItem.add(cursor.getString(1));
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
        namess.setAdapter(adapter);
    }

    private void viewData1() {

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
        namess.setAdapter(adapter);
    }


    private int loadData(int position) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        int idd = 0;
        Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            if (cursor.getPosition() == position) {
                int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                int classss = cursor.getColumnIndex(DBHelper.KEY_CLASS);
                int lvls = cursor.getColumnIndex(DBHelper.KEY_LVL);
                int races = cursor.getColumnIndex(DBHelper.KEY_RACE);
                int back = cursor.getColumnIndex(DBHelper.KEY_BACKSTORY);
                int world = cursor.getColumnIndex(DBHelper.KEY_WORDLVIEW);
                int pname = cursor.getColumnIndex(DBHelper.KEY_PNAME);
                int ex = cursor.getColumnIndex(DBHelper.KEY_EXP);
                int strr = cursor.getColumnIndex(DBHelper.KEY_STR);
                int dexx = cursor.getColumnIndex(DBHelper.KEY_DEX);
                int conn = cursor.getColumnIndex(DBHelper.KEY_CON);
                int intel = cursor.getColumnIndex(DBHelper.KEY_INT);
                int wiss = cursor.getColumnIndex(DBHelper.KEY_WIS);
                int chariss = cursor.getColumnIndex(DBHelper.KEY_CHARIS);
                int other = cursor.getColumnIndex(DBHelper.KEY_OTHERANDLANG);
                int ad = cursor.getColumnIndex(DBHelper.KEY_ADD);
                int charof = cursor.getColumnIndex(DBHelper.KEY_CHAROFSPELLS);
                int diceof = cursor.getColumnIndex(DBHelper.KEY_DICEOFSPELLS);
                int addof = cursor.getColumnIndex(DBHelper.KEY_ADDOFSPELLS);
                int dicestrr = cursor.getColumnIndex(DBHelper.KEY_DICESTR);
                int dicedexx = cursor.getColumnIndex(DBHelper.KEY_DICEDEX);
                int diceconn = cursor.getColumnIndex(DBHelper.KEY_DICECON);
                int diceint = cursor.getColumnIndex(DBHelper.KEY_DICEINT);
                int dicewiss = cursor.getColumnIndex(DBHelper.KEY_DICEWIS);
                int dicechariss = cursor.getColumnIndex(DBHelper.KEY_DICECHARIS);
                int eqp = cursor.getColumnIndex(DBHelper.KEY_EQP);
                int goldd = cursor.getColumnIndex(DBHelper.KEY_GOLD);
                int silverr = cursor.getColumnIndex(DBHelper.KEY_SILVER);
                int copperr = cursor.getColumnIndex(DBHelper.KEY_COPPER);
                int guilds = cursor.getColumnIndex(DBHelper.KEY_GUILD);
                int hp = cursor.getColumnIndex(DBHelper.KEY_HPANDECT);
                int lvlof = cursor.getColumnIndex(DBHelper.KEY_LVLOFSPELLS);
                int per = cursor.getColumnIndex(DBHelper.KEY_PERSONAL);
                int ideal = cursor.getColumnIndex(DBHelper.KEY_IDEAL);
                int loves = cursor.getColumnIndex(DBHelper.KEY_LOVE);
                int bads = cursor.getColumnIndex(DBHelper.KEY_BAD);
                int atf = cursor.getColumnIndex(DBHelper.KEY_ATF);
                int ats = cursor.getColumnIndex(DBHelper.KEY_ATS);
                int att = cursor.getColumnIndex(DBHelper.KEY_ATT);
                int addat = cursor.getColumnIndex(DBHelper.KEY_ADDAT);
                int treas = cursor.getColumnIndex(DBHelper.KEY_TREASURE);
                int story = cursor.getColumnIndex(DBHelper.KEY_STORY);
                int specc = cursor.getColumnIndex(DBHelper.KEY_SPECIAL);
                int charmss = cursor.getColumnIndex(DBHelper.KEY_CHARMS);

                name_char.setText(cursor.getString(nameIndex));
                classs.setText(cursor.getString(classss));
                lvl.setText(cursor.getString(lvls));
                race.setText(cursor.getString(races));
                backstory.setText(cursor.getString(back));
                worldview .setText(cursor.getString(world));
                name_player .setText(cursor.getString(pname));
                exp .setText(cursor.getString(ex));
                str.setText(cursor.getString(strr));
                dex .setText(cursor.getString(dexx));
                con.setText(cursor.getString(conn));
                inte .setText(cursor.getString(intel));
                wis.setText(cursor.getString(wiss));
                charis .setText(cursor.getString(chariss));
                addddd .setText(cursor.getString(ad));
                at1 .setText(cursor.getString(atf));
                at2.setText(cursor.getString(ats));
                at3 .setText(cursor.getString(att));
                adat .setText(cursor.getString(addat));
                charmsss .setText(cursor.getString(charmss));
                dicestr .setText(cursor.getString(dicestrr));
                dicedex .setText(cursor.getString(dicedexx));
                dicecon .setText(cursor.getString(diceconn));
                diceinte .setText(cursor.getString(diceint));
                dicewis .setText(cursor.getString(dicewiss));
                dicecharis.setText(cursor.getString(dicechariss));
                eq.setText(cursor.getString(eqp));
                gold .setText(cursor.getString(goldd));
                silver.setText(cursor.getString(silverr));
                copper.setText(cursor.getString(copperr));
                treasuree .setText(cursor.getString(treas));
                historyy .setText(cursor.getString(story));
                spec .setText(cursor.getString(specc));
                pers .setText(cursor.getString(per));
                ideals .setText(cursor.getString(ideal));
                love.setText(cursor.getString(loves));
                bad.setText(cursor.getString(bads));
                otherandlangg .setText(cursor.getString(other));
                guildss .setText(cursor.getString(guilds));
                lvlsofspellss.setText(cursor.getString(lvlof));
                hpandectt .setText(cursor.getString(hp));
                charofspell .setText(cursor.getString(charof));
                diceofspell.setText(cursor.getString(diceof));
                aaddofspell .setText(cursor.getString(addof));

                idd = cursor.getInt(idIndex);
            }
        }
        cursor.close();
        return idd;
    }

    public class MyGestureListener extends GestureDetector.SimpleOnGestureListener
    {

        @Override
        public boolean onDown(MotionEvent e)
        {
            return true;
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_DISTANCE)
                return false;

            if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY)
            {
                Intent i=new Intent(Selection.this,MainActivity.class);
                startActivity(i);
            }
            return false;
        }
    }

}

