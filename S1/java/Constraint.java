package filRouge;

import java.util.*;

public interface Constraint {
	public abstract boolean isSatisfiedBySchedule(HashMap<Activity, GregorianCalendar> schedule);
}
