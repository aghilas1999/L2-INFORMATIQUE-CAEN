package filRouge;

import java.util.*;

public class Scheduler
{
	private HashMap<Activity, Integer> initNbPreds(List<PrecedenceConstraint> allConstraints)
	{
		//Si la liste fournie est nulle, il n'y a pas de hashmap à retourner
		if(allConstraints.isEmpty())
			return null;
		
		//On crée la hashmap à retourner
		HashMap<Activity, Integer> schedule = new HashMap<Activity, Integer>();
		
		//On met toutes les activités ayant au moins un prédécesseur avec leur nombre de prédécesseurs
		//dans la hashmap à l'aide de getNbPreds()
		for (PrecedenceConstraint c: allConstraints)
			schedule.put(c.getActi(2), this.getNbPreds(c.getActi(2), allConstraints, schedule));
		
		//On met toutes les activités qui n'avaient pas de prédecesseur dans la hashmap
		//en renseignant qu'elles n'ont pas de prédécesseur
		for (PrecedenceConstraint c: allConstraints)
		{
			if(!schedule.containsKey(c.getActi(1)))
				schedule.put(c.getActi(1), 0);
		}
		
		return schedule;
	}
	
	private int getNbPreds(Activity acti, List<PrecedenceConstraint> allConstraints, HashMap<Activity, Integer> schedule)
	{
		//On initialise une liste de prédécesseurs d'acti et le nombre d'activités précédant acti à 0
		ArrayList<Activity> preds = new ArrayList<Activity>();
		int nbPreds = 0;
		
		//On cherche les activités précédant acti et on met leur nombre dans nbPreds
		for (PrecedenceConstraint c: allConstraints)
		{
			if(acti.equals(c.getActi(2)))
			{
				nbPreds++;
				preds.add(c.getActi(1));
			}
		}
		
		//Si acti a au moins un prédécesseur,
		//on ajoute à son nombre dde prédécesseurs, celui de son/ses prédécesseur(s)
		for(Activity pred : preds)
		{
			//Si certaines de ces activités sont déjà renseignées dans la hashmap,
			//on récupère le nombre de leurs prédécesseur(s) pour ne pas le recalculer
			//sinon on le calcule
			if(schedule.containsKey(pred))
				nbPreds+=schedule.get(pred);
			else
				nbPreds+=getNbPreds(pred, allConstraints, schedule);
		}
		
		//On retourne le nombre d'activités précédant acti
		return nbPreds;
	}
	
