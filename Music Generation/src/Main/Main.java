package Main;

import Music.ComplexAnalyzer;
import Music.ComplexComposer;
import Music.FileNameResolver;

public class Main
{
	public static void main(String[]args)
	{
		FileNameResolver fnr = new FileNameResolver("bach");
		String path = "complexBach.midi";
		boolean toWrite = true;
		
		ComplexAnalyzer complexAnalyzer = new ComplexAnalyzer(fnr.getFiles());
		complexAnalyzer.analyze();
		
		ComplexComposer complexComposer = new ComplexComposer();
		complexComposer.play(0, complexAnalyzer);
		
		if(toWrite)
		{
			complexComposer.write(path);
		}
	}
}
