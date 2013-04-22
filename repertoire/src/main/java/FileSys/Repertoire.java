package FileSys;
import java.util.*;

/**
 * Cette classe nous permet de représenter et de manipuler un répertoire
 * 
 * @author Cluchet Adda
 * @version 22/04/13
 */
public class Repertoire extends Objet
{
    // Création d'une liste de type Objet nommé repertoire et une liste représentant l'arborescence
    private ArrayList<Objet> repertoire;
    private static ArrayList<Repertoire> listRep = new ArrayList<Repertoire>();

    /**
     * Constructeur d'un repertoire
     * @param nom Nom du repertoire que l'on va instancier
     */
    public Repertoire(String nom)
    {
        super(nom);
        repertoire = new ArrayList<Objet>();
        
        if(listRep.size() == 0)
            ajoutRepList(this);
    }
   
    /**
    * Methode permettant d'ajouter un element dans un repertoire
    * @param obj Objet que l'on souhaite inserer dans le repertoire
    * @return un boolean en fonction de la reussite de l'ajout
    * @throws RepException Une exception est soulevee si l'ajout n'est pas possible
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
     * Methode permettant de tester si un objet possede le meme nom qu'un element du repertoire
     * @param obj Objet a comprarer avec le contenu du dossier
     * @return Un boolean selon le resultat de la comparaison
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
    
    /**
     * Permet d'ajouter un repertoire dans l'arborescence
     * @param obj Objet que l'on souhaite ajouter dans la liste
     * @return un boolean en fonction de la reussite de l'ajout dans l'arborescence
     */
     public static boolean ajoutRepList(Objet obj){
 
        if(obj instanceof Repertoire){
            Repertoire rep = (Repertoire) obj;
            listRep.add(rep);
            return true;
        }
        else
            return false;
    }
    /**
     * Permet de savoir si un objet est deja present dans l'arborescence 
     * @param obj Objet dont l'on veut tester la présence dans l'arborescence
     * @return un boolean en fonction du resultat du test
     */
    public static boolean nonPresentDans(Objet obj){
    
        for(int i = 0;i<listRep.size();i++){
            if(listRep.get(i) == obj)
                return false;
        }
        
        return true;
    }
    
    /**
     * Permet de recupere la taille totale de l'arborescence a partir d'un repetoire
     * @return la taille du repertoire
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
