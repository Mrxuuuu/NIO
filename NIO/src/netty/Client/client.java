package netty.Client;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

public class client {

	/**
	 * 1.����ͻ����� 2.boss�̼߳�����worker��д 3.����NIO���� 4.���ùܵ�����
	 */

	public static void main(String[] args) {
		// ����ͻ�����
		ClientBootstrap Bootstrap = new ClientBootstrap();
		// �����߳�
		Executor bossExecutor = Executors.newCachedThreadPool();
		Executor workerExecutor = Executors.newCachedThreadPool();
		// ���ù���
		Bootstrap.setFactory(new NioClientSocketChannelFactory(bossExecutor, workerExecutor));
		// ���ùܵ�
		Bootstrap.setPipelineFactory(new ChannelPipelineFactory() {

			@Override
			public ChannelPipeline getPipeline() throws Exception {
				// TODO Auto-generated method stub
				// ����һ���ܵ�
				ChannelPipeline Pipeline = Channels.pipeline();
				Pipeline.addLast("decoder", new StringDecoder());
				Pipeline.addLast("encoder", new StringEncoder());
				Pipeline.addLast("hiHandler", new hiHandler());
				return Pipeline;
			}
		});
		// ��÷��������
		ChannelFuture connect = Bootstrap.connect(new InetSocketAddress(10201));
		// �������ͨ��
		Channel channel = connect.getChannel();
		System.out.println("�����ѽ������");

		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("������...");
			channel.write(in.next());
		}

	}
}
