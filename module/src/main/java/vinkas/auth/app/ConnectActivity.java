package vinkas.auth.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.common.SignInButton;

import vinkas.app.Activity;
import vinkas.auth.R;

public class ConnectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        SignInButton googleSignIn = (SignInButton) findViewById(R.id.googleSignIn);
        googleSignIn.setSize(SignInButton.SIZE_WIDE);
        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount(v);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setResult(resultCode);
        finish();
    }

    public final static int CREATE_ACCOUNT = 1001;
    public final static int SIGN_IN = 1002;

    protected void createAccount(View view) {
        Intent i = new Intent(this, vinkas.auth.app.GoogleConnectActivity.class);
        startActivityForResult(i, CREATE_ACCOUNT);
    }

    protected void signIn(View view) {
        /*Intent i = new Intent(this, UsernameActivity.class);
        startActivityForResult(i, SIGN_IN);*/
    }

}
