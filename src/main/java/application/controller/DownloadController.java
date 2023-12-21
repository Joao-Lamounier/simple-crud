package application.controller;

import application.services.ExcelService;
import application.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class DownloadController {
    private final ExcelService service;

    @Autowired
    public DownloadController(ExcelService excelService) {
        this.service = excelService;
    }

    @GetMapping("/planilha")
    public ResponseEntity<ByteArrayResource> downloadPlanilha() {
        ExcelUtil excelUtil = service.saveDatas();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "planilha.xlsx");

        byte[] excelBytes = excelUtil.toByteArray();

        ByteArrayResource resource = new ByteArrayResource(excelBytes);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(excelBytes.length)
                .body(resource);
    }
}
