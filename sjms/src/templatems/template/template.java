package templatems.template;

public abstract class template {

	public void process(){
		//���ȵ���
		first();
		//�м����
		middle();
		//������
		last();
	}

	private void first() {
		// TODO Auto-generated method stub
		System.out.println("��ʼ");
	}

	private void last() {
		// TODO Auto-generated method stub
		System.out.println("����");
	}

	abstract void middle();
}
