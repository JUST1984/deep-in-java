package priv.just1984.deep.in.java.demo.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.just1984.deep.in.java.demo.business.service.ExportService;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-27 17:11
 */
@RestController
public class ExportController {

    @Autowired
    private ExportService exportService;

    @PostMapping("/export")
    public void export() {
        exportService.export();
    }

}
