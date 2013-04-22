package FileSys;

import org.junit.Test;

/**
 * Test sur la classe Fichier
 *
 * @author Cluchet Adda 
 * @version 22/04/13
 * 
 */

public class FichierTest {

	/**
	 * Creation d'un fichier de taille negative
	 * @throws FicException Exception si la taille est negative
	 */
	@Test(expected=FicException.class)
	public void creationfichiertaillenegatif() throws FicException{
		@SuppressWarnings("unused")
		Fichier f1 = new Fichier("f1",-40);
	}

}
