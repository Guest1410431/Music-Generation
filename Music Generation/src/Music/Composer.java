package Music;

import javax.sound.midi.Track;

public abstract class Composer
{
	int instrument;
	Analyzer analyzer;
	
	public abstract void play(int instrument, Analyzer analyzer);
	
	public abstract void compose(Track track, Analyzer analyzer);
	
	public abstract void write(String path);
}
