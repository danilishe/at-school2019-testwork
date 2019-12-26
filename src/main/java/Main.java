import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class Main {
    public static void main(String[] args) {
        String s = "Саббуфер Al-467 mk";
        Pattern pattern = Pattern.compile("[а-яА-Я]");
        String s2 = s.replaceAll(String.valueOf(pattern),"");
        System.out.println(s2);
    }


}
