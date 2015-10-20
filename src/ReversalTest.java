import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ReversalTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void testoneSpace() {
			try {
				File input = folder.newFile("test.txt");
				File output = folder.newFile("test2.txt");
				// create input file
				PrintWriter write = new PrintWriter(input);
				write.println("stuff");
				write.println("");
				write.println("words stuff junk");
				write.close();

				// invoke program
				Reversal.reverseFile(input, output);

				// verify file results
				assertTrue("no file", output.exists());
				String actual, expected;
				Scanner scan = new Scanner(output);
				actual = scan.nextLine();
				expected = "junk stuff words";
				assertEquals("fail", expected, actual);
				actual = scan.nextLine();
				expected = "";
				assertEquals("fail", expected, actual);
				actual = scan.nextLine();
				expected = "stuff";
				assertEquals("fail", expected, actual);
				assertFalse("end of file", scan.hasNext());
			} catch (IOException e) {
				fail("exception");
			}
		}
	
	@Test
	public void testnoLines() {
		try {
			File input = folder.newFile("test.txt");
			File output = folder.newFile("test2.txt");
			// create input file
			PrintWriter write = new PrintWriter(input);
			write.println("");
			write.close();

			//call program
			Reversal.reverseFile(input, output);

			//results
			assertTrue("no file", output.exists());
			Scanner scan = new Scanner(output);
			String actual = scan.nextLine();
			String expected = "";
			assertEquals("fail", expected, actual);
			assertFalse("end of file", scan.hasNext());
		} catch (IOException e) {
			fail("exception");
		}
	}
	@Test
	public void test1Line() {
		try {
			File input = folder.newFile("test.txt");
			File output = folder.newFile("test2.txt");
			// create input file
			PrintWriter write = new PrintWriter(input);
			write.println("i will run");
			write.close();

			// call program
			Reversal.reverseFile(input, output);

			// file results
			assertTrue("no file", output.exists());
			Scanner scan = new Scanner(output);
			String actual = scan.nextLine();
			String expected = "run will i";
			assertEquals("fail", expected, actual);
			assertFalse("end of file", scan.hasNext());
		} catch (IOException e) {
			fail("exception");
		}
	}

	@Test
	public void test3Lines() {
		try {
			File input = folder.newFile("test.txt");
			File output = folder.newFile("test2.txt");
			// create input file
			PrintWriter write = new PrintWriter(input);
			write.println("i cant believe it");
			write.println("it works cool");
			write.println("this is stuff");
			write.close();

			// invoke program
			Reversal.reverseFile(input, output);

			// verify file results
			assertTrue("no file", output.exists());
			String actual, expected;
			Scanner scan = new Scanner(output);
			actual = scan.nextLine();
			expected = "stuff is this";
			assertEquals("fail", expected, actual);
			actual = scan.nextLine();
			expected = "cool works it";
			assertEquals("fail", expected, actual);
			actual = scan.nextLine();
			expected = "it believe cant i";
			assertEquals("fail", expected, actual);
			assertFalse("end of file", scan.hasNext());
		} catch (IOException e) {
			fail("exception");
		}
	}

	@Test
	public void testSeveralWithEmptyLines() {
		try {
			File input = folder.newFile("test.txt");
			File output = folder.newFile("test2.txt");
			// create input file
			PrintWriter write = new PrintWriter(input);

			write.println("this is a long sentance");
			write.println();
			write.println();
			write.println("check spaces");
			write.println();
			write.println("will it work");
			write.println();
			write.println("final one");
			write.close();

			// invoke program
			Reversal.reverseFile(input, output);

			// verify file results
			assertTrue("Output file does not exist", output.exists());
			String actual, expected;
			Scanner scan = new Scanner(output);
			actual = scan.nextLine();
			expected = "one final";
			actual = scan.nextLine();
			expected = "";
			assertEquals("fail", expected, actual);
			actual = scan.nextLine();
			expected = "work it will";
			assertEquals("fail", expected, actual);
			actual = scan.nextLine();
			expected = "";
			assertEquals("fail", expected, actual);
			actual = scan.nextLine();
			expected = "spaces check";
			assertEquals("fail", expected, actual);
			actual = scan.nextLine();
			expected = "";
			assertEquals("fail", expected, actual);
			actual = scan.nextLine();
			expected = "";
			assertEquals("fail", expected, actual);
			actual = scan.nextLine();
			expected = "sentance long a is this";
			assertEquals("fail", expected, actual);
			assertFalse("end of file", scan.hasNext());
		} catch (IOException e) {
			fail("exception");
		}
	}
	@Test
	public void startingSpaces() {
		try {
			File input = folder.newFile("test.txt");
			File output = folder.newFile("test2.txt");
			// create input file
			PrintWriter write = new PrintWriter(input);

		
			write.println("work? try");
			write.println();
			write.println();
			
			write.close();

			// invoke program
			Reversal.reverseFile(input, output);

			// verify file results
			assertTrue("Output file does not exist", output.exists());
			String actual, expected;
			Scanner scan = new Scanner(output);
			actual = scan.nextLine();
			expected = "";
			assertEquals("fail", expected, actual);
			actual = scan.nextLine();
			expected = "";
			assertEquals("fail", expected, actual);
			actual = scan.nextLine();
			expected = "try work?";
			assertEquals("fail", expected, actual);
		
			assertEquals("fail", expected, actual);
			assertFalse("end of file", scan.hasNext());
		} catch (IOException e) {
			fail("exception");
		}
	}
}
