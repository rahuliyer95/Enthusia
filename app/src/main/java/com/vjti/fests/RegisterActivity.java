package com.vjti.fests;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import de.keyboardsurfer.android.widget.crouton.Crouton;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        findViewById(R.id.register_btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( ((EditText) findViewById(R.id.register_et_username)).getText().toString().equals("") ) {
                    Utils.showAlert(RegisterActivity.this, R.string.alert_register_enter_username);
                } else if ( ((EditText) findViewById(R.id.register_et_email)).getText().toString().equals("")) {
                    Utils.showAlert(RegisterActivity.this, R.string.alert_register_enter_email);
                } else if ( !((EditText) findViewById(R.id.register_et_email)).getText().toString().contains("@")) {
                    Utils.showAlert(RegisterActivity.this, R.string.alert_register_enter_valid_email);
                } else {
                    getSharedPreferences(Utils.SHARED_PREFS, MODE_PRIVATE).edit().putString(Utils.PREF_USER_NAME, ((EditText) findViewById(R.id.register_et_username)).getText().toString()).commit();
                    getSharedPreferences(Utils.SHARED_PREFS, MODE_PRIVATE).edit().putString(Utils.PREF_EMAIL, ((EditText) findViewById(R.id.register_et_email)).getText().toString()).commit();
                    getSharedPreferences(Utils.SHARED_PREFS, MODE_PRIVATE).edit().putBoolean(Utils.PREF_REGISTRATION_DONE, true).commit();

                    // TODO Register for push notification

                    finish();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        Crouton.cancelAllCroutons();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        Utils.showAlert(this, R.string.alert_register_first);
    }
}
