package com.github.piotryuxuan.springbootplayground.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

	@GetMapping("answer")
	public ResponseEntity<int[]> getAnswer() {
		int[] array = { 42 };
		return new ResponseEntity<>(array, HttpStatus.OK);
	}

	@GetMapping("addition")
	public ResponseEntity<Long> getAddition(@RequestParam Long a, @RequestParam Long b) {
		return new ResponseEntity<>(a + b, HttpStatus.OK);
	}

}
