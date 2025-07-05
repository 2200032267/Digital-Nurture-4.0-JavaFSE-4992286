package com.example.country_service;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Optional<Country> findByCode(String code) {
        return countryRepository.findById(code.toUpperCase());
    }

    public Country addCountry(Country country) {
        String code = country.getCode().toUpperCase();
        if (countryRepository.existsById(code)) {
            throw new CountryAlreadyExistsException("Country with code '" + code + "' already exists.");
        }
        country.setCode(code);
        return countryRepository.save(country);
    }
}
