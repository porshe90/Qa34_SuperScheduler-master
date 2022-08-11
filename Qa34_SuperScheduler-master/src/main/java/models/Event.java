package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Event {
    private String title;
    private String type;
    private int breaks;
    private int wage;
}
