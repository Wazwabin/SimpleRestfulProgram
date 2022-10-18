package ru.vallione.simple_rest.service;


import ru.vallione.simple_rest.dto.CeoDto;

import java.util.List;

public interface ICeo {
    List<CeoDto> getAll();
    CeoDto getCeoByName(String ceoName);
    CeoDto updateCeo(int id, CeoDto ceoDto);
    CeoDto saveNewCeo(CeoDto ceoDto);
}
