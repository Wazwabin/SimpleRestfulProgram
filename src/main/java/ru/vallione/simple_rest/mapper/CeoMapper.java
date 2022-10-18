package ru.vallione.simple_rest.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vallione.simple_rest.dto.CeoDto;
import ru.vallione.simple_rest.model.Ceo;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CeoMapper {

    public List<CeoDto> toCeoDtos(List<Ceo> ceoList){
        return ceoList.stream().map(ceo -> toDto(ceo)).collect(Collectors.toList());
    }

    public CeoDto toDto(Ceo ceo){
        CeoDto ceoDto = new CeoDto();
            ceoDto.setId(ceo.getId());
            ceoDto.setName(ceo.getName());
            ceoDto.setBirthday(ceo.getBirthday());
            ceoDto.setSex(ceo.getSex());
            ceoDto.setPhoneNum(ceo.getSex());
            return ceoDto;

    }

    public Ceo fromDto(CeoDto dto){
        Ceo ceo = new Ceo();
        ceo.setName(dto.getName());
        ceo.setBirthday(dto.getBirthday());
        ceo.setSex(dto.getSex());
        ceo.setPhoneNum(dto.getPhoneNum());
        return ceo;
    }
}
