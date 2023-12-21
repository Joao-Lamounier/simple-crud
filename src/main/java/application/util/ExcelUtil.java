package application.util;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import application.domain.entities.Pessoa;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ExcelUtil {
    private Workbook workbook;
    private Sheet sheet;
    private Row headerRow;

    public ExcelUtil() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Pessoas");
        headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("Nome");
        headerRow.createCell(1).setCellValue("Apelido");
        headerRow.createCell(2).setCellValue("Time do Coração");
        headerRow.createCell(3).setCellValue("CPF Válido");
        headerRow.createCell(4).setCellValue("Hobbie");
        headerRow.createCell(5).setCellValue("Cidade");
    }
    public void clearData() {
        int index = workbook.getSheetIndex("Pessoas");
        if (index != -1) {
            workbook.removeSheetAt(index);
        }

        sheet = workbook.createSheet("Pessoas");
        headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Nome");
        headerRow.createCell(1).setCellValue("Apelido");
        headerRow.createCell(2).setCellValue("Time do Coração");
        headerRow.createCell(3).setCellValue("CPF Válido");
        headerRow.createCell(4).setCellValue("Hobbie");
        headerRow.createCell(5).setCellValue("Cidade");
    }
    public void toFilePeoples(List<Pessoa> list) {
        for (Pessoa pessoa : list) {
            Row novaLinha = sheet.createRow(sheet.getLastRowNum() + 1);
            novaLinha.createCell(0).setCellValue(pessoa.getNome());
            novaLinha.createCell(1).setCellValue(pessoa.getApelido());
            novaLinha.createCell(2).setCellValue(pessoa.getTime());
            novaLinha.createCell(3).setCellValue(pessoa.getCpf());
            novaLinha.createCell(4).setCellValue(pessoa.getHobbie());
            novaLinha.createCell(5).setCellValue(pessoa.getCidade().toString());
        }
    }

    public byte[] toByteArray() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            workbook.write(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
    public Workbook getWorkbook() {
        return workbook;
    }
}
