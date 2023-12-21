package application.services;

import application.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {
    private final ExcelUtil excelUtil;

    @Autowired
    PessoaService pessoaService;

    @Autowired
    public ExcelService(ExcelUtil excelUtil) {
        this.excelUtil = excelUtil;
    }
    public ExcelUtil saveDatas(){
        excelUtil.clearData();
        excelUtil.toFilePeoples(pessoaService.findAll());
        return excelUtil;
    }
}
