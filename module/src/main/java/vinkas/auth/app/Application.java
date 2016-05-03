package vinkas.auth.app;

import android.accounts.Account;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/**
 * Created by Vinoth on 3-5-16.
 */
public abstract class Application extends vinkas.app.Application {

    public abstract void setGoogleSignInAccount(GoogleSignInAccount googleAccount);
    public abstract void setAndroidAccount(Account androidAccount);

}
