package priv.just1984.deep.in.java.basic.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.beans.*;
import java.util.Arrays;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-26 15:15
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        User user = new User(0L, "JUST1984");
        BeanInfo userBeanInfo = Introspector.getBeanInfo(User.class);
        Arrays.stream(userBeanInfo.getPropertyDescriptors()).filter(propertyDescriptor -> "id".equals(propertyDescriptor.getName()))
                .findFirst().ifPresent(propertyDescriptor -> {
                    propertyDescriptor.setPropertyEditorClass(UserIdPropertyEditor.class);
                    PropertyEditor propertyEditor = propertyDescriptor.createPropertyEditor(user);
                    propertyEditor.addPropertyChangeListener(event -> {
                        User source = (User) event.getSource();
                        source.setId((Long) propertyEditor.getValue());
                    });
                propertyEditor.setAsText("1");
        });
        System.out.println(user.getId());
    }

    public static class UserIdPropertyEditor extends PropertyEditorSupport {

        public UserIdPropertyEditor(Object source) {
            setSource(source);
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Long.valueOf(text));
        }
    }

    @AllArgsConstructor
    @Data
    public static class User {

        private Long id;

        private String name;

    }

}
