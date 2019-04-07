package com.summer.graduate.webSocket;


import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName com.summer.graduate.webSocket.WebSocketChat
 * @Description TODO
 * @Author summer
 * @Date 2019/4/3 9:44
 * @Version 1.0
 **/

@ServerEndpoint(value="/chat/{username}",configurator = SpringConfigurator.class)
public class WebSocket {
	//静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;

	//concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	private static ConcurrentHashMap<String, WebSocket> webSocketSet = new ConcurrentHashMap<>();

	//与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	/**
	 * 连接建立成功调用的方法
	 *
	 * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public void onOpen(@PathParam("username")String username,  Session session) {
		this.session = session;
		addOnlineCount();           //在线数加1

		System.out.println(username + "上线了");
		webSocketSet.put(username, this);
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		webSocketSet.remove(this);  //从set中删除
		subOnlineCount();           //在线数减1
		System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
	}

	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message 客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(@PathParam("username")String username, String message) {

		//保存聊天记录

		sendHttp(username, message);

		System.out.println("来自客户端的消息:" + username + ": " + message);

		try {
			if (!username.equals("server")) {
				webSocketSet.get("server").sendMessage(message);
			} else {
				for (WebSocket item : webSocketSet.values()) {
					item.sendMessage(message);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 发生错误时调用
	 *
	 * @param error
	 */
	@OnError
	public void onError(Throwable error) {
		System.out.println("发生错误");
		error.printStackTrace();
	}

	/**
	 * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
	 *
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}


	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocket.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocket.onlineCount--;
	}

	private static void sendHttp(String username, String message) {
		try {
			CloseableHttpClient client = null;
			CloseableHttpResponse response = null;
			try {
				// 创建一个提交数据的容器
				List<BasicNameValuePair> parames = new ArrayList<>();
				parames.add(new BasicNameValuePair("username", username));
				parames.add(new BasicNameValuePair("message", message));

				HttpPost httpPost = new HttpPost("http://localhost:8080/wechat_war_exploded/sentMessage.do");
				httpPost.setEntity(new UrlEncodedFormEntity(parames, "UTF-8"));

				client = HttpClients.createDefault();
				response = client.execute(httpPost);
				HttpEntity entity = response.getEntity();
				String result = EntityUtils.toString(entity);
				System.out.println(result);
			} finally {
				if (response != null) {
					response.close();
				}
				if (client != null) {
					client.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
