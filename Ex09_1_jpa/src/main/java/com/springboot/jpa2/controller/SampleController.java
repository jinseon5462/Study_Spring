package com.springboot.jpa2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.jpa2.dto.SampleDTO;
import com.springboot.jpa2.entity.Sample;
import com.springboot.jpa2.repository.SampleRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample")
@Slf4j
public class SampleController {
	
	@Autowired
	private SampleRepository sampleRepository;
	
	@GetMapping("/main")
	@ResponseBody
	public String main() {
		log.info("---------------------- sample >> main ----------------------");
		return "main~~";
	}
	
	@GetMapping("/regForm")
	public void regForm() {
		log.info("regForm...");
	}
	
	@PostMapping("/regist.do")
	public String regist(SampleDTO dto) {
		Sample sample = Sample.builder()
				.name(dto.getName())
				.age(dto.getAge())
				.build();
		sampleRepository.save(sample);
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public void getList(Model model){
		List<Sample> list = sampleRepository.findAll();
		model.addAttribute("list", list);
	}
	
	@GetMapping("/updateForm")
	public void updateForm(Long no, Model model) {
		Optional<Sample> sample = sampleRepository.findById(no);
		log.info("================================");
		log.info(sample.toString());
		log.info("================================");
		Sample sample2 = sample.get();
		model.addAttribute("sample", sample2);
	}
	
	@PostMapping("/update.do")
	public String updateDo(Sample sample) {
		Sample s = Sample.builder()
				.name(sample.getName())
				.age(sample.getAge())
				.no(sample.getNo())
				.build();
		sampleRepository.save(s);
		return "redirect:list";
	}
	
	@GetMapping("/delete.do")
	public String delete(Long no) {
		sampleRepository.deleteById(no);
		return "redirect:list";
	}
}
