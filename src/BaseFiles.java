import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseFiles {
	public static void NeutralWords() throws IOException{
		String fileName1 = "neutralAdjectives.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName1, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			
			String[] wordsArray = {"new", "first","last", "long", 
					"own", "old", "big", "small", "short", "high", 
					"low", "early", "late", "same", "few", "many"};
			double[] prob = {.0625,.012};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName1 = "neutralAll.txt";
		}
		
		String fileName2 = "neutralNouns.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName2, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			String[] wordsArray = {"time", "person", "day", 
					"today", "thing", "man", "world", "school", 
					"company", "number", "group", "problem","fact"};
			double[] prob = {.0769,.012};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName2 = "neutralAll.txt";
		}
		
		String fileName3 = "neutralAdverbs.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName3, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			String[] wordsArray = {"up", "out", "so", "there", "even"};
			double[] prob = {.2,.012};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName3 = "neutralAll.txt";
		}
		
		String fileName4 = "neutralVerbs.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName4, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			String[] wordsArray = {"be", "have", "do", "say", 
					"get", "make", "go", "know", "come", "think", 
					"look", "want", "feel", "try", "leave", "call"};
			double[] prob = {.0625,.012};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName4 = "neutralAll.txt";
		}
		
		String fileName5 = "nuetralPronouns.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName5, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			
			String[] wordsArray = {"I", "you", "she", "he", "it", "we", "they"};
			double[] prob = {.143,.012};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName5 = "neutralAll.txt";
		}
		
		String fileName6 = "nuetralConjunctions.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName6, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			
			String[] wordsArray = {"and", "or", "yet", "and", "so"};
			double[] prob = {.2,.012};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName6 = "neutralAll.txt";
		}
		
		String fileName7 = "nuetralInterjections.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName6, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			
			String[] wordsArray = {"bam", "boom", "bingo", "shhhh", "dang"};
			double[] prob = {.2,.012}; 
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName7 = "neutralAll.txt";
		}
		
		String fileName8 = "nuetralPrepositions.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName8, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			
			String[] wordsArray = {"of", "in", "to", "for", "with", 
					"on", "at", "from", "by", "about"};
			double[] prob = {.1,.012};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName8 = "neutralAll.txt";
		}
		
		String fileName9 = "nuetralSubConjunctions.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName9, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			
			String[] wordsArray = {"When", "While", "Though", "Since", "As much as", "Than", "In case that"};
			double[] prob = {.143,.012};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName9 = "neutralAll.txt";
		}
	}
	
	public static void CommWords() throws IOException{
		String fileName1 = "commInterjections.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName1, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			String[] wordsArray = {"Hello", "What's up", "Hey", "Yo"};
			double[] prob = {.25,.012};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName1 = "commAll.txt";
		}
		
		
		String fileName2 = "commQuestioins.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName2, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			String[] wordsArray = {"Why", "How", "What", "Would", "When"};
			double[] prob = {.25,.012};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName2 = "commAll.txt";
		}
	}
		
	public static void AngerWords() throws IOException{
		
		String fileName1 = "AngerAdjectives.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName1, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			
			String[] wordsArray = {"furious", "angry", "murderous", "mad", "ill", "insane", "annoying", "stupid"};
			double[] prob = {.125,.0357};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName1 = "AngerAll.txt";
		}
		
		String fileName2 = "AngerNouns.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName2, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			String[] wordsArray = {"anger", "murderer", "killer", "attacker", "fighter", "meanie" };
			double[] prob = {.1667,.0357};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName2 = "AngerAll.txt";
		}
		
		String fileName3 = "AngerAdverbs.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName3, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			String[] wordsArray = {"bitterly", "cruely", "angerly", "fatally", "madly", "pissy"};
			double[] prob = {.1667,.0357};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName3 = "AngerAll.txt";
		}
		
		String fileName4 = "AngerVerbs.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName4, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			String[] wordsArray = {"kill", "hurt", "fight", "punch", "attck", "annoy", "kick", 
								   "leave"};
			double[] prob = {.125,.0357};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName4 = "AngerAll.txt";
		}		
			
	}
	
	public static void HappyWords() throws IOException{
		
		String fileName1 = "HappyAdjectives.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName1, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			
			String[] wordsArray = {"happy", "joyfull", "prideful", "excited", "loving", "great", "kind", "stupid"};
			double[] prob = {.125,.037};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName1 = "HappyAll.txt";
		}
		
		String fileName2 = "HappyNouns.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName2, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			String[] wordsArray = {"joy", "happiness", "love", "care", "grace", "kindness" };
			double[] prob = {.1667,.037};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName2 = "HappyAll.txt";
		}
		
		String fileName3 = "HappyAdverbs.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName3, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			String[] wordsArray = {"happily", "lovingly", "kindly", "joyfully", "warmingly"};
			double[] prob = {.2,.037};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName3 = "HappyAll.txt";
		}
		
		String fileName4 = "HappyVerbs.txt";
		for(int i = 0; i<2; i++) {	
			FileWriter fw = new FileWriter(fileName4, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter output = new PrintWriter(bw);
			String[] wordsArray = {"kiss", "hug", "love", "excite", "warm", "entise", "donate", 
								   "consult"};
			double[] prob = {.125,.037};
			for(int j = 0; j < wordsArray.length; j++) {
				output.print("#");
				output.print(wordsArray[j]);
				output.print(",");
				output.print(prob[i]);
				output.print("/");
			}
			output.flush();
			fileName4 = "HappyAll.txt";
		}		
			
	}
	
	public void download() throws IOException {
		NeutralWords();
		CommWords();
		AngerWords();
		HappyWords();
		System.out.println("Files have been downloaded");
	}
}
