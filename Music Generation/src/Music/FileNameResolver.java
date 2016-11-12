package Music;

import java.io.File;
import java.util.ArrayList;

public class FileNameResolver
{
	String path;
	
	File file;
	
	public FileNameResolver(String filename)
	{
		path = filename;
		file = new File(path);
	}
	public ArrayList<File>getFiles()
	{
		ArrayList<File>files = new ArrayList<File>();
		
		for(File f : file.listFiles())
		{
			if(f.isFile())
			{
				files.add(f);
			}
		}
		return files;
	}
}
