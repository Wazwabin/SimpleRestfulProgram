package ru.vallione.simple_rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "Компания", description = "Информация о компании")
public class CompanyDto {

    @ApiModelProperty(value = "Уникальный идентификатор компании")
    private int id;

    @ApiModelProperty(value = "Уникальный идентификатор CEO компании")
    private int ceoId;

    @ApiModelProperty(value = "Название компании")
    private String companyName;

    @ApiModelProperty(value = "Адрес")
    private String address;

    @ApiModelProperty(value = "Дата основания")
    private Date date;
}
