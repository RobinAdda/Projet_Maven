package FileSys;
import java.util.*;

/**
 * Cette classe nous permet de représenter un répertoire
 * 
 * @author Cluchet Adda
 * @version 15/04/13
 */
public class Repertoire extends Objet
{
    // Création d'une liste de type Objet nommé répertoire
    private ArrayList<Objet> repertoire;
    private static ArrayList<Repertoire> listRep = new ArrayList<Repertoire>();

    /**
     * Définition du constructeur de Répertoire
     * On prend ici en argument le nom donné par l'utilisateur qui sera envoyé à la classe Objet
     * Ensuite on crée un tableau de type Objet appelé repertoire
     */
    public Repertoire(String nom)
    {
        super(nom);
        repertoire = new ArrayList<Objet>();
        
        if(listRep.size() == 0)
            ajoutRepList(this);
    }
   
    /**
     * Cette méthode ajoute un objet (fichier ou répertoire)dans le tableau appelé répertoire.
     * Afin d'ajouter l'élément dans le tableau on le parcourt jusqu'à trouver une case vide.
     * Ainsi on insère l'objet dans la case correspondante (qui est vide).
     */
    public boolean add(Object obj) throws RepException
    {
        if(obj instanceof Objet && obj != null){
            Objet o = (Objet) obj;  
            if(pasMemeNom(o)&& this!=o && nonPresentDans(o)){
                    repertoire.add(o);
                     ajoutRepList(o);
                    return true;
            }
            else
                throw new RepException("Objet déjà présent portant le meme nom ou ajout du meme objet ou deja present dans arborescence");
        }
        else{
            throw new RepException("Reference nulle ou objet de type différent d'Objet");
        }
    }
 
    /**
     * 
     * @param obj
     * @return
     */
    private boolean pasMemeNom(Objet obj){
        boolean result = true;
        int i = 0;
        
        for(i=0;i<repertoire.size();i++){
            if(repertoire.get(i).getNom().equals(obj.getNom())){
                result = false;
            }
        }
        return result;      
    }
    
    
     public static boolean ajoutRepList(Objet obj){
 
        if(obj instanceof Repertoire){
            Repertoire rep = (Repertoire) obj;
            listRep.add(rep);
            return true;
        }
        else
            return false;
    }
    
    public static boolean nonPresentDans(Objet obj){
    
        
        
        for(int i = 0;i<listRep.size();i++){
            if(listRep.get(i) == obj)
                return false;
        }
        
        return true;
    }
    
    
    /**
     *
     */
    public int getTaille()
    {
        int i=0;
        int taille=0;
        for(i=0 ; i<repertoire.size(); i++)
        {   
            taille += repertoire.get(i).getTaille();
        }
        
        return taille;
    }
 
    
}
