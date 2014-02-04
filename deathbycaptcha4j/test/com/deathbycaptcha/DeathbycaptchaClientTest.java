package com.deathbycaptcha;

import static org.junit.Assert.*;

import org.junit.Test;

import com.deathbycaptcha.DeathbycaptchaClient.Endpoint;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

public class DeathbycaptchaClientTest {
	private static final HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
	
	private static final Login login = new Login("XXX", "XXX"); // TODO: use real values

	@Test
	public void testSubmitNoLogin() throws Exception {
		final DeathbycaptchaClient client = new DeathbycaptchaClient(requestFactory, 10000, 10000, Endpoint.HTTP, null);
		try {
			client.submit(null);
			fail("Expected exception");
		} catch (NotLoggedInException e) {
			// Expected exception
		}
	}
	
	@Test
	public void testSubmitNoCaptcha() throws Exception {
		final DeathbycaptchaClient client = new DeathbycaptchaClient(requestFactory, 10000, 10000, Endpoint.HTTP, login);
		try {
			client.submit(null);
			fail("Expected exception");
		} catch (InvalidCaptchaException e) {
			// Expected exception
		}
	}
	
	@Test
	public void testSubmit() throws Exception {
		final DeathbycaptchaClient client = new DeathbycaptchaClient(requestFactory, 10000, 10000, Endpoint.HTTP, login);

		CaptchaStatus status = client.submit(TestCaptcha.LOVE);
		assertNotNull(status.captcha);
		while (status.text.isEmpty()) {
			status = client.getStatus(status.captcha);
		}
		assertEquals("love", status.text);
		assertTrue(status.is_correct);
	}
	
	@Test
	public void testHttpsGetSuccess() throws Exception {
		final DeathbycaptchaClient client = new DeathbycaptchaClient(requestFactory, 10000, 10000, Endpoint.HTTPS, null);
		final CaptchaStatus captchaStatus = client.getStatus(3846475L);
		assertEquals(0, captchaStatus.status.intValue());
		assertEquals(null, captchaStatus.error);
		assertEquals(3846475L, captchaStatus.captcha.longValue());
		assertEquals("6QUYBC", captchaStatus.text);
		assertTrue(captchaStatus.is_correct);
	}
	
	@Test
	public void testHttpGetSuccess() throws Exception {
		final DeathbycaptchaClient client = new DeathbycaptchaClient(requestFactory, 10000, 10000, Endpoint.HTTP, null);
		final CaptchaStatus captchaStatus = client.getStatus(3846475L);
		assertEquals(0, captchaStatus.status.intValue());
		assertEquals(null, captchaStatus.error);
		assertEquals(3846475L, captchaStatus.captcha.longValue());
		assertEquals("6QUYBC", captchaStatus.text);
		assertTrue(captchaStatus.is_correct);
	}
	
	@Test
	public void testGetNotFound() throws Exception {
		final DeathbycaptchaClient client = new DeathbycaptchaClient(requestFactory, 10000, 10000, Endpoint.HTTP, null);
		try {
			client.getStatus(80L);
			fail("Expected exception.");
		} catch (DeathbycaptchaException e) {
			// Expected exception
			assertNull(e.error.error);
			assertEquals(0, e.error.status.intValue());
		}
	}
	
	@Test
	public void testReportNoLogin() throws Exception {
		final DeathbycaptchaClient client = new DeathbycaptchaClient(requestFactory, 10000, 10000, Endpoint.HTTP, null);
		try {
			client.report(3846475L);
			fail("Expected exception.");
		} catch (NotLoggedInException e) {
			// Expected exception
		}
	}
}
