package com.stream.exception;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Exception handling in stream pipeline
 * Handle generic exception and compile time exception by using Consumer interface's accept method
 * 
 */
public class StreamExceptionHandling {
	
	//Step-2
	public static void handleException(String s) {
		try {
			System.out.println(Integer.parseInt(s));
		} catch(NumberFormatException ne) {
			System.out.println(ne.getClass().getName() + " : " + ne.getMessage());
		}
	}
	
	//Step-3 Handle only specific exception
	public static Consumer<String> handleExceptionIfAny(Consumer<String> payload) {
		return obj -> {
			try {
				payload.accept(obj);
			} catch (Exception ne) {
				System.out.println(ne.getClass().getName() + " : " + ne.getMessage());
			}
		};
	}
	
	//Step-4 Handle generic runtime exception
	public static <Target, ExObj extends Exception> Consumer<Target> handleGenericException(
			Consumer<Target> targetConsumer, Class<ExObj> exObjClass) {
		return obj -> {
			try {
				targetConsumer.accept(obj);
			} catch (Exception ex) {
				try {
					ExObj exObj = exObjClass.cast(ex);
					System.out.println(exObj.getClass().getName() + " : " + exObj.getMessage());
				} catch (ClassCastException cex) {
					throw cex;
				}
			}
		};
	}

	//Step-5 Handler check exception
	public static <Target> Consumer<Target> handleCheckedExceptionConsumer(
			CheckedExceptionHandlerConsumer<Target, Exception> handler) {
		return obj -> {
			try {
				handler.accept(obj);
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		};
	}
	
	public static void main(String[] args) {

		List<String> list = Arrays.asList("10","12","xyz");
		
		//Step-1  This is not good approach to handle exception in stream pipeline
		/*list.stream().forEach(e -> {
			try {
				System.out.println(Integer.parseInt(e));
			} catch(NumberFormatException ne) {
				System.out.println(ne.getClass().getName() + " : " + ne.getMessage());
			}
		});*/
		
		//Step-2  This is not good approach to handle exception in stream pipeline
		list.stream().forEach(StreamExceptionHandling::handleException);
		
		//Step-3 This not generic code to handle exception
		list.stream().forEach(handleExceptionIfAny(s -> System.out.println(Integer.parseInt(s))));
		
		//Step-4
		list.stream().forEach(handleGenericException(s -> System.out.println(Integer.parseInt(s)), NumberFormatException.class));

		//Step-5
		//Handle exception for checked exception
		list.forEach(handleCheckedExceptionConsumer(i -> { Thread.sleep(1000); System.out.println("Hi!");})); 
		
	}

}
