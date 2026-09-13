package com.ecommerce.auth.notes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class NoteDto {
    private String eventId;
    private String name;
    private String place;
    private String type;
    private double amount;
}
