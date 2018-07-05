package practice;

public class Details {
	
	private String name;
	private String team;
	private int age;
	Details(String name ,String team, int age){
		this.name = name;
		this.team = team;
		this.age = age;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		this.name = n;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String n) {
		this.team = n;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "Name : " + name + " ; Team : " + team + "; Age : " + age ;
		
	}
}
