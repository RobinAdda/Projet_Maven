package FileSys;



import org.junit.Test;

public class FichierTest {

	@Test(expected=FicException.class)
	public void creationfichiertaillenegatif() throws FicException{
		@SuppressWarnings("unused")
		Fichier f1 = new Fichier("f1",-40);
	}

}
