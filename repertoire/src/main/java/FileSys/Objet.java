package FileSys;

/**
 * La classe Objet est la classe mère des classes Fichier et Répertoire
 * @author Cluchet Adda
 * @version 22/04/13
 */

public abstract class Objet 
{
    // instance variables - replace the example below with your own
    String nom;
    /**
     * Constructeur d'un Objet (un objet ne sera jamais instancie car elle est immuable)
     * @param nom Nom du fichier ou du dossier
     */
    public Objet(String nom)
    {
    	this.nom= nom;	
    }

    /**
     * Permet de calculer la taille de l'objet (va etre redefini dans les classes heritees de celle ci
     * @return taille de l'objet
     */
    public abstract int getTaille();
    
    
    /**
     * Permet de recuperer le nom de l'objet 
     * @return le nom de l'objet
     */
    public String getNom()
    {
    	return nom;
    }
}

