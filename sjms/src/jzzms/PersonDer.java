package jzzms;

public class PersonDer {

	Person PerConstruct(BuiderMan per){
		//���÷���  �����ɫ��ͬ��λ�����ƴ�ӷ���
		per.buildbody();
		per.buildfootAndhand();
		per.buildHead();
		return per.buildMan();	
	}
	
	public static void main(String[] args) {
		PersonDer personDer=new PersonDer();
		//���ù����ɫ����
		Person person = personDer.PerConstruct(new ManBuilder());
		System.out.println(person.getHead());
		System.out.println(person.getBody());
		System.out.println(person.getFootAndhand());
		
	}
}
