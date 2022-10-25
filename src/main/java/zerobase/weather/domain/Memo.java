package zerobase.weather.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Memo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;

    public Memo(String text) {
        this.text = text;
    }
}
