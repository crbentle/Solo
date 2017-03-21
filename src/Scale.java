package src;

/**
 * This class contains a representation of all implemented scales.
 * The scale array contains all notes valid for the scale as fret values on the lowest guitar string
 * @author Chris Bentley
 */
public enum Scale {

	PENT_MAJ( new int[]{0,3,5,8,10,12,13,14,15,16,18,21} );
	
	private int[] scaleNotes;
	
	private Scale( int[] notes ){
		scaleNotes = notes;
	}
	
	public int[] getScaleNotes(){
		return scaleNotes;
	}

}
