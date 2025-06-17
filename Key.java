package whatKey;
import java.util.*;

public class Key {
	private String root = "Z";
	private String third = "Z";
	private String fifth = "Z";
	
	private String scale;
	
	private String calcRoot;
	private String calcThird;
	private String calcFifth;
	
	String[] notes = {"A", "Bb", "B", "C", "C#", "D", "Eb", "E", "F", "F#", "G", "G#"};
	
	String[] notesSharps = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
	
	String[] notesFlats = {"A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab"};
	
	
	//takes the root, third, and fifth, and calculates the scale (major, minor, augmented, or diminished) from that
	public Key(String r, String t, String f) {
		root = r;
		third = t;
		fifth = f;
		
		calcRoot = r;
		calcThird = t;
		calcFifth = f;
		
		this.setCalcs();
		
		int rootPosition = 0;
		int thirdPosition = 0;
		int fifthPosition = 0;
		for(int i = 0; i < notes.length; i++) {
			if(this.calcRoot.equals(notes[i])) {
				rootPosition = i;
			}
		}
		for(int i = 0; i < notes.length; i++) {
			if(this.calcThird.equals(notes[i])) {
				thirdPosition = i;
				if(thirdPosition < rootPosition) {
					thirdPosition += 12;
				}
			}
		}
		for(int i = 0; i < notes.length; i++) {
			if(this.calcFifth.equals(notes[i])) {
				fifthPosition = i;
				if(fifthPosition < rootPosition) {
					fifthPosition += 12;
				}
			}
		}
		if(thirdPosition - rootPosition == 4) {
			if(fifthPosition - rootPosition == 7) {
				scale = "Major";
			}
			else if(fifthPosition - rootPosition == 8) {
				scale = "Augmented";
			}
		}
		else if(thirdPosition - rootPosition == 3) {
			if(fifthPosition - rootPosition == 7) {
				scale = "Minor";
			}
			else if(fifthPosition - rootPosition == 6) {
				scale = "Diminished";
			}
		}
		if(!doesExist()) {
			third = "Z";
			fifth = "Z";
			scale = null;
		}
		
	}
	
	public Key(String r, String s) {
		root = r;
		scale = s;
		calcRoot = r;
		
		this.setCalcs();
		
		if(scale.equals("Major")) {
			int rootPosition = 0;
			int thirdPosition = 0;
			int fifthPosition = 0;
			for(int i = 0; i < notes.length; i++) {
				if(this.calcRoot.equals(notes[i])) {
					rootPosition = i;
				}
			}
			thirdPosition = rootPosition + 4;
			if(thirdPosition >= 12) {
				thirdPosition -= 12;
			}
			fifthPosition = thirdPosition + 3;
			third = notes[thirdPosition];
			fifth = notes[fifthPosition];
		}
		
		if(scale.equals("Minor")) {
			int rootPosition = 0;
			int thirdPosition = 0;
			int fifthPosition = 0;
			for(int i = 0; i < notes.length; i++) {
				if(this.calcRoot.equals(notes[i])) {
					rootPosition = i;
				}
			}
			thirdPosition = rootPosition + 3;
			if(thirdPosition >= 12) {
				thirdPosition -= 12;
			}
			fifthPosition = thirdPosition + 4;
			third = notes[thirdPosition];
			fifth = notes[fifthPosition];
		}
		
		if(scale.equals("Augmented")) {
			int rootPosition = 0;
			int thirdPosition = 0;
			int fifthPosition = 0;
			for(int i = 0; i < notes.length; i++) {
				if(this.calcRoot.equals(notes[i])) {
					rootPosition = i;
				}
			}
			thirdPosition = rootPosition + 4;
			if(thirdPosition >= 12) {
				thirdPosition -= 12;
			}
			fifthPosition = thirdPosition + 4;
			if(fifthPosition >= 12) {
				fifthPosition -= 12;
			}
			third = notes[thirdPosition];
			fifth = notes[fifthPosition];
		}
		
		if(scale.equals("Diminished")) {
			int rootPosition = 0;
			int thirdPosition = 0;
			int fifthPosition = 0;
			for(int i = 0; i < notes.length; i++) {
				if(this.calcRoot.equals(notes[i])) {
					rootPosition = i;
				}
			}
			thirdPosition = rootPosition + 3;
			if(thirdPosition >= 12) {
				thirdPosition -= 12;
			}
			fifthPosition = thirdPosition + 3;
			third = notes[thirdPosition];
			fifth = notes[fifthPosition];
		}
		
		if(!doesExist()) {
			third = "Z";
			fifth = "Z";
			scale = null;
		}
	}
	
