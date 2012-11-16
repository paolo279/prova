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
import android.view.Menu;
import android.widget.TextView;

public class ProvaParser extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prova_parser);
		
		// Selezioniamo il feed rss
		String url= "http://www.nasa.gov/rss/image_of_the_day.rss";
		String url1= "http://www.corrieredellosport.it/rss/Calcio-3.xml";
		
		//Facciamo partire il parser
		try {
			SAXParserFactory factory=SAXParserFactory.newInstance();
    		SAXParser parser=factory.newSAXParser();
			InputStream in = new URL(url1).openStream(); //connessione http al browser
			RssHandler handler=new RssHandler();
			XMLReader reader = parser.getXMLReader();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(in));
			
			//Creazione puntatori alle id delle TexView
		
			TextView t0 = (TextView) findViewById(R.id.titolo);
			TextView t1 = (TextView) findViewById(R.id.TextView01);
			TextView t2 = (TextView) findViewById(R.id.TextView02);
			TextView t3 = (TextView) findViewById(R.id.TextView03);
			
			final TextView t[] = {t0,t1,t2,t3};	
			for(int i=0; i<4; i++){
				t[i].setText(handler.title[i]);
			}
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
