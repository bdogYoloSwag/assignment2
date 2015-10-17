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
	public void test1Line() {
		try {
			File input = folder.newFile("foo.txt");
			File output = folder.newFile("bar.txt");
			// create input file
			PrintWriter write = new PrintWriter(input);
			write.println("2 + 5 = 7");
			write.close();

			// invoke program
			Reversal.reverseFile(input, output);

			// verify file results
			assertTrue("Output file does not exist", output.exists());
			Scanner scan = new Scanner(output);
			String actual = scan.nextLine();
			String expected = "7 = 5 + 2";
			assertEquals("Incorrect result", expected, actual);
			assertFalse("File should not have more data", scan.hasNext());
		} catch (IOException e) {
			fail("No exception should be thrown");
		}
	}

	@Test
	public void test3Lines() {
		try {
			File input = folder.newFile("boom.txt");
			File output = folder.newFile("argo.txt");
			// create input file
			PrintWriter write = new PrintWriter(input);
			write.println("Lorem ipsum dolor sit amet,");
			write.println("consectetur adipiscing elit.");
			write.println("suscipit pellentesque turpis, id gravida dolor ultrices ac.");
			write.close();

			// invoke program
			Reversal.reverseFile(input, output);

			// verify file results
			assertTrue("Output file does not exist", output.exists());
			String actual, expected;
			Scanner scan = new Scanner(output);
			actual = scan.nextLine();
			expected = "ac. ultrices dolor gravida id turpis, pellentesque suscipit";
			assertEquals("Incorrect result", expected, actual);
			actual = scan.nextLine();
			expected = "elit. adipiscing consectetur";
			assertEquals("Incorrect result", expected, actual);
			actual = scan.nextLine();
			expected = "amet, sit dolor ipsum Lorem";
			assertEquals("Incorrect result", expected, actual);
			assertFalse("File should not have more data", scan.hasNext());
		} catch (IOException e) {
			fail("No exception should be thrown");
		}
	}

	@Test
	public void testSeveralWithEmptyLines() {
		try {
			File input = folder.newFile("bing.txt");
			File output = folder.newFile("bang.txt");
			// create input file
			PrintWriter write = new PrintWriter(input);

			write.println("quam. eget congue vitae, venenatis eget rhoncus magna, dolor In");
			write.println();
			write.println();
			write.println("volutpat. ultrices elit in ligula tristique Nunc");
			write.println();
			write.println("ipsum");
			write.println("Lorem");
			write.close();

			// invoke program
			Reversal.reverseFile(input, output);

			// verify file results
			assertTrue("Output file does not exist", output.exists());
			String actual, expected;
			Scanner scan = new Scanner(output);
			actual = scan.nextLine();
			expected = "Lorem";
			assertEquals("Incorrect result", expected, actual);
			actual = scan.nextLine();
			expected = "ipsum";
			assertEquals("Incorrect result", expected, actual);
			actual = scan.nextLine();
			expected = "";
			assertEquals("Incorrect result", expected, actual);
			actual = scan.nextLine();
			expected = "Nunc tristique ligula in elit ultrices volutpat.";
			assertEquals("Incorrect result", expected, actual);
			actual = scan.nextLine();
			expected = "";
			assertEquals("Incorrect result", expected, actual);
			actual = scan.nextLine();
			expected = "";
			assertEquals("Incorrect result", expected, actual);
			actual = scan.nextLine();
			expected = "In dolor magna, rhoncus eget venenatis vitae, congue eget quam.";
			assertEquals("Incorrect result", expected, actual);
			assertFalse("File should not have more data", scan.hasNext());
		} catch (IOException e) {
			fail("No exception should be thrown");
		}
	}
}
