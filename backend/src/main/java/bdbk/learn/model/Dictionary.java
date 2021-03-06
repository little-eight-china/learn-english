package bdbk.learn.model;

import lombok.Data;

/**
 *
 * @author little_eight
 * @since 2021/8/17
 */
@Data
public class Dictionary {
    private Long id;
    private String dictionaryFrom;
    private String dictionaryType;
    private String dictionarySpell;
    private String dictionaryComment;
    private String dictionaryPronunciation;

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
    Integer converted = converter.convert("123");
}
