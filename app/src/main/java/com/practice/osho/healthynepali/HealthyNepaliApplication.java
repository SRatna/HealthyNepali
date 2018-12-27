package com.practice.osho.healthynepali;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

/**
 * Created by osho on 10/16/15.
 */
public class HealthyNepaliApplication extends Application {

    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "TnVxWmkpRhuDU5NQVKi8VSMfNnfXDqb4CUNdGXfw", "REvXOXMlAm3WP1cgVuXwrRInpfL5IX7fBbhxAGFF");

        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
