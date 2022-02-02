package com.challenge.arrayProducts;
import com.challenge.arrayProducts.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MongodbandspringbootApplicationTests {
	static Logger log = LogManager.getLogger(MongodbandspringbootApplicationTests.class);

	private String url;
	private static long startTime = System.nanoTime();

	@LocalServerPort
	private int port;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	void init(){
		url = String.format("http://localhost:%d/products/", port);
	}

	@BeforeEach
	public void beforeEachTests(){
		log.info("Starting test");
	}

	@BeforeAll
	public static void beforeAllTests(){
		log.info("Starting all tests");
	}

	@AfterAll
	public static void afterAllTests(){
		log.info("All tests were executed with a duration of {} ms", TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));
	}

	@Test
	public void createProduct(){
		String urlTest = url;
		Product postProduct = this.restTemplate.postForObject(urlTest, (new Product("Butter", 320, 2)), Product.class);
		Assert.notNull(postProduct, "Product is null");
		Assert.isTrue(postProduct.getId() == 2, "Id error");
		Assert.isTrue(postProduct.getTitle().equals("Butter"), "Product name error");
	}


	@Test
	public void getAllProducts(){
		String urlTest = url;

		List<Product> productListResult = this.restTemplate.getForObject(urlTest, List.class);

		Assert.notNull(productListResult, "Null Product List");
		Assert.notEmpty(productListResult, "Empty product List");

	}

	@Test
	public void getProductById(){
		String urlTest = String.format("%s%s", url, "0");
		Product productResult = this.restTemplate.getForObject(urlTest,Product.class);

		Assert.notNull(productResult, "Null product" );
		Assert.isTrue(productResult.getId() == 0, "Id error");
		Assert.isTrue(productResult.getTitle().equals("Milk"), "Product name error");
	}

	@Test
	public void getAllProductsHttp() throws IOException{
		String urlTest = url;
		HttpUriRequest request = new HttpGet(urlTest);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		String content = EntityUtils.toString((httpResponse.getEntity()));

		List<Product> productListResult = objectMapper.readValue(content, List.class);

		Assert.notNull(productListResult, "Null list");
		Assert.notEmpty(productListResult, "Empty list");
	}

	@Test
	public void getProductByIdHttp() throws IOException{
		String urlTest = String.format("%s%s", url, "0");
		HttpUriRequest request = new HttpGet(urlTest);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		String content = EntityUtils.toString((httpResponse.getEntity()));
		Product productResult = objectMapper.readValue(content, Product.class);

		Assert.notNull(productResult, "Null product");
		Assert.isTrue(productResult.getId() == 0, "Id error");
		Assert.isTrue(productResult.getTitle().equals("Milk"), "Product name error");
	}
}
