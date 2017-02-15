package com.satish.kafka.producer;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class ProducerProperties {


	/*private String bootstrapServers;

	private Object keySerializer;
	
	private Object valueSerializer;
	
	private String acks;
	
	private int bufferMemory;
	
	private String compressionType;
	
	private int retries;
	
	private int batchSize;
	
	private String clientId;
	
	private int connectionsMaxIdleMs;
	
	private int lingerMs;
*/
	private String topciName;
	
	private Map<String,Object> producerConfig;
	
	
	

	/**
	 * @return the producerConfig
	 */
	public Map<String, Object> getProducerConfig() {
		return producerConfig;
	}

	/**
	 * @param producerConfig the producerConfig to set
	 */
	public void setProducerConfig(Map<String, Object> producerConfig) {
		this.producerConfig = producerConfig;
	}

	/**
	 * @return the topciName
	 */
	public String getTopciName() {
		return topciName;
	}

	/**
	 * @param topciName the topciName to set
	 */
	public void setTopciName(String topciName) {
		this.topciName = topciName;
	}
	
	
	
	
}
