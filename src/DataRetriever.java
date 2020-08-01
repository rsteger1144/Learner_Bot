import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.Math;
import java.util.Random;


public class DataRetriever {
	private String FileName;
	private StringNode allWords;
	private StringNode specificWords;
	private int numWords;
	private double allProbs;
	private double average;


	
    private class StringNode {
        private double prob;
        private StringNode next;
        private String word;
        
        private StringNode(double i, String w, StringNode n) {
            prob = i;
            next = n;
            word = w;
        }
    }
    
	public DataRetriever(String str) {
		FileName = str;
	}
	
	public int search(String word, String[] syn) {
		/*
		 * Searches through all known words for synonyms and specific word
		 */
    	DataRetriever x = new DataRetriever("commAll.txt");
    	DataRetriever x1 = new DataRetriever("angerAll.txt");
    	DataRetriever x2 = new DataRetriever("happyAll.txt");
    	DataRetriever x3 = new DataRetriever("neutralAll.txt");
		StringNode trav = x.getSpecific();
		StringNode trav1 = x1.getSpecific();
		StringNode trav2 = x2.getSpecific();
		StringNode trav3 = x3.getSpecific();
		while (trav != null) {
			if (syn[0].equals(trav.word) || syn[1].equals(trav.word) || syn[2].equals(trav.word)) {
				return 1;
			}
			if(word.equals(trav.word)) {
				return 10;
			}
			trav = trav.next;
		}
		while (trav1 != null) {
			if (syn[0].equals(trav1.word) || syn[1].equals(trav1.word) || syn[2].equals(trav1.word)) {
				return 2;
			}
			if(word.equals(trav1.word)) {
				return 10;
			}
			trav1 = trav1.next;
		}
		while (trav2 != null) {
			if (syn[0].equals(trav2.word) || syn[1].equals(trav2.word) || syn[2].equals(trav2.word)) {
				return 3;
			}
			if(word.equals(trav2.word)) {
				return 10;
			}
			trav2 = trav2.next;
		}
		while (trav3 != null) {
			if (syn[0].equals(trav3.word) || syn[1].equals(trav3.word) || syn[2].equals(trav3.word)) {
				return 4;
			}
			if(word.equals(trav3.word)) {
				return 10;
			}
			trav3 = trav3.next;
		}

		return -1;
	}
	
	public int search2(String word) {
		/*
		 * Only searches for specific words
		 */
    	DataRetriever x = new DataRetriever("commAll.txt");
    	DataRetriever x1 = new DataRetriever("angerAll.txt");
    	DataRetriever x2 = new DataRetriever("happyAll.txt");
    	DataRetriever x3 = new DataRetriever("neutralAll.txt");
		StringNode trav = x.getSpecific();
		StringNode trav1 = x1.getSpecific();
		StringNode trav2 = x2.getSpecific();
		StringNode trav3 = x3.getSpecific();
		while (trav != null) {
			if(word.equals(trav.word)) {
				return 1;
			}
			trav = trav.next;
		}
		while (trav1 != null) {
			if(word.equals(trav1.word)) {
				return 2;
			}
			trav1 = trav1.next;
		}
		while (trav2 != null) {
			if(word.equals(trav2.word)) {
				return 3;
			}
			trav2 = trav2.next;
		}
		while (trav3 != null) {
			if(word.equals(trav3.word)) {
				return 4;
			}
			trav3 = trav3.next;
		}

		return -1;
	}
	

	public void getAll() {
		/*
		 * Gets all known words
		 */
		String[] fileNameArray = {"neutralAll.txt", "commAll.txt", "happyAll.txt", "angerAll.txt"};
		int holderw = 0;
		int holderp = 0;
		String word = "";
		double prob = 0.0;
		allProbs = 0.0;
		for(int j=0; j < fileNameArray.length; j++){
			String fileString = readAllBytesJava7(fileNameArray[j]);
			for(int i = 0; i<fileString.length(); i++){
				
				if(fileString.charAt(i) == '#') {
					holderw = i+1;
				}
				if(fileString.charAt(i)==','){
					word = fileString.substring(holderw, i);
					numWords++;
				}
				if(fileString.charAt(i)=='.'){
					holderp = i;
				}
				if(fileString.charAt(i) =='/'){
					String h = fileString.substring(holderp, i);
					prob = Double.parseDouble(h);
					allProbs = allProbs + prob;
					
					if (allWords == null){
						allWords = new StringNode(prob, word, null);
					}
					else{
						StringNode trav = allWords;
						while(trav.next != null) {
							trav = trav.next;
						}
						trav.next = new StringNode(prob, word, null);
					}
				}
			}
		}
	}
	
	public StringNode getSpecific() {
		/*
		 * Gets words from specific file
		 */
		String fileString = readAllBytesJava7(FileName);
		int holderw = 0;
		int holderp = 0;
		String word = "";
		double prob = 0.0;
		if(fileString.length() == 0) {
			return null;
		}
		for(int i = 0; i<fileString.length(); i++){
				
			if(fileString.charAt(i) == '#') {
				holderw = i+1;
			}
			if(fileString.charAt(i)==','){
				word = fileString.substring(holderw, i);
				numWords++;
			}
			if(fileString.charAt(i)=='.'){
				holderp = i;
			}
			if(fileString.charAt(i) =='/'){
				String h = fileString.substring(holderp, i);
				prob = Double.parseDouble(h);
				allProbs = allProbs + prob;
					
				if (specificWords == null){
					specificWords = new StringNode(prob, word, null);
				}
				else{
					StringNode trav = specificWords;
					while(trav.next != null) {
						trav = trav.next;
					}
					trav.next = new StringNode(prob, word, null);
				}
			}				
		}
		return specificWords;
	}
	
