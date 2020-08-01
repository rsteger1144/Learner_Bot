import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Neutral {
	
	private String word;
	private String fileName;
	private String AllFile = "neutralAll.txt";
    
    public Neutral(String wordX, String POS) {
    	//determines file based on part of speech of word
    	this.word = wordX;
    	if (POS.equals("noun")) {
    		fileName = "neutralNouns.txt";
    	}
    	else if (POS.equals("adverb")) {
    		fileName = "neutralAdverbs.txt";
    	}
    	else if (POS.equals("verb")) {
    		fileName = "neutralVerbs.txt";
    	}
    	else if (POS.equals("adjective")) {
    		fileName = "neutralAdjectives.txt";
    	}
    	else if (POS.equals("interjection")) {
    		fileName = "neutralInterjections.txt";
    	}
    	else if (POS.equals("conjunction")) {
    		fileName = "neutralConjunctions.txt";
    	}
    	else if (POS.equals("preposition")) {
    		fileName = "neutralPrepositions.txt";
    	}
    	else if (POS.equals("pronoun")) {
    		fileName = "neutralPronouns.txt";
    	}

    	try {
			addData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void addData() throws IOException {
    	/*
    	 * adds new word to pre-existing data
    	 */
    	DataRetriever info = new DataRetriever(fileName);
    	info.getSpecific();
    	//gets average of probability of previous words
    	double avg = info.getAverage();
    	info.Add(avg);
    	//changes probability of previous words
    	info.changeProbFile();
    	String probb = avg + "";
    	String fileNameChange = fileName;
    	
		try {
			for(int i = 0; i<2; i++) {	
				//inputs data to file
				FileWriter fw = new FileWriter(fileNameChange, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter output = new PrintWriter(bw);
				
				output.print("#");
				output.print(word);
				output.print(",");
				output.print(probb);
				output.print("/");
				
				output.flush();
				
				fileNameChange = AllFile;
			}

		}catch(FileNotFoundException e){
			e.printStackTrace();	
		}
    }
}