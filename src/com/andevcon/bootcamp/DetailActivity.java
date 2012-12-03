/**
 * 
 */
package com.andevcon.bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
		final int amount = intent.getIntExtra("amount", 0);

		String expense = formatForDisplay(name, amount);

		TextView expenseTextView = (TextView) findViewById(R.id.detail_expense_title);
		expenseTextView.setText(expense);

		Button convertButton = (Button) findViewById(R.id.detail_picture);
		convertButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String usdollars = formatForWebcall(amount);
				new CurrencyConversionTask().execute(usdollars);
			}
		});

	}
	

	/**
	 * AsyncTask to make the webservice call off the main UI thread
	 * 
	 */
	private class CurrencyConversionTask extends AsyncTask<String, Void, Void> {

		protected void onPreExecute() {
		}

		protected Void doInBackground(final String... args) {
			String inputValue = args[0];
			String convertedValue = convertToGBP(inputValue);
			Log.v("AnDevCon", "The return value from the call is: " + convertedValue);
			return null;
		}

		// can use UI thread here
		protected void onPostExecute(final Void unused) {

		}
	}

	/**
	 * Makes a call to a web-service to convert currency
	 * @param amount
	 * @return
	 */
	public static String convertToGBP(String amount) {
		String page = "";

		BufferedReader in = null;
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();

			StringBuilder sb = new StringBuilder();
			sb.append("http://www.google.com/ig/calculator?hl=en&q=");
			sb.append(amount);
			sb.append("USD=?GBP");
			Log.v("AnDevCon", "The URL we are sending is: " + sb.toString());

			request.setURI(new URI(sb.toString()));
			HttpResponse response = client.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity()
					.getContent()));
			StringBuffer retStr = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				retStr.append(line + NL);
			}
			in.close();
			page = retStr.toString();
		} catch (URISyntaxException e) {
			Log.v("AnDevCon", "URISyntaxException", e);
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			Log.v("AnDevCon", "ClientProtocolException", e);
			e.printStackTrace();
		} catch (IOException e) {
			Log.v("AnDevCon", "IOException", e);
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return page;
	}

	private String formatForDisplay(String name, int amount) {
		String usd = "$00.00";
		if (amount != 0) {
			Integer amountInt = Integer.valueOf(amount);
			String amountString = amountInt.toString();
			String dollars = amountString.substring(0,
					amountString.length() - 2);
			String cents = amountString.substring(amountString.length() - 2);
			usd = "$" + dollars + "." + cents;
		}

		String expenseUSD = name + " : " + usd;
		return expenseUSD;
	}
	
	private String formatForWebcall(int amount) {
		String usd = "00.00";
		if (amount != 0) {
			Integer amountInt = Integer.valueOf(amount);
			String amountString = amountInt.toString();
			String dollars = amountString.substring(0,
					amountString.length() - 2);
			String cents = amountString.substring(amountString.length() - 2);
			usd = dollars + "." + cents;
		}

		return usd;
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
