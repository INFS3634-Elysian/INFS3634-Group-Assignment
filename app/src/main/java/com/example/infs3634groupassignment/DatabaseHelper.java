package com.example.infs3634groupassignment;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    //DB VERSION AND NAME
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "behavioural.db";


    //DECLARING TABLE FOR BEHAVIOURAL QUIZ
    private static final String TABLE_NAME = "examples";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_QUESTION = "question";
    private static final String COLUMN_ANSWER = "answer";
    private static final String COLUMN_OPTION1 = "option1";
    private static final String COLUMN_OPTION2 = "option2";
    private static final String COLUMN_OPTION3 = "option3";

    //INSTANTIATING OTHER VARIABLES
    private String question = "";
    private String answer = "";
    private String option1 = "";
    private String option2 = "";
    private String option3 = "";
    private int holder;

    SQLiteDatabase database;

    //CLASS CONSTRUCTOR
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = getWritableDatabase();
    }

    //DB AT CONSTRUCTION; i.e instantiation in class
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ( "+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_QUESTION+" TEXT, "+COLUMN_ANSWER+" TEXT, "+COLUMN_OPTION1+ " TEXT, "+COLUMN_OPTION2+ " TEXT, "+COLUMN_OPTION3+ " TEXT)");
        db.execSQL("INSERT INTO " +TABLE_NAME+ " ( " + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_OPTION1 + ", " + COLUMN_OPTION2 + ", " + COLUMN_OPTION3 + ") VALUES ('Your organisation has implemented a new performance management system which explicitly links your performance to your pay.\n" +
                "\n" +
                "Your progression up the pay scale now relies on your proving you have achieved particular levels of performance.\n" +
                "\n" +
                "Please state which of these potential course of action is most and least appropriate.', 'Seek out a copy of the performance framework and use this to critically evaluate your performance and development areas, and then use this information to create a personal development plan.', 'Complain to your peers that the new system is unfair but make sure you participate fully in your performance reviews.', 'Make a note of everything you do which you think might demonstrate your performance.', 'Spend your performance reviews complaining to your manager that the new system is unfair, and refuse to participate in any discussions relating to it.')");
        db.execSQL("INSERT INTO " +TABLE_NAME+ " ( " + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_OPTION1 + ", " + COLUMN_OPTION2 + ", " + COLUMN_OPTION3 + ") VALUES ('You are running late for an important meeting where you will be presenting your team’s proposal for a new software system to the Board members responsible for allocating the funding.\n" +
                "\n" +
                "Rate how appropriate you feel each of the follow actions would be:', 'Arrange for someone else from your team to step in and lead the proposal until you can get there.', 'Drive quicker and hope you manage to make it in time.', 'Call the meeting Chair and ask whether there is any chance of rearranging the agenda.', 'Pretend you have a family emergency and ask to re-schedule the meeting.')");
        db.execSQL("INSERT INTO " +TABLE_NAME+ " ( " + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_OPTION1 + ", " + COLUMN_OPTION2 + ", " + COLUMN_OPTION3 + ") VALUES ('You answer the phone to an irate customer who claims that she has been overcharged.\n" +
                "\n" +
                "Although you have checked her account and cannot find any problems she remains convinced there has been a mistake and is becoming increasingly angry.\n" +
                "\n" +
                "Please rank these potential actions in order of appropriateness with 1 being most appropriate and 4 being least appropriate.', 'Take down all of the details of the problem and tell the customer you will fully investigate the problem and get back to her with a response. Fully investigate the issue and then call them back.', 'Explain the situation to your manager and ask them what they think you should do.', 'Transfer their call to another department and let them try to solve it.', 'Hang up on the customer, you’ve done your best and it is inappropriate for her to behave in that way.')");
    }

    //DB AT UPGRADE; i.e generally unnecessary
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    //METHODS FOR BEHAVIOURAL QUIZZES; FUNCTIONS: returns question and possible options
    public String getQuestion() {
        SQLiteDatabase db = this.getReadableDatabase();

        int retrieve = (int) Math.floor(Math.random() * 3) + 1;
        holder = retrieve;

        Cursor cursor = db.rawQuery("SELECT "+COLUMN_QUESTION+ " FROM " +TABLE_NAME+ " WHERE " +COLUMN_ID+ "=" + retrieve,null);
        if(cursor.moveToFirst()) {
            do {
                question = cursor.getString(cursor.getColumnIndex(COLUMN_QUESTION));
            } while (cursor.moveToNext());
        }

        return question;
    }

    public String getAnswer() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT "+COLUMN_ANSWER+ " FROM " +TABLE_NAME+ " WHERE " +COLUMN_ID+ "=" + holder,null);
        if(cursor.moveToFirst()) {
            do {
                answer = cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER));
            } while (cursor.moveToNext());
        }

        return answer;
    }

    public String getOption1() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT "+COLUMN_OPTION1+ " FROM " +TABLE_NAME+ " WHERE " +COLUMN_ID+ "=" + holder,null);
        if(cursor.moveToFirst()) {
            do {
                option1 = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION1));
            } while (cursor.moveToNext());
        }

        return option1;
    }

    public String getOption2() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT "+COLUMN_OPTION2+ " FROM " +TABLE_NAME+ " WHERE " +COLUMN_ID+ "=" + holder,null);
        if(cursor.moveToFirst()) {
            do {
                option2 = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION2));
            } while (cursor.moveToNext());
        }

        return option2;
    }

    public String getOption3() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT "+COLUMN_OPTION3+ " FROM " +TABLE_NAME+ " WHERE " +COLUMN_ID+ "=" + holder,null);
        if(cursor.moveToFirst()) {
            do {
                option3 = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION3));
            } while (cursor.moveToNext());
        }

        return option3;
    }
}
