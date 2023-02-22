package com.springboot.corstest.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CorsController {
	
	@GetMapping("/corstest")
	public @ResponseBody String corstest() {
		return "corstest...";
	}
	
	@GetMapping("/corstest/{name}")
	public @ResponseBody String corstestParam(@PathVariable String name) {
		String sname = null;
		try {
			sname = URLEncoder.encode(name, "UTF-8");
		}catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String inputLine = null;
		try {
            URL aURL= new URL("http://localhost:9001/api/get-api/user/" + sname);
            BufferedReader in = new BufferedReader(new InputStreamReader(aURL.openStream()));
            
//            while((inputLine = in.readLine()) != null)
//                System.out.println(inputLine);
            inputLine = in.readLine();
            in.close();
        } catch(IOException e){
            System.out.println("URL에 데이터를 입출력 중에 오류가 발생했습니다.");
        }
		return inputLine;
	}
}
