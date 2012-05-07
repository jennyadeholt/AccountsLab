package com.jayway.accountslab.authenication;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.jayway.accountslab.CreateAccountActivity;

/**
 *
 */
public class AccountAuthenticator extends AbstractAccountAuthenticator {

	private final Context context;

	public static final String AUTH_TOKEN_TYPE_PARAM = "auto_token_param";

	/**
	 * @param context
	 */
	public AccountAuthenticator(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType, String[] requiredFeatures, Bundle options) throws NetworkErrorException {
		final Bundle result = new Bundle();

		Intent intent = new Intent(context, CreateAccountActivity.class);
		intent.putExtra(AUTH_TOKEN_TYPE_PARAM, authTokenType);
		intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);

		result.putParcelable(AccountManager.KEY_INTENT, intent);

		return result;
	}

	@Override
	public Bundle confirmCredentials(AccountAuthenticatorResponse response, Account account, Bundle options) throws NetworkErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bundle editProperties(AccountAuthenticatorResponse response, String accountType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthTokenLabel(String authTokenType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bundle hasFeatures(AccountAuthenticatorResponse response, Account account, String[] features) throws NetworkErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bundle updateCredentials(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
		// TODO Auto-generated method stub
		return null;
	}

}
