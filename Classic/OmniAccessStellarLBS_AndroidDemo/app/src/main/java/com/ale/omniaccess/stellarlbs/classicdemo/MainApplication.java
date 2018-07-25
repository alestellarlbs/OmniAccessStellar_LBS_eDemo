/*
 * Copyright (C) 2018 Alcatel-Lucent Enterprise
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ale.omniaccess.stellarlbs.classicdemo;

import android.app.Application;
import android.graphics.Color;
import android.os.StrictMode;

import com.ale.rainbowsdk.RainbowSdk;

import io.mapwize.mapwizeformapbox.AccountManager;

/**
 * Created by vaymonin on 20/10/2017
 */

public class MainApplication extends Application {

    private static boolean activityVisible;

    @Override
    public void onCreate() {
        super.onCreate();
        Keys keys = new Keys();
        AccountManager.start(this, keys.getMwzApiKey());
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        RainbowSdk.instance().setNotificationBuilder(getApplicationContext(), MainActivity.class, R.drawable.biz_on_status,"Stellar LBS Demo app", "Connect to the app", Color.RED);
        RainbowSdk.instance().initialize();
    }




    public static void activityPaused(){
        activityVisible = false;
    }

    public static void activityResumed(){
        activityVisible = true;
    }

    public static boolean isActivityVisible() {
        return activityVisible;
    }
}
