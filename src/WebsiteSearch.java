import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebsiteSearch {
	private String word;
	private String[] wordDescrip = new String[2];
	private HashSet<String> synonyms = new HashSet<>();
	
	public WebsiteSearch(String w) {
		this.word = w;
	}
	
	public String getPartOfSpeech(){
		//get part of speech of word
		String partOfSpeech  = wordDescrip[0];
		for(int j = 0; j <partOfSpeech.length(); j++){
			if(partOfSpeech.charAt(j) == ',' || partOfSpeech.charAt(j) == ';' || partOfSpeech.charAt(j) == '.') {
				if(j == partOfSpeech.length()-1) {
					partOfSpeech = partOfSpeech.substring(0,j);
				}else {
				partOfSpeech = partOfSpeech.substring(0,j) + partOfSpeech.substring(j+1);
				}
			}
		}
		return partOfSpeech;
	}
	
	public String getDefinition(){
		//get definition of word
		String definition  = wordDescrip[1];
		return definition;
	}
	
	public HashSet<String> getSynonyms(){
		//get 0-3 synonyms of word

		return synonyms;
	}
	
	public int attributes(){
		try {
			String partOfSpeech = "";
			String def = "";
			//dictionary.com url
			String url = "https://www.dictionary.com/browse/"+ this.word +"?s=t";
			//thesaurus.com url
			String url2 = "https://www.thesaurus.com/browse/"+ this.word + "?s=t";
			Document doc1 = Jsoup.connect(url).userAgent("mozilla/17.0").get();
			Document doc2 = Jsoup.connect(url2).userAgent("mozilla/17.0").get();
			Elements ele = doc1.select("span.luna-pos");
			Elements ele2 = doc1.select("span.one-click-content.css-1p89gle.e1q3nk1v4");
			Elements ele3 = doc2.select("a.css-r5sw71-ItemAnchor.etbu2a31");
			//creates part of speech
			for(Element dictionary : ele) {
				partOfSpeech = dictionary.text();
				break;
	        }
			if (partOfSpeech.contains(" ")) {
				for(int i = 0; i < partOfSpeech.length(); i++) {
					if(partOfSpeech.charAt(i) == ' ') {
						wordDescrip[0] = partOfSpeech.substring(0, i);
						break;
					}
				}
			}else {
				wordDescrip[0] = partOfSpeech;
			}
			//creates definition;
			for(Element dictionary2 : ele2) {
				wordDescrip[1] = dictionary2.text();
				break;
	        }
			
			//creates array of  synonyms 
			int i = 0;
			for(Element dictionary3 : ele3) {
				synonyms.add(dictionary3.text());
				if(i == 19) {
					break;
				}
				i++;	
	        }
			return 1;
			
		}catch(IOException e) {
			return -1;
		}
	}

	
} 