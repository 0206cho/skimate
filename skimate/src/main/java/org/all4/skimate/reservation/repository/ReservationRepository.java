package org.all4.skimate.reservation.repository;

import org.all4.skimate.member.domain.Member;
import org.all4.skimate.member.domain.SocialType;
import org.all4.skimate.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
