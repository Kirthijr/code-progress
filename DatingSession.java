import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

//$Id$
//1. Class Person
public class Person {
	String name;
	int[] pref = new int[3];
	Person partner = null;
	int error;

	public Person(String name, int[] pref) {
		this.name = name;
		this.pref = pref;
		this.error = -1;
	}
	public int getPref(int position){
		return this.pref[position-1];
	}
	public String getName(){
		return this.name;
	}
	// Finds the incompatibility between two persons
	public int errorWith(Person p){
		int error=0;
		for(int i=0;i<3;i++){
			error += Math.pow(Math.round(this.pref[i] - p.pref[i]), 2);
		}
		if(error > 0){
			return error;
		}else{
			return -1;
		}
	}
	// Finds the favorite person in the array
	public Person freeFavoriteIn(Person[] themen){
		Person favorite=null;
		int temp = Integer.MAX_VALUE, index=0;
		for(int i=0;i<3;i++){
			if(themen[i].isFree() && this.errorWith(themen[i]) < temp){
				index = i;
				temp = this.errorWith(themen[i]);
			}
		}
		favorite = themen[index];
		return favorite;
	}
	// Checks if the person is free/not dating
	public boolean isFree(){
		if(this.partner != null){
			return false;
		}else{
			return true;
		}
	}
	// Sets the partner for a person
	public void setPartner(Person partner){
		this.partner = partner;
		this.error = this.errorWith(partner);
	}
	// Gets the partner of a person
	public Person getPartner(){
		Person partner= this.partner;
		return partner;
	}
	public int errorWithPartner(){
			return this.error;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		Random rand = new Random();
		System.out.println("Size? ");
		int n =sc.nextInt();
		Person m1= new Person("Barry", new int[]{1,2,1});
		Person m2= new Person("Eoin", new int[]{3,1,5});
		Person m3= new Person("Mick", new int[]{4,5,3});
		
		Person w1= new Person("Aude", new int[]{2,1,4});
		Person w2= new Person("Brenda", new int[]{1,1,5});
		Person w3= new Person("Anais", new int[]{2,3,4});

//		Random set of men and women with preferences
		Person themen[]=new Person[n];
		Person thewomen[]=new Person[n];
		for(int i=0; i<n; i++){
			themen[i] = new Person("m"+(i+1), new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)});
			thewomen[i] = new Person("w"+(i+1), new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)});
			System.out.println(themen[i].getName()+" Pref "+themen[i].pref[0]+","+themen[i].pref[1]+","+themen[i].pref[2]);
			System.out.println(thewomen[i].getName()+" Pref "+thewomen[i].pref[0]+","+thewomen[i].pref[1]+","+thewomen[i].pref[2]);
		}
		DatingSession ds=new DatingSession(themen,thewomen);
		
//		3.Perfect Match
		ds.perfectmatch(n);
		System.out.println("The total compatibility: "+ds.totalError(n));
		System.out.println(m1.repeatedString("abc", 100000));
	}

}
//2. Class DatingSession
class DatingSession{
	Person men[];
	Person women[];
	
	DatingSession(Person[] men, Person[] women){
		this.men = men;
		this.women = women;
	}
	int totalError(int n){
		int t_error=0;
		for(int i=0;i<n;i++){
			t_error+=this.women[i].error;
		}
		return t_error;
	}
	// assigns partners for a list of people
	void assignPartners(int n){
		System.out.println("\nPartners:");
		for(int i=0;i<n;i++){
			Person partner;
			partner = women[i].freeFavoriteIn(men);
			women[i].setPartner(partner);
			partner.setPartner(women[i]);
			System.out.println(women[i].getName()+"-"+women[i].partner.getName()+" Compatibility: "+women[i].error);
		}
	}
	// Assigns partner based on the compatibility level
	void sortAndAssign(int n){
		int incompatibility[] = new int[n];
		Arrays.fill(incompatibility,0);
		for(int i=0;i<n;i++){ 
			for(int j=0;j<n;j++){
				incompatibility[i] += women[i].errorWith(men[j]);
			}
		}
		
		Person p = this.women[0];
		for(int i=0;i<n-1;i++){ //sort
			for(int j=1;j<n-1;j++){
				if(incompatibility[i]<incompatibility[j]){
					p = this.women[i];
					this.women[i] = this.women[j];
					this.women[j] = p;
				}
			}
		}
	}
	//Finds perfect match
	void perfectmatch(int n){
		sortAndAssign(n);
		assignPartners(n);
		for(int i=0; i<n; i++){
			for(int j=i+1;j<n;j++){
				switchmatch(i,j,n);
			}
		}
	}
	// Switches match
	void switchmatch(int w1, int w2, int n){
		Person temp = null;
		int error = totalError(n) - (this.women[w1].errorWithPartner() + this.women[w2].errorWithPartner()) + (this.women[w1].errorWith(this.women[w2].partner) + this.women[w2].errorWith(this.women[w1].partner));
		System.out.println("\n"+this.women[w1].getName()+"-"+this.women[w1].partner.getName()+" "+this.women[w2].getName()+"-"+this.women[w2].partner.getName());
		System.out.println("OldTotal(n): "+totalError(n));
		System.out.println("NewTotal: "+error);
		if(totalError(n) > error){
			temp = this.women[w1].partner;
			this.women[w1].setPartner(this.women[w2].partner);
			this.women[w2].partner.setPartner(this.women[w1]);
			this.women[w2].setPartner(temp);
			temp.setPartner(this.women[w2]);
		}
		System.out.println(this.women[w1].getName()+"-"+this.women[w1].partner.getName()+" "+this.women[w2].getName()+"-"+this.women[w2].partner.getName());
		
	}
}
