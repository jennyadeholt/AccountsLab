package com.jayway.accountslab.authenication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * 
 */
public class AccountsAuthenticationService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		Log.d("", "AuthenicationService.onBind");
		return new AccountAuthenticator(this).getIBinder();
	}

}
