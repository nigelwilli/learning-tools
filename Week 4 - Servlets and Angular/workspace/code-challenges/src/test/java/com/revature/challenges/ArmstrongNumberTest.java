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
public class ArmstrongNumberTest {
	
	private static ArmstrongNumber sut;
	
	@Parameter(0)
	public int candidateValue;
	
	@Parameter(1)
	public boolean expectedResult;
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] testData = new Object[][] {{0, true}, {9, true}, {152, false}, {153, true}, {1624, false}, {1634, true}};
		return Arrays.asList(testData);
	}
	
	@BeforeClass
	public static void setUp() {
		sut = new ArmstrongNumber();
	}
	
	@Test
	public void isArmstrongNumberTest() {
		boolean actualResult = sut.isArmstrongNumber(candidateValue);
		Assert.assertEquals(expectedResult, actualResult);
	}
	
}
