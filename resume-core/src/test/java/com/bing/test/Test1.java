package com.bing.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1(){
		Map<String, Integer> map = new HashMap<>();
		String str = "dfsasoihfkshfsgfsgfjsgfsd";
		for(String strChar: str.split("")){
			Integer count = map.get(strChar);
			if(null == count){
				map.put(strChar, 1);
			}else{
				map.put(strChar, ++count);
			}
		}
		
		System.out.println(map);
		
	}
}
