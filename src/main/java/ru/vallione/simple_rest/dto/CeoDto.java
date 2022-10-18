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
@ApiModel(value = "CEO", description = "Генеральный директор компании")
public class CeoDto {

    @ApiModelProperty(name = "Уникальный идентификатор", required = true, value = "id")
    private int id;

    @ApiModelProperty(name = "Имя", required = true, value = "name")
    private String name;

    @ApiModelProperty(name = "День рождения", required = true, value = "birthday")
    private Date birthday;

    @ApiModelProperty(name = "Пол", required = true, value = "sex")
    private String sex;

    @ApiModelProperty(name = "Рабочий номер телефона", required = true, value = "phone")
    private String phoneNum;
}
