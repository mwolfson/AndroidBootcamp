/**
 * 
 */
package com.andevcon.bootcamp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 */
public class DetailActivity extends Activity {
	private ShareActionProvider provider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setTitle(R.string.expense_detail);

		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		int amount = intent.getIntExtra("amount", 0);

		String expense = convertToUsd(name, amount);

		TextView expenseTextView = (TextView) findViewById(R.id.detail_expense_title);
		expenseTextView.setText(expense);
	}

	private String convertToUsd(String name, int amount) {
		String usd = "$00.00";
		if (amount != 0) {
			Integer amountInt = Integer.valueOf(amount);
			String amountString = amountInt.toString();
			String dollars = amountString.substring(0, amountString.length() - 2);
			String cents = amountString.substring(amountString.length() - 2);
			usd = "$" + dollars + "." + cents;
		}

		String expenseUSD = name + " : " + usd;
		return expenseUSD;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.detail_menu, menu);

		// Setup share functionality
		MenuItem item = menu.findItem(R.id.menu_share);
		provider = (ShareActionProvider) item.getActionProvider();
		setShareIntent();

		return true;
	}

	/* Handles item selections */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent homeIntent = new Intent(this, MainActivity.class);
			startActivity(homeIntent);
			return true;
		case R.id.menu_main:
			Intent mainIntent = new Intent(this, MainActivity.class);
			startActivity(mainIntent);
			return true;
		case R.id.menu_email:
			String[] mailto = new String[] { "adcbootcamp@email.com" };
			String subject = "Subject: ";
			String body = "Body:";

			Intent email = new Intent(Intent.ACTION_SEND);
			email.setType("message/rfc822");
			email.putExtra(Intent.EXTRA_EMAIL, mailto);
			email.putExtra(Intent.EXTRA_SUBJECT, subject);
			email.putExtra(Intent.EXTRA_TEXT, body);

			try {
				startActivity(email);
			} catch (Exception e) {
				Context context = getApplicationContext();
				String text = "Oops, does your email work?";
				int duration = Toast.LENGTH_LONG;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				return true;
			}
			return false;
		}
		return false;
	}

	public void setShareIntent() {
		String shareSubject = "Expense to share: ";
		String shareText = "Expense info: ";

		final Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
		intent.putExtra(Intent.EXTRA_TEXT, shareText);
		if (provider != null) {
			provider.setShareIntent(intent);
		}
	}
}
