package com.jayway.accountslab.authenication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * 
 */
public class AccountsAuthenticationService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new AccountAuthenticator(this).getIBinder();
	}
}
