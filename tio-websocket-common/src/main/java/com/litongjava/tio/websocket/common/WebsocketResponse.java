package com.litongjava.tio.websocket.common;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tanyaowu
 * 2017年7月30日 上午10:09:59
 */
public class WebsocketResponse extends WebsocketSocketPacket {
	private static Logger log = LoggerFactory.getLogger(WebsocketResponse.class);

	private static final long serialVersionUID = 963847148301021559L;

	public static WebsocketResponse fromText(String text, String charset) {
		WebsocketResponse wsResponse = new WebsocketResponse();
		try {
			wsResponse.setBody(text.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			log.error(e.toString(), e);
		}
		wsResponse.setWsOpcode(Opcode.TEXT);
		return wsResponse;
	}

	public static WebsocketResponse fromBytes(byte[] bytes) {
		WebsocketResponse wsResponse = new WebsocketResponse();
		wsResponse.setBody(bytes);
		wsResponse.setWsOpcode(Opcode.BINARY);
		return wsResponse;
	}
}
