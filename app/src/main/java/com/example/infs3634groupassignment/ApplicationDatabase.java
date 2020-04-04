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
        applicationDatabase.add(new ApplicationDatabase("Step 1: Applicaton- Resume","appresume_image"));
        applicationDatabase.add(new ApplicationDatabase("Step 1: Application- CV","appcv_image"));
        applicationDatabase.add(new ApplicationDatabase("Step 2: Psychometric Test- Behavioural","psychbehavioural_image"));
        applicationDatabase.add(new ApplicationDatabase("Step 2: Psychometric Test- Cognitive",""));
        applicationDatabase.add(new ApplicationDatabase("Step 2: Psychometric Test- Numerical",""));
        applicationDatabase.add(new ApplicationDatabase("Step 3: Video Interview", ""));
        applicationDatabase.add(new ApplicationDatabase("Step 4: Assessment Centre- Group Work",""));
        applicationDatabase.add(new ApplicationDatabase("Step 4: Assessment Centre- Interview",""));
        applicationDatabase.add(new ApplicationDatabase("Step 5: Final Outcome",""));
        applicationDatabase.add(new ApplicationDatabase("Step 6: First Day of Work", ""));
        applicationDatabase.add(new ApplicationDatabase("Networking", ""));
        applicationDatabase.add(new ApplicationDatabase("Career Opportunities",""));

              return applicationDatabase;
    }
}

