package com.wiktor.wos.server.service;

import com.wiktor.wos.server.repository.GuestRepository;
import com.wiktor.wos.server.service.dto.GuestDTO;
import com.wiktor.wos.server.service.mapper.GuestMapper;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    private GuestRepository repository;
    private GuestMapper mapper;

    public GuestService(GuestRepository repository, GuestMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void saveGuest(GuestDTO dto) {
        repository.save(mapper.toEntity(dto));
    }

    public GuestDTO getGuestByEmail(String email) {
        return mapper.toDto(repository.findByEmail(email));
    }
}
