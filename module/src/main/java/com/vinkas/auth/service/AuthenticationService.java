package com.vinkas.auth.service;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.vinkas.auth.Authenticator;

/**
 * Created by Vinoth on 28-12-15.
 */
public class AuthenticationService extends android.app.Service {

    // Instance field that stores the authenticator object
    private Authenticator mAuthenticator;

    @Override
    public void onCreate() {
        mAuthenticator = new Authenticator(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Service", "Binder");
        return mAuthenticator.getIBinder();
    }

}
