package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
	private Selector selector;
	
	//1.��ʼ������
	public void initServer(int port) throws IOException
	{
		
		//1.�Ȼ��һ��ͨ��
		ServerSocketChannel socketChannel = ServerSocketChannel.open();
//		���÷�����
		socketChannel.configureBlocking(false);
		//��ͨ���󶨵���Ӧ�˿�
		socketChannel.socket().bind(new InetSocketAddress(port));
		//2.���һ��ͨ��������
		selector = Selector.open();
		//3.ע���ͨ����ͨ��������
//		SelectionKey.OP_ACCEPT  ���¼�����ʱ��ͨ���������᷵�أ�����һֱ����
		socketChannel.register(selector, SelectionKey.OP_ACCEPT);
	}

	//2.�������
	public void serverlisten() throws IOException{
		//����ѭ������
		 while(true)
		 {//�������¼��������
		  selector.select();
		  //ʹ�õ�������ѯ����
		  Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
		  while(iterator.hasNext())
		  {
			 //�Ȼ�ȡselectionKey
			  SelectionKey selectionKey = iterator.next();
//			  ���Ƴ��Ѿ����ʵ�
			  iterator.remove();
			  //����selectionKey����������
			  handler(selectionKey);
		  }
		 }
	}
	
	////3.��������
	public void handler(SelectionKey key) throws IOException {
//		 3.1:�����������
		if(key.isAcceptable())
		{//������ܵ����ȴ����������
			//��ȡͨ����Ϣ
			ServerSocketChannel server = (ServerSocketChannel) key.channel();
			//��ȡ�ͻ�������ͨ��
			SocketChannel channel = server.accept();
			channel.configureBlocking(false);//���÷�����
			//���ö�Ȩ��
			channel.register(selector, SelectionKey.OP_READ);	
		}
		if(key.isReadable()) {
//			3.2�����������
			//
			SocketChannel channel = (SocketChannel) key.channel();
			//����������
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int read = channel.read(buffer);
			//if
			if(read>0)
			{
				//
				byte[] bs = buffer.array();
				String msg=new String(bs);
				System.out.println("�յ���Ϣ��"+msg);
				
				ByteBuffer src=ByteBuffer.wrap(bs);
				channel.write(src);
			}
			else {
				System.out.println("û�з����ѹر�");
				key.cancel();
			}
		}
	}
	

//  
	public static void main(String[] args) throws IOException {
		NIOServer nIOServer=new NIOServer();
		nIOServer.initServer(10101);
		nIOServer.serverlisten();
	
	}
}
