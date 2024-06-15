package com.nhahuynh.bekiemtragiuaky.controller;

import com.nhahuynh.bekiemtragiuaky.model.NguoiDung;
import com.nhahuynh.bekiemtragiuaky.repository.NguoiDungRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nguoidung")
@CrossOrigin(origins = "http://localhost:3000")
public class NguoiDungController {

    public NguoiDungController(NguoiDungRepository nguoiDungRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
    }

    private final NguoiDungRepository nguoiDungRepository;

    @PostMapping("/sign-up")
    public ResponseEntity<NguoiDung> signUp(@RequestBody NguoiDung nguoiDung) {
        NguoiDung savedNguoiDung = nguoiDungRepository.save(nguoiDung);
        savedNguoiDung.setPassword("");
        return ResponseEntity.ok(savedNguoiDung);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<NguoiDung> signIn(@RequestBody NguoiDung nguoiDung) {
        List<NguoiDung> nguoiDungs = nguoiDungRepository.findAll();
        NguoiDung found = nguoiDungs.stream().filter((nguoiDung1 -> nguoiDung1.getUsername().equals(nguoiDung.getUsername()) && nguoiDung1.getPassword().equals(nguoiDung.getPassword()))).findFirst().orElse(null);
        if(found != null ){
            found.setPassword("");
        }
        return ResponseEntity.ok(found);
    }

}
