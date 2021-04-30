package trackster.data;

public class HomeLocator {
    public  static final String LANGUAGE_ITEMS = ".MuiMenuItem-root:nth-child(%s)";
    public static final String LANGUAGE="#root > div > div.jss1 > header > div > div.MuiInputBase-root.MuiInput-root.MuiInput-underline > div";
    public static final String NAV_BTN="#root > div > div.jss1 > header > div > button";
    public static final String FIND_PARSEL_HEADER="#root > div > div:nth-child(2) > div > div.jss12 > h5";
    public static final String INPUT_NUMBER="#root > div > div:nth-child(2) > div > div.jss12 > div > form > div > input";
    public static final String QUICK_SEARCH="#root > div > div:nth-child(2) > div > div.jss14 > div:nth-child(1) > span";
    public static final String SIMPLE_INTERFACE="#root > div > div:nth-child(2) > div > div.jss14 > div:nth-child(2) > span";
    public static final String ARCHIVE_PARSELS="#root > div > div:nth-child(2) > div > div.jss14 > div:nth-child(3) > span";
    public static final String OUR_PARTNERS_HEADER="#root > div > div:nth-child(2) > div > div.jss16 > h4";

    public HomeLocator(){
        BrowserConfigure bc = new BrowserConfigure();

    }
}

