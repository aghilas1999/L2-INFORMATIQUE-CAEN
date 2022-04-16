package persons;
  import java.util.galendar;
  import java.util.GregorianCalendar;
 public class persons{
	 private String name;
	 private int birthyear;
	 private int birthmonth;
	 private int birthday;
 }
	public persons(String name,int birthyear,int birthmonth,int birthday ){
		this.name=name;
		this.birthyear=birthyear;
		this.birthmonth=birthmonth;
		this.birthday=birthday;
	}
	public String getPresentation(){
		return "je suis"+this.name+"né"+this.birthDateToString()+"et je suis"+this.getCurrentAge() +"ans.";
	}