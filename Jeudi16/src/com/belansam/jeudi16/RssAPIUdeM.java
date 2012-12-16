package com.belansam.jeudi16;

import android.os.Bundle;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.util.Log;

//
// une classe qui charge une page web et parse le contenu XML feed rss
// NOTE: cette classe NE PEUT PAS toucher à l'interface
//

public class RssAPIUdeM {
	// null si pas d'erreur
	String erreur;

	// une liste de maps
	ArrayList<HashMap<String, Object>> data;
	
//	HashMap<String,Integer> categoryIcons;
	
	RssAPIUdeM(String feed) {
		//Log.d("rss","loading "+urlRss);		
		erreur=null;

		URL url;
		try {
			url = new URL("http://www.nouvelles.umontreal.ca/"+feed+"/rss.html");

			HttpURLConnection conn;
			conn = (HttpURLConnection) url.openConnection();
			if( conn.getResponseCode() != HttpURLConnection.HTTP_OK ) {
				erreur="pas de connexion";
				return;
			}

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			db = dbf.newDocumentBuilder();
			Document doc;
			doc = db.parse(url.openStream());
			doc.getDocumentElement().normalize();

			// va chercher les items
			NodeList items = doc.getElementsByTagName("item");

			data=new ArrayList<HashMap<String, Object>>();
			
//			categoryIcons=new HashMap<String,Integer>();
//			categoryIcons.put("Cinéma",android.R.drawable.ic_menu_camera);
//			categoryIcons.put("Arts de la scène",android.R.drawable.ic_menu_myplaces);
//			categoryIcons.put("Belles soirées",android.R.drawable.ic_menu_zoom);

			SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss ZZZZZ",Locale.CANADA);
			

			for(int i=0;i<items.getLength();i++) {
				Node item = items.item(i);
				if(item.getNodeType() != Node.ELEMENT_NODE) {
					erreur="illegal node type "+item.getNodeType();
					break;
				}
				Element e = (Element)item;
				NodeList n;
				HashMap<String,Object> hm=new HashMap<String,Object>();
				n = e.getElementsByTagName("title");
				hm.put("title",n.item(0).getChildNodes().item(0).getNodeValue());
				n = e.getElementsByTagName("link");
				hm.put("link", n.item(0).getChildNodes().item(0).getNodeValue());
				n = e.getElementsByTagName("description");
				hm.put("description", n.item(0).getChildNodes().item(0).getNodeValue());
				n = e.getElementsByTagName("category");
				hm.put("category",  n.item(0).getChildNodes().item(0).getNodeValue());
				n = e.getElementsByTagName("pubDate");
				hm.put("pubDate",n.item(0).getChildNodes().item(0).getNodeValue());
				// process la date
				// on saute la journee au debut de la date
				Date date = sdf.parse((String) hm.get("pubDate"),new ParsePosition(5));
				hm.put("time",(int)(date.getTime()/1000)); // en secondes
				CharSequence cs=android.text.format.DateUtils.getRelativeTimeSpanString(date.getTime());
				hm.put("since",cs);
				
				// cas special, l'image
	//			hm.put("icon",android.R.drawable.ic_menu_myplaces);
//				hm.put("icon",categoryIcons.get(hm.get("category")));

				data.add(hm);
			}

//			Log.d("rss","loading done. ("+items.getLength()+")");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			erreur=e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			erreur=e.getMessage();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			erreur=e.getMessage();
		} catch (SAXException e) {
			e.printStackTrace();
			erreur=e.getMessage();
		}

	}


}