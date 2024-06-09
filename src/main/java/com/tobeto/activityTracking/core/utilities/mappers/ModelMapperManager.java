package com.tobeto.activityTracking.core.utilities.mappers;

import com.tobeto.activityTracking.entities.Event;
import com.tobeto.activityTracking.entities.User;
import com.tobeto.activityTracking.services.dtos.event.requests.AddEventRequest;
import com.tobeto.activityTracking.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.activityTracking.services.dtos.user.requests.UpdateUserRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;



@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {

    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        TypeMap<AddEventRequest, Event> typeMap = this.modelMapper.getTypeMap(AddEventRequest.class, Event.class);
        if(typeMap == null){
            typeMap = this.modelMapper.createTypeMap(AddEventRequest.class, Event.class);

            typeMap.addMappings(mapper -> mapper.skip(Event::setId));
        }


        return this.modelMapper;
    }
}
