package com.api.feignclient.constants;

public class ClientConstants {

	private ClientConstants() {}

	public final class FeignClientConfig {
		private FeignClientConfig() {}
		public static final String FEIGNCLIENT_NAME = "customer";
		public static final String FEIGNCLIENT_URL = "${url.mockapi}";
	}

	public final class FeignClientEndpoints {
		private FeignClientEndpoints() {}
		public static final String V1_CUSTOMERS_CUSTOMER = "/v1/customers/customer";
	}

}
