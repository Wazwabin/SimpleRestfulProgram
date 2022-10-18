package ru.vallione.simple_rest.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vallione.simple_rest.dto.CeoDto;
import ru.vallione.simple_rest.service.ICeo;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "CEO Controller", description = "CEO Controller")
@RequestMapping("/secured/ceo")
@RequiredArgsConstructor
public class CeoController {

    @Autowired
    private final ICeo ceoService;

    @GetMapping("/all/")
    @ApiOperation(value = "Получение списка CEO", response = ArrayList.class, tags = "getAllCeo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Ошибка 404")
    })
    public List<CeoDto> getAllCeos(){
        List<CeoDto> ceoDtos = ceoService.getAll();
        return ceoDtos;
    }

    @GetMapping("/{name}/")
    @ApiOperation(value = "Получение CEO по имени")
    public CeoDto getCeoByName(
            @ApiParam(value = "Имя", required = true) @PathVariable("name") String name
    ){
        return ceoService.getCeoByName(name);
    }

    @PutMapping("/update/{id}/")
    @ApiOperation(value = "Обновление информации о CEO")
    public CeoDto updateCeo(
            @ApiParam(value = "Идентификатор CEO", required = true) @PathVariable("id") int id,
            @ApiParam(value = "тело с изменениями") @RequestBody CeoDto ceoDto ){
        return ceoService.updateCeo(id, ceoDto);
    }

    @PostMapping("/")
    @ApiOperation(value = "Создание нового CEO")
    public CeoDto addNewCeo(@ApiParam(name = "JSON body создаваемого СЕО") @RequestBody CeoDto ceoDto, HttpServletResponse response){
        CeoDto newCeo = ceoService.saveNewCeo(ceoDto);
        response.setHeader("Location", String.format("/{name}/", ceoDto.getName()));
        response.setStatus(201);
        return ceoDto;
    }

    

}
