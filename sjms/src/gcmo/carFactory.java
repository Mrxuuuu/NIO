package gcmo;

import gcmo.impl.bcCar;
import gcmo.impl.bmCar;

public class carFactory {

	public  car createCar(String name) {
		car car=null;
		if(name!=null)
		{
			if(name.equals("����"))
			{
				car=new bcCar();
				System.out.println("�����˱���");
			}
			if(name.equals("����"))
			{
				car= new bmCar();
				System.out.println("�����˱���");
			}
		}
		else {
			return null;
		}
		return car;
	}
}
