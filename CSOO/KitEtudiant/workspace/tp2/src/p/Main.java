package p;

public class Main {

	public static void main(String[] args) {
		
		Company c = new Company("Nestlé");		

		Mentor mo1= new Mentor("Jean",5200,1000.f);
		mo1.setLangage("C++");
		
		Mentee me2 = new Mentee("Vincent", 5201, 1000.f);
		me2.setLangage("Java");
		
		//mentor de vincent est marc
		//c.addEmploye(me2, mo);
		
		Mentee me3 = new Mentee("Camille", 5202, 1000.f);
		me3.setLangage("Java");

		Mentor mo4 = new Mentor("Marc",5203,1210.f);
		mo4.setLangage("Java");
		
		
		c.addEmploye(mo1);
		
		c.addEmploye(me2);
		c.addEmploye(me2,mo4);
		c.addEmploye(me3,mo4);
		c.addEmploye(mo4);
		
		
		
		c.displayEmployes();
		

		

//		mo1.display();
//		me2.display();
//		me3.display();
//		mo4.display();

	}

}
