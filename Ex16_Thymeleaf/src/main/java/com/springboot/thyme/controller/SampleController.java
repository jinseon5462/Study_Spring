package com.springboot.thyme.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.thyme.dto.SampleDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample")
@Slf4j
public class SampleController {
	
	@GetMapping("/ex01")
	public void ex01() {
		log.info("ex1...");
	}
	
	@GetMapping({"/ex02", "/exLink", "/ex04"})
	public void exModel(Model model) {
		List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(i -> {
			SampleDTO dto = SampleDTO.builder()
					.sno(i)
					.first("first.." + i)
					.last("Last..." + i)
					.regTime(LocalDateTime.now())
					.build();
			return dto;
		}).collect(Collectors.toList());
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(i -> {
			SampleDTO dto = SampleDTO.builder()
					.sno(i)
					.first("first.." + i)
					.last("Last..." + i)
					.regTime(LocalDateTime.now())
					.build();
			return dto;
		}).collect(Collectors.toList());
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/exInline")
	public String exInline(RedirectAttributes re) {
		log.info("exInline....");
		
		SampleDTO dto = SampleDTO.builder()
				.sno(100L)
				.first("First...100")
				.last("Last...100")
				.regTime(LocalDateTime.now())
				.build();
		re.addFlashAttribute("result", "success");
		re.addFlashAttribute("dto", dto);
		return "redirect:/sample/ex03";
	}
	
	@GetMapping("/ex03")
	public void ex03() {
		log.info("ex03...");
	}
	
	@GetMapping({"/exLayout1", "/exLayout2", "/exTemplate"})
	public void exLayout1() {
		log.info("exLayout1...");
	}
}
