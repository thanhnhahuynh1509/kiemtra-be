package com.nhahuynh.bekiemtragiuaky.repository;

import com.nhahuynh.bekiemtragiuaky.model.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, String> {
}
