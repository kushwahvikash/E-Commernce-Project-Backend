package com.vikas.pa.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.pa.model.Passport;
import com.vikas.pa.repository.PassportRepository;

@Service
public class PassportService {
    
    @Autowired
    private PassportRepository passportRepository;
    
    public Passport savePassport(Passport passport) {
        return passportRepository.save(passport);
    }
    
    public Passport getPassportByPerson(Long personId) {
        return passportRepository.findByPersonPersonId(personId);
    }
    
    public void deletePassport(Long passportId) {
        passportRepository.deleteById(passportId);
    }
    
    public Passport updatePassport(Long passportId, Passport passportDetails) {
        Passport passport = passportRepository.findById(passportId).orElse(null);
        if (passport != null) {
            passport.setPassportNumber(passportDetails.getPassportNumber());
            passport.setIssuingCountry(passportDetails.getIssuingCountry());
            passport.setExpirationDate(passportDetails.getExpirationDate());
            return passportRepository.save(passport);
        } else {
            return null;
        }
    }
    
    // Other operations as needed
}
