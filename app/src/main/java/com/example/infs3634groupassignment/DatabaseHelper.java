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

    //DECLARING TABLE FOR NUMERICAL QUIZ
    private static final String TABLE_NAME_3 = "Numericals";

    private static final String COLUMN_ID_3 = "id";
    private static final String COLUMN_QUESTION_3 = "question";
    private static final String COLUMN_ANSWER_3 = "answer";
    private static final String COLUMN_OPTION1_3 = "option1";
    private static final String COLUMN_OPTION2_3 = "option2";
    private static final String COLUMN_OPTION3_3 = "option3";

    //DECLARING TABLE FOR ACHIEVEMENTS
    private static final String TABLE_NAME_2 = "achievements";

    private static final String COLUMN_ID_2 = "id";
    private static final String COLUMN_PAGE = "page";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_STATUS = "status";

    //INSTANTIATING OTHER VARIABLES
    private String question = "";
    private String answer = "";
    private String option1 = "";
    private String option2 = "";
    private String option3 = "";
    private String questionNumerical = "";
    private String answerNumerical = "";
    private String option1Numerical = "";
    private String option2Numerical = "";
    private String option3Numerical = "";
    private int holder;

    //INSTANTIATING OTHER VARIABLES
    private boolean status;
    private String statusS;
    private boolean current;
    private String currentS;

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
                "Please select the most appropriate action', 'Take down all of the details of the problem and tell the customer you will fully investigate the problem and get back to her with a response. Fully investigate the issue and then call them back.', 'Explain the situation to your manager and ask them what they think you should do.', 'Transfer their call to another department and let them try to solve it.', 'Hang up on the customer, you’ve done your best and it is inappropriate for her to behave in that way.')");
        db.execSQL("INSERT INTO " +TABLE_NAME+ " ( " + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_OPTION1 + ", " + COLUMN_OPTION2 + ", " + COLUMN_OPTION3 + ") VALUES ('You find a colleague crying in the toilets. What do you do?', 'Ask if they are ok and whether there is anything you can do to help.', 'Walk out of the toilets and leave them to it.', 'Go and give them a big hug and tell them that everything will be ok.', 'Go and find your manager and let them manage the situation.')");
        db.execSQL("INSERT INTO " +TABLE_NAME+ " ( " + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_OPTION1 + ", " + COLUMN_OPTION2 + ", " + COLUMN_OPTION3 + ") VALUES ('You are working as a graduate trainee in a large bank. Whilst undertaking your placement with the customer service team, you take a call from an upset client. He is claiming that he was expecting a refund on some banking fees he was wrongly charged for but he has not received them. He explains that a colleague of yours promised the refund would be in his account today but the money has not arrived yet. He is getting more upset and is raising his voice to you. What would you say to him?', 'I will do all I can to help you with this issue. If you give me your account details I will investigate what has happened here.', 'Let me check with the colleague you mentioned about what the situation is. If you can hold for a couple of minutes I will speak to them and will be back with you in no time.', 'Sir, I can hear that you are really upset but I need you to calm down so that I can help you.', 'I am sure there is a logical explanation for this. If you give me your details I will look into it for you.')");
        db.execSQL("INSERT INTO " +TABLE_NAME+ " ( " + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_OPTION1 + ", " + COLUMN_OPTION2 + ", " + COLUMN_OPTION3 + ") VALUES ('As part of your graduate training scheme with a large energy company you have been undertaking a variety of placements with different departments in the business. You are close to finishing a really successful placement in the Procurement team and will be moving onto the Finance team in a weeks time. At lunchtime a colleague from Procurement, who you have become quite close to, takes you aside and warns you that there are a number of people in the Finance team who she has had problems with in the past. She says that there are people in Finance who are not to be trusted in her view and that you would be better off avoiding them if you can. What would you say?', 'Thanks for flagging that but it’s probably better if I go there with an open mind rather than having preconceptions about my future colleagues.', 'I don’t think it is appropriate for you to talk about people in this manner and I’m afraid it’s probably best if we end this conversation now.', 'What are you basing that opinion on? Could it be that you misinterpreted their actions or intentions towards you?', 'What makes you think they can’t be trusted? What advice can you offer about how to work with them?')");
        db.execSQL("INSERT INTO " +TABLE_NAME+ " ( " + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_OPTION1 + ", " + COLUMN_OPTION2 + ", " + COLUMN_OPTION3 + ") VALUES ('You are working as a trainee manager within a leisure company. Your current placement is at a busy city centre leisure club. You receive a call from head office explaining that a smaller, nearby leisure club has had a large number of staff call in sick today due to illness. The contact from head office asks if you would be able to spend at least half a day at the other leisure club today as the manager is off sick and the deputy manager is on holiday. You have a large pile of paperwork to complete today along with a number of internal meetings with your own team at your club.', 'Suggest to head office that they give you half an hour to re-plan your day and promise to call them back with a response.', 'Explain your situation and ask the person calling from head office how they would like you to prioritise your day.', 'Offer to call round a number of other local clubs to try and find another manager who might be able to support the understaffed club today as you are really busy.', 'Agree to spend half a day at the other club and simply take the paperwork with you.')");
        db.execSQL("INSERT INTO " +TABLE_NAME+ " ( " + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_OPTION1 + ", " + COLUMN_OPTION2 + ", " + COLUMN_OPTION3 + ") VALUES ('Whilst working as a graduate trainee at a small consulting firm you have noticed that there is a lot of useful research that is conducted in-house and on behalf of clients. You can see that this would benefit colleagues and clients alike in many ways but currently there is not an obvious way to disseminate this. You bring this to the attention of your manager and she suggests that you give this some thought and propose a way to improve practice. What would you do?', 'Suggest that the company could set up a ‘Research Forum’ whose remit is to ensure the successful sharing of research across the business with representatives from all relevant departments.', 'Suggest that you set up a webinar every 6 months where key people from the organisation are invited to share the findings from their recent research with other employees.', 'Suggest that the company runs a 2-day internal conference annually which has a direct focus on sharing research findings with all employees.', 'Suggest that an area is created on the company intranet where people are encouraged to upload the research that they undertake.')");
        db.execSQL("INSERT INTO " +TABLE_NAME+ " ( " + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_OPTION1 + ", " + COLUMN_OPTION2 + ", " + COLUMN_OPTION3 + ") VALUES ('You are working in a call centre for a major UK telecommunications company. You have received a call from a customer who has been waiting in for an engineer who has failed to arrive within the scheduled time slot. The customer is upset and is talking in a raised voice. What do you do?', 'Ask the customer to hold while you contact the engineer to establish where she is', 'Apologise to the customer and say you will arrange for a re-scheduled appointment.', 'Listen to the customer’s feedback and tell them that you can understand why they are upset and that it must be very inconvenient for them.', 'Explain that the engineer has a very busy schedule and it is difficult for her to always be on time but you’re sure she will arrive soon.')");
        db.execSQL("INSERT INTO " +TABLE_NAME+ " ( " + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ", " + COLUMN_OPTION1 + ", " + COLUMN_OPTION2 + ", " + COLUMN_OPTION3 + ") VALUES ('You are a team leader in a customer contact centre. You just overheard an employee in your team telling a customer that they were “over-reacting” and that they needed to “get psychiatric help”. You are not sure what the customer’s call was about but now the call has finished and you have a chance to speak to the employee. What do you do?', 'Tell your employee that you will work with them to improve their performance over the next 3 months', 'Tell the employee that you have no option but to recommend their dismissal', 'Tell the employee to do it again', 'Ignore the employees behaviour and hope they will not repeat their mistakes on another occasion')");

        db.execSQL("CREATE TABLE " + TABLE_NAME_2 + " ( " + COLUMN_ID_2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PAGE + " TEXT, " + COLUMN_NAME + " TEXT, " + COLUMN_STATUS + " TEXT)");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Main', 'The Journey Begins', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Resume', 'Completed: Resumes', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('CV', 'Completed: Curriculum Vitae', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Behavioural', 'Completed: Behavioural Tests', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Cognitive', 'Completed: Cognitive Tests', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Numerical', 'Completed: Numerical Tests', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Video Interviews', 'Completed: Video Interviews', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Assessment Centre', 'Completed: Group Work', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Assessment Centre', 'Completed: Personal Interviews', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Outcome', 'Completed: Outcomes', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('First Day', 'Completed: First Day', 'false')");

        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Home', 'Home, Sweet, Home', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Achievement', 'Achievements, so many Achievements...', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Notebook', 'Time to take some notes', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Profile', 'Who am I?', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Settings', 'Set your settings', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Settings', 'Meet the team!', 'false')");

        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Behavioural', 'A Behavioural Hero!', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Cognitive', 'A Cognitive Hero!', 'false')");

        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Offer', 'You did it!', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + " ( " + COLUMN_PAGE + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES ('Reject', 'Life goes on...', 'false')");

        db.execSQL("CREATE TABLE "+TABLE_NAME_3+" ( "+COLUMN_ID_3 +" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_QUESTION_3 +" TEXT, "+COLUMN_ANSWER_3 +" TEXT, "+COLUMN_OPTION1_3+ " TEXT, "+COLUMN_OPTION2_3+ " TEXT, "+COLUMN_OPTION3_3+ " TEXT)");
        db.execSQL("INSERT INTO " +TABLE_NAME_3+ " ( "+ COLUMN_QUESTION_3 + ", " + COLUMN_ANSWER_3 + ", " + COLUMN_OPTION1_3 + ", " + COLUMN_OPTION2_3 + ", " + COLUMN_OPTION3_3 + ") VALUES ('Which game was played by a higher percentage of females than males in 2020?', 'Clash of Clans' ,'League of legends ', 'Farmville', 'None of the above')");
        db.execSQL("INSERT INTO " +TABLE_NAME_3+ " ( "+ COLUMN_QUESTION_3 + ", " + COLUMN_ANSWER_3 + ", " + COLUMN_OPTION1_3 + ", " + COLUMN_OPTION2_3 + ", " + COLUMN_OPTION3_3 + ") VALUES ('What was the combined female readership percentage of the Echo360, the Clash of Clans, and League of legends for female students in 2020?', '26.9%', '27.1%', '26.7%', '26.5%')");
        db.execSQL("INSERT INTO " +TABLE_NAME_3+ " ( "+ COLUMN_QUESTION_3 + ", " + COLUMN_ANSWER_3 + ", " + COLUMN_OPTION1_3 + ", " + COLUMN_OPTION2_3 + ", " + COLUMN_OPTION3_3 + ") VALUES ('What was the most popular game in 2019?', 'Dota', 'Animal Crossing', 'League of Legends', 'Farmville')");
        db.execSQL("INSERT INTO " +TABLE_NAME_3+ " ( "+ COLUMN_QUESTION_3 + ", " + COLUMN_ANSWER_3 + ", " + COLUMN_OPTION1_3 + ", " + COLUMN_OPTION2_3 + ", " + COLUMN_OPTION3_3 + ") VALUES ('Which game was played by a higher percentage of males than females in 2020?', 'League of legends ', 'Farmville', 'Dota ', 'All of the above')");
        db.execSQL("INSERT INTO " +TABLE_NAME_3+ " ( "+ COLUMN_QUESTION_3 + ", " + COLUMN_ANSWER_3 + ", " + COLUMN_OPTION1_3 + ", " + COLUMN_OPTION2_3 + ", " + COLUMN_OPTION3_3 + ") VALUES ('What was the combined male readership percentage of Animal Crossing, Dota, and League of legends for male students in 2020?', '29.8%', '27.1%', '30.2%', '28.4%')");
        db.execSQL("INSERT INTO " +TABLE_NAME_3+ " ( "+ COLUMN_QUESTION_3 + ", " + COLUMN_ANSWER_3 + ", " + COLUMN_OPTION1_3 + ", " + COLUMN_OPTION2_3 + ", " + COLUMN_OPTION3_3 + ") VALUES ('What was the most popular game in 2020? ', 'Animal Crossing', 'League of Legends', 'Farmville', 'Clash of Clans')");
        db.execSQL("INSERT INTO " +TABLE_NAME_3+ " ( "+ COLUMN_QUESTION_3 + ", " + COLUMN_ANSWER_3 + ", " + COLUMN_OPTION1_3 + ", " + COLUMN_OPTION2_3 + ", " + COLUMN_OPTION3_3 + ") VALUES ('What was the least popular game in 2020? ', 'Farmville', 'Dota', 'Clash of Clans', 'Echo 360')");
        db.execSQL("INSERT INTO " +TABLE_NAME_3+ " ( "+ COLUMN_QUESTION_3 + ", " + COLUMN_ANSWER_3 + ", " + COLUMN_OPTION1_3 + ", " + COLUMN_OPTION2_3 + ", " + COLUMN_OPTION3_3 + ") VALUES ('What was the most popular game for males in 2020?', 'League of Legends', 'Farmville', 'Dota ', 'Echo 360')");
        db.execSQL("INSERT INTO " +TABLE_NAME_3+ " ( "+ COLUMN_QUESTION_3 + ", " + COLUMN_ANSWER_3 + ", " + COLUMN_OPTION1_3 + ", " + COLUMN_OPTION2_3 + ", " + COLUMN_OPTION3_3 + ") VALUES ('What was the most popular game for females in 2020?', 'Animal Crossing', 'Barbie', 'Dota ', 'Echo 360')");
        db.execSQL("INSERT INTO " +TABLE_NAME_3+ " ( "+ COLUMN_QUESTION_3 + ", " + COLUMN_ANSWER_3 + ", " + COLUMN_OPTION1_3 + ", " + COLUMN_OPTION2_3 + ", " + COLUMN_OPTION3_3 + ") VALUES ('What was the least popular game for males in 2020?', 'Farmville', 'Dota', 'Clash of Clans', 'Echo 360')");
        db.execSQL("INSERT INTO " +TABLE_NAME_3+ " ( "+ COLUMN_QUESTION_3 + ", " + COLUMN_ANSWER_3 + ", " + COLUMN_OPTION1_3 + ", " + COLUMN_OPTION2_3 + ", " + COLUMN_OPTION3_3 + ") VALUES ('What was the least popular game for females in 2020?', 'None of the above', 'Animal Crossing', 'League of Legends', 'Echo 360')");
        db.execSQL("INSERT INTO " +TABLE_NAME_3+ " ( "+ COLUMN_QUESTION_3 + ", " + COLUMN_ANSWER_3 + ", " + COLUMN_OPTION1_3 + ", " + COLUMN_OPTION2_3 + ", " + COLUMN_OPTION3_3 + ") VALUES ('The climate induced by COVID-19 has sparked an increase in playership for Animal Crossing by 20%. How much bigger is total playership for animal crossing than league of legends? (2 Decimal Places)', '2.05', '2.04', '0.49', '0.50')");


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

        int retrieve = (int) Math.floor(Math.random() * 10) + 1;
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

    //METHODS FOR ACHIEVEMENTS
    public boolean getAchievementStatus(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_STATUS + " FROM " + TABLE_NAME_2 + " WHERE " + COLUMN_NAME + "= '" + name + "'", null);
        if(cursor.moveToFirst()) {
            do {
                statusS = cursor.getString(cursor.getColumnIndex(COLUMN_STATUS));
            } while (cursor.moveToNext());
        }

        status = Boolean.parseBoolean(statusS);

        return status;
    }

    public void setAchievementStatus(String aName) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("UPDATE " + TABLE_NAME_2 + " SET " + COLUMN_STATUS + " = 'true' WHERE " + COLUMN_NAME + "='" + aName + "'");

    }

    public boolean getAchievementProgress(int id) {
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_STATUS + " FROM " + TABLE_NAME_2 + " WHERE " + COLUMN_ID_2 + " = " + id, null);
        if(cursor.moveToFirst()) {
            do {
                currentS = cursor.getString(cursor.getColumnIndex(COLUMN_STATUS));
            } while (cursor.moveToNext());
        }

        current = Boolean.parseBoolean(currentS);

        return current;
    }

    //METHODS FOR NUMERICAL QUIZZES; FUNCTIONS: returns question and possible options
    public String getQuestionNumerical() {
        SQLiteDatabase db = this.getReadableDatabase();

        int retrieve = (int) Math.floor(Math.random() * 10) + 1;
        holder = retrieve;

        Cursor cursor = db.rawQuery("SELECT "+COLUMN_QUESTION_3+ " FROM " +TABLE_NAME_3+ " WHERE " +COLUMN_ID_3+ "=" + retrieve,null);
        if(cursor.moveToFirst()) {
            do {
                questionNumerical = cursor.getString(cursor.getColumnIndex(COLUMN_QUESTION_3));
            } while (cursor.moveToNext());
        }

        return questionNumerical;
    }

    public String getAnswerNumerical() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT "+COLUMN_ANSWER_3+ " FROM " +TABLE_NAME_3+ " WHERE " +COLUMN_ID_3+ "=" + holder,null);
        if(cursor.moveToFirst()) {
            do {
                answerNumerical = cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_3));
            } while (cursor.moveToNext());
        }

        return answerNumerical;
    }

    public String getOption1Numerical() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT "+COLUMN_OPTION1_3+ " FROM " +TABLE_NAME_3+ " WHERE " +COLUMN_ID_3+ "=" + holder,null);
        if(cursor.moveToFirst()) {
            do {
                option1Numerical = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION1_3));
            } while (cursor.moveToNext());
        }

        return option1Numerical;
    }

    public String getOption2Numerical() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT "+COLUMN_OPTION2_3+ " FROM " +TABLE_NAME_3+ " WHERE " +COLUMN_ID_3+ "=" + holder,null);
        if(cursor.moveToFirst()) {
            do {
                option2Numerical = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION2_3));
            } while (cursor.moveToNext());
        }

        return option2Numerical;
    }

    public String getOption3Numerical() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT "+COLUMN_OPTION3_3+ " FROM " +TABLE_NAME_3+ " WHERE " +COLUMN_ID_3+ "=" + holder,null);
        if(cursor.moveToFirst()) {
            do {
                option3Numerical = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION3_3));
            } while (cursor.moveToNext());
        }

        return option3Numerical;
    }
}
