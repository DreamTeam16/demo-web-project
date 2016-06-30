package edu.csupomona.cs480.data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Test_jsoup {
	
	 public static void main(String[] args) {

	        Document doc;
	        try {
	        		//grabs the specified url
	                doc = Jsoup.connect("http://www.battle.net").get();

	                File f = new File("src/main/resources/static/jsouptest.html");
                   FileWriter nhtml= new FileWriter(f);
	                //grab name of site
	                String name = doc.title()+"<br/>";
	                nhtml.write("Quick Test of JSoup with Battle.net <br/>");
	                nhtml.write(name);
	                String plinks,texts;

	                // get all links
	                Elements links = doc.select("a[href]");
	                for (Element link : links) {
	                	
	                    
	                       
	                      plinks="\nLink : " + link.attr("href")+"<br/>";
	                      texts= "Text : " + link.text()+"<br/>";
	                      nhtml.write(plinks);
	                      nhtml.write(texts);
	                      
	                      
	                      
	                }nhtml.close();

	        } catch (IOException e) {
	  
	                e.printStackTrace();
	        }
	        
	       
	        

	  }

	}


