import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class CGIParser {


    public static void main(String[] args) {

        Authenticator.setDefault(new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("root", "root".toCharArray());
            }
        });


        Document doc = null;
        try {
            doc = Jsoup.connect("http://192.168.0.101/cgi-bin/minerStatus.cgi").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements asic_freq = doc.select("#cbi-table-1-frequency");
        Elements asic_temp = doc.select("#cbi-table-1-temp2");
        Elements asic_hash_ideal = doc.select("#cbi-table-1-rate2");
        Elements asic_hash_rt = doc.select("#cbi-table-1-rate");


        Element asic_fan_1 = doc.select("#ant_fan3").first();
        System.out.println("freq");
        Element asic_fan_2 = doc.select("#ant_fan6").first();
        for (Element element : asic_freq) {
            System.out.println(element.text());
        }
        System.out.println("temp");
        for (Element element : asic_temp) {
            System.out.println(element.text());
        }
        System.out.println("hash_ideal");
        for (Element element : asic_hash_ideal) {
            System.out.println(element.text());
        }
        System.out.println("hash_rt");
        for (Element element : asic_hash_rt) {
            System.out.println(element.text());
        }
        System.out.println("fan speed");
        System.out.println(asic_fan_1.text());
        System.out.println(asic_fan_2.text());


//
    }
}
