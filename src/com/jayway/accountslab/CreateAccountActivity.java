package com.jayway.accountslab;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.jayway.accountslab.authenication.AccountAuthenticator;


/**
 * @author Jenny Nilsson, Jayway
 */
public class CreateAccountActivity extends Activity {

    private static final int PROGRESS_DIALOG = 0;

    @Override
    protected void onCreate(Bundle icicle) {
        // TODO Auto-generated method stub
        super.onCreate(icicle);
        this.setContentView(R.layout.login_view);
    }

    /**
     * @param v
     */
    public void onLogin(View v) {

        showDialog(PROGRESS_DIALOG);

        boolean hasErrors = false;

        TextView tvUsername = (TextView) this.findViewById(R.id.username);
        TextView tvPassword = (TextView) this.findViewById(R.id.password);

        String username = tvUsername.getText().toString();
        String password = tvPassword.getText().toString();

        if (username.length() < 3) {
            hasErrors = true;
            tvUsername.setBackgroundColor(Color.GRAY);
        }
        if (password.length() < 3) {
            hasErrors = true;
            tvPassword.setBackgroundColor(Color.GRAY);
        }

        if (hasErrors) {
            return;
        }

        String accountType = this.getIntent().getStringExtra(AccountAuthenticator.AUTH_TOKEN_TYPE_PARAM);
        if (TextUtils.isEmpty(accountType)){
            accountType = getString(R.string.auth_token);
        }

        new LoginUserTask().execute(username, password, accountType);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case PROGRESS_DIALOG:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Creating account");
                return progressDialog;
            default:
                return super.onCreateDialog(id);
        }
    }

    private class LoginUserTask extends AsyncTask<String, Void, Boolean> {

        private String username;
        private String password;
        private String accountType;

        @Override
        protected Boolean doInBackground(String... params) {
            this.username = params[0];
            this.password = params[1];
            this.accountType = params[2];

            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);



            dismissDialog(PROGRESS_DIALOG);


        }
    }
}