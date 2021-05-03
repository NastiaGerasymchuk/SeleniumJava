package trackster.testData;

import org.junit.jupiter.params.provider.Arguments;
import trackster.enums.Language;
import trackster.models.HomePageTestData;

import java.util.stream.Stream;

public class LanguageData {
    private static Stream<Arguments> homeData() {

        return Stream.of(
                Arguments.of(new HomePageTestData(
                        Language.ENGLISH.getProgrammerCode(),
                        "Find your parcel just in one moment",
                        "Track number",
                        "Fast tracking",
                        "Intuitive Interface",
                        "Archive Parcels",
                        "Our Partners")),
                Arguments.of(new HomePageTestData(
                        Language.UKRAINIAN.getProgrammerCode(),
                        "Знайдіть вашу посилку в один клік",
                        "Трек номер",
                        "Швидкий пошук",
                        "Простий інтерфейс",
                        "Архів посилок",
                        "Наші партнери"))
        );
    }
}
