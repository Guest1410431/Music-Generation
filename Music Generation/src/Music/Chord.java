package Music;

import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.midi.ShortMessage;

public class Chord
{
	long start;
	long end;
	
	ArrayList<ShortMessage>chord;
	
	public Chord(long tick)
	{
		chord = new ArrayList<ShortMessage>();
		start = tick;
		end = 0;
	}
	public void addMessage(ShortMessage message)
	{
		chord.add(message);
	}
	public long duration()
	{
		return end-start;
	}
	public String toString()
	{
		String result = "[";
		
		int[]notes = new int[chord.size()];
		
		for(int i=0; i<chord.size(); i++)
		{
			notes[i] = chord.get(i).getData1();
		}
		Arrays.sort(notes);
		
		for(int i=0; i<chord.size()-1; i++)
		{
			result += notes[i] + ", ";
		}
		result += notes[chord.size()-1] + "]";
		return result;
	}
	public int size()
	{
		return chord.size();
	}
	public void setEnd(long tick)
	{
		end = tick;
	}
	public ArrayList<ShortMessage>getChord()
	{
		return chord;
	}
}
