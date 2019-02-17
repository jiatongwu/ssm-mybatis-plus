package cn.xvkang.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xvkang.mapper.Person2Mapper;
import cn.xvkang.service.TestService;

@RestController
public class TestController {
	@Autowired
	private TestService testService;
	@Autowired
	private Person2Mapper person2Mapper;

	@GetMapping("/hello")
	public String hello() {
		System.out.println(person2Mapper.selectById(1).getName());
		return testService.getName(1);
	}
	@GetMapping("/helloUpdate")
	public String helloUpdate() {
		testService.updateNameById(1);
		
		return "updateNameById";
	}
    @GetMapping("/weixin/onLogin")
    public String weixinOnlogin(String code)
    {


		CloseableHttpClient client = HttpClients.createDefault();
		//HttpPost httpPost = new HttpPost("");
		//httpPost.setHeader("Connection", "close");
		//ByteArrayEntity byteArrayEntity = new ByteArrayEntity(json.getBytes("utf-8"), ContentType.APPLICATION_JSON);
		//httpPost.setEntity(byteArrayEntity);
		System.out.println(code);
		HttpGet httpGet=new HttpGet("https://api.weixin.qq.com/sns/jscode2session?appid=wx97d3c955c98e05c2&secret=390da84e55bcc6a3072896fc70e81250&js_code="+code+"&grant_type=authorization_code");
		httpGet.setHeader("Connection", "close");

		try {

			CloseableHttpResponse response=client.execute(httpGet);
			HttpEntity httpEntity=response.getEntity();
			InputStream is=httpEntity.getContent();
			String result=IOUtils.toString(is,"UTF-8");
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

        return testService.getName(1);
    }

	@GetMapping("/checkSession")
	public String checkSession(String data) {
		//当小程序真机运行时，有时为了测试 session失效的情况，需要断开连接，断开连接后就看不到console了，发个请求过来能看到小程序的运行情况
		System.out.println(data);
		return "ok";
	}

    @PostMapping("/checkSessionPost")
    public String checkSessionPost(String data) {
        //当小程序真机运行时，有时为了测试 session失效的情况，需要断开连接，断开连接后就看不到console了，发个请求过来能看到小程序的运行情况
        System.out.println(data);
        return "ok";
    }

}
