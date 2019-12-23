package common.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  //в режиме выполнения программы
@Target({ElementType.TYPE})         // anotation на class
public @interface PartialUrl {

    String value();
}
