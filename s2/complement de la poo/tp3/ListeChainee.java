package listeschainees;
public class ListeChainee{
	private Cellule firsteCel;
	private Cellule secondCel;
	
	public ListeChainee(){
		firsteCel=null;
		secondCel=null;
	}
	public Cellule getfirsteCel(){
		return premiereCellule;
	
	}
	public Cellule getsecondCel(){
		return derniereCellule;
	}
	public void ajoutBegin(Cellule e){
		if(firsteCel==null){
			firsteCel = e;
			secondCel = e;
	}
		else{
	      	        e.steSuivant(firsteCel);
			firsteCel = e;	
		    }
	}
	public void ajoutFin(int i){
		ajoutFin(new Cellule(i));	
	}
	public Cellule rechercheCellule1(int valeurCherchee){
		for (Cellule c=firsteCel;c!=null;c=c.getSuivant())
		    if (c.getValeur()==valeurCherchee)
				return c;
			return null;		
	}
	public Cellule rechcase2(int valeurCherchee){
		return rechercheCelluleRecursive(valeurCherchee, firsteCel);
	}
	public Cellule rechcaseRecursive(int valeurCherche,cellule cellule){
		if (cellule==null)
		     return null;
		if (cellule.getValeur()==valeurCherche)
			return cellule;
		return rechcaseRecursive(valeurCherche, cellule.getSuivant());
	}
	public String toString(){
		return firsteCel.toStringRecursif();
	}
}
