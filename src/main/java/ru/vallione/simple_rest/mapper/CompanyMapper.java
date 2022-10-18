package ru.vallione.simple_rest.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vallione.simple_rest.dto.CompanyDto;
import ru.vallione.simple_rest.model.Company;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyMapper {

    public List<CompanyDto> toDtos(List<Company> companies){
        return companies.stream().map(company -> toDto(company)).collect(Collectors.toList());
    }

    public CompanyDto toDto(Company company){
        CompanyDto companyDto = new CompanyDto();
            companyDto.setId(company.getId());
            companyDto.setCeoId(company.getCeoId());
            companyDto.setCompanyName(company.getName());
            companyDto.setAddress(company.getAddress());
            companyDto.setDate(company.getCreationDate());
            return companyDto;
    }

    public Company fromDto(CompanyDto companyDto){
        Company company = new Company();
            company.setCeoId(companyDto.getCeoId());
            company.setName(companyDto.getCompanyName());
            company.setAddress(companyDto.getAddress());
            company.setCreationDate(companyDto.getDate());
            return company;
    }
}
