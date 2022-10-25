package zerobase.weather.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DateWeather {

    @Id
    private LocalDate date;
    @Column(length = 50, nullable = false)
    private String weather;
    @Column(length = 50, nullable = false)
    private String icon;
    @Column(nullable = false)
    private Double temperature;

    @Builder
    private DateWeather(LocalDate date, String weather, String icon, Double temperature) {
        this.date = date;
        this.weather = weather;
        this.icon = icon;
        this.temperature = temperature;
    }
}
