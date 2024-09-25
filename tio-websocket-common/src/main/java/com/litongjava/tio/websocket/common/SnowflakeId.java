package com.litongjava.tio.websocket.common;

import java.util.concurrent.ThreadLocalRandom;

import com.litongjava.aio.AioId;
import com.litongjava.tio.utils.hutool.Snowflake;


public class SnowflakeId implements AioId {
  private Snowflake snowflake;

  public SnowflakeId() {
    snowflake = new Snowflake(ThreadLocalRandom.current().nextInt(1, 30), ThreadLocalRandom.current().nextInt(1, 30));
  }

  public SnowflakeId(long workerId, long datacenterId) {
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
