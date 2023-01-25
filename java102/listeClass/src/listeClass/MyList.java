package listeClass;

public class MyList<T> {
	
	private int boyut;
	T[] dizi;
	
	public T[] getDizi() {
		return dizi;
	}

	public void setDizi(T[] dizi) {
		this.dizi = dizi;
	}

	public MyList() {
		this.boyut=10;
		dizi = (T[]) new Object[this.boyut];
	}
	
	public MyList(int capacity) {
		this.boyut=capacity;
		dizi = (T[]) new Object[this.boyut];
	}
	
	public int getCapacity() {
		return this.boyut;
	}
	
	public void setCapacity() {
		this.boyut*=2;
		dizi = (T[]) new Object[this.boyut];
	}
	
	public int size() {
		int count=0;
		
		for(int i=0;i<dizi.length;i++) {
			if(dizi[i]!=null) {
				count++;
			}
		}
		return count;
	}
	
	public T get(int index) {
		
		if(dizi.length>index) {
			return dizi[index];
		}
		return null;
	}
	
	
	public T remove(int index) {
		
		if(this.dizi.length>index) {
		    int y=0;	
			for(int x=0;x<this.dizi.length;x++) {
				if(x==index) {
					y=1;
				}
				else if(y==1 && x!=this.dizi.length-1) {
					dizi[x]=dizi[x+1];
					//System.out.println(x +" "+this.dizi[x]);
				}
				if(x!=this.dizi.length-1 && dizi[x+1]==null) {
					dizi[x]=null;			
				}
				
			}
			return (T)dizi;
		}
		return null;
		
	}
	
	public T set(int index,T data) {
		
		if(index<dizi.length) {
			dizi[index]=data;
			
			
			
			return dizi[index];
		}
		
		
		return null;
	}
	
	
	public String toString() {
		
		//
		
		return "stringe cevir";
		
		
	}
	
	public int indexOf(T data) {
		
		for(int x=0;x<dizi.length;x++) {
			if(dizi[x]==data) {
				return x;
			}
		}
		
		return -1;
	}	
		
		
	public int lastIndexOf(T data) {
		
		for(int x=dizi.length-1;x>=0;x--) {
			if(dizi[x]==data) {
				return x;
			}
		}
		return -1;
		
		
	}
	
	
	public boolean isEmpty() {
		
		if(dizi[0]==null) {
			return true;
		}
		return false;
	}
	
	public T[] toArray() {
		
		Object[] object = new Object[this.boyut];
	
		for(int x=0;x<dizi.length;x++) {
			object[x]=dizi[x];
			
		}
		
		return (T[])object;
		
	}
	
	
	public void clear() {
		for(T a:dizi) {
			a=null;
		}
	}
	
	public T[] sublist(int start,int finish){
		
		T[] dizi2 = (T[])new Object[finish-start];
		int a=0;
		
		for(int x=start;x<finish;x++) {
			dizi2[a]=dizi[x];
			a++;
		}
		
		return (T[])dizi2;
		
		
		
		
	}
	
	
	public boolean contains(T data) {
		
		for(T x:dizi) {
			if(dizi==data) {
				return true;
			}
		}
		
		return false;
	}
	
	
	

	public void add(T data) {
		
		T[] dizi2=null;
		
		for(int x=0;x<dizi.length;x++) {
			if(dizi[x]==null) {
				dizi[x]=data;
				System.out.println(x+" "+dizi[x]);
				break;
			}
			
		}
		
		dizi2 = (T[]) new Object[dizi.length];
		if(dizi[dizi.length-1]!=null) {
			for(int y=0;y<dizi.length;y++) {
				
				dizi2[y]=dizi[y];
				
			}
			setCapacity();
			
			
			for(int z=0;z<dizi2.length;z++) {
				dizi[z]=dizi2[z];
				
			}
			
			
			
		}
	}
	
	
	
	
	

}
