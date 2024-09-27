package com.litongjava.tio.websocket.common;

import java.util.concurrent.ThreadLocalRandom;

import com.litongjava.aio.AioId;
import com.litongjava.tio.utils.hutool.Snowflake;


public class WebsocketSnowflakeId implements AioId {
  private Snowflake snowflake;

  public WebsocketSnowflakeId() {
    snowflake = new Snowflake(ThreadLocalRandom.current().nextInt(1, 30), ThreadLocalRandom.current().nextInt(1, 30));
  }

  public WebsocketSnowflakeId(long workerId, long datacenterId) {
    snowflake = new Snowflake(workerId, datacenterId);
  }

  /**
   * @return
   * @author tanyaowu
   */
  @Override
  public String id() {
    return snowflake.nextId() + "";
  }
}
