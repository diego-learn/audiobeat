package com.br.audiobeatapi.component;

import com.br.audiobeatapi.dto.PayloadExcelDto;
import com.br.audiobeatapi.entity.*;
import com.br.audiobeatapi.util.ValidCell;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.commons.collections4.IteratorUtils.toList;

@Component
@NoArgsConstructor
public class ExcelMapper {


    public List<PayloadExcelDto> readFile(MultipartFile multipartFile) throws IOException {
        validaArquivo(multipartFile);
        @Cleanup Workbook workbook = WorkbookFactory.create(multipartFile.getInputStream());
        List<PayloadExcelDto> payloads = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        List<Row> rows = toList(sheet.iterator());

        rows.stream()
                .filter(r -> r.getRowNum() > 9)
                .forEach(row -> {
                    List<Cell> cells = toList(row.cellIterator());

                    //validação ja que podem vir dados sem padrão
                    if (cells.size() > 0 && cells.get(0).getCellType() == CellType.NUMERIC) {
                        payloads.add(getPayload(cells));
                    }
                });

        return payloads;
    }

    private void validaArquivo(MultipartFile multipartFile) {
        var extensions = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        Assert.state(extensions.equals("xlsx"), "Arquivo invalido");
    }

    private PayloadExcelDto getPayload(List<Cell> cells) {
        return PayloadExcelDto
                .builder()
                .idSecom((int) cells.get(0).getNumericCellValue())
                .ufOutorga(cells.get(1).getStringCellValue())
                .munOutorga(cells.get(2).getStringCellValue())
                .uf(cells.get(3).getStringCellValue())
                .munVeiculacao(cells.get(4).getStringCellValue())
                .nomeFantasia(cells.get(5).getStringCellValue())
                .nomeEmpresarial(cells.get(6).getStringCellValue())
                .tipoRadio(cells.get(7).getStringCellValue())
                .cnpj(cells.get(8).getStringCellValue())
                .tipoServico(cells.get(9).getStringCellValue())
                .generos(cells.get(10).getStringCellValue())
                .programa(cells.get(11).getStringCellValue())
                .apresentadores(cells.get(12).getStringCellValue())
                .fx(cells.get(13).getStringCellValue())
                .prx(cells.get(14).getNumericCellValue())
                .fxInicio(ValidCell.getHour(cells.get(15)))
                .fxFim(ValidCell.getHour(cells.get(16)))
                .peca(cells.get(17).getStringCellValue())
                .build();
    }


    public Radio mapperRadio(final PayloadExcelDto payload) {
        return Radio.builder()
                .idSecom(payload.getIdSecom())
                .NomeFantasia(payload.getNomeFantasia())
                .nameCompany(payload.getNomeEmpresarial())
                .idSecom(payload.getIdSecom())
                .cnpj(payload.getCnpj())
                .programas(Collections.singletonList(mapperPrograma(payload)))
                .radioCaract(mapperCaracteristicasRadio(payload))
                .build();
    }

    public RadioCaract mapperCaracteristicasRadio(final PayloadExcelDto payload) {
        return RadioCaract
                .builder()
                .municipioOut(payload.getMunOutorga())
                .tipoServico(payload.getTipoServico())
                .tipoRadio(RadioCaract.TipoRadio.RADIO)
                .prx(payload.getPrx())
                .peca(payload.getPeca())
                .fx(RadioCaract.Faixa.getfaixa(payload.getFx()))
                .build();
    }


    public RadioCampanha mapperRadioCampanha(final PayloadExcelDto payload) {
        return RadioCampanha
                .builder()
                .campanha(Campanha.builder().nome(payload.getNameCampanha()).build())
                .radio(mapperRadio(payload))
                .build();
    }

    public Programa mapperPrograma(final PayloadExcelDto payload) {
        return Programa.builder()
                .nome(payload.getPrograma())
                .faixaHoraFim(payload.getFxFim())
                .faixaHoraInit(payload.getFxInicio())
                .apresentadores(mapperApresentadoresPrograma(payload))
                .build();
    }


    private Collection<ApresentadorPrograma> mapperApresentadoresPrograma(final PayloadExcelDto payload) {

        List<ApresentadorPrograma> l = new ArrayList<>();

        mapperApresentador(payload).stream().forEach(a -> {
            l.add(ApresentadorPrograma.builder()
                    .apresentador(a)
                    .build());
        });

        return l;
    }

    private List<Apresentador> mapperApresentador(final PayloadExcelDto payload) {

        List<Apresentador> apresentadores = new ArrayList<>();

        Arrays.stream(payload.getApresentadores().split(",")).forEach(name -> {
            apresentadores.add(Apresentador
                    .builder()
                    .nome(name)
                    .build());
        });


        return apresentadores;
    }


}
