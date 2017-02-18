import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ComplexSorter {
	void readFile()
	{
		try
		{
			File file = new File("");
			BufferedReader reader= new BufferedReader(new FileReader(file));
			
			String inputText = null;
			while((inputText = reader.readLine()) != null)
			{
				String realString = inputText.split(" ")[0];
				String imagString = inputText.split(" ")[1];
				wave.add( new Complex());
			}
			reader.close();
		}
		catch(IOException except)
		{
			System.err.println("Error:" + except.getMessage());
			System.exit(1);
		}
	}
}
