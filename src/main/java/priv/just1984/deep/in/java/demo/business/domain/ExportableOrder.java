package priv.just1984.deep.in.java.demo.business.domain;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-30 18:12
 */
@Data
public class ExportableOrder implements Exportable {

    private Date createDate;

}
