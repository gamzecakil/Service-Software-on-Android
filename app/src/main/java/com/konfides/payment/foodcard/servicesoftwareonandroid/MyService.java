package com.konfides.payment.foodcard.servicesoftwareonandroid;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    //Services run in the background indepentdently of the user interface.
    //Example use service
    //1.we can ask the service to send us an e-mail every 15 minutes.
    //2.we can ask the service to return us an information every 10 seconds
    //3.we can ask the service to return a local push notification every 10 seconds

    //we will make example number 2 (message Toast)
    private static  final String TAG=MyService.class.getSimpleName();
    Handler handler=new Handler();
    Runnable runnable;
    private boolean killMe=false;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"service created ");

        Toast.makeText(getApplicationContext(),"Service started",Toast.LENGTH_LONG).show();

        runnable=new Runnable() {
            @Override
            public void run() {
                if(!killMe){
                    Toast.makeText(getApplicationContext(),"10 seconds expired",Toast.LENGTH_SHORT).show();
                    handler.postDelayed(this,10000);//10.000 10 seconds
                }
            }
        };
        handler.post(runnable);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"service destroyed...");
        Toast.makeText(getApplicationContext(),"Service stopped",Toast.LENGTH_SHORT).show();
        kill();
    }
    public void kill(){//The method is stop for runnaable
        killMe=true;
    }
}
