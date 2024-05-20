package com.goldinn.leasing.service;

import com.goldinn.leasing.model.HousingUnit;
import com.goldinn.leasing.repository.HousingUnitRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HousingUnitService {

    @Autowired
    private HousingUnitRepository housingUnitRepository;

    public List<HousingUnit> getAllHousingUnits() {
        return housingUnitRepository.findAll();
    }

    public Optional<HousingUnit> getHousingUnitById(String id) {
        return housingUnitRepository.findById(id);
    }

    public Optional<HousingUnit> getHousingUnitByUserId(String userId) {
        return housingUnitRepository.findByUserId(userId);
    }

    public List<HousingUnit> getVacantHousingUnits() {
        return housingUnitRepository.findByUserIdIsNull();
    }

    public String encodeFileToBase64(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        return Base64.encodeBase64String(bytes);
    }

    public List<String> encodeFilesToBase64(List<MultipartFile> files) throws IOException {
        return files.stream()
                .map(file -> {
                    try {
                        return encodeFileToBase64(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}
