import java.util.HashSet;

public class Desipher {
	private String singleWord;
	private String phrase;
	private StringNode first;
	private boolean YouIndicator;
	private boolean IIndicator;
	private boolean QuestionIndicator;
	private boolean ExcitementIndicator;
	private boolean Happy;
	private boolean Angry;
	private boolean Comm;
	private HashSet<String> object = new HashSet<>();
	private int happyCount;
	private int angryCount;
	private int commCount;
	private int unknownWordCount;
	private int wordCount;
	
    class StringNode {
        private StringNode next;
        private String word;
        
        private StringNode(String w, StringNode n) {
            next = n;
            word = w;
        }
    }
	
	public Desipher(String input) {
		if(input.contains(" ")) {
			phrase = input + " ";
			//BreakDown();
			//make all words uncapitalized
		}else {
			singleWord = input;
			//SingleBD();
		}
	}
	public boolean SingleBD() {
		WebsiteSearch wordSearch = new WebsiteSearch(singleWord);
		int realWord = wordSearch.attributes();
		//tests if word is real
		if(realWord == -1) {
			System.out.println("I think you might have misspelled this word!");
		}
		int val = search(singleWord);
		if(val == -1) {
			System.out.println("Hmmm... I don't know this word.");
			return false;
		}
		YouIndicator = false;
		IIndicator = false;
		QuestionIndicator  = false;
		ExcitementIndicator  = false;
		Happy  = false;
		Angry  = false;
		Comm  = false;
		return true;
	}
	public boolean BreakDown() {
		/*
		 * Breakdown of the sentence/s to create a StringNode for each word 
		 * from user input
		 * activates some indicators
		 */
		wordCount=0;
		YouIndicator = false;
		QuestionIndicator = false;
		int holder = 0;
		String word;
		
		if (phrase.contains("?")) {
			QuestionIndicator = true;
		}
		if (phrase.contains("!")) {
			ExcitementIndicator = true;
		}
		
		for(int i = 0; i < phrase.length()-1; i++) {
			//removes punctuation
			if(phrase.substring(i,i+1).contains(",;:.'")) {
				phrase = phrase.substring(0,i) + (i+1);
			}
		}
		
		for(int i = 0; i < phrase.length(); i++) {
			if (phrase.charAt(i) == ' ') {
				word = phrase.substring(holder, i);
				holder = i+1;
				wordCount++;
				if (word.equals("you")) {
					YouIndicator = true;
				}
				if (word.equals("I")) {
					IIndicator = true;
				}
				if (first == null){
					first = new StringNode(word, null);
				}
				else{
					StringNode trav = first;
					while(trav.next != null) {
						trav = trav.next;
					}
					trav.next = new StringNode(word, null);
				}
			}
		}
		if(find()){
			return true;
		}else{
			return false;
		}

	}
	
	public int search(String word) {
		//searches through all the words in Bot's library
		DataRetriever search = new DataRetriever("");
		return search.search2(word);
	}
	
	public boolean find() {
		/*
		 * Goes through StringNode and determines whether it knows enough of the 
		 * sentence, counts amount of happy/angry/communication words to 
		 * determine appropriate response
		 */
		HashSet<String> unknown = new HashSet<>();
		//HashSet of unknown words from user
		unknownWordCount = 0;
		commCount = 0;
		angryCount = 0;
		happyCount = 0;
		StringNode trav = first;
		while (trav != null) {
			int val = search(trav.word);
			WebsiteSearch wordSearch = new WebsiteSearch(trav.word);
			int realWord = wordSearch.attributes();
			//tests if word is real
			if(realWord == -1) {
				System.out.println("I think you might have misspelled some words!");
			}else {
				String POS = wordSearch.getPartOfSpeech();
				if(trav.word.contains("ABCDEFGHIJKLMNOPQRSTUV")) {
					object.add(trav.word);
				}
				if(val == -1) {
					unknown.add(trav.word);
					unknownWordCount++;
				}else if(val == 1) {
					if(POS.equals("noun")) {
						object.add(trav.word);
					}
					commCount++;
				}else if(val == 2) {
					if(POS.equals("noun")) {
						object.add(trav.word);
					}
					angryCount++;
				}else if(val == 3) {
					if(POS.equals("noun")) {
						object.add(trav.word);
					}
					happyCount++;
				}else {
					if(POS.equals("noun")) {
						object.add(trav.word);
					}			
				}
			}
			
			double average = (double)unknownWordCount/wordCount;
			if(average > .5) {
				//if there are more than 50% of unknown words
				System.out.println("I do not know enough of these words, sorry. "
						+ "\n"+ "Feel free to teach me them on the main selection so I can "
						+ "\n"+ "understand what you said!");
				System.out.println("However, if you want, we can continue talking! Say Something!");
				return false;
				
			}
			trav = trav.next;
		}
		System.out.println("UnkownWords: " + unknown);
		if(commCount > 0) {
			Comm = true;
		}else if(happyCount > angryCount) {
			Happy = true;
		}else if(happyCount < angryCount) {
			Angry = true;
		}else if(happyCount < angryCount) {
			Happy = false;
			Angry = false;
		}else if(commCount==0) {
			Comm = false;
		}
		return true;
	}
	
	public boolean[] getIndicators(){
		//gets specific indicators to help formulate response
		boolean[] indicatorArray = new boolean[4];
		indicatorArray[0] = YouIndicator;
		indicatorArray[1] = IIndicator;
		indicatorArray[2] = QuestionIndicator;
		indicatorArray[3] = ExcitementIndicator;
		
		return indicatorArray;
	}
	public boolean[] getEmotions(){
		//gets emotional indicators to help formulate response
		boolean[] EmotionArray = new boolean[3];
		EmotionArray[0] = Happy;
		EmotionArray[1] = Angry;
		EmotionArray[2] = Comm;
		
		return EmotionArray;
	}
	public HashSet<String> getObject(){
		//gets the object or topic of what the user inputed(for seemingly better response)
		return object;
		
	}
	
	
	
}
