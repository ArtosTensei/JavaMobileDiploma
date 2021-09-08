package com.example.myapplication;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

public class Creation extends AppCompatActivity
{

    Dialog general_info;
    Dialog characteristics;
    Dialog otherandlang;
    Dialog facee;
    Dialog adddd;
    Dialog attackk;
    Dialog charmss;
    Dialog charforspellss;
    Dialog dices;
    Dialog equips;
    Dialog guilds;
    Dialog hpandects;
    Dialog lvlofspellss;
    Dialog personals;
    Dialog skillss;
    Dialog specials;
    Dialog storys;
    Dialog treasures;

    String name ;
    String classss;
    String lvls ;
    String races ;
    String back ;
    String world ;
    String player ;
    String ex ;
    String strr ;
    String dexx ;
    String conn ;
    String intel;
    String wiss ;
    String chariss ;
    String otherlang;
    String ad;
    String charofspelll ;
    String diceofspelll ;
    String aaddofspelll ;
    String dicestrr;
    String dicedexx;
    String diceconc ;
    String diceintel ;
    String dicewiss ;
    String dicechariss;
    String eqv ;
    String goldd;
    String silverr;
    String copperr ;
    String guiild ;
    String hpandecttt;
    String lvlofspl ;
    String perss ;
    String ideal ;
    String lovee ;
    String badd;
    String at ;
    String at22 ;
    String at33 ;
    String at4 ;
    String chram ;
    String tresure ;
    String storr ;
    String speci ;



    DBHelper dbHelper;
    static final int GALLERY_REQUEST = 1;

    private GestureDetectorCompat lSwipeDetector;

    LinearLayout creation;

