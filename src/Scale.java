package src;

/**
 * This class contains a representation of all implemented scales.
 * The scale array contains all notes valid for the scale as fret values on the lowest guitar string
 * @author Chris Bentley
 */
public enum Scale {

	// Scales sourced from: http://www.all-guitar-chords.com/guitar_scales.php
	PENT_MAJ( new int[]{0,2,4,7,9,12,14,16,19,21} ),
	PENT_MIN( new int[]{0,3,5,7,10,12,15,17,19,22} ),
	PENT_BLUES( new int[]{0,3,5,6,7,10,12,15,17,18,19,22} ),
	CHROMATIC( new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21} ),
	MAJOR( new int[]{0,2,4,5,7,9,11,12,14,16,17,19,21} ),
	HARM_MIN( new int[]{0,2,3,5,7,8,11,12,14,15,17,19,20} );
	
	private int[] scaleNotes;
	
	private Scale( int[] notes ){
		scaleNotes = notes;
	}
	
	public int[] getScaleNotes(){
		return scaleNotes;
	}

}
