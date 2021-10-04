package com.stoklink.API.testCases;

import com.stoklink.API.pojo.Kaydet;
import com.stoklink.API.pojo.Resp;
import com.stoklink.API.pojo.TalepItem;
import com.stoklink.API.pojo.Urun;
import com.stoklink.utils.APIUtils;
import com.stoklink.utils.baseUtils.BaseAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TalepOlustur extends BaseAPI {

    @Test
    public void talepOlusturAPI(ITestContext context){

        ArrayList urunList = (ArrayList)(context.getAttribute("urunList"));
        List<TalepItem> itemList = new ArrayList<>();

        for (Object curObj : urunList) {
            Urun curData = (Urun)curObj;
            String miktar = "5";
            TalepItem item = new TalepItem(curData.getAciklama(), curData.getBirim(), "", curData.getMarka(), miktar,
                    true, false, new Urun(curData.getReferans(), curData.getBirim()), curData.getIsim());
            itemList.add(item);
        }



        Response response = APIUtils.talepOlustur(new Kaydet(-1, "2022-10-01T13:00:00.000Z", itemList));

        response.then()
                .assertThat()
                .statusCode(201)
                .contentType("application/json; charset=utf-8");

        Resp resp = response.as(Resp.class);

        Assert.assertEquals(resp.getStatus(),"OK");
        Assert.assertTrue(resp.getMessage().endsWith("talebiniz başarılı bir şekilde kaydedilmiştir"));

    }
}