	public HashMap<Activity, GregorianCalendar> compute(List<PrecedenceConstraint> allConstraints)
	{
		//On calcule pour chaque activité a combien elle a de prédécesseurs b,
		//c'est-à-dire d'activités b telles qu'il y ait une contrainte de précédence forçant b
		//à se terminer avant que a ne commence
		HashMap<Activity, Integer> nbPreds = this.initNbPreds(allConstraints);
		
		//On crée une hasmap tampon pour gérer les changements de nombre de prédécesseurs
		HashMap<Activity, Integer> tmp     = new HashMap<Activity, Integer>();
		
		//On crée schedule, la hashmap à retourner
		HashMap<Activity, GregorianCalendar> schedule = new HashMap<Activity, GregorianCalendar>();
		
		//On initialise une heure courante à 0
		GregorianCalendar heureCourante = new GregorianCalendar(2019, 11, 29, 0, 0, 0);
		
		//On vérifie si toutes les activités ont été traitées
		boolean toutesActiTraitees = true;
		
		for(Activity acti : nbPreds.keySet())
		{
			if(nbPreds.get(acti).intValue()>0)
				toutesActiTraitees = false;
		}
		
		//On vérifie si toutes les activités ont été traitées sans qu'aucune ne soit traitée,
		//on considère le planning comme vide
		if(!toutesActiTraitees)
		{
			boolean sansPred;
			int numActi;
			ArrayList<Activity> activites;
			
			//On vérifie si toutes les activités ont été traitées
			while(!toutesActiTraitees)
			{
				//Sinon, on regarde s'il y a une activité a sans prédécesseur
				activites = (ArrayList<Activity>) nbPreds.keySet();
				numActi = 0;
				sansPred = false;
				
				do
				{
					sansPred = nbPreds.get(activites.get(numActi))==0;
				}
				while(!sansPred && numActi<activites.size());
				
				//S'il y a une telle activité : on planifie a à l'heure courante,
				//on augmente l'heure courante de la durée de a, on diminue le nombre de prédécesseurs
				//de chaque activité qui est un successeur de a, et on retourne en 2.
				if(sansPred)
				{
					schedule.put(activites.get(numActi), heureCourante);
					
					heureCourante.add(Calendar.MINUTE, activites.get(numActi).getDuree());
					
					for(Activity acti : nbPreds.keySet())
					{
						if(allConstraints.contains(new PrecedenceConstraint(acti, activites.get(numActi))))
							tmp.put(acti, nbPreds.get(acti).intValue()-1);
						else
							tmp.put(acti, nbPreds.get(acti).intValue());
						nbPreds.remove(activites.get(numActi));
					}
				}
				
				//On vérifie si toutes les activités ont été traitées
				toutesActiTraitees = true;
				
				for(Activity acti : nbPreds.keySet())
				{
					if(nbPreds.get(acti).intValue()>0)
						toutesActiTraitees = false;
				}
			}
			
			//Si toutes les activités ont été traitées, on retourne le plan
			return schedule;
		}
		
		//S'il n'y a pas de telle activité, retourner null (pour coder l'absence de plan)
		return null;
		
		
		//////////////////////////////////////Autre version//////////////////////////////////////		
		/*
		ArrayList<Activity> listeOrdonnee = new ArrayList<Activity>();
		
		for(PrecedenceConstraint constraint : allConstraints)
		{
			if(!listeOrdonnee.contains(constraint.getActi(1)))
				listeOrdonnee.add(constraint.getActi(1));
			if(!listeOrdonnee.contains(constraint.getActi(2)))
				listeOrdonnee.add(constraint.getActi(2));
		}
		
		boolean scheduleOk = true;
		
		while(!scheduleOk)
		{
			scheduleOk = true;
			
			for(Activity a : listeOrdonnee)
			{
				for(Activity b : listeOrdonnee)
				{
					if(!a.equals(b) && allConstraints.contains(new PrecedenceConstraint(b, a)))
					{
						Activity tmp = new Activity(b);
						listeOrdonnee.remove(b);
						listeOrdonnee.add(listeOrdonnee.indexOf(a), tmp);
						
						scheduleOk = false;
					}
				}
			}
		}
		
		return (scheduleOk?listeOrdonnee:null);
		*/
	}
	
	public GregorianCalendar getDebut(Activity acti, ArrayList<Activity> liste)
	{
		if(acti.getDebut()!=null)
			return acti.getDebut();
		
		if(acti.equals(liste.get(0)))
			return new GregorianCalendar(0, 0, 0, 0, 0);
		
		GregorianCalendar debut = new GregorianCalendar(0, 0, 0, 0, 0);
		boolean dateTrouvee = false;
		
		for(int i=0; i<liste.size() && !dateTrouvee; i++)
		{
			if(!liste.get(i).equals(acti))
			{
				if(liste.get(i).getFin()!=null)
					debut = liste.get(i).getFin();
				else if(liste.get(i).getDebut()!=null)
				{
					debut = liste.get(i).getDebut();
					debut.add(Calendar.MINUTE, liste.get(i).getDuree());
				}
				else
					debut = this.getDebut(liste.get(i), liste);
			}
			else
				dateTrouvee = true;
		}
		
		if(!dateTrouvee)
			return null;
		
		return debut;
	}
	
	public String toString()
	{
		return "";
	}
}
