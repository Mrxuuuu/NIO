package spqms;

public class adapter implements JP_110VInterface{

	/**
	 * ����������ʵ���ձ���ѹ�Ľӿ�
	 * ͨ������ע���й���ѹ�ӿ�
	 * ���ձ���ѹ�Ľӿ�ʵ���е����й���ѹ�ӿڵķ���
	 * ʵ��������ת��
	 * 
	 */
	private CN_220VInterface CN_220VInterface;
	
	public adapter(CN_220VInterface CN_220VInterface)
	{
		this.CN_220VInterface=CN_220VInterface;
	}
	
	
	@Override
	public void connect() {
		// TODO Auto-generated method stub
		CN_220VInterface.connect();
	}

	
}
