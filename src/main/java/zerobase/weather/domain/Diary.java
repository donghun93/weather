package zerobase.weather.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String weather;

    @Column(length = 50, nullable = false)
    private String icon;

    @Column(nullable = false)
    private Double temperature;

    @Column(length = 500, nullable = false)
    private String text;

    @Column(nullable = false)
    private LocalDate date;

    @Builder
    private Diary(String weather, String icon, Double temperature, String text, LocalDate date) {
        this.weather = weather;
        this.icon = icon;
        this.temperature = temperature;
        this.text = text;
        this.date = date;
    }

    public void updateText(String text) {
        this.text = text;
    }
}
