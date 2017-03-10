package scjp;

import java.io.*;

class Collar {
	int size = 10;
	Collar(int size) {
		this.size = size;
	}
	public int getCollarsize() {
		return this.size;
	}
}

class Cat2 implements Serializable {
	
	
	transient Collar collar;
	
	
	private void writeObject(ObjectOutputStream os) {
		try {
			os.defaultWriteObject();
			os.writeInt(collar.getCollarsize());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void readObject(ObjectInputStream ois) {
		
		try {
			ois.defaultReadObject();
			System.out.println("Collar size is " + ois.readInt());
			collar = new Collar(ois.readInt());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
			Cat2 c = new Cat2();
			File f = new File("cat.ser");
		
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			c.writeObject(os);
			//os.writeInt(c.collar.getCollarsize());
			os.close();
			
			
			FileInputStream fis = new FileInputStream("cat.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			c.readObject(ois);
			
			//System.out.println("Collar size is " + ois.readInt());
			ois.close();
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}
}


