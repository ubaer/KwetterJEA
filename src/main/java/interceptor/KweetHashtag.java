package main.java.interceptor;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * Created by Kevin on 28-3-2017.
 */
@Retention(RUNTIME)
@Target({ METHOD, TYPE })
@InterceptorBinding
public @interface KweetHashtag {
}
