package com.bunnies.pinterest.domain.pin.service;

import com.bunnies.pinterest.domain.pin.entity.Pin;
import com.bunnies.pinterest.domain.pin.repository.PinRepository;
import com.bunnies.pinterest.domain.pin.dto.CreatePinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PinServiceImpl implements PinService {
    private final PinRepository PinRepository;

    @Override
    public Pin createPin(CreatePinRequestDto createPinRequestDto) {
        return PinRepository.save(createPinRequestDto.toEntity());
    }

    @Override
    public Pin updatePin(CreatePinRequestDto createPinRequestDto) {
        return PinRepository.save(createPinRequestDto.toEntity());
    }

    @Override
    public Pin getPinById(String pinId) {
        return PinRepository.findByPinId(pinId);
    }

    @Override
    public List<Pin> getPinsByTagIn(List<String> tags) {
        return PinRepository.findByTagsIn(tags);
    }
    @Override
    public void deletePin(String pinId) {
        PinRepository.deleteByPinId(pinId);
    }


}
