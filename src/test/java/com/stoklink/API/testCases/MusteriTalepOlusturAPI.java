package com.stoklink.API.testCases;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stoklink.API.pojo.Kaydet;
import com.stoklink.API.pojo.Resp;
import com.stoklink.API.pojo.TalepItem;
import com.stoklink.API.pojo.Urun;
import com.stoklink.utils.baseUtils.BaseAPI;

import io.restassured.response.Response;

public class MusteriTalepOlusturAPI extends BaseAPI {

	@Test
	public void musteriTalepOlustur() {
		Response response = given().spec(spec).header("authorization", auth).basePath("public/urun/getir")
				.queryParam("referans", "555").when().get();

		JSONObject json = new JSONObject(response.asString());
		Resp actualData = response.as(Resp.class);

		Assert.assertEquals(json.getString("status"), "OK");
		List<Urun> data = actualData.getData().stream().limit(2).collect(Collectors.toList());

		System.out.println(data);

		List<TalepItem> itemList = new ArrayList<TalepItem>();

		for (int i = 0; i < data.size(); i++) {
			Urun curData = data.get(i);
			String miktar = "5";
			TalepItem item = new TalepItem(curData.getAciklama(), curData.getBirim(), "", curData.getMarka(), miktar,
					true, false, new Urun(curData.getReferans(), curData.getBirim()), curData.getIsim());
			itemList.add(item);
		}

		Kaydet kaydet = new Kaydet(-1, "2022-10-01T13:00:00.000Z", itemList);

		response =

				given().spec(spec).header("authorization", auth).basePath("talep/kaydet")
						.contentType("application/json").body(kaydet).when().post();

		response.prettyPrint();

		actualData = response.as(Resp.class);

		String talepNo = actualData.getMessage();

		Assert.assertTrue(talepNo.endsWith("talebiniz başarılı bir şekilde kaydedilmiştir"));
		talepNo = talepNo.substring(0, talepNo.indexOf(" "));

		response = given().spec(spec).header("authorization", auth).basePath("talep/sil").queryParam("talepNo", talepNo)
				.when().delete();

		actualData = response.as(Resp.class);
		Assert.assertEquals(actualData.getMessage(), "Talep silme işleminiz başarıyla sonuçlanmıştır");
	}
}
