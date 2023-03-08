package org.all4.skimate.skiRounge.domain;


import lombok.*;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
@Getter
@Table(name = "ski")
public class Ski {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skiNum;

    private String skiName;
    private String skiAddress;
    private String skiPhone;
    private String skiImgUrl;
}
