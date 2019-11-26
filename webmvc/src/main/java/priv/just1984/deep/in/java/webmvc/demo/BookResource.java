package priv.just1984.deep.in.java.webmvc.demo;

import lombok.Data;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-25 16:54
 */
@Data
public class BookResource extends RelResource {

    private Long bookId;

    private String bookType;

    public BookResource(Long bookId, String bookType) {
        super("book");
        this.bookId = bookId;
        this.bookType = bookType;
    }

    public static void main(String[] args) {
        BookResource bookResource = new BookResource(1L, "xxx");
        System.out.println(bookResource.getResourceId());
        System.out.println(bookResource.getResourceType());
    }

}
