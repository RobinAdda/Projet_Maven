package FileSys;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test sur la classe Repertoire
 * 
 * @author Cluchet Adda 
 * @version 22/04/13
 * 
 */

public class TestRep {
	
	private Repertoire r1;
	/**
	 *Construction d'un nouveau repertoire avant les Tests
	 */
	@Before
	public final void setUp() {
		r1 = new Repertoire("r1");
	}
	
	/**
	 * Ajout d'un reference null dans une arborescence
	 * @throws RepException Exception si la reference est null
	 */
	@Test(expected = RepException.class)
	public final void testajoutreferencenull() throws RepException {
		r1.add(null);
	}

	/**
	 * Ajout d'une reference qui n'est pas de type Objet
	 * @throws RepException Exception si la reference n'a pas le bon type
	 */
	@Test(expected = RepException.class)
	public final void testajoutreferencenoncompatible() throws RepException {
		String a = "abcd";
		r1.add(a);
	}

	/**
	 * Ajout avec succes d'un fichier dans un repertoire
	 * @throws FicException
	 * @throws RepException
	 */
	@Test
	public final void ajoutfichierreussit() throws FicException, RepException {
		Fichier f1 = new Fichier("f1", 10);
		assertTrue(r1.add(f1));
	}
	
	/**
	 * Ajout avec succes d'un repertoire dans un repertoire
	 * @throws RepException
	 */
	@Test
	public final void ajoutrepertoirereussit() throws RepException {
		Repertoire r2 = new Repertoire("r2");
		assertTrue(r1.add(r2));
	}
	
	/**
	 * Ajout dans un repertoire de deux objet (un fichier et un repertoire) 
	 * ayant le meme nom
	 * @throws FicException
	 * @throws RepException
	 */
	@Test(expected = RepException.class)
	public final void nompresentdansrep() throws FicException, RepException {
		Repertoire r2 = new Repertoire("abcd");
		Fichier f1 = new Fichier("abcd", 12);
		r1.add(r2);
		r1.add(f1);
	}
	
	/**
	 * 
	 * @throws RepException
	 */
	@Test(expected = RepException.class)
	public final void reparborescence1() throws RepException {
		Repertoire r2 = new Repertoire("r2");
		Repertoire r3 = new Repertoire("r3");
		r1.add(r2);
		r1.add(r3);
		r3.add(r2);
	}
	
	/**
	 * 
	 * @throws RepException
	 */
	@Test(expected = RepException.class)
	public final void reparborescence2() throws RepException {
		Repertoire r2 = new Repertoire("r2");
		Repertoire r3 = new Repertoire("r3");
		Repertoire r4 = new Repertoire("r4");
		Repertoire r5 = new Repertoire("r5");
		r1.add(r2);
		r1.add(r3);
		r2.add(r4);
		r3.add(r5);
		r4.add(r2);
	}
	
	/**
	 * Calcul de la taille d'un repertoire -> Test 1
	 * @throws RepException
	 * @throws FicException
	 */
	@Test
	public final void calculetaille1()throws RepException, FicException {
		Repertoire r2 = new Repertoire("r2");
		Repertoire r3 = new Repertoire("r3");
		Fichier f1 = new Fichier("f1", 5);
		Fichier f2 = new Fichier("f2", 10);
		Fichier f3 = new Fichier("f3", 15);
		Fichier f4 = new Fichier("f4", 20);
		r1.add(r2);
		r1.add(r3);
		r1.add(f1);
		r1.add(f2);
		r2.add(f3);
		r3.add(f4);
		assertEquals(r1.getTaille(), 50, 0);
	}
	
	/**
	 * Calcul de la taille d'un repertoire -> Test 2
	 * @throws RepException
	 * @throws FicException
	 */
	@Test
	public final void calculetaille2()throws RepException, FicException {
		Repertoire r2 = new Repertoire("r2");
		Repertoire r3 = new Repertoire("r3");
		Repertoire r4 = new Repertoire("r4");
		Fichier f1 = new Fichier("f1", 5);
		Fichier f2 = new Fichier("f2", 10);
		Fichier f3 = new Fichier("f3", 5);
		Fichier f4 = new Fichier("f4", 20);
		r1.add(r2);
		r2.add(r3);
		r2.add(r4);
		r1.add(f1);
		r2.add(f2);
		r3.add(f3);
		r4.add(f4);
		assertEquals(r1.getTaille(), 40, 0);
	}
}
