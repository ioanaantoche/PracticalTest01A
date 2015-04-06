package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01SecondActivity extends Activity {

	public void onClicked(View v) {
		if (v.getId() == R.id.button1) {
			setResult(RESULT_OK, new Intent());
			finish();
		}
		if (v.getId() == R.id.button2) {
			setResult(RESULT_CANCELED, new Intent());
			finish();
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		Intent i = getIntent();
		if (i != null) {
			EditText tt = (EditText)findViewById(R.id.editText2);
			tt.setText(i.getStringExtra("t1"));
	        EditText tt1 = (EditText)findViewById(R.id.editText1);
	        tt1.setText(i.getStringExtra("t2"));
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_second, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
