package com.benscholer.textbomber;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFlat;


public class MainActivity extends ActionBarActivity {

	Toolbar toolbar;
	EditText phoneNumber;
	EditText message;
	EditText repeat;
	Button send;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		phoneNumber = (EditText) findViewById(R.id.phone_number);
		message = (EditText) findViewById(R.id.message_text);
		repeat = (EditText) findViewById(R.id.repeat);
		send = (Button) findViewById(R.id.send_button);
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle("Text Bomber");

		send.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
					String num = phoneNumber.getText().toString();
					String mssg = message.getText().toString();
					int rept = Integer.parseInt(repeat.getText().toString());

				if ((num == null || num.equals("")) || (mssg == null || mssg.equals(""))) {
					Toast.makeText(getApplicationContext(), "Make sure all fields are filled",
							Toast.LENGTH_LONG).show();
				} else {
					Bomb bomb = new Bomb(num, mssg, rept);
					bomb.send(getApplicationContext());
				}
			}
		});
	}
}
