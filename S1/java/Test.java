package filRouge;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class Test {

	public static void main(String[] args)
	{
		//args[0] correspond au n° du tp, et args[1] au numéro du fichier tp à partir desquels on fait les tests
		if(args[0].equals("1"))
		{
			//TP Prise en main de Java
			if(args[1].equals("1"))
			{
				//Fichier activités et contraintes de précédence
				
			}
			else if(args[0].equals("2"))
			{
				//Fichier ordonnancement d'activités
				
			}
			else
				signalerErreur(args[0], args[1]);
		}
		else if(args[0].equals("2"))
		{
			//TP Héritage (1/2) : Fichier contraintes de précédence avec durée
			
		}
		else if(args[0].equals("2"))
		{
			//TP Héritage (2/2) : Fichier emplois du temps et contraintes binaires
			
		}
		else if(args[0].equals("3"))
		{
			//TP Interfaces
			if(args[1].equals("1"))
			{
				//TP contraintes d'arité quelconque
				
			}
			else if(args[1].equals("2"))
			{
				//TP vérification interactive
				
			}
			else if(args[1].equals("3"))
			{
				//TP contraintes composites
				
			}
			else
				signalerErreur(args[0], args[1]);	
		}
		else
			signalerErreur(args[0], args[1]);
		
		
		/*if(args[0].equals("1"))
		{
			// Objets
			Activity options = new Activity ("Choisir mes options", 70);
			Activity ip      = new Activity ("Inscription pédagogique", 30);
			PrecedenceConstraint contrainte = new PrecedenceConstraint (options, ip);
	
			// Jours et heures
			
			GregorianCalendar date1 = new GregorianCalendar(2019, 12, 23, 23, 00);
			GregorianCalendar date2 = new GregorianCalendar(2019, 12, 24, 00, 30);
			
			// Test avec une programmation censée satisfaire la contrainte
			if ( ! contrainte.isSatisfied(date1, date2) ) {
			    System.out.println("Mon programme ne marche pas.");
			    System.out.println("Il aurait dû trouver que la contrainte est satisfaite.");
			} else {
			    System.out.println("Mon programme passe le premier test avec succès.");
			}
	
			// Test avec une programmation censée ne pas satisfaire la contrainte
			if ( contrainte.isSatisfied(date1, date2) ) {
			    System.out.println("Mon programme ne marche pas.");
			    System.out.println("Il aurait dû trouver que la contrainte n'est pas satisfaite.");
			} else {
			    System.out.println("Mon programme passe le deuxième test avec succès.");
			}
	
			// Test avec une programmation censée ne pas satisfaire la contrainte (car la première
			// activité finirait après le début de la seconde)
			if ( contrainte.isSatisfied(date1, date2) ) {
			    System.out.println("Mon programme ne marche pas.");
			    System.out.println("Il aurait dû trouver que la contrainte n'est pas satisfaite.");
			} else {
			    System.out.println("Mon programme passe le troisième test avec succès.");
			}
		}
		else if(args[0].equals("2"))
		{
			// Definition of activities
			Activity cafe = new Activity ("Boire un café", 10);
			Activity cours = new Activity ("Cours de POO", 75);
			Activity campus = new Activity ("Aller au campus", 30);
			Activity lireMail = new Activity ("Lire mon courrier électronique", 5);

			// Definition of constraints
			PrecedenceConstraint c1 = new PrecedenceConstraint (cafe, campus);
			PrecedenceConstraint c2 = new PrecedenceConstraint (campus, cours);
			PrecedenceConstraint c3 = new PrecedenceConstraint (lireMail, cours);
			List<PrecedenceConstraint> allConstraints = Arrays.asList (c1, c2, c3);

			// Computation of schedule
			Scheduler s = new Scheduler ();
			HashMap<Activity, GregorianCalendar> schedule = s.computeSchedule(allConstraints);
			if (schedule == null) {
			    System.out.println("Pas de plan cohérent avec toutes les contraintes");
			} else {
			    System.out.println("Un plan trouvé : " + schedule);
			}

			Activity blablacar = new Activity ("Aller au blablacar", 45);
			PrecedenceConstraint cBonus = new PrecedenceConstraint (campus, blablacar);
			PrecedenceConstraint cBonus2 = new PrecedenceConstraint (campus, blablacar);
			PrecedenceConstraint cRatee = new PrecedenceConstraint (cours, lireMail);
			schedule.addConstraint(cBonus);
			schedule.addConstraint(cBonus2);
			System.out.println("Nouveau plan trouvé : " + schedule +"\n");
			
			schedule.addConstraint(cRatee);
			System.out.println("Plan conservé : " + schedule);
			// affiche par exemple "{cafe = 0, lireMail = 10, campus = 15, cours = 45}" (en minutes)
		}
		else if(args[0].equals("3"))
		{
			System.out.println("-------Tests Supplémentaires-------");
			
			Activity actiCafe = new Activity ("Boire un café", 10);               //(year, month, dayOfMonth, hourOfDay, minute)
			Activity actiCours = new Activity ("Cours de POO", new GregorianCalendar(2019,    11,         29,        15,     15), 75);
			Activity actiCampus = new Activity ("Aller au campus", 30);
			Activity actiLireMail = new Activity ("Lire mon courrier électronique", 5);

			Activity actiPourrie = new Activity ("Acti invalide", new GregorianCalendar(2019,    11,         29,        15,     30), 75);
			
			PrecedenceConstraint con1 = new PrecedenceConstraint (actiCafe, actiCampus);
			PrecedenceConstraint con2 = new PrecedenceConstraint (actiCampus, actiCours);
			PrecedenceConstraint con3 = new PrecedenceConstraint (actiLireMail, actiCours);
			PrecedenceConstraintWithGap conGap = new PrecedenceConstraintWithGap (actiCafe, actiCours, 30);
			List<PrecedenceConstraint> newConstraints = Arrays.asList (con1, con2, con3, conGap);

			Scheduler s = new Scheduler ();
			Schedule schedule = s.computeSchedule(newConstraints);
			schedule.addActivity(actiPourrie);
			
			if (schedule == null) {
			    System.out.println("Pas de plan cohérent avec toutes les contraintes");
			} else {
			    System.out.println("Un plan trouvé : " + schedule);
			}
		}
		else
		{
			System.out.println("-------Tests Supplémentaires-------");
			
			Activity actiCafe = new Activity ("Boire un café", 10);               //(year, month, dayOfMonth, hourOfDay, minute)
			Activity actiCours = new Activity ("Cours de POO", new GregorianCalendar(2019,    11,         29,        15,     15), 75);
			Activity actiCampus = new Activity ("Aller au campus", 30);
			Activity actiLireMail = new Activity ("Lire mon courrier électronique", 5);

			Activity actiPourrie = new Activity ("Acti invalide", new GregorianCalendar(2019,    11,         29,        15,     30), 75);
			
			PrecedenceConstraint con1 = new PrecedenceConstraint (actiCafe, actiCampus);
			PrecedenceConstraint con2 = new PrecedenceConstraint (actiCampus, actiCours);
			PrecedenceConstraint con3 = new PrecedenceConstraint (actiLireMail, actiCours);
			PrecedenceConstraintWithGap conGap = new PrecedenceConstraintWithGap (actiCafe, actiCours, 30);
			List<PrecedenceConstraint> newConstraints = Arrays.asList (con1, con2, con3, conGap);
			
			System.out.println(conGap);
		}*/
	}
	
	public static void signalerErreur(String tp, String fichier)
	{
		if(tp.equals("4") && fichier.equals("1"))
			System.out.println("Utilisez plutôt la commande >java filRouge.RandomScheduler <n> (avec n le nombre d'emplois du temps aléatoires à générer) pour tester le fichier 1 du tp 4");
		else if(tp.equals("5") && fichier.equals("1"))
			System.out.println("Ceci est la version finale du programme, veuillez vous référer au fichier commentLancer.txt pour l'exécuter");
		else
			System.out.println("Le fichier " + fichier + " du TP " + tp + "n'existe pas");		
	}
}
