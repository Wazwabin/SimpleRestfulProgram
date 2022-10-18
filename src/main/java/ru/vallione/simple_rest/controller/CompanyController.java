package ru.vallione.simple_rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vallione.simple_rest.dto.CompanyDto;
import ru.vallione.simple_rest.service.ICompany;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/secured/company")
@Api(tags = "Company controller")
public class CompanyController {

    @Autowired
    private final ICompany companyService;

    @GetMapping("/all/")
    @ApiOperation(value = "Получение списка всех компаний")
    public List<CompanyDto> getAllCompanies(){
        List<CompanyDto> companies = companyService.getAll();
        return companies;
    }

    @GetMapping("/{name}/")
    @ApiOperation(value = "Получение компании по названию")
    public CompanyDto getCompanyByName(
            @ApiParam(value = "Название компании", required = true) @PathVariable("name") String name){
        return companyService.getByName(name);
    }

    @PutMapping("/update/{name}/")
    @ApiOperation(value = "Изменение информации о компании")
    public CompanyDto updateCompany(@ApiParam(value = "Название компании", required = true) @PathVariable("name") String name,
                                    @ApiParam(value = "JSON body с изменениями") @RequestBody CompanyDto dto){
        return companyService.update(name,dto);
    }

    @PostMapping("/")
    @ApiOperation(value = "Создание новой компании")
    public CompanyDto addNewCompany(@ApiParam(value = "JSON body создаваемой компании") @RequestBody CompanyDto companyDto, HttpServletResponse response){
        CompanyDto newCompany = companyService.save(companyDto);
        response.setHeader("Locale", String.format("/{%s}/",companyDto.getCompanyName()));
        response.setStatus(201);
        return companyDto;
    }

}
