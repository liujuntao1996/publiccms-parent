package org.publiccms.controller.admin;

import cn.com.antcloud.api.AntFinTechApiClient;
import cn.com.antcloud.api.AntFinTechProfile;
import cn.com.antcloud.api.appex.v1_0_0.model.NameValuePair;
import cn.com.antcloud.api.appex.v1_0_0.request.QuerySolutionFastnotaryRequest;
import cn.com.antcloud.api.appex.v1_0_0.request.SaveSolutionFastnotaryRequest;
import cn.com.antcloud.api.appex.v1_0_0.response.QuerySolutionFastnotaryResponse;
import cn.com.antcloud.api.appex.v1_0_0.response.SaveSolutionFastnotaryResponse;
import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class UpChain {
    AntFinTechProfile antFinTechProfile = AntFinTechProfile.getProfile("https://prodapigw.cloud.alipay.com", "LTAI4FzSZ87r8yFB7s9iRDAz", "xQwZYOubEsLYGe7fKUo2OqEnCzcmRM");
    AntFinTechApiClient antFinTechApiClient = new AntFinTechApiClient(antFinTechProfile);

    public UpChain() throws InterruptedException {
    }


    public void DataUpChain(String idv,String namev) throws InterruptedException {
        SaveSolutionFastnotaryRequest saveSolutionFastnotaryRequest=new SaveSolutionFastnotaryRequest("appex");
        saveSolutionFastnotaryRequest.setAppDid("did:mychain:439842830db5699a6d097fe3d49bccc4db73c111f65a8093109298844722773a");
        saveSolutionFastnotaryRequest.setSchemaName("test");

        NameValuePair nameValuePair1=new NameValuePair();
        nameValuePair1.setName("id");
        nameValuePair1.setValue(idv);
        NameValuePair nameValuePair2=new NameValuePair();
        nameValuePair2.setName("name");
        nameValuePair2.setValue(namev);


        saveSolutionFastnotaryRequest.setAttributes(Arrays.asList(nameValuePair1,nameValuePair2));
        SaveSolutionFastnotaryResponse saveSolutionFastnotaryResponse = antFinTechApiClient.execute(saveSolutionFastnotaryRequest);
        System.out.println(JSON.toJSONString(saveSolutionFastnotaryResponse));


    }
    public String QueryData(String id) throws InterruptedException {
        //查询存证
        QuerySolutionFastnotaryRequest querySolutionFilenotaryRequest=new QuerySolutionFastnotaryRequest("appex");
        querySolutionFilenotaryRequest.setAppDid("did:mychain:439842830db5699a6d097fe3d49bccc4db73c111f65a8093109298844722773a");
        querySolutionFilenotaryRequest.setSchemaName("test");
        querySolutionFilenotaryRequest.setBizIndexKeyValue(id);
        QuerySolutionFastnotaryResponse querySolutionFastnotaryResponse = antFinTechApiClient.execute(querySolutionFilenotaryRequest);
        String getData=JSON.toJSONString(querySolutionFastnotaryResponse);
        System.out.println(JSON.toJSONString(querySolutionFastnotaryResponse));
        System.out.println(getData.substring(55,119));
        return getData.substring(55,119);
    }
}
