package priv.just1984.deep.in.java.basic.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-19 16:00
 */
public class GenericDemo {

    public static void main(String[] args) {
        Type[] genericInterfaces = UserRepository.class.getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType parameterizedInterface = (ParameterizedType) genericInterface;
                System.out.println(parameterizedInterface.getRawType().getTypeName());
                System.out.println(parameterizedInterface.getActualTypeArguments()[0].getTypeName());
            }
        }
    }

    private class UserRepository implements Repository<User> {

        @Override
        public User get() {
            return new User(1L, "JUST1984");
        }

    }

    private interface Repository<T> {

        T get();

    }

    @AllArgsConstructor
    @Data
    private class User implements Comparable<User> {

        private Long id;

        private String name;

        @Override
        public int compareTo(User o) {
            return this.getId().compareTo(o.getId());
        }
    }

}
