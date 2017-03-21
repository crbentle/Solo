package src;

/**
 * Generate a random guitar solo based on the input Key, Scale, and Length
 * TODO: Need to implement additional Scales
 * @author Chris Bentley
 *
 */
public class CreateSolo {

	/**
	 * Create an array containing random notes from the input scale.
	 * The notes will be adjusted to be near the middle of the fret board.
	 * 
	 * @param key The music key in which to build the solo. 
	 * 	The key is an integer representing the fret on the e string of the guitar.
	 * @param scale The music scale used for the solo.
	 * @param length The number of notes the solo whould contain.
	 */
	public CreateSolo(int key, String scale, int length){
		int[] Solo = new int[length];
		int[] thisScale = new Scales().getScale(scale);
		int numNotes = thisScale.length;
		int randomNote;
		for (int i = 0; i < length; i++) {
			randomNote = (int) Math.floor(Math.random() * numNotes);
			Solo[i] = (thisScale[(int) randomNote] + key);
		}
		ConvertFrets(Solo);
	}
	
	/**
	 * Adjust the notes in the solo so that all notes are around the middle of the fret board.
	 * @param Solo The raw solo
	 */
	public void ConvertFrets(int[] Solo){
		// How many frets to reduce when moving to the next guitar string
		int reduction=5;
		// A 2D array where the first element is the fret value and the second element is the guitar string
		int[][] newSolo = new int[Solo.length][2];
		
		// Copy the input Solo into the 2D solo array. All notes start out on the lowest string
		for (int y = 0; y < Solo.length; y++) {
			newSolo[y][0] = Solo[y];
		}
		
		// Loop through the solo, moving any notes over fret 9 onto a higher string
		// We loop 5 times so notes can be moved all the way to the highest string
		for (int i = 0; i < 4; i++) {
			// Moving up to the 'G' string only reduces the fret value by 4
			if (i == 3) {
				reduction = 4;
			} else {
				reduction = 5;
			}
			
			// Loop through all solo notes. If the fret value is higher than 9 move
			//  the note up 1 string and reduce the fret value accordingly
			for (int x = 0; x < newSolo.length; x++) {
				if (newSolo[x][0] > 9) {
					newSolo[x][0] -= reduction;
					newSolo[x][1] = i + 1;
				}
			}
		}
		
		// Print out the solo in tablature notation
		for (int x = 5; x >= 0; x--) {
			for (int j = 0; j < newSolo.length; j++) {
				if (newSolo[j][1] == x) {
					System.out.print("-" + newSolo[j][0] + "-");
				} else {
					System.out.print("---");
				}
				// System.out.println(Solo[j]+" "+newSolo[j][0]+","+newSolo[j][1]);
			}
			System.out.print("\n");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CreateSolo(5, "PentMaj", 40);
	}

}
