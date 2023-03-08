package org.all4.skimate.skiRounge.service;


import lombok.RequiredArgsConstructor;
import org.all4.skimate.skiRounge.domain.Ski;
import org.all4.skimate.skiRounge.repository.SkiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkiService {

    private final SkiRepository skiRepository;

    public List<Ski> skiList(){

        return skiRepository.findAll();
    }
}
