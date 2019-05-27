package com.xz.fujie;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/dynamic/{uname}")
public class Dynamic {
	@Resource
	private Dynamic webcomment;

	// ��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�
	private static int onlineCount = 0;
	// concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��MyWebSocket������Ҫʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ�������ʹ��Map����ţ�����Key����Ϊ�û���ʶ
	// private static CopyOnWriteArraySet<Webcomment> webSocketSet = new
	// CopyOnWriteArraySet<Webcomment>();
	// �̰߳�ȫ��Map
	private static ConcurrentHashMap<String, Session> webSocketMap = new ConcurrentHashMap<String, Session>();// �������ӵķ���
	
	@OnOpen
	public void onOpen(Session session, @PathParam("uname") String uname) {
		/*
		 * ��ȡ��/websocket��ʼ���������ӣ����ڻ�ȡuname��***=***�Ĳ��� String uri =
		 * session.getRequestURI().toString();
		 */
		
		if(webSocketMap.get(uname)!=null) {
			
		}else {
			webSocketMap.put(uname, session);
			addOnlineCount(); // ��������
		}
		
		System.out.println(uname + "����");
		/*
		 * Gson gson=new Gson(); String json = gson.toJson("����������");
		 * sendMessage(uname,);
		 */
		System.out.println("�������Ӽ��룡��ǰ��������Ϊ" + getOnlineCount());
	}

	/**
	 * ���ӹرյ��õķ���
	 */
	@OnClose
	public void onClose(Session session) {
		Map<String, String> map = session.getPathParameters();
		webSocketMap.remove(map.get("uname")); // ��set��ɾ��
		for (String user : webSocketMap.keySet()) {
			System.out.println(user);
		}
		subOnlineCount(); // ��������
		System.out.println("��һ���ӹرգ���ǰ��������Ϊ" + getOnlineCount());
	}

	/**
	 * �յ��ͻ�����Ϣ����õķ���
	 * 
	 * @param message �ͻ��˷��͹�������Ϣ
	 * @param session ��ѡ�Ĳ���
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("���Կͻ��˵���Ϣ:" + message);
		/*
		 * String sendUserno = message.split("[|]")[1]; String sendMessage =
		 * message.split("[|]")[0];
		 */
		//String now = getNowTime();
		try {
			if (webSocketMap.get(message)!= null) {
				System.out.println("����");
				//((Dongtaitongxing) webSocketMap.get("С��")).sendMessage(message,webSocketMap.get("С��"));
				sendMessage(message,webSocketMap.get(message));
			} else {
				System.out.println("��ǰ�û�������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��������ʱ����
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("��������");
		error.printStackTrace();
	}

	public void sendMessage(String message, Session session) throws IOException {
		if (session.isOpen()) {
			session.getAsyncRemote().sendText(message);
		}
		// this.session.getAsyncRemote().sendText(message);
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		Dynamic.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		Dynamic.onlineCount--;
	}
}
