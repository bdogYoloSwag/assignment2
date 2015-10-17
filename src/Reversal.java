	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.PrintWriter;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Scanner;
public class Reversal {



		public static void reverseFile(File input, File output) {
			
			ArrayList<String> list1 = new ArrayList<String>();
			ArrayList<String> list2 = new ArrayList<String>();
			try {
				Scanner in = new Scanner(input);
				PrintWriter out = new PrintWriter(output);

				while (in.hasNextLine()) {
					String line = in.nextLine();
					list1.add(line);
				}
				Collections.reverse(list1);
				
				for(int i= 0; i<list1.size(); i++){
					Scanner words = new Scanner(list1.get(i));
					
					list2.clear(); // clear the list so that we can use it again
					int next = 0;
					while (words.hasNext()) {
						next++;
						String x = words.next();
						list2.add(x);
					}
					if (next == 0) // if next == 0 then the line was empty
						list2.add("");
					
					Collections.reverse(list2);
				
					int j;
					// loop size - 1 so that we don't put a space after the last word
					for(j= 0; j<list2.size() -1; j++){
						out.print(list2.get(j) + " ");
						System.out.print(list2.get(j) + " ");
					}
					// write the last word with a line feed instead of a trailing space
					out.print(list2.get(j) + "\n");
					System.out.print(list2.get(j) + "\n");
				}

				in.close();
				out.close();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
		}
		public static void main(String [] args){
			reverseFile(new File("C:\\Users\\Aaron\\desktop\\test.txt"), new File("C:\\Users\\Aaron\\desktop\\test2.txt"));
		}
	}


