package filRouge;

import java.util.GregorianCalendar;
import java.util.HashMap;

public class NegationConstraint implements Constraint
{
	private Constraint constraint;
	
	public NegationConstraint(Constraint c)
	{
		this.constraint = c;
	}
	
	public boolean isSatisfiedBySchedule(HashMap<Activity, GregorianCalendar> schedule)
	{
		return !this.constraint.isSatisfiedBySchedule(schedule);
	}
}
