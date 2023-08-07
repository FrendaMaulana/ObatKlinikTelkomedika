package com.apotek.crudobat.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ObatDTO {

    private Long id;
    private String nama_obat;
    private String kategori;
    private Integer stok;
    private Integer harga;
    private String supplier;
    private Date createAt;
    private Date updateAt;

}
