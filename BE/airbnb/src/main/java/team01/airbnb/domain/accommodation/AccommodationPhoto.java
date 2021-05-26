package team01.airbnb.domain.accommodation;

import lombok.*;
import team01.airbnb.dto.request.TotalAccommodationSaveRequestDto;

@ToString
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccommodationPhoto {

    private Long id;
    private Long accommodationId;
    private String name;

    public static AccommodationPhoto fromSaveRequestDto(TotalAccommodationSaveRequestDto totalAccommodationSaveRequestDto) {
        return AccommodationPhoto.builder()
                .accommodationId(totalAccommodationSaveRequestDto.getId())
                .name(totalAccommodationSaveRequestDto.getPhoto())
                .build();
    }

}
