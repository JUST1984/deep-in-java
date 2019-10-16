package priv.just1984.deep.in.java.webmvc.business.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-30 18:12
 */
@Data
public class ExportableOrder implements Exportable {

    @ExcelProperty("订单ID")
    private Long orderId;

    @ExcelProperty("订单编号")
    private String orderNo;

    @ExcelProperty("下单日期")
    private Date createDate;

}
