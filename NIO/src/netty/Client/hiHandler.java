package netty.Client;

import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

//�̳��Լ򵥵Ĺܵ�������
public class hiHandler extends SimpleChannelHandler{

	/**
	 * ������Ϣ
	 */
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.messageReceived(ctx, e);
		System.out.println("messageReceived");
	}
	
	/**
	 *�����쳣
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, e);
		System.out.println("exceptionCaught");
	}
	
	/**
	 * ����������
	 */
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelConnected(ctx, e);
		System.out.println("channelConnected");
	}
	
	/**
	 * ���ӶϿ�
	 */
	@Override
	public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelDisconnected(ctx, e);
		System.out.println("channelDisconnected");
	}
	
	/**
	 * ���ӹر�
	 */
	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelClosed(ctx, e);
		System.out.println("channelClosed");
	}
}
