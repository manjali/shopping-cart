package com.assessment.skuservice;

import com.assessment.skuservice.entity.CustomerInfo;
import com.assessment.skuservice.entity.OrderInfo;
import com.assessment.skuservice.service.impl.OrderServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SkuServiceApplicationTests extends TestCase {

	@Test
	public void contextLoads() {
	}

	private OrderInfo orderInf;

	private WireMockServer wireMockServer;
	@Before
	public void setUp() throws Exception {
		wireMockServer = new WireMockServer(8002);
		wireMockServer.start();
		super.setUp();
		String orderPayload = "{\n" +
				" \"orderId\": \"OOD000\",\n" +
				"\"customerId\": \"001\",\n" +
				"\"stockunits\": [{\n" +
				"\"id\": \"A123\",\n" +
				"\"nameofItem\": \"Basket\",\n" +
				"\"price\": 100,\n" +
				"\"numberOfItems\": 1}]\n" +
				"}\n" +
				"}";
		CustomerInfo cInfo = new CustomerInfo("001", "Albert",4123432,"Shepparton");
		ObjectMapper objectMapper = new ObjectMapper();
		OrderInfo orderInf = objectMapper.readValue(orderPayload, OrderInfo.class);
		stubFor(get(urlEqualTo("/customer/viewCustomerId=001"))
				.willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBody(cInfo.toString())));

	}

	@After
	public void destroy(){
		wireMockServer.stop();
	}

	@Autowired
	private OrderServiceImpl orderService;

	@Test
	public void testNewOrderPlacement(){
		try {
			String addedOrder = orderService.addOrder(orderInf);
			assertTrue(addedOrder.equals("Success"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
