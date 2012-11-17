package com.example.provaparser;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ProvaParser extends Activity {
	static String s[]= new String[6];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prova_parser);
		
		// Selezioniamo il feed rss
		String url= "http://www.corrieredellosport.it/rss/Calcio-3.xml";
		
		
		//Facciamo partire il parser
		try {
			SAXParserFactory factory=SAXParserFactory.newInstance();
    		SAXParser parser=factory.newSAXParser();
			InputStream in = new URL(url).openStream(); //connessione http al browser
			RssHandler handler=new RssHandler();
			XMLReader reader = parser.getXMLReader();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(in));
			
			//Creazione puntatori alle id delle TexView
		
			TextView t0 = (TextView) findViewById(R.id.titolo);
			TextView t1 = (TextView) findViewById(R.id.TextView01);
			TextView t2 = (TextView) findViewById(R.id.TextView02);
			TextView t3 = (TextView) findViewById(R.id.TextView03);
			TextView t4 = (TextView) findViewById(R.id.TextView04);
			TextView t5 = (TextView) findViewById(R.id.TextView05);
			
			final TextView t[] = {t0,t1,t2,t3,t4,t5};	
			for(int i=0; i<6; i++){
				t[i].setText(handler.title[i]);
				s[i]=handler.title[i];
			}
			
			t0.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(ProvaParser.this,SecondActivity.class);
					startActivity(intent);
					
				}
			});
		}catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_prova_parser, menu);
		return true;
	}

}
