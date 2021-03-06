/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.samples.testing.externalgateway;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Gary Russell
 * @since 2.0.2
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/spring/integration/04-externalgateway/*.xml"); 
		System.out.println("Please enter zip");
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String zip = console.readLine().trim();
		WeatherAndTraffic weatherAndTraffic = context.getBean("wat", WeatherAndTraffic.class);
		List<String> result = weatherAndTraffic.getByZip(zip);
		System.out.println(result.get(0) + "\r\n" + result.get(1) + "\r\n");
		context.close();
		System.exit(0);
	}
}
