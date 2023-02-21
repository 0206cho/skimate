package org.all4.skimate.skiRounge.repository;

import org.all4.skimate.skiRounge.domain.Ski;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkiRepository extends JpaRepository<Ski, Long> {

}
