package jzzms;

public class ManBuilder implements BuiderMan {

	//�����ɫʵ��
	Person person=new Person();
	@Override
	public void buildHead() {
		// TODO Auto-generated method stub
		person.setHead("����ͷ");
	}

	@Override
	public void buildbody() {
		// TODO Auto-generated method stub
		person.setBody("������");
	}

	@Override
	public void buildfootAndhand() {
		// TODO Auto-generated method stub
		person.setFootAndhand("�������ͷ");
	}

	@Override
	public Person buildMan() {
		return person;
		// TODO Auto-generated method stub
    
	}
	
	

}
