package src;

/**
 * This class contains a representation of all implemented scales.
 * The scale array contains all notes valid for the scale as fret values on the lowest guitar string
 * @author Chris Bentley
 */
public class Scales {

	final static int[] PentMaj = new int[]{0,3,5,8,10,12,13,14,15,16,18,21};
	public Scales(){}
	
	public int[] getScale(String scale){
		// TODO: Implement more scales and find the correct scale based on the input string
		return PentMaj;
	}

}
