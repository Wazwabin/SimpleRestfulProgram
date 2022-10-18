package ru.vallione.simple_rest.service.implementation;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vallione.simple_rest.dto.CeoDto;
import ru.vallione.simple_rest.exceptions.ResourceNotFound;
import ru.vallione.simple_rest.mapper.CeoMapper;
import ru.vallione.simple_rest.model.Ceo;
import ru.vallione.simple_rest.repository.CeoRepository;
import ru.vallione.simple_rest.service.ICeo;

import java.util.List;

@Service
public class ICeoImpl implements ICeo {

    private static final Logger log = LoggerFactory.getLogger(ICeoImpl.class);

    @Autowired
    private CeoRepository ceoRepository;
    @Autowired
    private CeoMapper ceoMapper;

    @Override
    public List<CeoDto> getAll() {
        log.info("Getting list of all CEO...");
        List<Ceo> ceoList = ceoRepository.findAll();
        return ceoMapper.toCeoDtos(ceoList);
    }

    @Override
    public CeoDto getCeoByName(String ceoName) {
        log.info("Getting CEO by name" + ceoName);
            Ceo ceo = ceoRepository.findByName(ceoName);
                if (ceo == null){
                    throw new ResourceNotFound("CEO with name = "+ ceoName + " is not exist");
                }
        return ceoMapper.toDto(ceo);
    }

    @Override
    public CeoDto updateCeo(int id, CeoDto ceoDto) {
        log.info("Updating CEO...");
            Ceo ceo = ceoRepository.findById(id);
                if (ceo == null){
                    throw new ResourceNotFound("CEO with id = "+ id + " is not exist");
                }
            ceo.setName(ceoDto.getName());
            ceo.setBirthday(ceoDto.getBirthday());
            ceo.setSex(ceoDto.getSex());
            ceo.setPhoneNum(ceoDto.getPhoneNum());
        return ceoMapper.toDto(ceoRepository.save(ceo));
    }

    @Override
    public CeoDto saveNewCeo(CeoDto ceoDto) {
        log.info("Creating new CEO...\n{}", ceoDto);
            Ceo ceo = new Ceo();
                ceo.setName(ceoDto.getName());
                ceo.setBirthday(ceoDto.getBirthday());
                ceo.setSex(ceoDto.getSex());
                ceo.setPhoneNum(ceoDto.getPhoneNum());
        return ceoMapper.toDto(ceoRepository.save(ceo));
    }
}
