import com.vdurmont.emoji.EmojiParser;

enum Emoji
{
    SUN(":sunny:"),
    CLOUD(":cloud:"),
    RAIN(":umbrella:"),
    SNOW(":snowflake:"),
    ZAP(":zap:"),
    FOGGY(":foggy:"),
    WAVE(":wave:"),
    RELIAVER(":relieved:"),
    CITY(":city_sunset:"),
    PENSIVE(":pensive:"),
    WINK(":wink:"),
    TADA(":tada:");

    private final String value;

    public String get() {
        return EmojiParser.parseToUnicode(value);
    }

    Emoji(String value) {
        this.value = value;
    }
}