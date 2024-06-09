package com.tobeto.activityTracking.adapters;

import com.tobeto.activityTracking.mernis.FVNKPSPublicSoap;
import com.tobeto.activityTracking.services.abstracts.UserCheckService;
import com.tobeto.activityTracking.services.dtos.user.requests.CreateUserRequest;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements UserCheckService {

    FVNKPSPublicSoap fvnkpsPublicSoap = new FVNKPSPublicSoap();


    @Override
    public boolean checkIfRealPerson(CreateUserRequest createUserRequest) throws Exception {
        try {
            // Mernis kontrolü
            return fvnkpsPublicSoap.TCKimlikNoDogrula(Long.valueOf(createUserRequest.getNationalityId()),
                    createUserRequest.getName(),
                    createUserRequest.getSurname(),
                    createUserRequest.getBirthday().getYear());
        }catch (Exception e) {

            throw new Exception("Not a valid person");
        }
    }
}
