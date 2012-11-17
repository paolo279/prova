package com.example.provaparser;





import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends ProvaParser {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		TextView output = (TextView)findViewById(R.id.testo2);
	
			
			output.setText(ProvaParser.s[1]);
	}

}
