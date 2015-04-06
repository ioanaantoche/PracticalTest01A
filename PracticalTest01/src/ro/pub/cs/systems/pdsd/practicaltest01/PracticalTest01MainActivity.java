package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01MainActivity extends Activity {
	int clk = 0;
	
	public void onClicked(View v) {
		if (v.getId() == R.id.button1) {
			++clk;
			Button b = (Button) findViewById(R.id.button2);
			EditText t = (EditText) findViewById(R.id.editText2);
			Button b1 = (Button) findViewById(R.id.button3);
			Button b_ = (Button) findViewById(R.id.button1);
			if (clk % 2 == 1) {
				b.setVisibility(View.VISIBLE);
				b1.setVisibility(View.VISIBLE);
				t.setVisibility(View.VISIBLE);
				b_.setText("LessDetails");
			} else {
				b.setVisibility(View.INVISIBLE);
				b1.setVisibility(View.INVISIBLE);
				t.setVisibility(View.INVISIBLE);
				b_.setText("MoreDetails");
			}
		}
		if (v.getId() == R.id.button3) {
			EditText tt = (EditText)findViewById(R.id.editText2);
	        EditText tt1 = (EditText)findViewById(R.id.editText1);
			Intent i = new Intent("android.intent.action.SEC");
			i.putExtra("t1", tt1.getText().toString());
			i.putExtra("t2", tt.getText().toString());
			startActivityForResult(i, 1);
		}
	}
	
	public void onEdit(View v) {
		EditText t = (EditText) findViewById(R.id.editText2);
		Button b = (Button) findViewById(R.id.button2);
		String s[] = t.getText().toString().split("//");
		if (s[0].equals("https")) {
			b.setBackgroundColor(Color.GREEN);
		} else {
			b.setBackgroundColor(Color.RED);
		}
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        EditText tt = (EditText)findViewById(R.id.editText2);
        EditText tt1 = (EditText)findViewById(R.id.editText1);
        
        if (savedInstanceState != null) {
        	String s1 = (String) savedInstanceState.getString("t1");
        	tt1.setText(s1);
        	s1 = (String) savedInstanceState.getString("t2");
        	tt.setText(s1);
        }
        
        tt.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable ss) {
            	EditText t = (EditText) findViewById(R.id.editText2);
        		Button b = (Button) findViewById(R.id.button2);
        		String s[] = t.getText().toString().split("//");
        		if (s[0].equals("https")) {
        			b.setBackgroundColor(Color.GREEN);
        			b.setText("Success");
        		} else {
        			b.setBackgroundColor(Color.RED);
        			b.setText("Fail");
        		}
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        }); 
        
       
    }
    
    protected void onActivityResult(int req, int res, Intent intent) {
    	Toast.makeText(this, "Rezultat "+ res, Toast.LENGTH_LONG).show();
    	if (res == RESULT_OK) {
    		Log.d("RESULT OK ", "...");
    	} else {
    		Log.d("RESULT FAIL ", "...");
    	}
    }

    @Override
    protected void onSaveInstanceState(Bundle sis) {
    	EditText tt = (EditText)findViewById(R.id.editText1);
    	sis.putString("t1", tt.toString());
    	EditText tt1 = (EditText)findViewById(R.id.editText2);
    	sis.putString("t2", tt1.toString());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
