package com.stoklink.testCases;

import com.google.gson.JsonParser;
import com.stoklink.pageObjects.musteri.M_TalepOlustur;
import com.stoklink.pageObjects.musteri.M_Talepler;
import com.stoklink.utils.baseUtils.Base;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;

public class MusteriTalepOlustur extends Base {

    @Test
    public void talepOlustur(ITestContext context) throws IOException, ParseException, InterruptedException {
        musteriLogin();
        mTalepler = new M_Talepler(driver);

        if (mTalepler.isTedarikci()) {
            mTalepler.clickMusteriMenu();
        }


        mTalepler.clickTalepOlustur();

        mTalepOlustur = new M_TalepOlustur(driver);

        JSONParser parser = new JSONParser();

        String jsonString = parser.parse(
                new FileReader(System.getProperty("user.dir") + "/urunler.json")).toString();

        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.toList().size(); i++) {
            JSONObject current = jsonArray.getJSONObject(i);
            mTalepOlustur.addProductItem(
                    current.getString("referans"),
                    current.getBoolean("muadil"),
                    current.getBoolean("stok"),
                    current.getString("urunMiktari"),
                    current.getString("aciklama"));
        }

        String talepNo = mTalepOlustur.save("teklif");
        context.setAttribute("talepNo", talepNo);

    }
}
