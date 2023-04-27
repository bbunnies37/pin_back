package com.bunnies.pinterest.domain.pin.service;


import com.bunnies.pinterest.domain.pin.dto.CreatePinRequestDto;
import com.bunnies.pinterest.domain.pin.entity.Pin;

import java.util.List;


public interface PinService {

    Pin createPin(CreatePinRequestDto createPinRequestDto);

    Pin updatePin(CreatePinRequestDto createPinRequestDto);
    Pin getPinById(String pinId);
    List<Pin> getPinsByTagIn(List<String> tags);

    void deletePin(String pinId);
}


