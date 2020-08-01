import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//import Desipher.StringNode;

public class Constructor {
	private String[] simple1 = {"subject","verb","object"};
	private String[] simple2 = {"subject","verb","object", "prep"};
	private String[] simple3 = {"subject", "adverb", "verb", "object"};
	private String[] simple4 = {"subject", "adverb", "verb", "adjective", "object"};
	private String[] dependent = {"subconj","subject","verb","object"};
	private String input;
	private boolean single;
	private int BD;
	private String botTalk;
	
	private class StringNode {
		private StringNode next;
	    private String word;
	        
	    private StringNode(String w, StringNode n) {
	    	next = n;
	        word = w;
	    }
	}
		
	public Constructor(String in, int val) {
		input = in;
		BD = val;
		
	}
		
	public boolean Creator() {
		/*
		 * Creates the sentence/s of the Bot based on the words its been taught. 
		 * Word choice based on probability
		 * amount/sentence choice based on random numbers
		 */
		Desipher X = new Desipher(input);
		boolean flag;
		if (BD == 1) {
			flag = X.SingleBD();
			single = true;
		}else {
			flag = X.BreakDown();
			single = false;
		}
		
		HashSet<String> object = X.getObject();
		if(flag == false) {
			return false;
		}
		
		DataRetriever Ncon = new DataRetriever("nuetralConjunctions.txt");
		Ncon.FileRunner();
		DataRetriever Nprep = new DataRetriever("nuetralPrepositions.txt");
		Nprep.FileRunner();
		DataRetriever Npro = new DataRetriever("nuetralPronouns.txt");
		Npro.FileRunner();
		DataRetriever NSubC = new DataRetriever("nuetralSubConjunctions.txt");
		NSubC.FileRunner();
		DataRetriever Nadj = new DataRetriever("neutralAdjectives.txt");
		Nadj.FileRunner();
		DataRetriever Nverb = new DataRetriever("neutralVerbs.txt");
		Nverb.FileRunner();
		DataRetriever Nadv = new DataRetriever("neutralAdverbs.txt");
		Nadv.FileRunner();
		DataRetriever Nnoun = new DataRetriever("neutralNouns.txt");
		Nnoun.FileRunner();
		
		DataRetriever commInter = new DataRetriever("commInterjections.txt");
		commInter.FileRunner();
		DataRetriever commQ = new DataRetriever("commQuestioins.txt");
		commQ.FileRunner();
		
		DataRetriever Aadj = new DataRetriever("AngerAdjectives.txt");
		Aadj.FileRunner();
		DataRetriever Averb = new DataRetriever("AngerVerbs.txt");
		Averb.FileRunner();
		DataRetriever Aadv = new DataRetriever("AngerAdverbs.txt");
		Aadv.FileRunner();
		DataRetriever Anoun = new DataRetriever("AngerNouns.txt");
		Anoun.FileRunner();
		
		DataRetriever Hadj = new DataRetriever("HappyAdjectives.txt");
		Hadj.FileRunner();
		DataRetriever Hverb = new DataRetriever("HappyVerbs.txt");
		Hverb.FileRunner();
		DataRetriever Hadv = new DataRetriever("HappyAdverbs.txt");
		Hadv.FileRunner();
		DataRetriever Hnoun = new DataRetriever("HappyNouns.txt");
		Hnoun.FileRunner();
		
		int position = 0;
		String word = "";
		
		//indicators[you,I,?,!]
		boolean[] indicators = X.getIndicators();
		//emotions[happy,angry,comm]
		boolean[] emotions = X.getEmotions();
		
		botTalk = "";
		Random rand = new Random(); 
	    int upperbound = 4;
	    //decides amount of sentences
	    int int_random = rand.nextInt(upperbound);
	    if(single == true) {
	    	int_random = 1;
	    }
	    for(int i = 0; i < int_random; i++) {
	    	int int_random2 = rand.nextInt(4);
	    	//creates dependent clause for complex sentence
	    	if(int_random2 == 3) {
		    	for(int j = 0; j < dependent.length; j++) {
		    		if(dependent[j].equals("subject")) {
			    		if(indicators[0] == true) {
			    			botTalk = botTalk +" "+ "I";
			    		}if(indicators[1] == true) {
			    			botTalk = botTalk +" "+ "you";
			    		}
			    		else {
			    			position = Npro.probOfWord();
			    			Npro.ifUsed(position);
			    			Npro.changeProbFile();
			    			word = Npro.getWord(position);
			    			botTalk = botTalk + " " + word;
			    		}
	    			}else if (dependent[j].equals("verb")) {
	    				int int_random4 = rand.nextInt(2);
	    				if(int_random4 == 0 && (emotions[0] == true || emotions[1] == true)) {
	    					if(emotions[0] == true) {
	    						position = Hverb.probOfWord();
				    			Hverb.ifUsed(position);
				    			Hverb.changeProbFile();
				    			word = Hverb.getWord(position);
				    			botTalk = botTalk + " " + word;
	    					}else if(emotions[1] == true) {
	    						position = Averb.probOfWord();
				    			Averb.ifUsed(position);
				    			Averb.changeProbFile();
				    			word = Averb.getWord(position);
				    			botTalk = botTalk + " " + word;
	    					}
	    				}else {
	    					position = Nverb.probOfWord();
			    			Nverb.ifUsed(position);
			    			Nverb.changeProbFile();
			    			word = Nverb.getWord(position);
			    			botTalk = botTalk + " " + word;
	    				}
	    			}else if (dependent[j].equals("object")) {
	    				int int_random4 = rand.nextInt(4);
	    				if(int_random4>0) {
	    					position = Nnoun.probOfWord();
			    			Nnoun.ifUsed(position);
			    			Nnoun.changeProbFile();
			    			word = Nnoun.getWord(position);
			    			botTalk = botTalk + " " + word;
	    				}else {
	    					position = Npro.probOfWord();
			    			Npro.ifUsed(position);
			    			Npro.changeProbFile();
			    			word = Npro.getWord(position);
			    			botTalk = botTalk + " " + word;
	    				}
	    			}else if (dependent[j].equals("subconj")) {
	    				position = NSubC.probOfWord();
		    			NSubC.ifUsed(position);
		    			NSubC.changeProbFile();
		    			word = NSubC.getWord(position);
		    			word = word.substring(0,1).toUpperCase() + word.substring(1);
		    			botTalk = botTalk + word;
	    			}
		    	}
		    	
		    	botTalk = botTalk + ", ";
	    	
	    	}
	    	//creates independent clause
	    	int int_random3 = rand.nextInt(4);
	    	String[] simple = {};
	   		//chooses one of 4 simple sentences
	   		if(int_random3 == 0) {
	   			simple = simple1;
	   		}
	    	else if(int_random3 == 1) {
	    		simple = simple2;
	   		}
	   		else if(int_random3 == 2) {
	   			simple = simple3;
	   		}
    		else if(int_random3 == 3) {
	    		simple = simple4;
	    	}
	   		//creates chosen simple sentence
	    	for(int j = 0; j < simple.length; j++) {
	    		if(simple[j].equals("subject")) {
		    		if(indicators[0] == true) {
		    			botTalk = botTalk + "I";
			    	}if(indicators[1] == true) {
			    		if(int_random2 == 3) {
			    			botTalk = botTalk + "you";
			    		}else {
			    			botTalk = botTalk + "You";
			    		}
		    		}else {
			   			position = Npro.probOfWord();
			   			Npro.ifUsed(position);
			   			Npro.changeProbFile();
			   			word = Npro.getWord(position);
			   			if(int_random2 != 3) {
			   				word = word.substring(0,1).toUpperCase() + word.substring(1);
			   			}
		    			botTalk = botTalk + word;
			   		}
	    		}else if (simple[j].equals("verb")) {
	   				int int_random4 = rand.nextInt(2);
	   				if(int_random4 == 0 && (emotions[0] == true || emotions[1] == true)) {
	   					if(emotions[0] == true) {
	   						position = Hverb.probOfWord();
			    			Hverb.ifUsed(position);
				    		Hverb.changeProbFile();
				    		word = Hverb.getWord(position);
				   			botTalk = botTalk + " " + word;
	    				}else if(emotions[1] == true) {
	    						position = Averb.probOfWord();
				    			Averb.ifUsed(position);
				    			Averb.changeProbFile();
				    			word = Averb.getWord(position);
				    			botTalk = botTalk + " " + word;
	    				}
	    				}else {
	    					position = Nverb.probOfWord();
			    			Nverb.ifUsed(position);
			    			Nverb.changeProbFile();
			    			word = Nverb.getWord(position);
			    			botTalk = botTalk + " " + word;
	    				}
	    			}else if (simple[j].equals("object")) {
	    				if(!object.isEmpty()) {
	    					//if there is a user is talking about an object...
	    					//will choose one of the object to talk about
	    					int int_random5 = rand.nextInt(object.size());
	    					int a = 0;
	    					Iterator itr = object.iterator();
	    					while (itr.hasNext()) {
	    						if(a == int_random5) {
	    							word = (String) itr.next();
	    							botTalk = botTalk + " " + word;
	    						}
	    						a++;
	    					}
	    				}else {
	    					int int_random4 = rand.nextInt(4);
		    				if(int_random4 >0) {
		    					position = Nnoun.probOfWord();
				    			Nnoun.ifUsed(position);
				    			Nnoun.changeProbFile();
				    			word = Nnoun.getWord(position);
				    			botTalk = botTalk + " " + word;
		    				}else {
		    					position = Npro.probOfWord();
				    			Npro.ifUsed(position);
				    			Npro.changeProbFile();
				    			word = Npro.getWord(position);
				    			botTalk = botTalk + " " + word;
		    				}
	    				}
	    				
	    			}else if (simple[j].equals("adverb")) {
	    				int int_random4 = rand.nextInt(2);
	    				if(int_random4 == 0 && (emotions[0] == true || emotions[1] == true)) {
	    					if(emotions[0] == true) {
	    						position = Hadv.probOfWord();
				    			Hadv.ifUsed(position);
				    			Hadv.changeProbFile();
				    			word = Hadv.getWord(position);
				    			botTalk = botTalk + " " + word;
	    					}else if(emotions[1] == true) {
	    						position = Aadv.probOfWord();
				    			Aadv.ifUsed(position);
				    			word = Aadv.getWord(position);
				    			botTalk = botTalk + " " + word;
	    					}
	    				}else {
	    					position = Nadv.probOfWord();
			    			Nadv.ifUsed(position);
			    			Nadv.changeProbFile();
			    			word = Nadv.getWord(position);
			    			botTalk = botTalk + " " + word;
	    				}
	    			}else if (simple[j].equals("adjective")) {
	    				int int_random4 = rand.nextInt(2);
	    				int int_random5 = rand.nextInt(2);
	    				String article = "";
	    				if(int_random5 == 0) {
	    					article = "the";
	    				}else {
	    					article = "a";
	    				}
	    				if(int_random4 == 0 && (emotions[0] == true || emotions[1] == true)) {
	    					if(emotions[0] == true) {
	    						position = Hadj.probOfWord();
				    			Hadv.ifUsed(position);
				    			Hadv.changeProbFile();
				    			word = Hadv.getWord(position);
				    			botTalk = botTalk + " " + article + " " + word;
	    					}else if(emotions[1] == true) {
	    						position = Aadj.probOfWord();
				    			Aadv.ifUsed(position);
				    			Aadv.changeProbFile();
				    			word = Aadv.getWord(position);
				    			botTalk = botTalk + " " + article + " " + word;
	    					}
	    				}else {
	    					position = Nadj.probOfWord();
			    			Nadj.ifUsed(position);
			    			Nadj.changeProbFile();
			    			word = Nadj.getWord(position);
			    			botTalk = botTalk + " " + article + " " + word;
	    				}
	    			}
	    		}
			    	
	    		
	    		//adds a prepositional phrase to end of last simple sentence
			    if(int_random2 == 1) {
			    	int int_random5 = rand.nextInt(2);
    				String article = "";
    				if(int_random5 == 0) {
    					article = "the";
    				}else {
    					article = "a";
    				}
    				position = Nprep.probOfWord();
	    			Nprep.ifUsed(position);
	    			Nprep.changeProbFile();
	    			word = Nprep.getWord(position);
	    			botTalk = botTalk + " " + word;
	    			
	    			position = Nnoun.probOfWord();
	    			Nnoun.ifUsed(position);
	    			Nnoun.changeProbFile();
	    			word = Nnoun.getWord(position);
	    			botTalk = botTalk + " " +article+" " + word;
	    			
    			//adds conjunction for compound sentence	
			    }else if(int_random2 == 2) {
			    	position = Ncon.probOfWord();
	    			Ncon.ifUsed(position);
	    			Ncon.changeProbFile();
	    			word = Ncon.getWord(position);
	    			botTalk = botTalk + ", " + word;
	    			//adds a second simple sentence of the same sentence structure
	    			for(int j = 0; j < simple.length; j++) {
		    			if(simple[j].equals("subject")) {
				    		if(indicators[0] == true) {
				    			botTalk = botTalk + "I";
				    		}if(indicators[1] == true) {
				    			botTalk = botTalk + "you";
				    		}else {
				    			position = Npro.probOfWord();
				    			Npro.ifUsed(position);
				    			Npro.changeProbFile();
				    			word = Npro.getWord(position);
				    			botTalk = botTalk +" "+ word;
				    		}
		    			}else if (simple[j].equals("verb")) {
		    				int int_random4 = rand.nextInt(2);
		    				if(int_random4 == 0 && (emotions[0] == true || emotions[1] == true)) {
		    					if(emotions[0] == true) {
		    						position = Hverb.probOfWord();
					    			Hverb.ifUsed(position);
					    			Hverb.changeProbFile();
					    			word = Hverb.getWord(position);
					    			botTalk = botTalk + " " + word;
		    					}else if(emotions[1] == true) {
		    						position = Averb.probOfWord();
					    			Averb.ifUsed(position);
					    			Averb.changeProbFile();
					    			word = Averb.getWord(position);
					    			botTalk = botTalk + " " + word;
		    					}
		    				}else {
		    					position = Nverb.probOfWord();
				    			Nverb.ifUsed(position);
				    			Nverb.changeProbFile();
				    			word = Nverb.getWord(position);
				    			botTalk = botTalk + " " + word;
		    				}
		    			}else if (simple[j].equals("object")) {
		    				if(!object.isEmpty()) {
		    					int int_random5 = rand.nextInt(object.size());
		    					int a = 0;
		    					Iterator itr = object.iterator();
		    					while (itr.hasNext()) {
		    						if(a == int_random5) {
		    							word = (String) itr.next();
		    							botTalk = botTalk + " " + word;
		    						}
		    						a++;
		    					}
		    				}else {
		    					int int_random4 = rand.nextInt(4);
			    				if(int_random4 >0) {
			    					position = Nnoun.probOfWord();
					    			Nnoun.ifUsed(position);
					    			Nnoun.changeProbFile();
					    			word = Nnoun.getWord(position);
					    			botTalk = botTalk + " " + word;
			    				}else {
			    					position = Npro.probOfWord();
					    			Npro.ifUsed(position);
					    			Npro.changeProbFile();
					    			word = Npro.getWord(position);
					    			botTalk = botTalk + " " + word;
			    				}
		    				}
		    				
		    			}else if (simple[j].equals("adverb")) {
		    				int int_random4 = rand.nextInt(2);
		    				if(int_random4 == 0 && (emotions[0] == true || emotions[1] == true)) {
		    					if(emotions[0] == true) {
		    						position = Hadv.probOfWord();
					    			Hadv.ifUsed(position);
					    			Hadv.changeProbFile();
					    			word = Hadv.getWord(position);
					    			botTalk = botTalk + " " + word;
		    					}else if(emotions[1] == true) {
		    						position = Aadv.probOfWord();
					    			Aadv.ifUsed(position);
					    			Aadv.changeProbFile();
					    			word = Aadv.getWord(position);
					    			botTalk = botTalk + " " + word;
		    					}
		    				}else {
		    					position = Nadv.probOfWord();
				    			Nadv.ifUsed(position);
				    			Nadv.changeProbFile();
				    			word = Nadv.getWord(position);
				    			botTalk = botTalk + " " + word;
		    				}
		    			}else if (simple[j].equals("adjective")) {
		    				int int_random4 = rand.nextInt(2);
		    				int int_random5 = rand.nextInt(2);
		    				String article = "";
		    				if(int_random5 == 0) {
		    					article = "the";
		    				}else {
		    					article = "a";
		    				}
		    				if(int_random4 == 0 && (emotions[0] == true || emotions[1] == true)) {
		    					if(emotions[0] == true) {
		    						position = Hadj.probOfWord();
					    			Hadv.ifUsed(position);
					    			Hadv.changeProbFile();
					    			word = Hadv.getWord(position);
					    			botTalk = botTalk + " " + article + " " + word;
		    					}else if(emotions[1] == true) {
		    						position = Aadj.probOfWord();
					    			Aadv.ifUsed(position);
					    			Aadv.changeProbFile();
					    			word = Aadv.getWord(position);
					    			botTalk = botTalk + " " + article + " " + word;
		    					}
		    				}else {
		    					position = Nadj.probOfWord();
				    			Nadj.ifUsed(position);
				    			Nadj.changeProbFile();
				    			word = Nadj.getWord(position);
				    			botTalk = botTalk + " " + article + " " + word;
		    				}
		    			}
		    		}
	    			
			    }
			    botTalk = botTalk + ". ";
		    }
	    return true;
	}
	
	public String toString(){
		//prints out the Bots response and makes indents where necessary
		String botTalk2 = "";
		int count = 0;
		int holder = 0;
		if(botTalk.length() < 30) {
			return botTalk;
		}
		for(int i = 0; i<botTalk.length()-1; i++) {
			if(count > 29 && botTalk.substring(i,i+1).equals(" ")) {
				count = 0;
				botTalk2 = botTalk.substring(0,i) + "\n" + botTalk.substring(i);
			}
			count++;
		}
		return botTalk2;
	}

}