    private static final int SWIPE_MIN_DISTANCE = 130;
    private static final int SWIPE_MAX_DISTANCE = 300;
    private static final int SWIPE_MIN_VELOCITY = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation);


        dbHelper = new DBHelper(this);


        //диалоговые окна
        general_info = new Dialog(Creation.this);
        general_info.setContentView(R.layout.general_info);
        general_info.setTitle("Основная информация");
        general_info.setCanceledOnTouchOutside(false);
        general_info.setCancelable(false);

        characteristics = new Dialog(Creation.this);
        characteristics.setContentView(R.layout.characteristics);
        characteristics.setTitle("Характеристики");
        characteristics.setCanceledOnTouchOutside(false);
        characteristics.setCancelable(false);

        otherandlang = new Dialog(Creation.this);
        otherandlang.setContentView(R.layout.otherandlang);
        otherandlang.setTitle("Другие умения и языки");
        otherandlang.setCanceledOnTouchOutside(false);
        otherandlang.setCancelable(false);

        adddd = new Dialog(Creation.this);
        adddd.setContentView(R.layout.addd);
        adddd.setTitle("Основная информация");
        adddd.setCanceledOnTouchOutside(false);
        adddd.setCancelable(false);

        attackk = new Dialog(Creation.this);
        attackk.setContentView(R.layout.attack);
        attackk.setTitle("Основная информация");
        attackk.setCanceledOnTouchOutside(false);
        attackk.setCancelable(false);

        charmss = new Dialog(Creation.this);
        charmss.setContentView(R.layout.charms);
        charmss.setTitle("Основная информация");
        charmss.setCanceledOnTouchOutside(false);
        charmss.setCancelable(false);

        charforspellss = new Dialog(Creation.this);
        charforspellss.setContentView(R.layout.charforspells);
        charforspellss.setTitle("Основная информация");
        charforspellss.setCanceledOnTouchOutside(false);
        charforspellss.setCancelable(false);

        dices = new Dialog(Creation.this);
        dices.setContentView(R.layout.dice);
        dices.setTitle("Основная информация");
        dices.setCanceledOnTouchOutside(false);
        dices.setCancelable(false);

        equips = new Dialog(Creation.this);
        equips.setContentView(R.layout.equip);
        equips.setTitle("Основная информация");
        equips.setCanceledOnTouchOutside(false);
        equips.setCancelable(false);

        guilds = new Dialog(Creation.this);
        guilds.setContentView(R.layout.guild);
        guilds.setTitle("Основная информация");
        guilds.setCanceledOnTouchOutside(false);
        guilds.setCancelable(false);

        hpandects = new Dialog(Creation.this);
        hpandects.setContentView(R.layout.hpandect);
        hpandects.setTitle("Основная информация");
        hpandects.setCanceledOnTouchOutside(false);
        hpandects.setCancelable(false);

        lvlofspellss = new Dialog(Creation.this);
        lvlofspellss.setContentView(R.layout.lvlofspells);
        lvlofspellss.setTitle("Основная информация");
        lvlofspellss.setCanceledOnTouchOutside(false);
        lvlofspellss.setCancelable(false);

        personals = new Dialog(Creation.this);
        personals.setContentView(R.layout.personal);
        personals.setTitle("Основная информация");
        personals.setCanceledOnTouchOutside(false);
        personals.setCancelable(false);

        specials = new Dialog(Creation.this);
        specials.setContentView(R.layout.special);
        specials.setTitle("Основная информация");
        specials.setCanceledOnTouchOutside(false);
        specials.setCancelable(false);

        storys = new Dialog(Creation.this);
        storys.setContentView(R.layout.story);
        storys.setTitle("Основная информация");
        storys.setCanceledOnTouchOutside(false);
        storys.setCancelable(false);

        treasures = new Dialog(Creation.this);
        treasures.setContentView(R.layout.treasure);
        treasures.setTitle("Основная информация");
        treasures.setCanceledOnTouchOutside(false);
        treasures.setCancelable(false);

        //кнопки в меню создания
        final Button maininfo = findViewById(R.id.maininfo);
        final Button charac = findViewById(R.id.charac);
        final Button dice = findViewById(R.id.dice);
        final Button skills = findViewById(R.id.skills);
        final Button otherandlan = findViewById(R.id.otherandlang);
        final Button equip = findViewById(R.id.equip);
        final Button attack = findViewById(R.id.attack);
        final Button special = findViewById(R.id.special);
        final Button personal = findViewById(R.id.personal);
        final Button hpandect = findViewById(R.id.hpandect);
        final Button face = findViewById(R.id.face);
        final Button story = findViewById(R.id.story);
        final Button addd = findViewById(R.id.addd);
        final Button treasure = findViewById(R.id.treasure);
        final Button guild = findViewById(R.id.guild);
        final Button charforspells = findViewById(R.id.charforspells);
        final Button charms = findViewById(R.id.charms);
        final Button lvlsofspells = findViewById(R.id.lvlsofspells);
        final Button saveall = findViewById(R.id.save);



        //кнопки выхода и сохранения в диалоговых окнах
        final Button exitgeneral = general_info.findViewById(R.id.btn25);
        final Button savegeneral = general_info.findViewById(R.id.btn26);
        final Button exitchar = characteristics.findViewById(R.id.btn25);
        final Button savechar = characteristics.findViewById(R.id.btn26);
        final Button exitlang = otherandlang.findViewById(R.id.btn25);
        final Button savelang = otherandlang.findViewById(R.id.btn26);
        final Button exitadd = adddd.findViewById(R.id.btn25);
        final Button saveadd = adddd.findViewById(R.id.btn26);
        final Button exitcharspell = charforspellss.findViewById(R.id.btn25);
        final Button savecharspell = charforspellss.findViewById(R.id.btn26);
        final Button exitdice = dices.findViewById(R.id.btn25);
        final Button savedice = dices.findViewById(R.id.btn26);
        final Button exiteq = equips.findViewById(R.id.btn25);
        final Button saveeq = equips.findViewById(R.id.btn26);
        final Button exitg = guilds.findViewById(R.id.btn25);
        final Button saveg = guilds.findViewById(R.id.btn26);
        final Button exithp = hpandects.findViewById(R.id.btn25);
        final Button savehp = hpandects.findViewById(R.id.btn26);
        final Button exitlvlspell = lvlofspellss.findViewById(R.id.btn25);
        final Button savelvlspell = lvlofspellss.findViewById(R.id.btn26);
        final Button exitper = personals.findViewById(R.id.btn25);
        final Button saveper = personals.findViewById(R.id.btn26);
        final Button exitspec = specials.findViewById(R.id.btn25);
        final Button savespec = specials.findViewById(R.id.btn26);
        final Button exitstory = storys.findViewById(R.id.btn25);
        final Button savestory = storys.findViewById(R.id.btn26);
        final Button exittreas = treasures.findViewById(R.id.btn25);
        final Button savetreas = treasures.findViewById(R.id.btn26);
        final Button exitcharm = charmss.findViewById(R.id.btn25);
        final Button savecharm = charmss.findViewById(R.id.btn26);
        final Button exitat = attackk.findViewById(R.id.btn25);
        final Button saveat = attackk.findViewById(R.id.btn26);

        //кнопка добавления изображения


        //тексты и выборы из диалоговых окон
        final EditText name_char = general_info.findViewById(R.id.name_char);
        final EditText classs = general_info.findViewById(R.id.classs);
        final EditText lvl = general_info.findViewById(R.id.lvl);
        final EditText race = general_info.findViewById(R.id.race);
        final EditText backstory = general_info.findViewById(R.id.backstory);
        final EditText worldview = general_info.findViewById(R.id.worldview);
        final EditText name_player = general_info.findViewById(R.id.name_player);
        final EditText exp = general_info.findViewById(R.id.exp);
        final EditText str = characteristics.findViewById(R.id.str);
        final EditText dex = characteristics.findViewById(R.id.dex);
        final EditText con = characteristics.findViewById(R.id.con);
        final EditText inte = characteristics.findViewById(R.id.inte);
        final EditText wis = characteristics.findViewById(R.id.wis);
        final EditText charis = characteristics.findViewById(R.id.charis);
        final EditText addddd = adddd.findViewById(R.id.addd);
        final EditText at1 = attackk.findViewById(R.id.at1);
        final EditText at2 = attackk.findViewById(R.id.at2);
        final EditText at3 = attackk.findViewById(R.id.at3);
        final EditText adat = attackk.findViewById(R.id.addat);
        final EditText charmsss = charmss.findViewById(R.id.charmss);
        final EditText dicestr = dices.findViewById(R.id.dicestr);
        final EditText dicedex = dices.findViewById(R.id.dicedex);
        final EditText dicecon = dices.findViewById(R.id.dicecon);
        final EditText diceinte = dices.findViewById(R.id.diceinte);
        final EditText dicewis = dices.findViewById(R.id.dicewis);
        final EditText dicecharis = dices.findViewById(R.id.dicecharis);
        final EditText eq = equips.findViewById(R.id.eq);
        final EditText gold = equips.findViewById(R.id.gold);
        final EditText silver = equips.findViewById(R.id.silver);
        final EditText copper = equips.findViewById(R.id.copper);
        final EditText treasuree = treasures.findViewById(R.id.treasuree);
        final EditText historyy = storys.findViewById(R.id.historyy);
        final EditText spec = specials.findViewById(R.id.spec);
        final EditText pers = personals.findViewById(R.id.pers);
        final EditText ideals = personals.findViewById(R.id.ideals);
        final EditText love = personals.findViewById(R.id.love);
        final EditText bad = personals.findViewById(R.id.bad);
        final EditText otherandlangg = otherandlang.findViewById(R.id.otherandlangg);
        final EditText guildss = guilds.findViewById(R.id.guilds);
        final EditText lvlsofspellss = lvlofspellss.findViewById(R.id.lvlsofspells);
        final EditText hpandectt = hpandects.findViewById(R.id.hpandect);
        final EditText charofspell = charforspellss.findViewById(R.id.charofspell);
        final EditText diceofspell = charforspellss.findViewById(R.id.diceofspell);
        final EditText aaddofspell = charforspellss.findViewById(R.id.aaddofspell);


        //обработка свайпа
        lSwipeDetector = new GestureDetectorCompat(this, new MyGestureListener());
        creation = (LinearLayout) findViewById(R.id.creation);
        creation.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return lSwipeDetector.onTouchEvent(event);
            }
        });

    /*    addfpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fphotoPickerIntent = new Intent(Intent.ACTION_PICK);
                fphotoPickerIntent.setType("image/*");
                startActivityForResult(fphotoPickerIntent, GALLERY_REQUEST);
            }
        });

        addgpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gphotoPickerIntent = new Intent(Intent.ACTION_PICK);
                gphotoPickerIntent.setType("image/*");
                startActivityForResult(gphotoPickerIntent, GALLERY_REQUEST);
            }
        });*/

        //открытие диалоговых окон
        maininfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                general_info.show();
            }
        });

        charac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                characteristics.show();
            }
        });

        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dices.show();
            }
        });

        skills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skillss.show();
            }
        });

        otherandlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherandlang.show();
            }
        });

        equip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equips.show();
            }
        });

        attack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackk.show();
            }
        });

        special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                specials.show();
            }
        });

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personals.show();
            }
        });

        hpandect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hpandects.show();
            }
        });

        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facee.show();
            }
        });

        story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storys.show();
            }
        });

        addd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adddd.show();
            }
        });

        treasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                treasures.show();
            }
        });

        guild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guilds.show();
            }
        });

        charforspells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charforspellss.show();
            }
        });

        charms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charmss.show();
            }
        });

        lvlsofspells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvlofspellss.show();
            }
        });

        //сохранение всей информации
        saveall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = dbHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();

                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_CLASS, classss);
                contentValues.put(DBHelper.KEY_LVL, lvls);
                contentValues.put(DBHelper.KEY_RACE, races);
                contentValues.put(DBHelper.KEY_BACKSTORY, back);
                contentValues.put(DBHelper.KEY_WORDLVIEW, world);
                contentValues.put(DBHelper.KEY_PNAME, player);
                contentValues.put(DBHelper.KEY_EXP, ex);
                contentValues.put(DBHelper.KEY_STR, strr);
                contentValues.put(DBHelper.KEY_DEX, dexx);
                contentValues.put(DBHelper.KEY_CON, conn);
                contentValues.put(DBHelper.KEY_INT, intel);
                contentValues.put(DBHelper.KEY_WIS, wiss);
                contentValues.put(DBHelper.KEY_CHARIS, chariss);
                contentValues.put(DBHelper.KEY_OTHERANDLANG, otherlang);
                contentValues.put(DBHelper.KEY_ADD, ad);
                contentValues.put(DBHelper.KEY_CHAROFSPELLS, charofspelll);
                contentValues.put(DBHelper.KEY_DICEOFSPELLS, diceofspelll);
                contentValues.put(DBHelper.KEY_ADDOFSPELLS, aaddofspelll);
                contentValues.put(DBHelper.KEY_DICESTR, dicestrr);
                contentValues.put(DBHelper.KEY_DICEDEX, dicedexx);
                contentValues.put(DBHelper.KEY_DICECON, diceconc);
                contentValues.put(DBHelper.KEY_DICEINT, diceintel);
                contentValues.put(DBHelper.KEY_DICEWIS, dicewiss);
                contentValues.put(DBHelper.KEY_DICECHARIS, dicechariss);
                contentValues.put(DBHelper.KEY_EQP, eqv);
                contentValues.put(DBHelper.KEY_GOLD, goldd);
                contentValues.put(DBHelper.KEY_SILVER, silverr);
                contentValues.put(DBHelper.KEY_COPPER, copperr);
                contentValues.put(DBHelper.KEY_GUILD, guiild);
                contentValues.put(DBHelper.KEY_HPANDECT, hpandecttt);
                contentValues.put(DBHelper.KEY_LVLOFSPELLS, lvlofspl);
                contentValues.put(DBHelper.KEY_PERSONAL, perss);
                contentValues.put(DBHelper.KEY_IDEAL, ideal);
                contentValues.put(DBHelper.KEY_LOVE, lovee);
                contentValues.put(DBHelper.KEY_BAD, badd);
                contentValues.put(DBHelper.KEY_ATF, at);
                contentValues.put(DBHelper.KEY_ATS, at22);
                contentValues.put(DBHelper.KEY_ATT, at33);
                contentValues.put(DBHelper.KEY_ADDAT, at4);
                contentValues.put(DBHelper.KEY_CHARMS, chram);
                contentValues.put(DBHelper.KEY_TREASURE, tresure);
                contentValues.put(DBHelper.KEY_STORY, storr);
                contentValues.put(DBHelper.KEY_SPECIAL, speci);


                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);


                Intent i=new Intent(Creation.this, Selection.class);
                startActivity(i);
            }
        });

        //обработка сохранений данных из диалоговх окон
        exitgeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                general_info.cancel();
            }
        });

        savegeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 name = name_char.getText().toString();
                 classss = classs.getText().toString();
                 lvls = lvl.getText().toString();
                 races = race.getText().toString();
                 back = backstory.getText().toString();
                 world = worldview.getText().toString();
                 player = name_player.getText().toString();
                 ex = exp.getText().toString();

                maininfo.setEnabled(false);
                general_info.cancel();
                Log.i("gegfd" , name);
            }
        });

        exitchar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                characteristics.cancel();
            }
        });

        savechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 strr = str.getText().toString();
                 dexx = dex.getText().toString();
                 conn = con.getText().toString();
                 intel = inte.getText().toString();
                 wiss = wis.getText().toString();
                 chariss = charis.getText().toString();

                charac.setEnabled(false);
                characteristics.cancel();
            }
        });

        exitlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherandlang.cancel();
            }
        });

        savelang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherlang = otherandlangg.getText().toString();

                otherandlan.setEnabled(false);
                otherandlang.cancel();
            }
        });


        exitadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adddd.cancel();
            }
        });

        saveadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad = addddd.getText().toString();

                addd.setEnabled(false);
                adddd.cancel();
            }
        });

        exitcharspell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charforspellss.cancel();
            }
        });

        savecharspell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charofspelll = charofspell.getText().toString();
                diceofspelll = diceofspell.getText().toString();
                aaddofspelll = aaddofspell.getText().toString();

                charforspells.setEnabled(false);
                charforspellss.cancel();
            }
        });

        exitdice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dices.cancel();
            }
        });

        savedice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dicestrr = dicestr.getText().toString();
                dicedexx = dicedex.getText().toString();
                diceconc = dicecon.getText().toString();
                diceintel = diceinte.getText().toString();
                dicewiss = dicewis.getText().toString();
                dicechariss = dicecharis.getText().toString();

                dice.setEnabled(false);
                dices.cancel();
            }
        });

        exiteq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equips.cancel();
            }
        });

        saveeq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqv = eq.getText().toString();
                goldd = gold.getText().toString();
                silverr = silver.getText().toString();
                copperr = copper.getText().toString();

                equip.setEnabled(false);
                equips.cancel();
            }
        });

        exitg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guilds.cancel();
            }
        });

        saveg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guiild = guildss.getText().toString();


                guild.setEnabled(false);
                guilds.cancel();
            }
        });

        exithp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hpandects.cancel();
            }
        });

        savehp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hpandecttt = hpandectt.getText().toString();

                hpandect.setEnabled(false);
                hpandects.cancel();
            }
        });

        exitlvlspell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvlofspellss.cancel();
            }
        });

        savelvlspell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvlofspl = lvlsofspellss.getText().toString();

                lvlsofspells.setEnabled(false);
                lvlofspellss.cancel();
            }
        });

        exitper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personals.cancel();
            }
        });

        saveper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perss = pers.getText().toString();
                ideal = ideals.getText().toString();
                lovee = love.getText().toString();
                badd = bad.getText().toString();

                personal.setEnabled(false);
                personals.cancel();
            }
        });


        exitspec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                specials.cancel();
            }
        });

        savespec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speci = spec.getText().toString();

                special.setEnabled(false);
                specials.cancel();
            }
        });

        exitstory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storys.cancel();
            }
        });

        savestory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storr = historyy.getText().toString();

                story.setEnabled(false);
                storys.cancel();
            }
        });

        exittreas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                treasures.cancel();
            }
        });

        savetreas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tresure = treasuree.getText().toString();

                treasure.setEnabled(false);
                treasures.cancel();
            }
        });

        exitcharm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charmss.cancel();
            }
        });

        savecharm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chram = charmsss.getText().toString();

                charms.setEnabled(false);
                charmss.cancel();
            }
        });

        exitat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackk.cancel();
            }
        });

        saveat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                at = at1.getText().toString();
                at22 = at2.getText().toString();
                at33 = at3.getText().toString();
                at4 = adat.getText().toString();

                attack.setEnabled(false);
                attackk.cancel();
            }
        });

    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
        {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_DISTANCE)
                return false;

            if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY)
            {
                Intent i = new Intent(Creation.this, Selection.class);
                startActivity(i);
            }
            return false;
        }

    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent)
    {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;
        ImageView fimageView = (ImageView) findViewById(R.id.fimage);

        switch (requestCode)
        {
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK)
                {
                    Uri selectedImage = imageReturnedIntent.getData();
                    fimageView.setImageURI(selectedImage);
                }
        }


    }*/

}
