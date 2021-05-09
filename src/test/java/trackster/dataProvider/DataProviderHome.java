package trackster.dataProvider;

import trackster.enums.Language;
import trackster.models.HomePageTestData;


public class DataProviderHome
{
    //@DataProvider(name = "data-provider-home")
    public static Object[][] dataProviderMethod()
    {
        return new Object[][] { { new HomePageTestData(
                                    Language.ENGLISH,
                                    "Find your parcel just in one moment",
                                    "Track number",
                                    "Fast tracking",
                                    "Intuitive Interface",
                                    "Archive Parcels",
                                    "Our Partners")},
                                    {new HomePageTestData(
                                     Language.UKRAINIAN,
                                     "Знайдіть вашу посилку в один клік",
                                     "Трек номер",
                                     "Швидкий пошук",
                                     "Простий інтерфейс",
                                     "Архів посилок",
                                      "Наші партнери")},
        };
    }
}