package com.bunnies.pinterest.application.controller;

import com.bunnies.pinterest.domain.pin.dto.CreatePinRequestDto;
import com.bunnies.pinterest.domain.pin.entity.Pin;
import com.bunnies.pinterest.domain.pin.service.PinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pin")
public class PinController {

    @Autowired
    private PinService pinService;

    /* 전체 핀 보여주기 추후 추가
    @GetMapping
    public List<Pin> getAllPins() {
        return pinService.getAllPins();
    }
    */
    @GetMapping("/{id}")
    public Pin getPinById(@PathVariable String pinId) {
        return pinService.getPinById(pinId);
    }

    @PostMapping("/create")
    public Pin createPin(@RequestBody CreatePinRequestDto createPinRequestDto) {
        return pinService.createPin(createPinRequestDto);
    }

    @PostMapping("/{id}/update")
    public void updatePin(@RequestBody CreatePinRequestDto createPinRequestDto) {
        pinService.updatePin(createPinRequestDto);
    }

    @PostMapping("/{id}/update")
    public void deletePin(@PathVariable String pinId) {
        pinService.deletePin(pinId);
    }

    /* 태그 검색 추후 추가
    @GetMapping("/search")
    public List<Pin> searchPins(@RequestParam List<String> tags) {
        return pinService.searchPins(tags);
    }

     */


}
