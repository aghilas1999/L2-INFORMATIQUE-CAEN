package filRouge;

import java.util.*;

public class InteractiveScheduling
{
	public static final int[] JOUR_ACTIVITES = {2019, 11, 29};
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		// On crée les activités
		Activity actiCafe = new Activity ("Boire un café", 10);
		Activity actiCours = new Activity ("Cours de POO", 75);
		Activity actiCampus = new Activity ("Aller au campus", 30);
		Activity actiLireMail = new Activity ("Lire mon courrier électronique", 5);
		
		//On commence la collecte des horaires de début des activités
		String hCafe, hPOO, hCampus, hMails;
		
		hCafe   = "";
		hPOO    = "";
		hCampus = "";
		hMails  = "";
		
		System.out.println("Toute erreur dans les réponses à venir entraînera la compréhension d'une demande de valeur aléatoire de votre part.");
		
		System.out.println("Saisissez l'horaire de l'activité : Boire un café (format hh:mm)");
		hCafe = sc.nextLine();
		System.out.println("Saisissez l'horaire de l'activité : Cours de POO (format hh:mm)");
		hPOO = sc.nextLine();
		System.out.println("Saisissez l'horaire de l'activité : Aller au campus (format hh:mm)");
		hCampus = sc.nextLine();
		System.out.println("Saisissez l'horaire de l'activité : Lire mon courrier électronique (format hh:mm)");
		hMails = sc.nextLine();
		
		// On place les activités et horaires dans un emploi du temps
		HashMap<Activity, GregorianCalendar> schedule = new HashMap<Activity, GregorianCalendar>();
		
		schedule.put(actiCafe,     traductionHoraire(hCafe));
		schedule.put(actiCours,    traductionHoraire(hPOO));
		schedule.put(actiCampus,   traductionHoraire(hCampus));
		schedule.put(actiLireMail, traductionHoraire(hMails));
		
		// On crée les différentes contraintes
		PrecedenceConstraint con1 = new PrecedenceConstraint (actiCafe, actiCampus);
		PrecedenceConstraint con2 = new PrecedenceConstraint (actiCampus, actiCours);
		
		PrecedenceConstraintWithGap conGap1 = new PrecedenceConstraintWithGap (actiCafe, actiLireMail, 30);
		PrecedenceConstraintWithGap conGap2 = new PrecedenceConstraintWithGap (actiCours, actiLireMail, 20);
		
		ArrayList<Activity> blocActivity = new ArrayList<Activity>();
		blocActivity.add(actiCafe);
		blocActivity.add(actiCours);
		blocActivity.add(actiCampus);
		
		MaxSpanConstraint conMS = new MaxSpanConstraint(blocActivity, 180);
		
		MeetConstraint conMeet1 = new MeetConstraint(actiCafe, actiCampus);
		MeetConstraint conMeet2 = new MeetConstraint(actiCafe, actiCours);
		
		// On vérifie si l'emploi du temps donné vérifie les différentes contraintes
		Verifier v = new Verifier();
		
		v.add(con1);
		v.add(con2);
		v.add(conGap1);
		v.add(conGap2);
		v.add(conMS);
		v.add(conMeet1);
		v.add(conMeet2);
		
		if(v.verify(schedule))
			System.out.println("L'emploi du temps est validé");
		else
			System.out.println(v.notOkCons(schedule));
	}
	
	public static GregorianCalendar nouvelleDate(int heures, int minutes)
	{
		return new GregorianCalendar( JOUR_ACTIVITES[0],
									  JOUR_ACTIVITES[1],
									  JOUR_ACTIVITES[2],
									  heures,
									  minutes,
									  0);
	}
	
	public static GregorianCalendar traductionHoraire(String horaire)
	{
		int hh, mm;
		
		if(horaire.length()==5 && horaire.charAt(2)==':')
		{
			hh = Integer.parseInt(horaire.substring(0,1));
			mm = Integer.parseInt(horaire.substring(3,4));
			
			if(!(hh<24 && hh>=0 && mm<60 && mm>=0))
			{
				hh = (int)(Math.random()*23);
				mm = (int)(Math.random()*59);
			}
		}
		else
		{
			hh = (int)(Math.random()*23);
			mm = (int)(Math.random()*59);
		}
		
		return nouvelleDate(hh, mm);
	}

}
