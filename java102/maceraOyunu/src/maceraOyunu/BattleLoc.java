package maceraOyunu;

import java.util.Random;

public abstract class BattleLoc extends Location{
	
	private Obstacle obstacle;
	private String award;
	private int maxObstacle;
	
	
	
	public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
		super(player, name);
		this.obstacle=obstacle;
		this.award=award;
		this.maxObstacle=maxObstacle;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean onLocation() {
		int obsNumber = this.randomObstacleNumber();
		
		
		System.out.println("Şu an buradasınız : "+this.getName());
		System.out.println("Dikkatli ol burada"+obsNumber +
		this.getObstacle().getName()+" yaşıyor");
		
		System.out.println("Savaş veya Kaç");
		String select = input.nextLine();
		select=select.toUpperCase();
		
		
		if(select.equals("S")) {
			if(combat(obsNumber)) {
				System.out.println(this.getName()+"tüm düşmanları yendiniz");
				return true;
			}
			
		}
		
		
		if(this.getPlayer().getHealth()<=0) {
			System.out.println("Öldünüz");
			return false;
		}
		
		
		return true;
	}
	
	public boolean combat(int obsNumber) {
		
		
		
		for(int i=1;i<=obsNumber;i++) {
			this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
			playerStats();
			obstacleStats();
			
			if(obstacle.getName()=="yılan") {
				int hasarRastgele = (int)Math.random()*4+3;
				obstacle.setDamage(hasarRastgele);
			}
			
			
			
			
			Random x = new Random();
			int y = x.nextInt(2);
			
			while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0) {
				System.out.println("Vur veya kaç");
				String selectCombat = input.nextLine().toUpperCase();
				if(selectCombat.equals("V")) {
					
					if(y==1) {
					System.out.println("Siz vurdunuz");
					obstacle.setHealth(this.getObstacle().getHealth()-this.getPlayer().getDamage());
					afterHit();
					y=0;
					}
					
					if(this.getObstacle().getHealth()>0 && y!=1) {
						System.out.println("Canavar size vurdu");
						int obstacleDamage = this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
						if(obstacleDamage<0) {
							obstacleDamage=0;
						}
						this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
						afterHit();
						y=1;
					}
					
					
				}else {
					return false;
				}
			}
			
			if(this.getObstacle().getHealth()<this.getPlayer().getHealth()) {
				System.out.println("Düşmanı yendiniz");
				
				
				if(this.getObstacle().getName()!="yılan") {
				System.out.println(this.getObstacle().getAward()+"para kazandınız");
				this.getPlayer().setMoney(this.getObstacle().getAward()+this.getPlayer().getMoney());
				System.out.println("Güncel paranız: "+this.getPlayer().getMoney());
				}
				else {
					// olasılık hesaplarının yapıldığı yer.
					
					
				}
				
				
				
			}else {
				return false;
			}
			
		}
		
		if(this.getObstacle().getName()=="Vampir") {
		this.getPlayer().getInventory().setAward1(this.getAward());
		
		}
		if(this.getObstacle().getName()=="Ayı") {
			this.getPlayer().getInventory().setAward2(this.getAward());
			
		}
		if(this.getObstacle().getName()=="Zombie") {
			this.getPlayer().getInventory().setAward3(this.getAward());
			
		}
		
		
		
		
		
		
		return true;
	}
	
	public void afterHit() {
		System.out.println("canınız: " +this.getPlayer().getHealth());
		System.out.println(this.getObstacle().getName()+": "+this.getObstacle().getHealth());
	}
	
	
	
	public void playerStats() {
		System.out.println("Oyuncu değerleri : ");
		System.out.println("Sağlık : " +this.getPlayer().getHealth());
		System.out.println("Damage : "+this.getPlayer().getTotalDamage());
		System.out.println("Para : "+this.getPlayer().getMoney());
		System.out.println("Zırh : "+this.getPlayer().getInventory().getArmor().getName());
		System.out.println("Silah : "+this.getPlayer().getInventory().getWeapon().getName());
		System.out.println("Bloklama : " +this.getPlayer().getInventory().getArmor().getBlock());
	
	}
	
	public void obstacleStats() {
		System.out.println(this.getObstacle().getName() + "değerleri");
		System.out.println("Sağlık :  "+this.getObstacle().getHealth());
		System.out.println("Hasar : "+this.getObstacle().getDamage());
		System.out.println("Ödül : "+this.getObstacle().getDamage());
		System.out.println("Ödül : "+this.getObstacle().getAward());
	}
	
	
	
	public int randomObstacleNumber() {
		Random r = new Random();
		return r.nextInt(this.getMaxObstacle())+1;
	}
	

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public int getMaxObstacle() {
		return maxObstacle;
	}

	public void setMaxObstacle(int maxObstacle) {
		this.maxObstacle = maxObstacle;
	}

	
	
}
