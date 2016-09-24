package Trie;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

import List.NList;

public class NTrieTest {
	@Test
	public void addTest() {
		NTrie t = new NTrie();
		
		assertEquals("Expected empty trie", new Boolean(true), t.isEmpty());
		assertEquals("Expected successful add", new Boolean(true), t.add("nana"));
		assertEquals("Expected unsuccessful add", new Boolean(false), t.add("nana"));
		assertEquals("Expected size of 1", new Integer(1), new Integer(t.size()));
		assertEquals("Expected not empty trie", new Boolean(false), t.isEmpty());
	}
	
	@Test
	public void addContains() {
		NTrie t = new NTrie();
		
		assertEquals("Expected successful add", new Boolean(true), t.add("helloworld"));
		assertEquals("Expected successful add", new Boolean(true), t.add("he"));
		assertEquals("Expected successful add", new Boolean(true), t.add("hello"));
		assertEquals("Expected to find helloworld", new Boolean(true), t.contains("helloworld"));
		assertEquals("Expected to find he", new Boolean(true), t.contains("he"));
		assertEquals("Expected to find hello", new Boolean(true), t.contains("hello"));
		assertEquals("Didnt expect to find helloworl", new Boolean(false), t.contains("helloworl"));
		assertEquals("Expected size of 3", new Integer(3), new Integer(t.size()));
	}
	
	@Test
	public void addAllRemove() {
		Collection<String> collection = new NList<String>();
		collection.add("pokemon");
		collection.add("powerranger");
		collection.add("power");
		collection.add("harrypotter");
		collection.add("hairy");
		collection.add("harrypotterandtheorderofthephoenix");
		
		NTrie t = new NTrie();
		assertEquals("Expected successful add", new Boolean(true), t.addAll(collection));
		
		assertEquals("Expected to find power", new Boolean(true), t.contains("power"));
		assertEquals("Expected to find word", new Boolean(true), t.contains("harrypotterandtheorderofthephoenix"));
		assertEquals("Expected size of 6", new Integer(6), new Integer(t.size()));
		assertEquals("Expected word to have been removed", new Boolean(true), t.remove("harrypotterandtheorderofthephoenix"));
		assertEquals("Didnt expect word to have been removed", new Boolean(false), t.remove("harrypotterandtheorderofthephoenix"));
		assertEquals("Expected to not find word", new Boolean(false), t.contains("harrypotterandtheorderofthephoenix"));
		assertEquals("didnt expect word removal", new Boolean(false), t.remove("hairym"));
		assertEquals("Expected word to have been removed", new Boolean(true), t.remove("powerranger"));
		assertEquals("Expected size of 4", new Integer(4), new Integer(t.size()));
		
		
	}
}
