package com.sin90lzc.util.str;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReplacementUtilTest {
	
	private Cat cat=null; 
	
	private String srcText=null;
	
	private String trueText=null;
	
	@Before
	public void init(){
		 cat=new Cat("tim",29,new Cat("father",56),new Cat("mother",57)); 
		 srcText="��һֻè���������ֽ���${cat.name},�������Ѿ���${cat.age}������ˣ����ĸ��׽�${cat.father.name},����ĸ�׽�${cat.mother.name}!";
		 trueText="��һֻè���������ֽ���tim,�������Ѿ���29������ˣ����ĸ��׽�father,����ĸ�׽�mother!";
	}
	
	@Test
	public void testReplace(){
		Map<String,Object> vars=new HashMap<String,Object>();
		vars.put("cat", cat);
		String resultText=ReplacementUtil.replace(srcText, vars);
		Assert.assertEquals(trueText, resultText);
	}
	
	public static class Cat{
		private String name;
		private int age;
		private Cat father;
		private Cat mother;
		
		Cat(String name,int age){
			this.name=name;
			this.age=age;
		}
		
		Cat(String name,int age,Cat father,Cat mother){
			this.name=name;
			this.age=age;
			this.father=father;
			this.mother=mother;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Cat getFather() {
			return father;
		}

		public void setFather(Cat father) {
			this.father = father;
		}

		public Cat getMother() {
			return mother;
		}

		public void setMother(Cat mother) {
			this.mother = mother;
		}
	}
}
