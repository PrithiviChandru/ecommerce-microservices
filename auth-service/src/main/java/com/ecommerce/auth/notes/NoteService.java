package com.ecommerce.auth.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public List<NoteDto> list() {
        return noteRepository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    private NoteDto map(Note note) {
        return NoteDto.builder()
                .eventId(note.getEventId())
                .name(note.getName())
                .place(note.getPlace())
                .type(note.getType())
                .amount(note.getAmount())
                .build();
    }
}
