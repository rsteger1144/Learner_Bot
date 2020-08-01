import java.io.IOException;
import java.util.*;

public class LearnerMain {
	private String word;
	private String senStruc; 
	private Scanner input = new Scanner(System.in);
	
	public LearnerMain(String str) {
		this.word = str;		
	}
	
	public void add(String POS, String[] syn) {
		int val = search(syn);
		if (val == -1) {
			System.out.println("I looked through the words I know I dont understand the definition of this word!");
			System.out.println("I also can't find any words similar to it!");
			System.out.println("What category would this word fall under. Just input the number. This will help me a lot");
			System.out.println("1. Communication");
			System.out.println("2. Anger");
			System.out.println("3. Happy");
			System.out.println("4. Neutral");
			System.out.println("5. Question");
			val  = input.nextInt();
		}
		if(val == 1) {
			Communication com = new Communication(word, POS);
			System.out.println("Got it thanks for teaching me!");
		}
		else if(val == 2) {
			Anger ang = new Anger(word, POS);
			System.out.println("Got it thanks for teaching me!");
		}
		else if(val == 3) {
			Happy hap = new Happy(word, POS);
			System.out.println("Got it thanks for teaching me!");
		}
		else if(val == 4) {
			Neutral nue = new Neutral(word, POS);
			System.out.println("Got it thanks for teaching me!");
		}
		else if(val == 5) {
			//
		}else if(val == 10) {
			System.out.println("I already know this word!");
		}else {
			System.out.println("You did not input a correct option");
		}	
	}
	
	public void override() {
		System.out.print("So what is the part of speech of " + word + ": ");
		String POS = input.next();
		
		System.out.print("And the definiton: ");
		String def = input.nextLine();
		
		System.out.println("What are three synoyms: ");
		String[] syn = new String[3];
		String syn1 = input.next();
		System.out.println(", ");
		syn[0] = syn1;
		String syn2 = input.next();
		System.out.println(", ");
		syn[0] = syn2;
		String syn3 = input.next();
		System.out.println(", ");
		syn[0] = syn3;
		
		add(POS, syn);
		
	}
	
	
	public int search(String[] syn) {
		DataRetriever search = new DataRetriever("");
		return search.search(word, syn);
	}

	public static void main(String[] args) {
		boolean flag = true;
		while(flag == true){
			Scanner input = new Scanner(System.in);
			System.out.println("Hello I am Learner Bot.");
			System.out.println("1. Would you like to teach me a new word?");
			System.out.println("2. Or would you like to see everything I know?");
			System.out.println("3. Or would you like to talk with me?");
			System.out.println("4. Or would you like to download the base files");
			System.out.println("(Must do before starting and only need to do once)");
			System.out.println("5. Or do you want to do nothing");
			System.out.println();
			System.out.print("Type 1, 2, 3, 4, 5 for whatever you want: ");
			int decision  = input.nextInt();
			if (decision == 1) {
				
				System.out.println("What word would you like to teach me: ");
				String word = input.next();
				
				LearnerMain EnteredWord = new LearnerMain(word);
				WebsiteSearch wordSearch = new WebsiteSearch(word);
				int realWord = wordSearch.attributes();
				if(realWord == -1) {
					System.out.println("This word does not exist in the modern dictionary");
					break;
				}
				
				System.out.print("I looked up the definiton and found that it meant: ");
				String definition = wordSearch.getDefinition();
				System.out.println(definition);
					
				System.out.print("I looked up the part of speech is: ");
				String partOfSpeech = wordSearch.getPartOfSpeech();
					
				System.out.println(partOfSpeech);
				
				System.out.print("Here are a few synonyms of the word: ");
				HashSet<String> hashSyn = wordSearch.getSynonyms();
				String[] syn = new String[3];
				int x = 0;
				Iterator<String> iter = hashSyn.iterator();  
			    while(iter.hasNext() && x < 3){  
			       System.out.print(iter.next() + ", ");
			       syn[x] = iter.next();
		           x++;
		        }
			    for(int i = x; i<3;i++){
		        	syn[i] = null;
		        }
			    System.out.println();
				System.out.print("Is this the word you were think about(yes)(no): ");
				String decision3  = input.next();
				if(decision3.equals("yes")) {
					EnteredWord.add(partOfSpeech, syn);
				}else if(decision3.equals("no")) {
					EnteredWord.override();
				}else {		
					System.out.println("Thats not an option");
				}
	
			}else if(decision == 2) {
				System.out.println("Here are all the word I currently know!");
				DataRetriever allWords = new DataRetriever("");
				allWords.getAll();
				String all = allWords.toStringAll();
				System.out.print(all);
				
			}else if(decision == 3) {
				Scanner myObj = new Scanner(System.in);
				System.out.println("Speak first...");
				System.out.println("Whenever you would like to stop, just say stop");
				boolean toConstruct;
				boolean quit = false;	
				while(quit == false) {
					String talker = myObj.nextLine();
					if(talker.equals("stop")) {
						quit = true;
						break;
					}
					int val = 1;
					if(talker.contains(" ")) {
						val = 2;
					}
					Constructor speak = new Constructor(talker, val);
					toConstruct = speak.Creator();
					if(toConstruct == true) {
						System.out.println(speak.toString());
					}else{
						if(val == 2) {
							System.out.println("Something went worng...");
						}
					}
				}
				
				System.out.println("thanks for chatting!");
			
			}else if(decision == 4) {
				BaseFiles files = new BaseFiles();
				try {
					files.download();
				} catch (IOException e) {
					System.out.println("Something went wrong with the download");
				}
			}else if(decision == 5){
				System.out.println("Seeya later!");
				break;
			}else {
				System.out.println("Thats not an option");
			}
		}
	}

}
