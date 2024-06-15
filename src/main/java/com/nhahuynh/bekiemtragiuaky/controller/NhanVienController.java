package com.nhahuynh.bekiemtragiuaky.controller;

import com.nhahuynh.bekiemtragiuaky.model.NhanVien;
import com.nhahuynh.bekiemtragiuaky.repository.NhanVienRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/nhanvien")
@CrossOrigin(origins = "http://localhost:3000")
public class NhanVienController {


    public NhanVienController(NhanVienRepository nhanVienRepository) {
        this.nhanVienRepository = nhanVienRepository;
    }

    private final NhanVienRepository nhanVienRepository;

    @GetMapping("/size")
    public ResponseEntity<Integer> listSize() {
        List<NhanVien> nhanViens = nhanVienRepository.findAll();
        return ResponseEntity.ok(nhanViens.size());
    }

    @GetMapping("")
    public ResponseEntity<List<NhanVien>> list(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        if (page == null ) {
            page = 1;
        }
        List<NhanVien> nhanViens = nhanVienRepository.findAll();
        int limit = 5;
        int skip = (page - 1) * limit;
        return ResponseEntity.ok(nhanViens.stream().skip(skip).limit(limit).toList());
    }

    @PostMapping("")
    public ResponseEntity<NhanVien> add(@RequestBody NhanVien nhanVien) {
        return ResponseEntity.ok(nhanVienRepository.save(nhanVien));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable(name = "id") String id) {
        nhanVienRepository.deleteById(id);
        return ResponseEntity.ok("OK");
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVien> update(@RequestBody NhanVien nhanVien) {
        return ResponseEntity.ok(nhanVienRepository.save(nhanVien));
    }

}
