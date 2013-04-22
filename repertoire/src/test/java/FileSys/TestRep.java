package FileSys;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestRep{
	
	Repertoire r1;
	
	@Before
	public void setUp(){
		r1 = new Repertoire("r1");
	}
	
	@Test(expected=RepException.class)
	public void testajoutreferencenull() throws RepException{
		r1.add(null);
	}

	@Test(expected=RepException.class)
	public void testajoutreferencenoncompatible() throws RepException{
		String a ="abcd";
		r1.add(a);
	}

	@Test
	public void ajoutfichierreussit() throws FicException,RepException{
		Fichier f1 = new Fichier("f1", 10);
		assertTrue(r1.add(f1));
	}
	
	@Test
	public void ajoutrepertoirereussit() throws RepException{
		Repertoire r2 = new Repertoire("r2");
		assertTrue(r1.add(r2));
	}
		
	@Test(expected=RepException.class)
	public void nompresentdansrep() throws FicException,RepException{
		Repertoire r2 = new Repertoire("abcd");
		Fichier f1 = new Fichier("abcd",12);
		r1.add(r2);
		r1.add(f1);
	}
	
	@Test(expected=RepException.class)
	public void reparborescence1() throws RepException{
		Repertoire r2 = new Repertoire("r2");
		Repertoire r3 = new Repertoire("r3");
		r1.add(r2);
		r1.add(r3);
		r3.add(r2);
	}
	
	@Test(expected=RepException.class)
	public void reparborescence2() throws RepException{
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
	
	@Test
	public void calculetaille1()throws RepException,FicException{
		Repertoire r2 = new Repertoire("r2");
		Repertoire r3 = new Repertoire("r3");
		Fichier f1 = new Fichier("f1",5);
		Fichier f2 = new Fichier("f2",10);
		Fichier f3 = new Fichier("f3",15);
		Fichier f4 = new Fichier("f4",20);
		r1.add(r2);
		r1.add(r3);
		r1.add(f1);
		r1.add(f2);
		r2.add(f3);
		r3.add(f4);
		assertEquals(r1.getTaille(),50,0);
	}
		
	@Test
	public void calculetaille2()throws RepException,FicException{
		Repertoire r2 = new Repertoire("r2");
		Repertoire r3 = new Repertoire("r3");
		Repertoire r4 = new Repertoire("r4");
		Fichier f1 = new Fichier("f1",5);
		Fichier f2 = new Fichier("f2",10);
		Fichier f3 = new Fichier("f3",5);
		Fichier f4 = new Fichier("f4",20);
		r1.add(r2);
		r2.add(r3);
		r2.add(r4);
		r1.add(f1);
		r2.add(f2);
		r3.add(f3);
		r4.add(f4);
		assertEquals(r1.getTaille(),40,0);
	}
	

}
