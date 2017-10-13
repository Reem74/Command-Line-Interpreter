import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Cat extends Cmd {
	public ArrayList<String> execute(ArrayList<String> args) {
		ArrayList<String> ret = new ArrayList<String>();
		for (String e : args) {
			File f = new File(e);
			if (!f.isDirectory())
				e = CLI.workingDirectory + '/' + e;
			System.out.println(e);
			ret.addAll(readFile(f = (new File(e))));
		}
		return ret;
	}

	public ArrayList<String> readFile(File f) {
		ArrayList<String> ret = new ArrayList<String>();
		try {
			Scanner reader = new Scanner(f);
			while (reader.hasNextLine()) {
				ret.add(reader.nextLine());
			}
			reader.close();
		} catch (Exception e) {
			ret.add("No such file or directory");
		}
		return ret;
	}
}
