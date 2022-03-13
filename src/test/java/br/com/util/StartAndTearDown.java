package br.com.util;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;

public interface StartAndTearDown {
	
	@After
	public void tearDown();
	
	@Before
	public void before() throws MalformedURLException;
}
