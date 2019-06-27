package test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.MessageFormat;

import org.junit.Test;

public class Demo1 {
	@Test
	public void fun1(){
		String s = MessageFormat.format("{0}或{1}错误", "用户名","密码");
		System.out.println(s);
	}
	@Test
	public void fun2(){
		System.out.println(2.0-1.1);
	}
	
	
	@Test
	public void fun3(){
		BigInteger b = BigInteger.valueOf(1);
		for(int i = 1 ;i<=100;i++){
			BigInteger bi  = BigInteger.valueOf(i);
			b=b.multiply(bi);
		}
		System.out.println(b);
	}
	
	@Test
	public void fun4(){
		BigDecimal bi = BigDecimal.valueOf(2.0);
		BigDecimal bi1 = BigDecimal.valueOf(1.1);
		BigDecimal bi2 = bi.subtract(bi1);
		System.out.println(bi2);
	}
	
	@Test
	public void fun5(){
		BigDecimal d1  = new BigDecimal("0");
		for(int i = 0 ;i<100;i++){
			BigDecimal d2 = new BigDecimal(i+"");
			d1 = d1.add(d2);
		}
		System.out.println(d1.doubleValue());
	}
	@Test
	public void fun6(){
		System.out.println("hello");
	}
	
	
	
	
	
	
	
	
}