	public void setCalcs() {
		if(root.equals("A#")) {
			calcRoot = "Bb";
		}
		if(root.equals("Db")) {
			calcRoot = "C#";
		}
		if(root.equals("D#")) {
			calcRoot = "Eb";
		}
		if(root.equals("Gb")) {
			calcRoot = "F#";
		}
		if(root.equals("Ab")) {
			calcRoot = "G#";
		}
		
		if(third.equals("A#")) {
			calcThird = "Bb";
		}
		if(third.equals("Db")) {
			calcThird = "C#";
		}
		if(third.equals("D#")) {
			calcThird = "Eb";
		}
		if(third.equals("Gb")) {
			calcThird = "F#";
		}
		if(third.equals("Ab")) {
			calcThird = "G#";
		}
		
		if(fifth.equals("A#")) {
			calcFifth = "Bb";
		}
		if(fifth.equals("Db")) {
			calcFifth = "C#";
		}
		if(fifth.equals("D#")) {
			calcFifth = "Eb";
		}
		if(fifth.equals("Gb")) {
			calcFifth = "F#";
		}
		if(fifth.equals("Ab")) {
			calcFifth = "G#";
		}
	}
	
	public String arpeggio() {
		if(third.equals("Z") || fifth.equals("Z")) {
			return "Something was wrong. Check what you entered and try again.";
		}
		return (root + " " + third + " " + fifth);
	}
	
	public String getKey() {
		if(scale == null) {
			return "The notes you inputted do not form an arpeggio. One or more may be wrong. Please try again.";
		}
		return root + " " + scale;
	}
	
	public boolean doesExist() {
		for(int i = 0; i < notes.length; i++) {
			if(root.equals(notes[i])) {
				return true;
			}
		}
		for(int i = 0; i < notesSharps.length; i++) {
			if(root.equals(notes[i])) {
				return true;
			}
		}
		for(int i = 0; i < notesFlats.length; i++) {
			if(root.equals(notes[i])) {
				return true;
			}
		}
		return false;
	}
	/*
	public String majorOrMinor() {
		int rootPosition = 0;
		int thirdPosition = 0;
		for(int i = 0; i < notes.length; i++) {
			if(this.calcRoot.equals(notes[i])) {
				rootPosition = i;
			}
		}
		for(int i = 0; i < notes.length; i++) {
			if(this.third.equals(notes[i])) {
				thirdPosition = i;
			}
		}
		if(thirdPosition - rootPosition == 4) {
			return "Major";
		}
		else if(thirdPosition - rootPosition == 3) {
			return "Minor";
		}
		else {
			return "I don't know";
		}
		
	}
	*/
	/*
	public String whatKey() {
		String key = root;
		int rootPosition = 0;
		int thirdPosition = 0;
		int fifthPosition = 0;
		for(int i = 0; i < notes.length; i++) {
			if(this.calcRoot.equals(notes[i])) {
				rootPosition = i;
			}
		}
		for(int i = 0; i < notes.length; i++) {
			if(this.calcThird.equals(notes[i])) {
				thirdPosition = i;
				if(thirdPosition < rootPosition) {
					thirdPosition += 12;
				}
			}
		}
		for(int i = 0; i < notes.length; i++) {
			if(this.calcFifth.equals(notes[i])) {
				fifthPosition = i;
				if(fifthPosition < rootPosition) {
					fifthPosition += 12;
				}
			}
		}
		if(thirdPosition - rootPosition == 4) {
			if(fifthPosition - rootPosition == 7) {
				key = key + " Major";
			}
			else if(fifthPosition - rootPosition == 8) {
				key = key + " Augmented";
			}
		}
		else if(thirdPosition - rootPosition == 3) {
			if(fifthPosition - rootPosition == 7) {
				key = key + " Minor";
			}
			else if(fifthPosition - rootPosition == 6) {
				key = key + " Diminished";
			}
		}
		return key;
		
	}
	*/
}
