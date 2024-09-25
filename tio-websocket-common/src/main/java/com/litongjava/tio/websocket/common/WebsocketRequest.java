package com.litongjava.tio.websocket.common;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tanyaowu
 * 2017年7月30日 上午10:09:46
 */
public class WebsocketRequest extends WebsocketSocketPacket {
	private static final Logger log = LoggerFactory.getLogger(WebsocketRequest.class);

	private static final long serialVersionUID = -3361865570708714596L;

	public static WebsocketRequest fromText(String text, String charset) {
		WebsocketRequest wsRequest = new WebsocketRequest();
		try {
			wsRequest.setBody(text.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			log.error(e.toString(), e);
		}
		wsRequest.setWsEof(true);
		wsRequest.setWsOpcode(Opcode.TEXT);
		return wsRequest;
	}

	public static WebsocketRequest fromBytes(byte[] bytes) {
		WebsocketRequest wsRequest = new WebsocketRequest();
		wsRequest.setBody(bytes);
		wsRequest.setWsEof(true);
		wsRequest.setWsOpcode(Opcode.BINARY);
		return wsRequest;
	}
}