	public void FileRunner() {
		/*
		 * Gets word from specific file
		 */
		String fileString = readAllBytesJava7(FileName);
		int holderw = 0;
		int holderp = 0;
		String word = "";
		double prob = 0.0;
		for(int i = 0; i<fileString.length(); i++){
				
			if(fileString.charAt(i) == '#') {
				holderw = i+1;
			}
			if(fileString.charAt(i)==','){
				word = fileString.substring(holderw, i);
				numWords++;
			}
			if(fileString.charAt(i)=='.'){
				holderp = i;
			}
			if(fileString.charAt(i) =='/'){
				String h = fileString.substring(holderp, i);
				prob = Double.parseDouble(h);
				allProbs = allProbs + prob;
					
				if (specificWords == null){
					specificWords = new StringNode(prob, word, null);
				}
				else{
					StringNode trav = specificWords;
					while(trav.next != null) {
						trav = trav.next;
					}
					trav.next = new StringNode(prob, word, null);
				}
			}				
		}
		
	}
	
	public int getNumWords() {
		/*
		 * Gets the number of words in a specific file
		 */
		return numWords;
	}
	public double getAverage() {
		/*
		 * Gets the average probability of all words from 
		 * specified file
		 */
		return allProbs/numWords;
	}
	
	public int probOfWord(){
		/*
		 * Returns the position of a word that is chosen(based on probability)
		 */
		Random rand = new Random();
		int[] probTable = new int[numWords*2];
	    int count = 0;
	    StringNode trav = specificWords;
	    int i = 0;
	    int lastPos = numWords-1;
	    while(trav!=null) {
	    	double prob = trav.prob*numWords;
	    	int numOf = (int) Math.round(prob);
	    	for(int j = 0; j<numOf;j++){
	    		probTable[count] = i+1;
	    		count++;
	    	}
	    	if(probTable[i] == 0){
	    		lastPos = i-1;
	    	}
	    	i++;
	    	trav = trav.next;
	    }
	    
	    int randNum = rand.nextInt(lastPos);
	    int position  = probTable[randNum];
	    return position-1;
	}
	public String getWord(int position){
		/*
		 * Gets word of specified position in Linked List
		 */
		StringNode trav = specificWords;
		int count = 0;
		while(trav!=null) {
			if (count == position){
				return trav.word;
			}
			count++;
			trav = trav.next;
		}
		return "";
	}
	
	public void ifUsed(int position){
		/*
		 * Increases the probability of the word that is used during conversation
		 * with user
		 */
		StringNode trav = specificWords;
		int count=0;
		double diff = 0;
		while(trav!=null){
			if(count == position) {
				trav.prob = trav.prob + .02;
				if(trav.prob > .25) {
					diff = trav.prob -.35;
					trav.prob = .35;
				}
			}
			count++;
			trav = trav.next;
		}
		reduceProb(position, diff);
	}
	
	public void reduceProb(int position, double diff) {
		/*
		 * Reduces the probability of two random words in the 
		 * specified file
		 */
		StringNode trav = specificWords;
		int count = 0;
		Random rand = new Random();
		boolean flag = true;
		double x = .01;
		if(diff != 0) {
			x = diff/2;
		}
		int randNum1 = 0;
		int randNum2 = 0;
		while(flag) {
			randNum1 = rand.nextInt(numWords);
			randNum2 = rand.nextInt(numWords);
			if(randNum1 != position && randNum2 != position) {
				flag = false;
			}
		}
		while(trav!=null){
			if(count == randNum1) {
				trav.prob = trav.prob-x;
				if (trav.prob<0) {
					trav.prob = trav.prob+x;
					randNum1+=1;
				}
			}
			if(count == randNum2) {
				trav.prob = trav.prob-x;
				if (trav.prob<0) {
					trav.prob = trav.prob+x;
					randNum2+=1;
				}
			}
			trav = trav.next;	
		}
	}
	
	public void Add(double avg) {
		/*
		 * Changes the probability of all the words in a specified file 
		 * when a new word is added
		 */
		StringNode trav = specificWords;
		double change = avg/numWords;
		while(trav != null) {
			trav.prob = trav.prob - change;
			trav = trav.next;
		}
	}

	public void changeProbFile() {
		/*
		 * Edits the file for when the probability is altered
		 */
		StringNode trav = specificWords;
		try {
			PrintWriter output = new PrintWriter(FileName);
			while(trav!=null) {
				output.print("#");
				String word = trav.word;
				output.print(word);
				output.print(",");
				double probb = trav.prob;
				output.print(probb);
				output.print("/");
				trav = trav.next;
			}
			 output.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public String toStringAll() {
		/*
		 * Converts all the words from the Linked List to a String
		 */
		StringNode trav = allWords;
		String listWords = "";
		int counter = 0;
		while(trav != null) {
			if(counter == 7) {
				listWords = listWords + "\n";
				counter = 0;
			}
			listWords = listWords + trav.word + "," + " ";
			trav = trav.next;
			counter++;
		}
		return listWords;
	}
	
	public String toStringSpecific(String type) {
		/*
		 * Converts the words from the Linked List to a String from a specified file
		 */
		StringNode trav = specificWords;
		String listWords = "";
		int counter = 0;
		while(trav != null) {
			if(counter == 7) {
				listWords = listWords + "\n";
				counter = 0;
			}
			listWords = listWords + trav.word + "," + " ";
			trav = trav.next;
			counter++;
		}
		return listWords;
	}
	
    private static String readAllBytesJava7(String filePath) {
    	/*
    	 * Converts text in file to String
    	 */
        String content = "";
        try{
            content = new String (Files.readAllBytes( Paths.get(filePath) ) );
        } catch (IOException e){
            e.printStackTrace();
        }
        return content;
    }
	
}
