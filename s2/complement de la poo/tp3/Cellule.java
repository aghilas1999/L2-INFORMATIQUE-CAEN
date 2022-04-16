package tp3;
public class Cellule
{
	//valeur
	private int valeur;
	private Cellule next;
	//Constructeur
	public Cellule(int valeur,Cellule next)
	{
		this.valeur=valeur;
		this.next=next;	
	}
	public Cellule(int valeur)
	{
		this(valeur,null)
	}
	//Getter
	public Cellule getnext()
	{
		return next;	
	}
	//Setter
	public void setnext(Cellule c)
	{
		next=c;	
	}
	public int getValeur()
	{
		return valeur;	
	}
	//Methode toString pour afficher la valeur
	public String toString()
	{
	return "|"+valeur+"|";
	}
	public String toStringRecusrsif()
	{
	return toString()+((suivant==null)?".":","+suivant.toStringRecursif());	
	}
	
}
