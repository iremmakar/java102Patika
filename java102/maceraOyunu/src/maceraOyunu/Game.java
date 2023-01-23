package maceraOyunu;

import java.util.Scanner;

public class Game {
	private Scanner input = new Scanner(System.in);
	
	public void start() {
		System.out.println("Macera Oyununa Hoşgeldiniz !");
		System.out.println("Lütfen bir isim giriniz : ");
		String playerName = input.nextLine();
		Player player = new Player(playerName);
		System.out.println("Sayın "+player.getName()+" bu karanlık ve sisli adaya hoşgeldiniz !");
		System.out.println("Burada yaşananların hepsi gerçek");
		System.out.println("Lütfen bir karakter seçiniz ! ");
		player.selectChar();
		
		Location location = null;
		while(true) {
		player.printInfo();
		System.out.println("Bölgeler");
		System.out.println("1 Güvenli Ev");
		System.out.println("2 Mağaza");
		System.out.println("3 Mağaraya gir dikkatli ol canavar çıkabilir.");
		System.out.println("4 Ormana git");
		System.out.println("5 nehre git");
		System.out.println("6 madene git");
		System.out.println("Lütfen gtimek istediğiniz bölgey seçin");
		int selectLoc = input.nextInt();
		
		if(player.getInventory().getAward3()!=null) {
		if(player.getInventory().getAward3().equals("food") && selectLoc==3) {
			System.out.println("Daha önce bu bölgeye girdiniz ve kazandınız bir daha giremezsiniz.");
			continue;
		}
		}
		
		
		if(player.getInventory().getAward1()!=null) {
		if(player.getInventory().getAward1().equals("firewood") && selectLoc==4) {
			System.out.println("Daha önce bu bölgeye girdiniz ve kazandınız bir daha giremezsiniz.");
			continue;
			
		}
		}
		
		
		if(player.getInventory().getAward2()!=null) {
		if(player.getInventory().getAward2().equals("water") && selectLoc==5) {
			System.out.println("Daha önce bu bölgeye girdiniz ve kazandınız bir daha giremezsiniz.");
			continue;
		}	
		}
		
		
		switch(selectLoc) {
		case 0:
			location=null;
			break;
		case 1:
			location = new SafeHouse(player);
			break;
		case 2:
			location = new ToolStore(player);
			break;
		case 3:
			location=new Cave(player);
			break;
		case 4:
			location=new Forest(player);
			break;
		case 5:
			location=new River(player);
			break;
		case 6:
			location=new Mine(player);
			break;	
			default:
				location = new SafeHouse(player);
				break;
		}
		
		
		
		
		if(location==null) {
			System.out.println("Oyun bitti yine bekleriz.");
			break;
		}
		
		if(!location.onLocation()) {
			System.out.println("Game over");
			break;
		}
		
		if(player.getInventory().getAward1()!=null && player.getInventory().getAward3()!=null &&player.getInventory().getAward2()!=null) {
		if(player.getInventory().getAward1().equals("firewood")&&
			player.getInventory().getAward2().equals("water")&&
			player.getInventory().getAward3().equals("food")) {
			System.out.println("Oyunu kazandınız");
			location = new SafeHouse(player);
			break;
		}
		}
		
		
		}
		
		
	}
	
	

}
