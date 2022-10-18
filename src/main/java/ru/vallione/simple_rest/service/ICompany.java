package ru.vallione.simple_rest.service;

import ru.vallione.simple_rest.dto.CompanyDto;

import java.util.List;

public interface ICompany {
    List<CompanyDto> getAll();
    CompanyDto getByName(String name);
    CompanyDto update(String name, CompanyDto companyDto);
    CompanyDto save(CompanyDto companyDto);
}
