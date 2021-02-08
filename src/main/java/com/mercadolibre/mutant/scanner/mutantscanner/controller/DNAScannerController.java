package com.mercadolibre.mutant.scanner.mutantscanner.controller;

import com.mercadolibre.mutant.scanner.mutantscanner.domain.dto.DNARequestDTO;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.dto.GeneralResponse;
import com.mercadolibre.mutant.scanner.mutantscanner.service.IDNAScannerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/mutant")
public class DNAScannerController {

	@Autowired
	private IDNAScannerService dnaScannerService;

	@ApiOperation(value = "Scan DNA", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@PostMapping("/")
	public ResponseEntity<GeneralResponse> scanDNA(@Valid @RequestBody(required = true) DNARequestDTO dna) {
		return dnaScannerService.isMutant(dna.getDna())
				? new ResponseEntity<>(new GeneralResponse("Dna scanned belongs to a mutant"), HttpStatus.OK)
				: new ResponseEntity<>(new GeneralResponse("Dna Scanned belongs to a human"), HttpStatus.FORBIDDEN);
	}
}
