package com.stream.exception;


@FunctionalInterface
public interface CheckedExceptionHandlerConsumer<Target, ExpObj extends Exception> {

	void accept(Target target) throws ExpObj;
}
