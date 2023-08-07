package com.apotek.crudobat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@Entity
public class ObatHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long id_obat;
    private String nama_obat;
    private String kategori;
    private Integer stok;
    private Integer harga;
    private String supplier;

    @CreatedDate
    @Column(name = "created_at")
    private Date createAt;
}
