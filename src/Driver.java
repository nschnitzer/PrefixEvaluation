import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Driver {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("src/inputs.txt"));
		
		while (scan.hasNextLine())
		{
			String input = scan.nextLine();
			
			//Put everything into stack
			StringTokenizer tokenizer = new StringTokenizer(input, " ");
			ArrayList<String> stk = new ArrayList<String>();
			
			while (tokenizer.hasMoreTokens())
			{
				stk.add(tokenizer.nextToken());
			}
			
			PrefixEvaluator eval = new PrefixEvaluator(stk);
		}

	}

}
