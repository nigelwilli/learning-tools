package com.revature.challenges;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WordCounterTest {

	private static WordCounter sut;

	@BeforeClass
	public static void setUp() {
		sut = new WordCounter();
	}

	@Test
	public void wordCountTest1() {
		Map<String, Integer> actualResult = sut.countWords(new String[]{"a", "b", "c", "d", "a"});
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("a", 2));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("b", 1));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("c", 1));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("d", 1));
	}
	
	@Test
	public void wordCountTest2() {
		Map<String, Integer> actualResult = sut.countWords(new String[]{"the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog"});
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("the", 2));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("quick", 1));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("brown", 1));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("fox", 1));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("jumped", 1));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("over", 1));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("lazy", 1));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("dog", 1));
	}
	
	@Test
	public void wordCountTest3() {
		Map<String, Integer> actualResult = sut.countWords(new String[]{"d", "aa", "b", "b", "c", "cc", "d", "b", "aa"});
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("aa", 2));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("b", 3));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("c", 1));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("cc", 1));
		Assert.assertThat(actualResult, IsMapContaining.hasEntry("d", 2));
	}

}
