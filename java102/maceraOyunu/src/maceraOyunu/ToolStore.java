package maceraOyunu;

public class ToolStore extends NormalLoc{

	public ToolStore(Player player) {
		super(player, "Mağaza");
		// TODO Auto-generated constructor stub
	}
	
	public boolean onLocation() {
		 System.out.println("Mağazaya hoşgeldiniz. ");
		 boolean showMenu = true;
		 while(showMenu) {
		 System.out.println("Yapamak istediğiniz işlem");
		 System.out.println("1 Silahlar");
		 System.out.println("2 Zırhlar");
		 System.out.println("3 Çıkış Yap");
		 int selectedCase = Location.input.nextInt();
		 while(selectedCase<1 || selectedCase>3) {
			 System.out.println("Geçersiz değer");
			 selectedCase=input.nextInt();
		 }
		 
		 switch(selectedCase) {
		 case 1:
			 printWeapon();
			 buyWeapon();
			 break;
		 case 2:
			 printArmor();
			 buyArmor();
			 break;
		 case 3:
			 System.out.println("Bir daha bekleriz");
			 showMenu=false;
			 break;
			 
		 
		 }
		 }
		 
		 return true;
		 
	}
	
	public void printWeapon() {
		System.out.println("Silahlar");
		for(Weapon w : Weapon.weapons()) {
			System.out.println(w.getName()+"Para : "+
		w.getPrice()+
		"Hasar : "+w.getDamage());
		}
		
		System.out.println("0 Çıkış Yap");
		
		
	}
	
	public void buyWeapon() {
		System.out.println("Bir silah seçiniz : ");
		int selectedWeapon = input.nextInt();
		 while(selectedWeapon<0 || selectedWeapon>Weapon.weapons().length) {
			 System.out.println("Geçersiz değer");
			 selectedWeapon=input.nextInt();
		 }
		 
		 if(selectedWeapon!=0) {
			 Weapon selectWeapon = Weapon.getWeaponObjById(selectedWeapon);
			 if(selectWeapon!=null) {
				 if(selectWeapon.getPrice()>this.getPlayer().getMoney()) {
					 System.out.println("Yeterli paranız bulunmamaktadır.");
					 
				 }else {
					System.out.println(selectWeapon.getName()+" silahını satın aldınız."); 
					int balance = this.getPlayer().getMoney()-selectWeapon.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Kalan paranız : "+this.getPlayer().getMoney());
					this.getPlayer().getInventory().setWeapon(selectWeapon);
				 }
			 }
		 }
		 
		 
		 
		
		 
	}
	
	public void printArmor() {
		System.out.println("Zırhlar");
		System.out.println("Silahlar");
		for(Armor a : Armor.armors()) {
			System.out.println(a.getId()+"-  "+
		a.getName()+
		"Zırh "+a.getBlock()+
		"Fiyat"+a.getPrice());
		}
		System.out.println("0 çıkış yap");
		
	}
	
	
	public void buyArmor() {
		System.out.println("Bir zırh seçiniz : ");
		int selectedArmor = input.nextInt();
		 while(selectedArmor<0 || selectedArmor>Armor.armors().length) {
			 System.out.println("Geçersiz değer");
			 selectedArmor=input.nextInt();
		 }
		 
		 if(selectedArmor!=0) {
		 Armor selectArmor = Armor.getArmorObjById(selectedArmor);
		 if(selectArmor!=null) {
			 if(selectArmor.getPrice()>this.getPlayer().getMoney()) {
				 System.out.println("Yeterli paranız yoktur.");
			 }else {
				 System.out.println(selectArmor.getName()+"zırhını satın aldınız");
				 int balance = this.getPlayer().getMoney()-selectArmor.getPrice();
				 this.getPlayer().setMoney(balance);
				 this.getPlayer().getInventory().setArmor(selectArmor);
			 }
		 }
		 }
		 
	}

}
