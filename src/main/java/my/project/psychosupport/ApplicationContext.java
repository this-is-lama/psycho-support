package my.project.psychosupport;

import my.project.psychosupport.config.Config;
import my.project.psychosupport.config.Instance;
import my.project.psychosupport.logging.Logged;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ApplicationContext {

	private final Map<Class<?>, Object> instances = new HashMap<>();

	public ApplicationContext() throws InvocationTargetException, IllegalAccessException {
		Reflections reflections = new Reflections("my.project.psychosupport.config");
		final var configs = reflections.getTypesAnnotatedWith(Config.class)
				.stream()
				.map(type -> {
					try {
						return type.getDeclaredConstructor().newInstance();
					} catch (InstantiationException
							 | IllegalAccessException
							 | InvocationTargetException
							 | NoSuchMethodException e) {
						throw new RuntimeException(e);
					}
				})
				.toList();
		for (Object config : configs) {
			Method[] methods = config.getClass().getMethods();
			List<Method> methodList =
					Arrays.stream(methods)
					.filter(method -> method.isAnnotationPresent(Instance.class))
					.toList();
			for (Method method : methodList) {
				instances.put(method.getReturnType(), method.invoke(config));
			}
		}
	}

	
	public <T> T getInstance(Class<T> type) {
		return (T) Optional.ofNullable(instances.get(type))
				.orElseThrow();
	}
}
