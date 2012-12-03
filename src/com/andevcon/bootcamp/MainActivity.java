package com.andevcon.bootcamp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText expenseName = (EditText) findViewById(R.id.item_name_edittext);
		final EditText expenseAmount = (EditText) findViewById(R.id.item_amount_edittext);
		Button nextButton = (Button) findViewById(R.id.enter_button);
		
		nextButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String name = expenseName.getText().toString();
				String amountString = expenseAmount.getText().toString();
				int amount = 0;
				if (!amountString.equals("")) {
					amount = Integer.parseInt(expenseAmount.getText().toString());
				} 
				
				Log.v("Bootcamp", "The expense: " + name + " has the value: " + amount);
				Intent details = new Intent(MainActivity.this, DetailActivity.class);
				details.putExtra("name", name);
				details.putExtra("amount", amount);
				startActivity(details);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
