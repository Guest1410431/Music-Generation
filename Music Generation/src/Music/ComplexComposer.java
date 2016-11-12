package Music;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class ComplexComposer extends Composer
{
	Sequence seq;

	public void play(int instrument, Analyzer an)
	{
		ComplexAnalyzer analyzer = (ComplexAnalyzer)an;
		
		try
		{
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			System.out.println(instrument);
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			track.add(changeInstrument);
			
			compose(track, analyzer);
			
			player.setSequence(seq);
			player.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void compose(Track track, Analyzer an)
	{
		ComplexAnalyzer analyzer = (ComplexAnalyzer) an;
		
		try
		{
			long tick = 1;
			
			Chord chord = analyzer.randomChord();
			
			ShortMessage a;
			ShortMessage b;
			
			MidiEvent noteOn;
			MidiEvent noteOff;
			
			while(tick < 1000)
			{
				ArrayList<ShortMessage>notes = chord.getChord();
				
				for(int i=0; i<notes.size(); i++)
				{
					a = notes.get(i);
					noteOn = new MidiEvent(a, tick);
					track.add(noteOn);
					
					b = new ShortMessage();
					b.setMessage(a.getCommand()-16, a.getChannel(), a.getData1(), a.getData2());
					noteOff = new MidiEvent(b, tick+chord.duration());
					track.add(noteOff);
				}				
				tick += 2;
				chord = analyzer.pickRandomWeighted(chord);
				
				if(chord == null)
				{
					chord = analyzer.randomChord();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void write(String path)
	{
		try
		{
			File file = new File(path);
			MidiSystem.write(seq, 1, file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
































