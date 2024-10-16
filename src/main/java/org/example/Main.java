package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) {
       String url ="https://results.govdoc.lk/results/jayoda-2068";
       try {
            Document doc = Jsoup.connect(url).timeout(6000).get();
            Elements lotteryResults = doc.select("div.wrp.single-result.name" );
            if(lotteryResults.isEmpty() ){
                System.out.println("Not found results");
            }
            else{
                for (Element li : lotteryResults) {
                    System.out.println("Lottery Result: " + li.text());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}