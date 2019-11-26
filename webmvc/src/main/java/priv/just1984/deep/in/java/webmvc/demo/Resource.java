package priv.just1984.deep.in.java.webmvc.demo;

import lombok.Data;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-25 16:43
 */
public interface Resource {

    Long getResourceId();

    String getResourceType();

    @Data
    class Book implements Resource {

        private Long bookId;

        private String bookType;

        @Override
        public Long getResourceId() {
            return bookId;
        }

        @Override
        public String getResourceType() {
            return bookType;
        }
    }

}
