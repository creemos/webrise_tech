package creemos.webrise.subs.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author kay 07.05.2025
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class TopSubscription {

    String text;
    Integer count;

    public TopSubscription(String text, Integer count) {
        this.text = text;
        this.count = count;
    }
}
