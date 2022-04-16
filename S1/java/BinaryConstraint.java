package filRouge;

import java.util.*;

public abstract class BinaryConstraint implements Constraint
{
	Activity acti, acti2;
	
	public abstract boolean isSatisfiedBySchedule(HashMap<Activity, GregorianCalendar> schedule);
}
