package com.revature.challenges;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SumDigitsInStringTest {

	private static SumDigitsInString sut;
	
	@Parameter(0)
	public String candidateValue;
	
	@Parameter(1)
	public int expectedResult;
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] testData = new Object[][] {{"aaa3bbb2ccc1d", 6}, {"3jk3j3h5", 14}, {"33ljk39", 18}, {"abc1def3hijk6lmno7", 17}};
		return Arrays.asList(testData);
	}
	
	@BeforeClass
	public static void setUp() {
		sut = new SumDigitsInString();
	}
	
	@Test
	public void sumDigitsInStringTest() {
		int actualResult = sut.sumDigitsInString(candidateValue);
		Assert.assertEquals(expectedResult, actualResult);
	}
	
}
