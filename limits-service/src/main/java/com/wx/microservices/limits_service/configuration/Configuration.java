package com.wx.microservices.limits_service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configuration {

		int minimum;
		int maximum;
		public int getMinimum() {
			return minimum;
		}
		public void setMinimum(int minimum) {
			this.minimum = minimum;
		}
		public int getMaximum() {
			return maximum;
		}
		public void setMaximum(int maximum) {
			this.maximum = maximum;
		}
		
}
