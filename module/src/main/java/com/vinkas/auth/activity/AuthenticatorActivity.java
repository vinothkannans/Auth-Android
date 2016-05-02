package com.vinkas.auth.activity;

import android.content.Intent;
import android.os.Bundle;

import com.vinkas.auth.R;

/**
 * Created by Vinoth on 28-12-15.
 */
public class AuthenticatorActivity extends android.accounts.AccountAuthenticatorActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
//        setContentView(R.layout.activity_account_authenticator);
        addAccount();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*if(requestCode == Constants.ADD_ACCOUNT) {
            finish();
        }*/
    }

    protected void addAccount() {
        /*Intent i = new Intent(this, ConnectActivity.class);
        i.putExtra("From", AuthenticatorActivity.class.toString());
        startActivityForResult(i, Constants.ADD_ACCOUNT);*/
    }
}
