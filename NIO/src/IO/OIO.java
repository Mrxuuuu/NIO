package IO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OIO {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();

		try {
//			ServerSocket��10101�˿ڼ���
			ServerSocket server = new ServerSocket(10101);
			System.out.println("���ӵ�������");

			while (true) {
				// �Ӷ˿ڼ�����socket����ȡ��socket����
				Socket accept = server.accept();
				// ����socket��Ϣ
				executorService.execute(new Runnable() {

					@Override
					public void run() {
						// ���߳�����¼���
						// TODO Auto-generated method stub
						try {
							handler(accept);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void handler(Socket accept) throws IOException {
		// TODO Auto-generated method stub
		// ��socket���װ���ֽ�����Ϣ
		InputStream is = accept.getInputStream();
		// �����ֽ�����
		byte[] by = new byte[1024];
		//
		while (true) {
			//
			int len = is.read(by);
			// ����������һ���ֽ�
			if (len != -1) {
				System.out.println(new String(by, 0, len));
			}

		}

	}
}
