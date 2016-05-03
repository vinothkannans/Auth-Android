package vinkas.auth.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import vinkas.auth.R;
import vinkas.util.Helper;

public class GoogleConnectActivity extends Activity
        implements GoogleApiClient.OnConnectionFailedListener {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result != null && result.isSuccess()) {
                onSignIn(result.getSignInAccount());
            } else {
                if (result.getStatus().getStatusMessage() != null)
                    Log.e("GoogleSignIn", result.getStatus().getStatusMessage());
                Toast.makeText(this, "Unable to sign in. Please try again.", Toast.LENGTH_LONG).show();
                sendResult(Helper.RESULT_ERROR);
            }
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        sendResult(Helper.RESULT_ERROR);
    }

    GoogleApiClient mApiClient;

    protected void signIn() {
        if (signInPrepared == false)
            prepareSignIn();
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    boolean signInPrepared = false;

    protected void prepareSignIn() {
        // Configure sign-in to request the user's ID, email address, and basic profile. ID and
        // basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.server_client_id))
                .requestEmail()
                .build();

        // Build a GoogleApiClient with access to GoogleSignIn.API and the options above.
        mApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        signInPrepared = true;
    }

    int RC_SIGN_IN = 1001;

    protected void onSignIn(final GoogleSignInAccount account) {
        getApp().setGoogleSignInAccount(account);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        if (savedInstanceState == null)
            signIn();
    }
}