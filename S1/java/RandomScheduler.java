package filRouge;

import java.util.*;

public class RandomScheduler
{
	private List<Activity>    activities;
	private List<Constraint> constraints;
	private java.util.Random randomGenerator;
	
	public RandomScheduler()
	{
		activities  = new ArrayList<Activity>();
		constraints = new ArrayList<Constraint>();
		randomGenerator = new java.util.Random();
	}
	
	public void add(Activity acti)
	{
		activities.add(acti);
	}
	
	public void add(Constraint con)
	{
		constraints.add(con);
	}
	
	public HashMap<Activity, GregorianCalendar> randomCalendar()
	{
		HashMap<Activity, GregorianCalendar> randomCalendar = new HashMap<Activity, GregorianCalendar>();
		
		GregorianCalendar debut;
		
		for(Activity acti : activities)
		{
			debut = new GregorianCalendar( 2019, 11, 13, randomGenerator.nextInt(24), randomGenerator.nextInt(60), 00);
			
			randomCalendar.put(acti, debut);
		}
		
		return randomCalendar;
	}
	
	public int nbOfSatisfiedCons(HashMap<Activity, GregorianCalendar> schedule)
	{
		int nbOkCons = 0;
		
		for(Constraint c : this.constraints)
			if(c.isSatisfiedBySchedule(schedule))
				nbOkCons++;
		
		return nbOkCons;
	}
	
	public HashMap<Activity, GregorianCalendar> bestInNRandomCalendars(int n)
	{
		HashMap<Activity, GregorianCalendar> tmpCalendar;
		HashMap<Activity, GregorianCalendar> bestCalendar = null;
		
		int maxNbSatisfied = 0;
		int nbSatisfied;
		
		for(int i=0; i<n; i++)
		{
			tmpCalendar = randomCalendar();
			nbSatisfied = nbOfSatisfiedCons(tmpCalendar);

			System.out.println("(" + nbSatisfied + ")\n" + miseEnForme(tmpCalendar));
			
			if(nbSatisfied > maxNbSatisfied)
			{
				bestCalendar   = copy(tmpCalendar);
				maxNbSatisfied = nbSatisfied;
			}
		}
		
		System.out.println("----------------------------");
		
		return bestCalendar;
	}
	
	public static HashMap<Activity, GregorianCalendar> copy(HashMap<Activity, GregorianCalendar> calendar)
	{
		HashMap<Activity, GregorianCalendar> copy = new HashMap<Activity, GregorianCalendar>();
		
		for(Activity acti : calendar.keySet())
			copy.put(acti, (GregorianCalendar)calendar.get(acti).clone());
		
		return copy;
	}
	
	public static String miseEnForme(HashMap<Activity, GregorianCalendar> calendar)
	{
		String calendrierMisEnForme = "";
		ArrayList<Activity> activities = new ArrayList<Activity>(calendar.keySet());
		
		for(Activity acti : activities)
		{
			String month, day, hour, minute;
			
			if(calendar.get(acti).get(Calendar.MONTH)>9)
				month = "" + calendar.get(acti).get(Calendar.MONTH);
			else
				month = "0" + calendar.get(acti).get(Calendar.MONTH);
			
			if(calendar.get(acti).get(Calendar.DAY_OF_MONTH)>9)
				day = "" + calendar.get(acti).get(Calendar.DAY_OF_MONTH);
			else
				day = "0" + calendar.get(acti).get(Calendar.DAY_OF_MONTH);
			
			if(calendar.get(acti).get(Calendar.HOUR)>9)
				hour = "" + calendar.get(acti).get(Calendar.HOUR);
			else
				hour = "0" + calendar.get(acti).get(Calendar.HOUR);
			
			if(calendar.get(acti).get(Calendar.MINUTE)>9)
				minute = "" + calendar.get(acti).get(Calendar.MINUTE);
			else
				minute = "0" + calendar.get(acti).get(Calendar.MINUTE);
			
			calendrierMisEnForme+= calendar.get(acti).get(Calendar.YEAR) +  "-";
			calendrierMisEnForme+= month  +  "-";
			calendrierMisEnForme+= day    +  ":";
			calendrierMisEnForme+= hour   +  "h";
			calendrierMisEnForme+= minute +  "\t";
			calendrierMisEnForme+= acti.toString() + "\n";
		}
		
		return calendrierMisEnForme;
	}
	
	public static void main(String[] args)
	{
		RandomScheduler rs = new RandomScheduler();
		
		Activity actiCafe     = new Activity ("Boire un café", 10);
		Activity actiCours    = new Activity ("Cours de POO", 75);
		Activity actiCampus   = new Activity ("Aller au campus", 30);
		Activity actiLireMail = new Activity ("Lire mon courrier électronique", 5);
		Activity actitest1 = new Activity ("TestUno", 95);
		Activity actitest2 = new Activity ("TestoDos", 7);
		
		rs.add(actiCafe);
		rs.add(actiCours);
		rs.add(actiCampus);
		rs.add(actiLireMail);
		rs.add(actitest1);
		rs.add(actitest2);
		
		rs.add(new PrecedenceConstraint (actiCafe, actiCampus));
		rs.add(new PrecedenceConstraintWithGap (actiCours, actiLireMail, 20));
		
		ArrayList<Activity> blocActivity = new ArrayList<Activity>();
		blocActivity.add(actiCafe);
		blocActivity.add(actiCours);
		blocActivity.add(actiCampus);
		
		MaxSpanConstraint conMS = new MaxSpanConstraint(blocActivity, 1800);
		
		rs.add(conMS);
		rs.add(new MeetConstraint(actiCafe, actiCampus));
		
		System.out.println(miseEnForme(rs.bestInNRandomCalendars(Integer.parseInt(args[0]))));
	}
}
