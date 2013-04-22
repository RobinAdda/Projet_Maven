package FileSys;

/**
 * Cette classe nous permet de représenter un fichier
 * 
 * @author Cluchet Adda 
 * @version 22/04/13
 */
public class Fichier extends Objet
{
    // Création d'une variable de type int qui contiendra la taille d'un fichier
   private int taille;

   /**
    * Constructeur de la classe fichier
    * @param nom Nom du fichier que l'on veut creer
    * @param taille Taille du fichier
    * @throws FicException Exception si la taille est negative
    */
    public Fichier(String nom, int taille) throws FicException
    {
        super(nom);
    	if(taille<0) throw new FicException("Taille fichier incompatible");
        else this.taille= taille;
    }
    
    /**
     * Cette méthode permet de renvoyer la taille
     * @return Retourne la taille du fichier qui est un int
     */
    public int getTaille()
    {
        return  taille;
    }
}