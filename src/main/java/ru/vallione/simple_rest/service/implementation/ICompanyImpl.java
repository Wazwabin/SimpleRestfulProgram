package ru.vallione.simple_rest.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vallione.simple_rest.dto.CompanyDto;
import ru.vallione.simple_rest.exceptions.ResourceNotFound;
import ru.vallione.simple_rest.mapper.CompanyMapper;
import ru.vallione.simple_rest.model.Company;
import ru.vallione.simple_rest.repository.CompanyRepository;
import ru.vallione.simple_rest.service.ICompany;

import java.util.List;

@Service
public class ICompanyImpl implements ICompany {

    private static final Logger log = LoggerFactory.getLogger(ICompanyImpl.class);

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<CompanyDto> getAll() {
        log.info("Getting list of all companies...");
            List<Company> companies = companyRepository.findAll();
        return companyMapper.toDtos(companies);
    }

    @Override
    public CompanyDto getByName(String name) {
        log.info("Get company by Id = "+ name);
            Company company = companyRepository.findByName(name);
        return companyMapper.toDto(company);
    }

    @Override
    public CompanyDto update(String name, CompanyDto companyDto) {
        log.info("Updating company with name: " + name);
            Company company = companyRepository.findByName(name);
            if(company == null){
                throw new ResourceNotFound("Company with name " + name + " is not exist");
            }
            company.setName(companyDto.getCompanyName());
            company.setAddress(companyDto.getAddress());
            company.setCreationDate(companyDto.getDate());
        return companyMapper.toDto(companyRepository.save(company));
    }

    @Override
    public CompanyDto save(CompanyDto companyDto) {
        log.info("Saving new company with name = {}", companyDto.getCompanyName());
            Company company = new Company();
                company.setName(companyDto.getCompanyName());
                company.setAddress(companyDto.getAddress());
                company.setCreationDate(companyDto.getDate());
        return companyMapper.toDto(companyRepository.save(company));
    }
}
