package maceraOyunu;

public class SafeHouse extends NormalLoc{

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
		// TODO Auto-generated constructor stub
	}
	
	public boolean onLocation() {
		System.out.println("Güvenli evdesiniz");
		System.out.println("Canınız fullendi.");
		this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
		return true;
	}

}
