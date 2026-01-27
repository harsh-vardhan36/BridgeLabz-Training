package com.reflections.advance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggingProxyDemo {

	// 🔹 Interface
	interface Greeting {
		void sayHello(String name);
	}

	// 🔹 Real Implementation
	static class GreetingImpl implements Greeting {
		@Override
		public void sayHello(String name) {
			System.out.println("Hello, " + name + "!");
		}
	}

	// 🔹 Invocation Handler (Proxy Logic)
	static class LoggingHandler implements InvocationHandler {

		private final Object target;

		LoggingHandler(Object target) {
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// Log before method execution
			System.out.println("Invoking method: " + method.getName());

			// Call actual method
			return method.invoke(target, args);
		}
	}

	public static void main(String[] args) {

		Greeting realObject = new GreetingImpl();

		// Create dynamic proxy
		Greeting proxyObject = (Greeting) Proxy.newProxyInstance(Greeting.class.getClassLoader(),
				new Class[] { Greeting.class }, new LoggingHandler(realObject));

		// Invoke method via proxy
		proxyObject.sayHello("Anuj");
	}
}