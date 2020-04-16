package com.example.infs3634groupassignment;

import java.util.ArrayList;

public class ApplicationDatabase {
    private String name;
    private String icon;

    public ApplicationDatabase(){
    }

    public ApplicationDatabase(String name, String icon){
        this.name= name;
        this.icon= icon;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // Populating the data fields with specific information associated with each restaurant
    public static ArrayList<ApplicationDatabase> getApplicationDatabase(){
        ArrayList<ApplicationDatabase> applicationDatabase = new ArrayList<>();
        applicationDatabase.add(new ApplicationDatabase("Step 1: Applicaton- Resume","home_resume"));
        applicationDatabase.add(new ApplicationDatabase("Step 1: Application- CV","home_cv"));
        applicationDatabase.add(new ApplicationDatabase("Step 2: Psychometric Test- Behavioural","home_behavioural"));
        applicationDatabase.add(new ApplicationDatabase("Step 2: Psychometric Test- Cognitive","home_cognitive"));
        applicationDatabase.add(new ApplicationDatabase("Step 2: Psychometric Test- Numerical","home_numerical"));
        applicationDatabase.add(new ApplicationDatabase("Step 3: Video Interview", "home_video"));
        applicationDatabase.add(new ApplicationDatabase("Step 4: Assessment Centre- Group Work","home_groupwork"));
        applicationDatabase.add(new ApplicationDatabase("Step 4: Assessment Centre- Interview","home_interview"));
        applicationDatabase.add(new ApplicationDatabase("Step 5: Final Outcome","home_outcome"));
        applicationDatabase.add(new ApplicationDatabase("Step 6: First Day of Work", "home_firstday"));
        applicationDatabase.add(new ApplicationDatabase("Networking", "home_networking"));
        applicationDatabase.add(new ApplicationDatabase("Career Opportunities","home_career"));

              return applicationDatabase;
    }
}

