package com.nhahuynh.bekiemtragiuaky.repository;

import com.nhahuynh.bekiemtragiuaky.model.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long> {
}
