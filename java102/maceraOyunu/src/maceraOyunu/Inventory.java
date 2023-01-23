package maceraOyunu;

public class Inventory {
	
	private Weapon weapon;
	private Armor armor;
	private String award1;
	private String award2;
	private String award3;
	
	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Inventory() {
		this.weapon = new Weapon("yumruk",-1,0,0);
		this.armor=new Armor(-1,"Paçavra",0,0);
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public String getAward1() {
		return award1;
	}

	public void setAward1(String award1) {
		this.award1 = award1;
	}

	public String getAward2() {
		return award2;
	}

	public void setAward2(String award2) {
		this.award2 = award2;
	}

	public String getAward3() {
		return award3;
	}

	public void setAward3(String award3) {
		this.award3 = award3;
	}
	
	

}
